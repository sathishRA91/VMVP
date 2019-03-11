package com.live.vmvp.presenter;

import com.live.vmvp.contract.CustomerAddContract;
import com.live.vmvp.model.DataModelAddCustomer;

public class CustomerAddPresenter {


    private CustomerAddContract view;

    private DataModelAddCustomer dataModel;

    public CustomerAddPresenter(CustomerAddContract view)
    {
        this.view = view;
        initPresenter();
    }

    private void initPresenter() {

        view.initView();

        dataModel=new DataModelAddCustomer();
    }


    public void Validation(String houseNumber, String residentName, String residentMobileNumber,
                           String advanceAmount, boolean isAdvanceDone, String rendAmount,
                           String ebUnit, boolean isWater, String waterAmount,
                           boolean isMaintenace, String maintenceAmount,String residentJoinDate) {


        dataModel.setCustomerAdd_houseNumber(houseNumber);
        dataModel.setCustomerAdd_residentName(residentName);
        dataModel.setCustomerAdd_residentMobileNumber(residentMobileNumber);
        dataModel.setCustomerAdd_advanceAmount(advanceAmount);
        dataModel.setCustomerAdd_isAdvanceDone(isAdvanceDone);
        dataModel.setCustomerAdd_rendAmount(rendAmount);
        dataModel.setCustomerAdd_ebUnit(ebUnit);
        dataModel.setCustomerAdd_isWater(isWater);
        dataModel.setCustomerAdd_waterAmount(waterAmount);
        dataModel.setCustomerAdd_isMaintenace(isMaintenace);
        dataModel.setCustomerAdd_maintenceAmount(maintenceAmount);
        dataModel.setCustomerAdd_joinDate(residentJoinDate);
        dataModel.setCustomerAdd_FirstEbUnit(ebUnit);
        dataModel.setCustomerAdd_SecondEbUnit(ebUnit);


        boolean check = view.validation(dataModel);

        if (check) {
            view.addResident(dataModel);
        }

    }

}
