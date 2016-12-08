package com.max;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

	private List<Folder> folderList;

	/*** update ***/
	private Folder currentFolder;
	private Website currentSite;
	
  
  public User(){
   		folderList = new ArrayList<Folder>();
   		Folder folder = new Folder("Default");
    	folderList.add(folder);
  }

  /** update **/
  /*
        setCurrentFolder - set current working directory.
        getCurrentFolder - returns reference of current working directory.
        getSite - returns reference of selected site from current working directory.
   */
  public void setCurrentFolder(int index) {
      currentFolder = folderList.get(index);
  }

  public Folder getCurrentFolder() {
      return currentFolder;
  }

  public Website getSite(int index) {
      return currentFolder.getSite(index);
  }

	public void addSite ( String userName, String notes, String password, boolean favorite, String url, Folder folder) throws MalformedURLException{
		Website site = new Website( userName,  password);
		site.setSiteURL( url );
		site.setFavorite( favorite );
		site.setNotes( notes );
    	site.setIndex( folder.getSiteList().size() );
    
    	folderList.get(folderList.indexOf(folder)).addSite(site);
		
	}
	
      
  public void addSite ( String userName, String notes, String password, boolean favorite, String url) throws MalformedURLException{
		Website site = new Website( userName, password);
		site.setSiteURL( url );
		site.setFavorite( favorite );
		site.setNotes( notes );
		site.setIndex( folderList.get(0).getSiteList().size());
    
		folderList.get(0).addSite(site);
		
	}
	
	public void deleteSite (Folder folder, Website site){
		folder.deleteSite( site );
		
	}
	
	public void addFolder(String name){
		Folder folder = new Folder(name);		
		folderList.add(folder);
	}
	
	public String PasswordGen(int length, boolean capital, boolean lowercase, boolean number, boolean symbol){
		String password = null;
    
    //check to make sure inputs are valid (can be removed if we use a dropdown and checkboxes)
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
					password = password + capitalGen();
				}
				if(category == 1){
					password = password + lowercaseGen();
				}
				if(category == 2){
					password = password + numberGen();
				}
				if(category == 3){
					password = password + symbolGen();
				}
				
			}
		}
		
		return password;
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

}
