package com.auction.couchdb.repository.entity;

/**
 * Created by hsupar on 9/15/2016.
 */
public class User {

    private String id;

    private String email;

    private String name;

    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" + "id='" + id + "', email='" + email + "', name='" + name
            + "', password='" + password + "'}";
    }
}
