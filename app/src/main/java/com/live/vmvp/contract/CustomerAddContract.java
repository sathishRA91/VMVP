package com.live.vmvp.contract;

public interface CustomerAddContract {

    void initView();

    void addResident();

    boolean validation(String houseNumber, String residentName, String residentMobileNumber,
                       String advanceAmount, boolean isAdvanceDone, String rendAmount, String ebUnit,
                       boolean isWater, String waterAmount, boolean isMaintenace, String maintenceAmount);

}
