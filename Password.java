

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Oscar Herrera on 12/6/2016.
 * @author Oscar Herrera
 *
 */
public class Password implements Serializable {

    private final String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%&?";
    private String key;
    private String strPassword;
    private String encPassword = "";
    private String decryptedPassword = "";
    private Random rand;

    /**
     *  Create new Password object
     */
    public Password() { rand = new Random(); }

    /**
     * Create new Password object and
     * generates a key, then encrypts the password.
     * @param strPassword
     */
    public Password(String strPassword) {
        this.strPassword = strPassword;
        rand = new Random();
        generateKey();
        encryptPassword();
    }

    /**
     * Set new password.
     * @param str
     */
    public void setStrPassword(String str) { strPassword = str; }

    /**
     * returns current set password.
     * @return
     */
    public String getPassword() { return strPassword; }

    /**
     * returns current encrypted password.
     * @return
     */
    public String getEncPassword() { return encPassword; }

    /**
     * returns current decrypted password.
     * @return
     */
    public String getDecryptedPassword() { return decryptedPassword; }

    /**
     * returns current generated key.
     * @return
     */
    public String getKey() { return key; }
    
    /**
     * Returns true if key is set,
     * false otherwise.
     * @return
     */
    public boolean isKeySet() {
        if ( key == null || key.equals("")){
            return false;
        }
        return true;
    }

    /**
     * Clears current password.
     */
    public void clearPassword() { strPassword = ""; }
    
    /**
     * Clears current encrypted password.
     **/
    public void clearEncryptedPassword() {encPassword = "";}
    
    
    /**
     * Clears current decrypted password.
     */
    public void clearDecryptedPassword() { decryptedPassword = "";}

    /**
     * Generates a new encryption key.
     */
    public void generateKey() {
        ArrayList<Character> temp = new ArrayList<Character>();

        for (int j = 0; j < chars.length(); j++) {
            temp.add(chars.charAt(j));
        }

        char[] newStr = new char[chars.length()];

        for (int i = 0; i < chars.length(); i++ ) {
            int nextChar = rand.nextInt(temp.size());
            newStr[i] = temp.get(nextChar);
            temp.remove(nextChar);

        }
        key = new String(newStr);
    } // generateKey

    /**
     * Encrypts current password
     */
    public void encryptPassword() {
        int charCount = chars.length();
        int passCount = strPassword.length();
        clearEncryptedPassword();
        for (int i = 0; i < passCount; i++) {
            for (int j = 0; j < charCount; j++) {
                if (strPassword.charAt(i) == chars.charAt(j)) {
                    encPassword += key.charAt(j);
                }
            }
        }
    } // encryptPassword

    /**
     * Decrypts current encrypted password
     */
    public void decryptPassword() {
        int charCount = key.length();
        int encPassCount = encPassword.length();
        clearDecryptedPassword();
        for (int i = 0; i < encPassCount; i++){
            for (int j = 0; j < charCount; j++){
                if (encPassword.charAt(i) == key.charAt(j)){
                    decryptedPassword += chars.charAt(j);
                }
            }
        }
    } // decryptPassword
} // Class Password
