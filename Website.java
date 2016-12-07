

import java.awt.*;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Oscar Herrera on 12/6/2016.
 * @author Oscar Herrera
 */
public class Website implements Serializable, Comparable<Website> {

    private String userName;
    private String notes;
    private Password password;
    private boolean favorite;
    private URL siteURl;
    private Desktop desktop;

    public Website() {
        userName = "";
        notes = "";
        password = new Password();
        favorite = false;
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    } // Website


    public Website(String userName, String password) {
        this.userName = userName;
        this.password = new Password(password);
        notes = "";
        favorite = false;
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    } // Website

    public Website(String userName, Password password) {
        this.userName = userName;
        this.password = password;
        notes = "";
        favorite = false;
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    } // Website

    public void setUserName(String username) { userName = username; }

    public void setSiteURl(String url) throws MalformedURLException {
            siteURl = new URL(url);
    } // setSiteUrl

    public void setPassword(String newPassword) {
        if (password == null ) {
            password = new Password(newPassword);
        }
        else {
            password.setStrPassword(newPassword);
        }
    } // setPassword

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    } // setFavorite

    public void setNotes(String note) {
        this.notes = note;
    } // setNotes

    public void addToNotes(String note) {
        this.notes = "\n" + note;
    } // addToNotes

    public String getUserName() { return userName; }

    public String getNotes() { return notes; }

    public String getPassword(){
      return  password.getPassword();
    } // getPassword

    public void passwordEncrypt(){
        if ( password.isKeySet()) {
            password.encryptPassword();
        }
        else{
            password.generateKey();
            password.encryptPassword();
        }
    } // passwordEncrypt

    public void genNewKey() {
        password.generateKey();
    } // genNewKey

    public void clearCurrentPassword() {
        password.clearPassword();
    } // clearCurrentPassword

    public void openWebsite() throws Exception {
        if (desktop == null) {
            desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        }
        else {
            throw new Exception("Desktop API is not supported.");
        }
        desktop.browse(siteURl.toURI());
    } // openWebsite

    @Override
    public int compareTo(Website website) {

        if ( this.favorite == website.favorite) {
            return 0;
        }

        if ( this.favorite == true && website.favorite == false) {
            return 1;
        }
        return -1;
    } // compareTo


} // Class Website
