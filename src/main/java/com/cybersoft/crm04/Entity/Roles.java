package com.cybersoft.crm04.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "roles")
@Data
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
private int id;
    @Column(name = "name")
private String name;
    @Column(name = "description")
private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @OneToMany(mappedBy = "roles") //Tên của thuộc tính Entity khai báo Users trong package Entity
private List<Users> users;
}
