package com.example.Liyakhat_Poc.util;

import com.example.Liyakhat_Poc.model.Town;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class JsonUtilImpl  implements  IJsonUtil{

    @Override
    public <T> T parseJsonString(String json, Class<T> class1) {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = null;
        try {
            t = objectMapper.readValue(json, class1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void main(String[] args) {
        JsonUtilImpl ob = new JsonUtilImpl();
        String input ="[{\"name\" : \"Erumad\", \"population\" : 200}," +
                "{\"name\" : \"SBY\", \"population\" : 1000}]";

        Town[] towns = ob.parseJsonString(input, Town[].class);
        Arrays.stream(towns).forEach(System.out::println);

        //towns[0].getName();
    }


}
