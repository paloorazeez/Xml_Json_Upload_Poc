package com.example.Liyakhat_Poc.entity;

import org.springframework.data.repository.CrudRepository;

public interface DBBranchRepository extends CrudRepository<DBBranch, Long> {

    DBBranch findByName(String name);

}
