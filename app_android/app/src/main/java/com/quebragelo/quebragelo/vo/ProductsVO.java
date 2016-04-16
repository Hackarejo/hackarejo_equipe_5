package com.quebragelo.quebragelo.vo;

/**
 * Created by Ezequiel on 16/04/2016.
 */
public class ProductsVO {

    private int productsId;

    private String name;

    private Double price ;

    private CompaniesVO companies;

    public int getProductsId() {
        return productsId;
    }

    public void setProductsId(int productsId) {
        this.productsId = productsId;
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

    public CompaniesVO getCompanies() {
        return companies;
    }

    public void setCompanies(CompaniesVO companies) {
        this.companies = companies;
    }
}
