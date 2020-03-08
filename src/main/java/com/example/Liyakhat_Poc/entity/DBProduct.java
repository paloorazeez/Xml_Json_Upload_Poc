package com.example.Liyakhat_Poc.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class DBProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer clients;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private DBBranch branch;

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

    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }

    public DBBranch getBranch() {
        return branch;
    }

    public void setBranch(DBBranch branch) {
        this.branch = branch;
    }
}
