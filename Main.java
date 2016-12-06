package com.max;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Password s = new Password();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a password: ");
        System.out.print("--> ");
        String pass = input.next();

        s.setStrPassword(pass);
        s.generateKey();
        s.encryptPassword();
        s.decryptPassword();

        System.out.println("\nYour password: " + s.getPassword());
        System.out.println("The key is: " + s.getKey());
        System.out.println("Then encrypted password: " + s.getEncPassword());
        System.out.println("The decryted string: " + s.getDecryptedPassword());
    }
}
