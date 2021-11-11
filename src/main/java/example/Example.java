package example;

import java.util.regex.Pattern;

public class Example {
    public static final String FULLNAME_REGEX="^([A-Z]+[a-z]*?[ ]?)+$";
    public static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}";
    public static final String EMAIL_REGEX = "^\\w+@\\w+(\\.\\w+){1,2}$";

    public boolean isEmail(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    public boolean isPassword(String password) {
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }
    public boolean isFullname(String fullname) {
        return Pattern.compile(FULLNAME_REGEX).matcher(fullname).matches();
    }

}
