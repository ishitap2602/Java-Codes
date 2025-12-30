
package com.test;

import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        // try-with-resources auto-closes the scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter your age:");
            int age = sc.nextInt();

            VoterData obj = new VoterData();
            try {
                obj.checkAge(age); // throws only if invalid
                System.out.println("You are eligible to vote.");
            } catch (ValidAgeException ve) {
                // Print the message from the exception
                System.out.println("Check your age: " + ve.getMessage());
            }
        }
    }
}
