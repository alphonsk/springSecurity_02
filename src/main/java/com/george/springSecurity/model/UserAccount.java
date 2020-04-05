package com.george.springSecurity.model;

import javax.persistence.*;

@Entity
@Table(name="user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long userId;
    @Column(name="username")
    private String userName;
    private String email;
    private String password;
    private boolean enabled = true;

    public UserAccount() {
    }

//    public UserAccount(long userId, String userName, String email, String password, boolean enabled) {
//        this.userId = userId;
//        this.userName = userName;
//        this.email = email;
//        this.password = password;
//        this.enabled = enabled;
//    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    //
}
