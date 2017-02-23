package by.peshko.soccms.controller;

import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.component.facade.ProfileFacade;
import by.peshko.soccms.component.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ProfileController {
    @Autowired
    @Qualifier("profileValidator")
    private Validator profileValidator;
    @Autowired
    private ProfileFacade profileFacade;
    @Autowired
    private UserFacade userFacade;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/profile/beforeprofilepage", method = RequestMethod.GET)
    public String beforeVisitingProfilePage(final Model model) {
        addProfileDTOToModel(model);
        return "/profile/profilepage";
    }

    @RequestMapping(value = "/profile/profileedit", method = RequestMethod.GET)
    public String initProfileEdition(final Model model) {
        addProfileDTOToModel(model);

        return "/profile/profileeditpage";
    }

    @RequestMapping(value = "/profile/editprofile", method = RequestMethod.POST)
    public String editProfile(final Model model, @ModelAttribute("profileDTO") final ProfileDTO profileDTO,
                              final BindingResult result) {
        profileValidator.validate(profileDTO, result);

        if (result.hasErrors()) {
            return "/profile/profileeditpage";
        }

        profileFacade.updateProfile(profileDTO);

        model.addAttribute("profileDTO", profileDTO);

        return "/profile/profilepage";
    }

    @RequestMapping(value = "/profile/passwordchange", method = RequestMethod.GET)
    public String beforePasswordChange(final Model model) {
        model.addAttribute("userDTO", new UserDTO());

        return "/profile/passwordchange";
    }

    @RequestMapping(value = "/profile/passwordchange", method = RequestMethod.POST)
    public String passwordChange(final Model model, @ModelAttribute("userDTO") final UserDTO userDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();

        UserDTO currentLoggedUserDTO = userFacade.getUserByUsername(userDetail.getUsername());

        if (userDTO.getNewPassword().equals(userDTO.getConfirmPassword()) && userDTO.getNewPassword().length() > 0 &&
                userDTO.getConfirmPassword().length() > 0) {
            currentLoggedUserDTO.setPassword(passwordEncoder.encode(userDTO.getNewPassword()));
            userFacade.updateUser(currentLoggedUserDTO);
            String passwordchanged = "passwordchanged";
            model.addAttribute("passwordchanged", passwordchanged);
            model.addAttribute("profileDTO", currentLoggedUserDTO.getProfileDTO());
            return "/profile/profilepage";
        } else {
            String passwordsDoNotMatch = "passwordsDoNotMatch";
            model.addAttribute("passwordsDoNotMatch", passwordsDoNotMatch);
            model.addAttribute("userDTO", new UserDTO());

            return "/profile/passwordchange";
        }
    }

    private void addProfileDTOToModel(final Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDTO userDTO = userFacade.getUserByUsername(user.getUsername());
        model.addAttribute("profileDTO", userDTO.getProfileDTO());
    }

    @InitBinder
    protected void initBinder(final WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}