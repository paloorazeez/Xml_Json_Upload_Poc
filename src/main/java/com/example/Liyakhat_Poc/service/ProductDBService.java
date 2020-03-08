package com.example.Liyakhat_Poc.service;

import com.example.Liyakhat_Poc.entity.DBBranch;
import com.example.Liyakhat_Poc.entity.DBBranchRepository;
import com.example.Liyakhat_Poc.entity.DBProduct;
import com.example.Liyakhat_Poc.entity.DBProductRepository;
import com.example.Liyakhat_Poc.model.Products;
import com.example.Liyakhat_Poc.util.IXmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductDBService  implements IDBService{

    @Autowired
    private IXmlUtil xmlUtil;

    @Autowired
    private DBProductRepository productRepository;

    @Autowired
    private DBBranchRepository branchRepository;

    @Override
    public <T> void process(String input) {

        //convert the json to pojo
        Products products = xmlUtil.parseXmlString(input, Products.class);
        //convert input pojo to enitiy
        List<DBProduct> dbProductList= convertToDBEntity(products);
        dbProductList.forEach(System.out::println);
        //persist
        productRepository.saveAll(dbProductList);
    }

    private List<DBProduct> convertToDBEntity(Products products) {

        List<DBProduct> dbProductList = new ArrayList<>();
        Arrays.stream(products.getProduct()).forEach(p->{
            DBProduct dbProduct = new DBProduct();
            dbProduct.setClients(p.getClients());
            dbProduct.setName(p.getName());
            if(p.getBranch() != null && !"".equals(p.getBranch().trim()))
            {
                DBBranch branch = branchRepository.findByName(p.getBranch());
                if(branch != null)
                {
                    dbProduct.setBranch(branch);
                    dbProductList.add(dbProduct);

                }else {
                    System.out.println("Branch:"+p.getBranch()+" doesn't exist");
                }
            }
            else {
                System.out.println("Branch is empty");
            }
        });

        return dbProductList;
    }
}
