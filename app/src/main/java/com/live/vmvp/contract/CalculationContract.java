package com.live.vmvp.contract;

import com.live.vmvp.model.DataModelCalculation;

public interface CalculationContract {

    void initView();

    void calculate(DataModelCalculation dataModel);

    boolean validation(DataModelCalculation dataModel);

}
