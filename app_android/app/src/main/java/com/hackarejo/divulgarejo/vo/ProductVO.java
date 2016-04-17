package com.hackarejo.divulgarejo.vo;

import com.hackarejo.divulgarejo.helper.WebAddressable;

/**
 * Created by Ezequiel on 16/04/2016.
 */
public class ProductVO implements WebAddressable {

    private int Id;

    private String name;

    private Double price ;

    private CompanyVO companies;

    public int getProductsId() {
        return Id;
    }

    public void setProductsId(int productsId) {
        this.Id = productsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CompanyVO getCompanies() {
        return companies;
    }

    public void setCompanies(CompanyVO companies) {
        this.companies = companies;
    }

    @Override
    public String getPath() {
        return "products";
    }

    @Override
    public Boolean hasId() {
        return getProductsId() > 0;
    }

    @Override
    public int getId() {
        return getProductsId();
    }
}
