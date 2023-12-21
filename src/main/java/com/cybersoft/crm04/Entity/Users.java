package com.cybersoft.crm04.Entity;

import jakarta.persistence.*;
import lombok.Data;

/*
 * để mapping khóa ngoại trong entity:
 * bước 1: xem khóa chính 2 bảng quan hệ với nhau có phải là tự động tăng hay không.Nếu tựu động tăng
 *  thì không phải là OneToOne => OneToMany
 * Bước 2: Nếu khóa chính không tựu đông tăng vầ vừa là khóa chính và khóa ngoại =>OneToOne;
 *
 *
 * (*) : OneToMany: Entity nào giữ khóa ngoại thì sẽ có 2 Anotation sau đây:
 * -@ManyToOne và @JoinColunm
 * Bảng nào được tham chiếu khóa ngoại sẽ map ngược lại
 * */
@Entity(name = "users")
@Data
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "avatar")
    private String avatar;
 /*   @Column(name = "role_id")
    private int roleid;*/

@ManyToOne
    @JoinColumn(name = "role_id")//tên cột khóa ngoại trong database dùng để liên kết dữ liệu
    private Roles roles;//dựa vào OneToMany hay ManyToOne thì sẽ biết được 1 list đối tượng(OneToMany)
    // hay 1 đối tượng(ManyToOne)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
