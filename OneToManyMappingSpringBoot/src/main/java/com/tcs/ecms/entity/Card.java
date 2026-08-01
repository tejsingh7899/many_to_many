package com.tcs.ecms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Card {
    @Id
    private Integer cardId;
    private String cardNumber;
    private LocalDate expiryDate;

    public Card() {
    }

    public Card(Integer cardId, String cardNumber, LocalDate expiryDate) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardId, card.cardId) && Objects.equals(cardNumber, card.cardNumber) && Objects.equals(expiryDate, card.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardNumber, expiryDate);
    }
}
