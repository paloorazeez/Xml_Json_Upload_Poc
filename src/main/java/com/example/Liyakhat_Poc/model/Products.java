package com.example.Liyakhat_Poc.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
public class Products
{
    private Product[] product;

    public Product[] getProduct ()
    {
        return product;
    }

    public void setProduct (Product[] product)
    {
        this.product = product;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(product).forEach(p->sb.append(p.toString()));
        return "Products [product = "+sb.toString()+"]";
    }
}

