package com.live.vmvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.live.vmvp.R;
import com.live.vmvp.contract.HomeContract;
import com.live.vmvp.presenter.HomePresenter;

public class HomeActivity extends AppCompatActivity implements HomeContract, View.OnClickListener {

    private HomePresenter homePresenter;
    private Button Bt_Rcalc, Bt_Cadd, Bt_Cview, Bt_Rreceive, Bt_Rhistory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homePresenter = new HomePresenter(this);
    }

    @Override
    public void navigateCustomerAdd() {

        Intent customerAddIntent=new Intent(HomeActivity.this,CustomerActivity.class);
        startActivity(customerAddIntent);

    }

    @Override
    public void navigateCustomerView() {
        Intent customerViewIntent=new Intent(HomeActivity.this,CustomerViewActivity.class);
        startActivity(customerViewIntent);
    }

    @Override
    public void navigateCalculationAdd() {

        Intent calculationIntent=new Intent(HomeActivity.this,CalculationActivity.class);
        startActivity(calculationIntent);

    }

    @Override
    public void navigateReceive() {
        Intent ReceiveIntent=new Intent(HomeActivity.this,ReceiveActivity.class);
        startActivity(ReceiveIntent);
    }

    @Override
    public void navigateHistory() {
        Intent historyIntent=new Intent(HomeActivity.this,HistoryActivity.class);
        startActivity(historyIntent);
    }

    @Override
    public void initView() {

        Bt_Rcalc = findViewById(R.id.Bt_Rcalc);
        Bt_Cadd = findViewById(R.id.Bt_Cadd);
        Bt_Cview = findViewById(R.id.Bt_Cview);
        Bt_Rreceive = findViewById(R.id.Bt_Rreceive);
        Bt_Rhistory = findViewById(R.id.Bt_Rhistory);

        Bt_Rcalc.setOnClickListener(this);
        Bt_Cadd.setOnClickListener(this);
        Bt_Cview.setOnClickListener(this);
        Bt_Rreceive.setOnClickListener(this);
        Bt_Rhistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.Bt_Rcalc) {
            homePresenter.navigation("Calculation");
        } else if (v.getId() == R.id.Bt_Cadd) {
            homePresenter.navigation("CustomerAdd");
        } else if (v.getId() == R.id.Bt_Cview) {
            homePresenter.navigation("CustomerView");
        } else if (v.getId() == R.id.Bt_Rreceive) {
            homePresenter.navigation("Receive");
        } else if (v.getId() == R.id.Bt_Rhistory) {
            homePresenter.navigation("History");
        }

    }
}
