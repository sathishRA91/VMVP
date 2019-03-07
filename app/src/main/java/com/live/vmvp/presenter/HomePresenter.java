package com.live.vmvp.presenter;

import com.live.vmvp.contract.HomeContract;

public class HomePresenter {

    private HomeContract view;

    public HomePresenter(HomeContract view) {

        this.view = view;

        initPresenter();
    }


    private void initPresenter() {

        view.initView();
    }

    public void navigation(String navigate)
    {
        if (navigate.equals("CustomerAdd"))
        {
            view.navigateCustomerAdd();
        }
        else if (navigate.equals("CustomerView"))
        {
            view.navigateCustomerView();
        }
        else if (navigate.equals("Receive"))
        {
            view.navigateReceive();
        }
        else if (navigate.equals("History"))
        {
            view.navigateHistory();
        }
        else if (navigate.equals("Calculation"))
        {
            view.navigateCalculationAdd();
        }

    }

}
