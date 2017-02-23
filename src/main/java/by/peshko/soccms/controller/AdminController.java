package by.peshko.soccms.controller;

import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.component.facade.ProfileFacade;
import by.peshko.soccms.component.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private ProfileFacade profileFacade;
    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginAsAdmin(final Model model) {
        model.addAttribute("allTheProfiles", profileFacade.getAllTheProfiles());

        return "/secure/adminpage";
    }

    @RequestMapping(value = "/manageuserinfo/{userID}", method = RequestMethod.GET)
    public String manageUserInfo(final Model model, @PathVariable(value = "userID") final String userID) {
        ProfileDTO profileDTO = profileFacade.getProfileById(Long.valueOf(userID));
        model.addAttribute("userDTO", profileDTO.getUserDTO());
        return "/secure/userinfo";
    }

    @RequestMapping(value = "/deletteuser/{username}", method = RequestMethod.GET)
    public String deleteUser(final Model model, @PathVariable(value = "username") final String username) {
        UserDTO userDTO = userFacade.getUserByUsername(username);
        ProfileDTO profileDTO = userDTO.getProfileDTO();

        userFacade.deleteUser(userDTO);

        model.addAttribute("allTheProfiles", profileFacade.getAllTheProfiles());
        model.addAttribute("userdeleted", userDTO);

        return "/secure/adminpage";
    }

}
