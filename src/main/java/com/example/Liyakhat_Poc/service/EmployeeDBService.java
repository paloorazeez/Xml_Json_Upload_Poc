package com.example.Liyakhat_Poc.service;

import com.example.Liyakhat_Poc.entity.*;
import com.example.Liyakhat_Poc.model.Employees;
import com.example.Liyakhat_Poc.util.IXmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeDBService implements IDBService {

    @Autowired
    private IXmlUtil xmlUtil;

    @Autowired
    private DBEmployeeRepository employeeRepository;

    @Autowired
    private DBBranchRepository branchRepository;

    @Autowired
    private CardRepository cardRepository;


    @Override
    public <T> void process(String input) {

        //convert the json to pojo
        Employees employees = xmlUtil.parseXmlString(input, Employees.class);
        //convert input pojo to enitiy
        List<DBEmployee> dbEmployeeList= convertToDBEntity(employees);
        dbEmployeeList.forEach(System.out::println);
        //persist
        employeeRepository.saveAll(dbEmployeeList);
    }

    private List<DBEmployee> convertToDBEntity(Employees employees) {
        List<DBEmployee> dbEmployeeList = new ArrayList<>();
        Arrays.stream(employees.getEmployee()).forEach(e->{
            DBEmployee dbEmployee = new DBEmployee();
            dbEmployee.setFirstName(e.getFirstName());
            dbEmployee.setLastName(e.getLastName());
            dbEmployee.setPosition(e.getPosition());
            if(e.getCard() == null || "".equals(e.getCard())) {
                System.out.println("Card is empty for employee:"+e.getFirstName()+" "+e.getLastName());
                return;

            }
            DBEmpCard card = cardRepository.findByNumber(e.getCard());
            if(card == null)
            {
                System.out.println("Card:"+e.getCard()+" doesn't exists");
                return;
            }
            dbEmployee.setCard(card);


            if(e.getBranch() == null || "".equals(e.getBranch()))
            {
                System.out.println("Branch is empty for Employee:"+e.getFirstName()+ " "+e.getLastName());
                return;
            }
            DBBranch branch = branchRepository.findByName(e.getBranch());
            if(branch == null)
            {
                System.out.println("Branch: "+ e.getBranch()+" doesn't exists");
                return;

            }
            dbEmployee.setBranch(branch);

           dbEmployeeList.add(dbEmployee);


        });

        return dbEmployeeList;
    }
}
