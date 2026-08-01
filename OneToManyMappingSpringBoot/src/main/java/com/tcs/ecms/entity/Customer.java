package com.tcs.ecms.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer customerId;
    @Column(name="emailid")
    private String emailId;
    private String name;
    private LocalDate dateOfBirth;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="cust_id")
    private List<Card> cards;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(emailId, customer.emailId) && Objects.equals(name, customer.name) && Objects.equals(dateOfBirth, customer.dateOfBirth) && Objects.equals(cards, customer.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, emailId, name, dateOfBirth, cards);
    }
}
