package com.live.vmvp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.live.vmvp.R;
import com.live.vmvp.contract.CalculationContract;
import com.live.vmvp.model.DataModelCalculation;
import com.live.vmvp.presenter.CalculationPresenter;

public class CalculationActivity extends AppCompatActivity implements View.OnClickListener, CalculationContract, CompoundButton.OnCheckedChangeListener {

    private TextView Tv_houseNumber, Tv_residentName, Tv_rendAmount, Tv_OldebUnit,Tv_waterAmount, Tv_maintenceAmount;

    private Switch Sv_eb, Sv_waterCharge, Sv_maintenceCharge;

    private EditText Et_ebCurrentUnit, Et_ebUnitPerAmount;

    private Button Bt_calculate;

    private CalculationPresenter presenter;

    private boolean is_EB, is_Water, is_Maintain;

    private String customerId,calculateDate,totalAmount,receiveDate,receivedAmount,pendingAmount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        presenter = new CalculationPresenter(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.Bt_calculate) {

            presenter.validationCalculation(customerId,calculateDate,Tv_residentName.getText().toString(),
                    Tv_houseNumber.getText().toString(),Tv_rendAmount.getText().toString(),
                    is_Water,Tv_waterAmount.getText().toString(),is_EB,"",is_Maintain,
                    Tv_maintenceAmount.getText().toString(),totalAmount,receiveDate,receivedAmount,pendingAmount);
        }

    }

    @Override
    public void initView() {
        Tv_houseNumber = findViewById(R.id.Tv_houseNumber);
        Tv_residentName = findViewById(R.id.Tv_residentName);
        Tv_rendAmount = findViewById(R.id.Tv_rendAmount);
        Tv_OldebUnit = findViewById(R.id.Tv_OldebUnit);
        Tv_maintenceAmount = findViewById(R.id.Tv_maintenceAmount);
        Tv_waterAmount=findViewById(R.id.Tv_waterAmount);

        Sv_eb = findViewById(R.id.Sv_eb);
        Sv_waterCharge = findViewById(R.id.Sv_waterCharge);
        Sv_maintenceCharge = findViewById(R.id.Sv_maintenceCharge);
        Et_ebCurrentUnit = findViewById(R.id.Et_ebCurrentUnit);
        Et_ebUnitPerAmount = findViewById(R.id.Et_ebUnitPerAmount);
        Bt_calculate = findViewById(R.id.Bt_calculate);

        Bt_calculate.setOnClickListener(this);
        Sv_eb.setOnCheckedChangeListener(this);
        Sv_waterCharge.setOnCheckedChangeListener(this);
        Sv_maintenceCharge.setOnCheckedChangeListener(this);
    }

    @Override
    public void calculate(DataModelCalculation dataModel) {

    }

    @Override
    public boolean validation(DataModelCalculation dataModel) {
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {

        if (buttonView.getId() == R.id.Sv_eb) {
            is_EB = isChecked;
        } else if (buttonView.getId() == R.id.Sv_waterCharge) {
            is_Water = isChecked;
        } else if (buttonView.getId() == R.id.Sv_maintenceCharge) {
            is_Maintain = isChecked;
        }

    }
}