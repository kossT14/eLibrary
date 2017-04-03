/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author koss
 */
public class UserBean {

    private String username;
    private String password;
    private String role;
    private int userId;
    public boolean valid;

    public UserBean() {
        this.username = "";
        this.password = "";
        this.role = "";
        this.userId = createID();
    }
    
    static AtomicInteger idCounter = new AtomicInteger();

    private static int createID() {
        return idCounter.incrementAndGet();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
