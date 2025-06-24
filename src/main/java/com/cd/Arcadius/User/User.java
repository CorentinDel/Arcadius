package com.cd.Arcadius.User;

import com.cd.Arcadius.Account.Account;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "level_xp", nullable = false)
    private Integer levelXp;

    @Column(name = "total_xp", nullable = false)
    private Long totalXp;

    public User() {
    }

    public User(String username, Integer level, Integer levelXp, Long totalXp) {
        this.username = username;
        this.level = level;
        this.levelXp = levelXp;
        this.totalXp = totalXp;
    }

    @OneToOne(mappedBy = "user")
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLevelXp() {
        return levelXp;
    }

    public void setLevelXp(Integer levelXp) {
        this.levelXp = levelXp;
    }

    public Long getTotalXp() {
        return totalXp;
    }

    public void setTotalXp(Long totalXp) {
        this.totalXp = totalXp;
    }
}
