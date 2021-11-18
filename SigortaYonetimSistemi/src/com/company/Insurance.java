package com.company;

import java.util.Date;

public abstract class Insurance {
    private String insuranceName;
    private int insurancePrice;
    private Date insuranceStartandFinishDate;

    public Insurance(String insuranceName, int insurancePrice, Date insuranceStartandFinishDate) {
        this.insuranceName = insuranceName;
        this.insurancePrice = insurancePrice;
        this.insuranceStartandFinishDate = insuranceStartandFinishDate;
    }

    public abstract  double InsuranceCalculate(); //kalıtım alınan sınıfları doldur.
}
