package com.buaa.user.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "buaa.user")
public class User {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_account")
    private String userAccount;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_detail")
    private String userDetail;

    @Column(name = "user_url")
    private String userUrl;

    public User() {
    }

    public User(String userAccount, String userPassword, String userEmail, String userName) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(String userAccount) {
        this.userAccount = userAccount;
    }

    public User(Integer userId, String userAccount, String userPassword, String userEmail, String userName, String userDetail, String userUrl) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userDetail = userDetail;
        this.userUrl = userUrl;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_account
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * @param userAccount
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * @return user_password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_detail
     */
    public String getUserDetail() {
        return userDetail;
    }

    /**
     * @param userDetail
     */
    public void setUserDetail(String userDetail) {
        this.userDetail = userDetail;
    }

    /**
     * @return user_url
     */
    public String getUserUrl() {
        return userUrl;
    }

    /**
     * @param userUrl
     */
    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }
}