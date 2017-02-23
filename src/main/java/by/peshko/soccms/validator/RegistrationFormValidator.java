package by.peshko.soccms.validator;

import by.peshko.soccms.dto.UserDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("registrationValidator")
public class RegistrationFormValidator implements Validator {
    private static final int USERNAME_MAX_LENGTH = 16;
    private static final int USERNAME_MIN_LENGTH = 5;
    private static final int PASSWORD_MIN_LENGTH = 7;

    public boolean supports(final Class<?> aClass) {
        return UserDTO.class.isAssignableFrom(aClass);
    }

    public void validate(final Object targret, final Errors errors) {
        final UserDTO userDTO = (UserDTO) targret;
        final String username = userDTO.getUsername();
        final String password = userDTO.getPassword();
        final String confirmPassword = userDTO.getConfirmPassword();

        if (username.length() > USERNAME_MAX_LENGTH) {
            errors.rejectValue("username", "registration.page.text.validation.logintoolong", "Login is too long.");
        } else if (StringUtils.isEmpty(username) || username.length() < USERNAME_MIN_LENGTH) {
            errors.rejectValue("username", "registration.page.text.validation.logintoshort", "Login is too short");
        }

        if (StringUtils.isEmpty(password) || password.length() < PASSWORD_MIN_LENGTH) {
            errors.rejectValue("password", "registration.page.text.validation.password.length", "Password is too short.");
        }

        if (!password.equals(confirmPassword)) {
            errors.rejectValue("confirmPassword", "registration.page.text.validation.password.confirmation", "Passwords don't match.");
        }

        String email = userDTO.getEmail();
        if (!FieldsValidatorUtils.isValidEmailAddress(email)) {
            errors.rejectValue("email", "registration.page.text.validation.emailisnotcorrect", "Email isn't valid");
        }
    }

}
