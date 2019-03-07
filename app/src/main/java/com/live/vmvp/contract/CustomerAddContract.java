package com.live.vmvp.contract;

import com.live.vmvp.model.DataModelAddCustomer;

public interface CustomerAddContract {

    void initView();

    void addResident(DataModelAddCustomer dataModel);

    boolean validation(DataModelAddCustomer dataModel);

}
