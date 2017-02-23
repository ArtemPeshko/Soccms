package by.peshko.soccms.validator;

final class FieldsValidatorUtils {

    private FieldsValidatorUtils() {
    }

    static boolean isValidEmailAddress(final String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\." +
                "[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    static boolean isValidDateFormat(final String date) {
        String ePattern = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(date);
        return m.matches();
    }

    static boolean isValidNameFormat(final String anyName) {
        String ePattern = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(anyName);
        return m.matches();
    }

    static boolean isValidPhone(final String phone) {
        String ePattern = "\\d{7,15}";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(phone);
        return m.matches();
    }

}
