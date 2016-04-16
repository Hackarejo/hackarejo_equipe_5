package com.quebragelo.quebragelo.vo;

/**
 * Created by Ezequiel on 16/04/2016.
 */
public class VouchersVO {

    private int vouchersId;

    private String code;

    private OffersVO offers;




    public int getVouchersId() {
        return vouchersId;
    }

    public void setVouchersId(int vouchersId) {
        this.vouchersId = vouchersId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OffersVO getOffers() {
        return offers;
    }

    public void setOffers(OffersVO offers) {
        this.offers = offers;
    }
}
