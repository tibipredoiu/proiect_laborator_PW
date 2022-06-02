package com.example.proiectfinal;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(nullable = false, unique = true, length = 60)
    private String email;

    //get-ari
    public Long getID() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    //set-ari
    public void setID(Long Id) {
        this.Id = Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
