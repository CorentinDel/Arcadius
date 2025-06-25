package com.cd.Arcadius.Pack;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Date;

import com.cd.Arcadius.User.User;

import jakarta.persistence.Column;

@Entity
@Table(name = "pack")
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "next_at")
    private Date nextAt;

    @OneToOne(mappedBy = "pack")
    private User user;

    public Pack() {
    }

    public Pack(int amount, Date nextAt) {
        this.amount = amount;
        this.nextAt = nextAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getNextAt() {
        return nextAt;
    }

    public void setNextAt(Date nextAt) {
        this.nextAt = nextAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
