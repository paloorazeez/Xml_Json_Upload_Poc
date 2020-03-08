package com.example.Liyakhat_Poc.model;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
public class Employees
{
    private Employee[] employee;

    public Employee[] getEmployee ()
    {
        return employee;
    }

    public void setEmployee (Employee[] employee)
    {
        this.employee = employee;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(employee).forEach(e->sb.append(e.toString()));
        return "Employees [employee = "+sb.toString()+"]";
    }
}
