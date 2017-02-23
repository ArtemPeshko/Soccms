package by.peshko.soccms.controller;

import by.peshko.soccms.dto.MessageDTO;
import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.component.facade.MessageFacade;
import by.peshko.soccms.component.facade.ProfileFacade;
import by.peshko.soccms.component.RequestSplitterForUserAndProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping(value = "/messages")
public class MessageController {

    @Autowired
    private ProfileFacade profileFacade;
    @Autowired
    private MessageFacade messageFacade;
    @Autowired
    private RequestSplitterForUserAndProfile requestSplitterForUserAndProfile;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAllTheFriends(final Model model) {
        model.addAttribute("allThePeople", profileFacade.getAllTheProfiles());
        return "/messages/messages";
    }

    @RequestMapping(value = "/beforesendmessage/{request}", method = RequestMethod.GET)
    public String beforeSendingMessage(final Model model, @PathVariable(value = "request") final String request,
                                       final HttpSession session) {
        UserDTO currentLoggedUserDTO = (UserDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(request).get(0);

        ProfileDTO destinationProfileDTO = (ProfileDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(request).get(1);
        ProfileDTO senderProfileDTO = currentLoggedUserDTO.getProfileDTO();

        MessageDTO messageDTO = new MessageDTO();

        session.setAttribute("destinationProfileDTO", destinationProfileDTO);
        session.setAttribute("senderProfileDTO", senderProfileDTO);

        model.addAttribute("senderProfileDTO", senderProfileDTO);
        model.addAttribute("destinationProfileDTO", destinationProfileDTO);

        model.addAttribute("MessageDTO", messageDTO);
        model.addAttribute("allTheMessages",
                messageFacade.getAllTheMessages(senderProfileDTO.getProfileID(), destinationProfileDTO.getProfileID())
        );

        return "/messages/sendmessage";
    }

    @RequestMapping(value = "/sendmessage", method = RequestMethod.POST)
    public String sendMessage(final Model model, @ModelAttribute("MessageDTO") final MessageDTO messageDTO,
                              final BindingResult result, final HttpSession session) {
        messageDTO.setMessageDate(new Date());

        messageDTO.setSenderProfileDTO((ProfileDTO) session.getAttribute("senderProfileDTO"));
        messageDTO.setDestinationProfileDTO((ProfileDTO) session.getAttribute("destinationProfileDTO"));

        messageFacade.createMessage(messageDTO);

        model.addAttribute("allTheMessages",
                messageFacade.getAllTheMessages(messageDTO.getSenderProfileDTO().getProfileID(),
                        messageDTO.getDestinationProfileDTO().getProfileID()
                )
        );

        return "redirect:/messages/beforesendmessage/" + messageDTO.getSenderProfileDTO().getUserDTO().getUsername() + "&" +
                messageDTO.getDestinationProfileDTO().getProfileID();
    }

}