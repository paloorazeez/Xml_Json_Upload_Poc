package com.example.Liyakhat_Poc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "branches")
public class DBBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JsonIgnoreProperties("branchList")
    @JoinColumn(name = "town_id")
    private DBTown dbTown;

    @OneToMany
    private List<DBProduct> productList;

    @OneToMany
    private List<DBEmployee> employeeList;

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

    public DBTown getDbTown() {
        return dbTown;
    }

    public void setDbTown(DBTown dbTown) {
        this.dbTown = dbTown;
    }

    public List<DBProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<DBProduct> productList) {
        this.productList = productList;
    }

    public List<DBEmployee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<DBEmployee> employeeList) {
        this.employeeList = employeeList;
    }
}
