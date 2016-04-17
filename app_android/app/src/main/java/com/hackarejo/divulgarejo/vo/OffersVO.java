package com.hackarejo.divulgarejo.vo;

import java.util.Date;


    public class OffersVO {

        private int offersId;

        private Date dual_date;

        private  String description;

        private String title;


        private CompanyVO companies;

        private ProductVO products;

    public CompanyVO getCompanies() {
        return companies;
    }

    public void setCompanies(CompanyVO companies) {
        this.companies = companies;
    }

    public ProductVO getProducts() {
        return products;
    }

    public void setProducts(ProductVO products) {
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
