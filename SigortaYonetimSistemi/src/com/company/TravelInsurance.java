package com.company;

import java.util.Date;

public class TravelInsurance extends Insurance{
    public TravelInsurance(String insuranceName, int insurancePrice, Date insuranceStartandFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartandFinishDate);
    }

    @Override
    public double InsuranceCalculate() {
        return 0;
    }
}
