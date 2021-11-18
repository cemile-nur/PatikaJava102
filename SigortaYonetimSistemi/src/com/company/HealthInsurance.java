package com.company;

import java.util.Date;

public class HealthInsurance extends  Insurance{

    public HealthInsurance(String insuranceName, int insurancePrice, Date insuranceStartandFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartandFinishDate);
    }

    @Override
    public double InsuranceCalculate() {
        return 0;
    }
}
