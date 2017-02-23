package by.peshko.soccms.controller;

import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.model.RegistrationStatus;
import by.peshko.soccms.component.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
    @Autowired
    @Qualifier("registrationValidator")
    private Validator registrationValidator;
    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String initRegistration(final Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "/registration";
    }

    @RequestMapping(value = "/registrationComplete", method = RequestMethod.POST)
    public String displayRegistration(final Model model, @ModelAttribute("userDTO") final UserDTO userDTO,
                                      final BindingResult result) {
        registrationValidator.validate(userDTO, result);

        if (result.hasErrors()) {
            return "/registration";
        }

        final RegistrationStatus registrationStatus = userFacade.registrationStatus(userDTO.getUsername(), userDTO.getEmail());

        if (registrationStatus != RegistrationStatus.USERNAME_EXISTS) {
            if (registrationStatus != (RegistrationStatus.EMAIL_EXISTS)) {

                userFacade.createUser(userDTO);
                model.addAttribute("brandnewuser", userDTO);
                return "loginpage";
            } else {
                model.addAttribute("pageNotification", "email");
                return "/registration";
            }
        } else {
            model.addAttribute("pageNotification", "username");
            return "/registration";
        }
    }

}
