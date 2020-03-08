package com.example.Liyakhat_Poc.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBTownRepository extends CrudRepository<DBTown, Long> {

    DBTown findByName(String name);

}
