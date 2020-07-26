package validator;

public class Validator {

    // Fields cannot be empty.
    public static boolean validateEmpty(String username, String phone, String email, String password, String passwordConfirm){
        return username.equals("") && phone.equals("") && email.equals("")
                && password.equals("") && passwordConfirm.equals("");
    }

    // Username should contains at least 2 letters - upper or lower case
    public static boolean validateUsername(String username){
        return username.matches("[a-zA-Z]{2,}");
    }

    // Phone should contains two groups of digits surrounded by parenthesis.
    public static boolean validatePhone(String phone){
        return phone.matches("[(]\\d{4}[)]\\s[(]\\d{7}[)]");
    }

    // Email should contains only lowercase letters, no duplicate @, dots and spaces inside.
    public static boolean validateEmail(String email){
        return email.matches("([a-z]+([.]|[a-z]*))+[@][a-z]+[.][a-z]+");
    }

    // Password should be at least 5 symbols, one lower and upper case, digit and symbol.
    public static boolean validatePassword(String password){
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$^*@&]).{5,}$");
    }

    // Confirm password should be identical to password.
    public static boolean validateConfirmPassword(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }
}
