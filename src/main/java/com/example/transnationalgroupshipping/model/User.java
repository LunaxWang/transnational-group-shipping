package com.example.transnationalgroupshipping.model;

import javax.persistence.*;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "telephone"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password")
    private String password;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "role")
    private String role;

    public User(){

    }

    public User(String nickname, String password, String telephone, String role) {
        this.nickname = nickname;
        this.password = password;
        this.telephone = telephone;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickName) {
        this.nickname = nickName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
