package by.peshko.soccms.controller;

import by.peshko.soccms.dto.PostDTO;
import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.component.facade.PostFacade;
import by.peshko.soccms.component.facade.ProfileFacade;
import by.peshko.soccms.component.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class PostController {

    @Autowired
    private ProfileFacade profileFacade;

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private PostFacade postFacade;

    @RequestMapping(value = "/welcomePage", method = RequestMethod.GET)
    public String beforeVisitingWelcomePage(final Model model, final HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();

        UserDTO userDTO = userFacade.getUserByUsername(userDetail.getUsername());
        ProfileDTO profileDTO = userDTO.getProfileDTO();

        session.setAttribute("senderProfileDTO", profileDTO);

        model.addAttribute("allThePosts", postFacade.getAllThePosts(profileDTO.getProfileID()));
        model.addAttribute("postDTO", new PostDTO());
        return "/welcome";
    }

    @RequestMapping(value = "/posts/showusers", method = RequestMethod.GET)
    public String showUsersBeforePost(final Model model) {
        model.addAttribute("allTheProfiles", profileFacade.getAllTheProfiles());
        return "/posts/postforallpeople";
    }

    @RequestMapping(value = "/posts/makeapost/{profileID}", method = RequestMethod.GET)
    public String initiateAPost(final Model model, @PathVariable("profileID") final String profileID, final HttpSession session) {
        ProfileDTO wallOwnerProfileDTO = profileFacade.getProfileById(Long.valueOf(profileID));
        session.setAttribute("wallOwnerProfileDTO", wallOwnerProfileDTO);

        PostDTO postDTO = new PostDTO();
        postDTO.setSenderProfileDTO((ProfileDTO) session.getAttribute("senderProfileDTO"));
        postDTO.setWallOwnerProfileDTO(wallOwnerProfileDTO);

        model.addAttribute("postDTO", postDTO);
        return "/posts/sendpost";
    }

    @RequestMapping(value = "/posts/sendapost", method = RequestMethod.POST)
    public String makePost(@ModelAttribute("postDTO") final PostDTO postDTO, @RequestParam("photo") final MultipartFile file,
                           final HttpSession session) {
        postDTO.setSenderProfileDTO((ProfileDTO) session.getAttribute("senderProfileDTO"));
        postDTO.setWallOwnerProfileDTO((ProfileDTO) session.getAttribute("wallOwnerProfileDTO"));
        postDTO.setPostDate(new Date());

        postFacade.createPost(postDTO, file);

        return "redirect:/welcomePage";
    }

    @RequestMapping(value = "/posts/sendaposttomyself", method = RequestMethod.POST)
    public String makePostToMyself(@ModelAttribute("postDTO") final PostDTO postDTO,
                                   @RequestParam("photo") final MultipartFile file, final HttpSession session) {
        postDTO.setSenderProfileDTO((ProfileDTO) session.getAttribute("senderProfileDTO"));
        postDTO.setWallOwnerProfileDTO((ProfileDTO) session.getAttribute("senderProfileDTO"));
        postDTO.setPostDate(new Date());
        postFacade.createPost(postDTO, file);
        return "redirect:/welcomePage";
    }

    @RequestMapping(value = "/posts/deleteapost/{postID}", method = RequestMethod.GET)
    public String deletePost(@PathVariable("postID") final String postID) {
        PostDTO postToDelete = postFacade.getById(Long.valueOf(postID));
        postFacade.deletePost(postToDelete);

        return "redirect:/welcomePage";
    }

}