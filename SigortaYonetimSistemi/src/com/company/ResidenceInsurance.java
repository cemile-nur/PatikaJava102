package com.company;

import java.util.Date;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance(String insuranceName, int insurancePrice, Date insuranceStartandFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartandFinishDate);
    }

    @Override
    public double InsuranceCalculate() {
        return 0;
    }
}
