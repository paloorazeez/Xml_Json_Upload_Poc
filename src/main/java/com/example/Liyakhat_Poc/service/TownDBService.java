package com.example.Liyakhat_Poc.service;

import com.example.Liyakhat_Poc.entity.DBTown;
import com.example.Liyakhat_Poc.entity.DBTownRepository;
import com.example.Liyakhat_Poc.model.Town;
import com.example.Liyakhat_Poc.util.IJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TownDBService implements IDBService {

    @Autowired
    private IJsonUtil jsonUtil;

    @Autowired
    private DBTownRepository townRepository;
    
    @Override
    public void process(String input) {

        //convert the json to pojo
        Town[] towns = jsonUtil.parseJsonString(input, Town[].class);
        //convert input pojo to enitiy
        DBTown[] dbTowns = convertToDBEntity(towns);
        Arrays.stream(dbTowns).forEach(System.out::println);
        //persist
        townRepository.saveAll(Arrays.asList(dbTowns));

    }

    private DBTown[] convertToDBEntity(Town[] towns) {

        DBTown[] dbTowns = new DBTown[towns.length];
        for(int i=0;i<towns.length;i++)
        {
            DBTown dbTown = new DBTown(towns[i]);
            dbTowns[i] = dbTown;
        }
        return dbTowns;
    }
}
