package com.SpringProject.Task.Management.Application.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long users_id;
    @Column(name="name",nullable=false)
    private String name;
    @Column(name="email",nullable=false)
    private String email;
    @Column(name="password",nullable=false)
    private String password;


    public void setUsers_id(long id){
         this.users_id=id;
    }

    public long getUsers_id(){
        return users_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


}
