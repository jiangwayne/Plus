package com.plus.server.model;

/**
 * Created by jiangwulin on 16/5/22.
 */
public class User {
    private String phone;
    private String email;
    private String password_hash;
    private String password_salt;
    private int valid;

    public User(String phone, String email)
    {
        this.phone = phone;
        this.email = email;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword_hash(String password_hash)
    {
        this.password_hash = password_hash;
    }

    public void setPassword_salt(String password_salt)
    {
        this.password_salt = password_salt;
    }

    public void setValid(int valid)
    {
        this.valid = valid;
    }
}
