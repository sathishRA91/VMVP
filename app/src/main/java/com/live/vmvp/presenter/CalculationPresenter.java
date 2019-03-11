package com.live.vmvp.presenter;

import com.live.vmvp.contract.CalculationContract;
import com.live.vmvp.model.DataModelCalculation;

public class CalculationPresenter {

    private CalculationContract view;

    private DataModelCalculation calculation;

    public CalculationPresenter(CalculationContract view) {
        this.view = view;
        initPresenter();
    }


    private void initPresenter() {
        view.initView();
        calculation = new DataModelCalculation();
    }


    public void validationCalculation(String caluculate_customer_id,
                                      String caluculate_date,
                                      String caluculate_customer_name, String caluculate_house_no,
                                      String caluculate_rent_amount,
                                      boolean caluculate_is_water, String caluculate_water_amount,
                                      boolean caluculate_is_eb, String caluculate_eb_amount,
                                      boolean caluculate_is_maintain, String caluculate_maintain_charge,
                                      String caluculate_total_amount,
                                      String caluculate_receive_date, String caluculate_received_amount,
                                      String caluculate_pending_amount)
    {


        calculation.setCaluculate_customer_id(caluculate_customer_id);
        calculation.setCaluculate_date(caluculate_date);
        calculation.setCaluculate_customer_name(caluculate_customer_name);
        calculation.setCaluculate_house_no(caluculate_house_no);
        calculation.setCaluculate_rent_amount(caluculate_rent_amount);
        calculation.setCaluculate_is_water(caluculate_is_water);
        calculation.setCaluculate_water_amount(caluculate_water_amount);
        calculation.setCaluculate_is_eb(caluculate_is_eb);
        calculation.setCaluculate_eb_amount(caluculate_eb_amount);
        calculation.setCaluculate_is_maintain(caluculate_is_maintain);
        calculation.setCaluculate_maintain_charge(caluculate_maintain_charge);
        calculation.setCaluculate_total_amount(caluculate_total_amount);
        calculation.setCaluculate_receive_date(caluculate_receive_date);
        calculation.setCaluculate_received_amount(caluculate_received_amount);
        calculation.setCaluculate_pending_amount(caluculate_pending_amount);

        boolean check=view.validation(calculation);

        if (check)
        {
            view.calculate(calculation);
        }

    }
}
