package com.quebragelo.quebragelo.vo;

import java.util.Date;


    public class OffersVO {

        private int offersId;

        private Date dual_date;

        private  String description;

        private String title;


        private CompaniesVO companies;

        private ProductsVO products;

    public CompaniesVO getCompanies() {
        return companies;
    }

    public void setCompanies(CompaniesVO companies) {
        this.companies = companies;
    }

    public ProductsVO getProducts() {
        return products;
    }

    public void setProducts(ProductsVO products) {
        this.products = products;
    }

    public int getOffersId() {
        return offersId;
    }

    public void setOffersId(int offersId) {
        this.offersId = offersId;
    }

    public Date getDual_date() {
        return dual_date;
    }

    public void setDual_date(Date dual_date) {
        this.dual_date = dual_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
