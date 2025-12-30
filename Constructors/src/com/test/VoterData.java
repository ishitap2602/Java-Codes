
package com.test;

public class VoterData {
    public void checkAge(int age) throws ValidAgeException {
        if (age >= 18) {
            // Valid age: no exception, method returns normally
            return;
        } else {
            // Invalid age: throw custom exception
            throw new ValidAgeException("Invalid age: must be 18 or older. Entered: " + age);
        }
    }
}
