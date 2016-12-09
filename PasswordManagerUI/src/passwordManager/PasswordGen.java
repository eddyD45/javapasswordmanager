package passwordManager;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class PasswordGen {
	private int length;
	private boolean capital;
	private boolean lowercase;
	private boolean number;
	private boolean symbol;
	private String password = "";

	
	
	public static void main(String[] args) {
		int length;
		boolean capital;
		boolean lowercase;
		boolean number;
		boolean symbol;
		boolean repeat;
		
		//get user input
		Scanner scanner = new Scanner (System.in);
		System.out.print("Enter the length for your new password (4-100): ");
		length = scanner.nextInt();
		System.out.print("Include capital letters? (True/False) ");
		capital = scanner.nextBoolean();
		System.out.print("Include lowercase letters? (True/False) ");
		lowercase = scanner.nextBoolean();
		System.out.print("Include numbers? (True/False) ");
		number = scanner.nextBoolean();
		System.out.print("Include symbols? (True/False) ");
		symbol = scanner.nextBoolean();
		
		//create the password
		PasswordGen newpassword = new PasswordGen(length, capital, lowercase, number, symbol);
		System.out.println("Randomly Generated Password: " + newpassword.getpassword());
		
		//ask if the user wants to generate another
		System.out.println("Generate again? (True/False)");
		repeat = scanner.nextBoolean();
		
		newpassword = new PasswordGen(length, capital, lowercase, number, symbol);

		while(repeat == true){
			System.out.println("Randomly Generated Password: " + newpassword.getpassword());
			
			System.out.print("Generate again? (True/False) ");
			repeat = scanner.nextBoolean();
			
			newpassword = new PasswordGen(length, capital, lowercase, number, symbol);

		}
	}
	
	public PasswordGen(int length, boolean capital, boolean lowercase, boolean number, boolean symbol){
		//check to make sure inputs are valid
		if(length <4 || length >100){
			System.out.println("Length of the password is not between 4 and 100");			
		} else if (capital == false && lowercase == false && number == false && symbol == false){
			System.out.println("Select at least one category for your password");
		} 
		//generate password if inputs are valid
		else{
			
			
			//loop through the length of the new password
			for(int i =0; i<length; i++){
				//pick one of the available categories
				List<Integer> categories = new ArrayList<Integer>();
				if(capital)
					categories.add(0);
				if(lowercase)
					categories.add(1);
				if(number)
					categories.add(2);
				if(symbol)
					categories.add(3);
				
				int random = (int)(Math.random()*categories.size());
				int category = categories.get(random);
				
				//generate the character depending on the category
				if(category == 0){
					this.password = this.password + capitalGen();
				}
				if(category == 1){
					this.password = this.password + lowercaseGen();
				}
				if(category == 2){
					this.password = this.password + numberGen();
				}
				if(category == 3){
					this.password = this.password + symbolGen();
				}
				
			}
		}
	}
	
	//random lowercase
	private char lowercaseGen(){
		int random = (int)(Math.random()*26+97);
		char c = (char)random;
		return c;
	}
	
	//random capital
	private char capitalGen(){
		int random = (int)(Math.random()*26+65);
		char c = (char)random;
		return c;
	}
	
	//random number
	private char numberGen(){
		int random = (int)(Math.random()*10+48);
		char c = (char)random;
		return c;
	}
	
	//random symbol
	private char symbolGen(){
		char[] symbols = {'!','@','#','$','%','&','?'};
		int random = (int)(Math.random()*7);
		return symbols[random];
	}
	
	//return password
	public String getpassword(){
		return this.password;
	}

}
