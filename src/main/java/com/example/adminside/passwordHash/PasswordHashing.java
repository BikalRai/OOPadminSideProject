package com.example.adminside.passwordHash;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {
    // Method to hash a password
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    // Method to verify entered password with stored hashed password
    public static boolean verifyPassword(String enteredPassword, String storedHashedPassword) {
        return BCrypt.checkpw(enteredPassword, storedHashedPassword);
    }
}
