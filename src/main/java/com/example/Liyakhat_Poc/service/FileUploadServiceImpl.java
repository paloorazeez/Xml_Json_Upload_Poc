package com.example.Liyakhat_Poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileUploadServiceImpl  implements IFileUploadService{

    Map<String, IDBService> dbSrvcMap = null;

    @Autowired
    private TownDBService townDBService;

    @Autowired
    private CardDBService cardDBService;

    @Autowired
    private BranchDBService branchDBService;

    @Autowired
    private ProductDBService productDBService;

    @Autowired
    private EmployeeDBService employeeDBService;



    @PostConstruct
    public void init()
    {
        dbSrvcMap = new HashMap<>();
        dbSrvcMap.put("towns", townDBService);
        dbSrvcMap.put("cards", cardDBService);
        dbSrvcMap.put("branches", branchDBService);
        dbSrvcMap.put("products", productDBService);
        dbSrvcMap.put("employees", employeeDBService);

    }

    @Override
    public void process(String fileName, String fileType) {

        IDBService dbService = dbSrvcMap.get(fileType);
        dbService.process(fileName);

    }
}
