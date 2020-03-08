package com.example.Liyakhat_Poc.util;

import com.example.Liyakhat_Poc.model.Employees;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class XmlUtil implements IXmlUtil{

    @Override
    public <T> T parseXmlString(String xml, Class<T> class1) {
        T t = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(class1);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));
            System.out.println(t);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return t;
    }


    public static void main(String[] args) throws IOException {
        /*XmlUtil util = new XmlUtil();
        String input = new String(Files.readAllBytes(Paths.get("/Users/azeezpaloor/Documents/workspace/poc/Java Task_v2 2/resources/files/xml/products.xml")));
        util.parseXmlString(input,Products.class);*/

        XmlUtil util = new XmlUtil();
        String input = new String(Files.readAllBytes(Paths.get("/Users/azeezpaloor/Documents/workspace/poc/Java Task_v2 2/resources/files/xml/employees.xml")));
        util.parseXmlString(input, Employees.class);
    }

}
