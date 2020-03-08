package com.example.Liyakhat_Poc.util;

public interface IJsonUtil{

   <T> T parseJsonString(String json, Class<T> expectedClassFormat);
}
