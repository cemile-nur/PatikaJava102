package com.company;

import java.util.Date;

public class CarInsurance extends Insurance{
    public CarInsurance(String insuranceName, int insurancePrice, Date insuranceStartandFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartandFinishDate);
    }

    @Override
    public double InsuranceCalculate() {
        return 0;
    }
}
