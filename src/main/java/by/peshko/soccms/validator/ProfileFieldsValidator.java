package by.peshko.soccms.validator;

import by.peshko.soccms.dto.ProfileDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component("profileValidator")
public class ProfileFieldsValidator implements Validator {
    private static final int CITY_MAX_LENGTH = 30;
    private static final int AGE_MAX_VALUE = 160;

    public boolean supports(final Class<?> aClass) {
        return ProfileDTO.class.isAssignableFrom(aClass);
    }

    public void validate(final Object targret, final Errors errors) {
        final ProfileDTO profileDTO = (ProfileDTO) targret;

        final String firstname = profileDTO.getFirstname();
        final String lastname = profileDTO.getLastname();
        final String email = profileDTO.getEmail();
        final String city = profileDTO.getCity();
        final String sex = profileDTO.getSex();
        final String phoneNumber = profileDTO.getPhoneNumber();
        final Date birthDate;

        if (StringUtils.isNotEmpty(firstname) && !FieldsValidatorUtils.isValidNameFormat(firstname)) {
            errors.rejectValue("firstname", "profile.page.field.text.name", "Incorrect name format.");
        }

        if (StringUtils.isNotEmpty(lastname) && !FieldsValidatorUtils.isValidNameFormat(lastname)) {
            errors.rejectValue("lastname", "profile.page.field.text.name", "Incorrect name format.");
        }

        if (StringUtils.isNotEmpty(email) && !FieldsValidatorUtils.isValidEmailAddress(email)) {
            errors.rejectValue("email", "registration.page.text.validation.emailisnotcorrect", "Email isn't valid");
        }

        if (StringUtils.isNotEmpty(phoneNumber) && !FieldsValidatorUtils.isValidPhone(phoneNumber)) {
            errors.rejectValue("phoneNumber", "profile.page.field.text.phonenumber", "phoneNumber isn't valid");
        }

        if (profileDTO.getAge() != null) {
            if ((profileDTO.getAge() < 0 || profileDTO.getAge() > AGE_MAX_VALUE)) {
                errors.rejectValue("age", "profile.page.field.text.age", "age format isn't valid");
            }
        } else if (StringUtils.isNotEmpty(city) && (city.length() > CITY_MAX_LENGTH))

        {
            errors.rejectValue("city", "profile.page.field.text.city", "City name is too long");
        }

        if (profileDTO.getBirthDate() != null) {
            birthDate = profileDTO.getBirthDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = dateFormat.format(birthDate);

            if (!FieldsValidatorUtils.isValidDateFormat(dateString) && !dateString.equals("")) {
                errors.rejectValue("birthDate", "profile.page.field.text.birthDate", "Incorrect birthdate");
            }
        }

    }
}