/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Radwa Hassan Salah
 */
public class MyUser {

    public boolean valid;  //sarah 

    private String userID;

    private String userName;

    private String userJob;

    private String userAddress;

    private String userBirthDate;

    private String userCredit;

    private String userEmail;

    private String userPassword;
    
    private int status;
    
    

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    ////////////////Setter and Getter of userPassword//////////////////
    /**
     * Get the value of userPassword
     *
     * @return the value of userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Set the value of userPassword
     *
     * @param userPassword new value of userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    ////////////////Setter and Getter of userEmail//////////////////
    /**
     * Get the value of userEmail
     *
     * @return the value of userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Set the value of userEmail
     *
     * @param userEmail new value of userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    ////////////////Setter and Getter of userCredit//////////////////
    /**
     * Get the value of userCredit
     *
     * @return the value of userCredit
     */
    public String getUserCredit() {
        return userCredit;
    }

    /**
     * Set the value of userCredit
     *
     * @param userCredit new value of userCredit
     */
    public void setUserCredit(String userCredit) {
        this.userCredit = userCredit;
    }

    ////////////////Setter and Getter of userBirthDate//////////////////
    /**
     * Get the value of userBirthDate
     *
     * @return the value of userBirthDate
     */
    public String getUserBirthDate() {
        return userBirthDate;
    }

    /**
     * Set the value of userBirthDate
     *
     * @param userBirthDate new value of userBirthDate
     */
    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    ////////////////Setter and Getter of userAddress//////////////////
    /**
     * Get the value of userAddress
     *
     * @return the value of userAddress
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * Set the value of userAddress
     *
     * @param userAddress new value of userAddress
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    ////////////////Setter and Getter of userJob//////////////////
    /**
     * Get the value of userJob
     *
     * @return the value of userJob
     */
    public String getUserJob() {
        return userJob;
    }

    /**
     * Set the value of userJob
     *
     * @param userJob new value of userJob
     */
    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    ////////////////Setter and Getter of userName//////////////////
    /**
     * Get the value of userName
     *
     * @return the value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the value of userName
     *
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    ////////////////Setter and Getter of userID//////////////////
    /**
     * Get the value of userID
     *
     * @return the value of userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Set the value of userID
     *
     * @param userID new value of userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }
          public boolean isValid() {
         return valid;
	}

      public void setValid(boolean newValid) {
         valid = newValid;
	}

}
