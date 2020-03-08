package com.example.Liyakhat_Poc.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class DBEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    private String firstName;

    private String lastName;

    private String position;

    @OneToOne
    @JoinColumn(name = "card_id")
    private DBEmpCard card;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private DBBranch branch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public DBEmpCard getCard() {
        return card;
    }

    public void setCard(DBEmpCard card) {
        this.card = card;
    }

    public DBBranch getBranch() {
        return branch;
    }

    public void setBranch(DBBranch branch) {
        this.branch = branch;
    }


    @Override
    public String toString() {
        return "DBEmployee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", card=" + card +
                ", branch=" + branch +
                '}';
    }
}
