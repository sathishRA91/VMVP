package com.live.vmvp.presenter;

import com.live.vmvp.contract.CustomerAddContract;

public class CustomerAddPresenter {


    private CustomerAddContract view;

    public CustomerAddPresenter(CustomerAddContract view) {
        this.view = view;
        initPresenter();
    }

    private void initPresenter() {

        view.initView();
    }


    public void Validation(String houseNumber, String residentName, String residentMobileNumber,
                           String advanceAmount, boolean isAdvanceDone, String rendAmount,
                           String ebUnit, boolean isWater, String waterAmount,
                           boolean isMaintenace, String maintenceAmount) {


        boolean check = view.validation(houseNumber, residentName, residentMobileNumber, advanceAmount, isAdvanceDone, rendAmount,
                 ebUnit, isWater, waterAmount, isMaintenace, maintenceAmount);

        if (check) {
            view.addResident();
        }

    }

}
