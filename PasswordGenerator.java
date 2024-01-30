import java.security.SecureRandom;

public class PasswordGenerator {
    
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+</>?";

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        
        password.append(LOWERCASE_CHARS.charAt(random.nextInt(LOWERCASE_CHARS.length())));
        password.append(UPPERCASE_CHARS.charAt(random.nextInt(UPPERCASE_CHARS.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

        
        for (int i = 4; i < length; i++) {
            String charSet = LOWERCASE_CHARS + UPPERCASE_CHARS + DIGITS + SPECIAL_CHARS;
            password.append(charSet.charAt(random.nextInt(charSet.length())));
        }

        // Shuffle 
        String shuffledPassword = shufflePassword(password.toString());
        
        return shuffledPassword;
    }

    private static String shufflePassword(String password) {
        char[] passwordChars = password.toCharArray();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < passwordChars.length; i++) {
            int randomIndex = random.nextInt(passwordChars.length);
            char temp = passwordChars[i];
            passwordChars[i] = passwordChars[randomIndex];
            passwordChars[randomIndex] = temp;
        }
        return new String(passwordChars);
    }

    public static void main(String[] args) {
        int passwordLength = 12; // Change the length as needed
        String password = generatePassword(passwordLength);
        System.out.println("Generated Password: " + password);
    }
}
