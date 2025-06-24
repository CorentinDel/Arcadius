package com.cd.Arcadius.Card;

import java.util.Set;

import com.cd.Arcadius.Card.Enum.CardRarityEnum;
import com.cd.Arcadius.Card.Enum.CardTypeEnum;
import com.cd.Arcadius.UserCard.UserCard;

import jakarta.persistence.*;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "c_name", nullable = false)
    private String name;

    @Column(name = "c_filename")
    private String filename;

    @Column(name = "c_type")
    private CardTypeEnum type;

    @Column(name = "c_rarity")
    private CardRarityEnum rarity;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private Set<UserCard> userCards;

    public Set<UserCard> getUserCards() {
        return userCards;
    }

    public void setUserCards(Set<UserCard> userCards) {
        this.userCards = userCards;
    }

    public CardTypeEnum getType() {
        return type;
    }

    public void setType(CardTypeEnum type) {
        this.type = type;
    }

    public CardRarityEnum getRarity() {
        return rarity;
    }

    public void setRarity(CardRarityEnum rarity) {
        this.rarity = rarity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
