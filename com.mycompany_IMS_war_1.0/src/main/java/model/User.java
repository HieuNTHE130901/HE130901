
package model;

/**
 *
 * @author trung
 */
public class User {
    
    private int userId;
    private String fullName;
    private String email;
    private String mobile;
    private String password;
    private String avatarImage;
    private String verificationCode;
    private boolean isVerified;
    private String userRole;

    public User() {
    }

    public User(int userId, String fullName, String email, String mobile, String password, String avatarImage, String verificationCode, boolean isVerified, String userRole) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.avatarImage = avatarImage;
        this.verificationCode = verificationCode;
        this.isVerified = isVerified;
        this.userRole = userRole;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
}
