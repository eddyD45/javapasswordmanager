

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

		boolean a = true;
		boolean b= false;
		
		User user = new User();
		String pass = user.PasswordGen(20, a, b, a, a);
		Password s = new Password();
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
