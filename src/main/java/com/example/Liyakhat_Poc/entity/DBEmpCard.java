package com.example.Liyakhat_Poc.entity;

import com.example.Liyakhat_Poc.model.Employee;
import com.example.Liyakhat_Poc.model.EmployeeCard;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cards")
public class DBEmpCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToOne
    private DBEmployee employee;

    public DBEmpCard(){}

    public DBEmpCard(EmployeeCard card) {
        this.number = card.getNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public DBEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(DBEmployee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "DBEmpCard{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
