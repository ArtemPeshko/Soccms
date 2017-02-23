package by.peshko.soccms.controller;

import by.peshko.soccms.dto.FriendDTO;
import by.peshko.soccms.dto.MessageDTO;
import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.component.facade.FriendFacade;
import by.peshko.soccms.component.facade.ProfileFacade;
import by.peshko.soccms.component.facade.UserFacade;
import by.peshko.soccms.component.RequestSplitterForUserAndProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

@Controller
public class FriendController {
    @Autowired
    private ProfileFacade profileFacade;
    @Autowired
    private UserFacade userFacade;
    @Autowired
    private FriendFacade friendFacade;
    @Autowired
    private RequestSplitterForUserAndProfile requestSplitterForUserAndProfile;

    @RequestMapping(value = "/friends/allthepeople/{currentLoggedUsername}", method = RequestMethod.GET)
    public String showAllThePeople(final Model model,
                                   @PathVariable(value = "currentLoggedUsername") final String currentLoggedUsername) {
        UserDTO currentLoggedUserDTO = userFacade.getUserByUsername(currentLoggedUsername);

        Set<ProfileDTO> profilesNotFriends
                = profileFacade.getAllTheProfilesOfNonPendingAndNotFriends(currentLoggedUserDTO.getProfileDTO().getProfileID(),
                currentLoggedUsername
        );

        model.addAttribute("allTheProfiles", profilesNotFriends);

        return "/friends/allthepeople";
    }

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    public String redirectToManageFriends() {
        return "friends/managefriends";
    }

    @RequestMapping(value = "/friends/allthefriends/{currentLoggedUsername}", method = RequestMethod.GET)
    public String showAllTheFriends(final Model model,
                                    @PathVariable(value = "currentLoggedUsername") final String currentLoggedUsername) {
        UserDTO currentLoggedUserDTO = userFacade.getUserByUsername(currentLoggedUsername);

        model.addAttribute("allTheFriends", profileFacade.getAllTheProfilesOfFriends(currentLoggedUserDTO.getId()));

        return "/friends/allthefriends";
    }

    @RequestMapping(value = "/friends/delete/friend/{deleterequest}", method = RequestMethod.GET)
    public String deleteFriend(final Model model, @PathVariable(value = "deleterequest") final String deleterequest) {
        UserDTO currentLoggedUserDTO = (UserDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(deleterequest).get(0);
        ProfileDTO friendProfileDTO = (ProfileDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(deleterequest).get(1);

        friendFacade.deleteFriend(currentLoggedUserDTO.getProfileDTO().getProfileID(), friendProfileDTO.getProfileID());

        model.addAttribute("allTheFriends", profileFacade.getAllTheProfilesOfFriends(currentLoggedUserDTO.getId()));

        return "/friends/allthefriends";
    }

    @RequestMapping(value = "/friends/addfriend/{friendRequest}", method = RequestMethod.GET)
    public String manageFriendInfo(@PathVariable(value = "friendRequest") final String friendRequestString) {
        UserDTO currentLoggedUserDTO = (UserDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(friendRequestString).get
                (0);
        ProfileDTO newFriendProfileDTO = (ProfileDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(friendRequestString)
                .get(1);

        friendFacade.addFriend(currentLoggedUserDTO.getProfileDTO(), newFriendProfileDTO);

        return "redirect:/friends";
    }

    @RequestMapping(value = "/friends/pendingrequests/{username}", method = RequestMethod.GET)
    public String showPendingRequests(final Model model, @PathVariable(value = "username") final String currentLoggedUsername) {
        UserDTO currentLoggedUserDTO = userFacade.getUserByUsername(currentLoggedUsername);
        Set<FriendDTO> pendingFriends = friendFacade.getAllThePendingFriendRequest(currentLoggedUserDTO.getProfileDTO()
                .getProfileID());
        model.addAttribute("allThePendingRequests", pendingFriends);
        return "/friends/pendingrequests";
    }

    @RequestMapping(value = "/friends/approve/{approveRequestString}", method = RequestMethod.GET)
    public String approvePendingRequests(@PathVariable(value = "approveRequestString") final String approveRequestString) {
        UserDTO currentLoggedUserDTO = (UserDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(approveRequestString)
                .get(0);
        ProfileDTO newFriendProfileDTO = (ProfileDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(approveRequestString)
                .get(1);

        friendFacade.approveFriendRequest(currentLoggedUserDTO.getId(), newFriendProfileDTO.getProfileID());

        return "redirect:/friends/";
    }

    @RequestMapping(value = "/friends/reject/{username}", method = RequestMethod.GET)
    public String rejectPendingRequests(@PathVariable(value = "username") final String rejectRequest) {
        UserDTO currentLoggedUserDTO = (UserDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(rejectRequest).get(0);
        ProfileDTO newFriendProfileDTO = (ProfileDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(rejectRequest).get(1);

        friendFacade.rejectFriendRequest(currentLoggedUserDTO.getId(), newFriendProfileDTO.getProfileID());

        return "redirect:/friends/";
    }

    @RequestMapping(value = "/friends/searchfriends/", method = RequestMethod.GET)
    public String visitSearchPage(final Model model) {
        model.addAttribute("messageDTO", new MessageDTO());
        return "/friends/searchfriends";
    }

    @RequestMapping(value = "/friends/searchfriends/", method = RequestMethod.POST)
    public String searchFriend(@ModelAttribute("messageDTO") final MessageDTO messageDTO, final Model model) {
        List<ProfileDTO> profilesFriends;

        if (messageDTO != null && messageDTO.getText().trim().length() > 0) {
            profilesFriends = profileFacade.getAllTheProfilesOneParameter(messageDTO.getText().trim());
        } else {
            String nofriends = "nofriends";
            model.addAttribute("nofriends", nofriends);
            return "/friends/searchfriends";
        }

        if (profilesFriends.size() == 0) {
            String nofriends = "nofriends";
            model.addAttribute("nofriends", nofriends);
            return "/friends/searchfriends";
        }

        model.addAttribute("allTheProfiles", profilesFriends);
        model.addAttribute("messageDTO", new MessageDTO());
        return "/friends/searchfriends";
    }

}