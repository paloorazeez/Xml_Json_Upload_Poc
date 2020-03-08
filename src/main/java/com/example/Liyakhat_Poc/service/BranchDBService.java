package com.example.Liyakhat_Poc.service;

import com.example.Liyakhat_Poc.entity.DBBranch;
import com.example.Liyakhat_Poc.entity.DBBranchRepository;
import com.example.Liyakhat_Poc.entity.DBTown;
import com.example.Liyakhat_Poc.entity.DBTownRepository;
import com.example.Liyakhat_Poc.model.Branch;
import com.example.Liyakhat_Poc.model.EmployeeCard;
import com.example.Liyakhat_Poc.util.IJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.IntStream;

@Service
public class BranchDBService implements IDBService {

    @Autowired
    private IJsonUtil jsonUtil;

    @Autowired
    private DBBranchRepository branchRepository;

    @Autowired
    private DBTownRepository townRepository;


    @Override
    public <T> void process(String input) {

        //convert the json to pojo
        Branch[] branches = jsonUtil.parseJsonString(input, Branch[].class);
        //convert input pojo to enitiy
        DBBranch[] dbBranches = convertToDBEntity(branches);
        Arrays.stream(dbBranches).forEach(System.out::println);
        //persist
        branchRepository.saveAll(Arrays.asList(dbBranches));
    }

    private DBBranch[] convertToDBEntity(Branch[] branches) {
        DBBranch[] dbBranches = new DBBranch[branches.length];
        IntStream.range(0,branches.length).forEach(index->
        {
            Branch branch = branches[index];
            DBBranch dbBranch = new DBBranch();
            dbBranch.setName(branch.getName());
            if(branch.getTown() != null && !"".equals(branch.getTown().trim()))
            {
                DBTown town= townRepository.findByName(branch.getTown());
                if(town != null)
                {
                    dbBranch.setDbTown(town);
                }
                else
                {
                    System.out.println("Town: "+branch.getTown()+" doesn't exists");
                }

            }
            dbBranches[index] = dbBranch;
        });
        return dbBranches;
    }
}
