package com.test;
 
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
 
public class ValidateEmailUser {
 
 
    private static final String EXPECTED_EMAIL = "sahana@example.com";
    private static final String EXPECTED_PASSWORD = "password";
 
    // Simple email regex (not perfect, but good enough for demo)
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        try {
            System.out.print("Enter email: ");
            String userEmail = sc.nextLine().trim();
 
            System.out.print("Enter password: ");
            String userPassword = sc.nextLine();
 
            boolean isValid = validate(userEmail, userPassword);
 
            if (isValid) {
                System.out.println("Login successful. Welcome, " + userEmail + "!");
            } else {
                System.out.println("Invalid email or password.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
 
    public static boolean validate(String email, String password) {
        if (email == null || password == null) {
            return false;
        }
        Matcher m = EMAIL_PATTERN.matcher(email);
        if (!m.matches()) {
            System.out.println("Invalid email format.");
            return false;
        }
 
        boolean emailMatches = EXPECTED_EMAIL.equals(email);
        boolean passwordMatches = EXPECTED_PASSWORD.equals(password);
 
        return emailMatches && passwordMatches;
    }
}
 
 
 
 