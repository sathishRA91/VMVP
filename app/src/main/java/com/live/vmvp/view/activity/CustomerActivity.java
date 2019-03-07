package com.live.vmvp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.live.vmvp.R;
import com.live.vmvp.contract.CustomerAddContract;
import com.live.vmvp.presenter.CustomerAddPresenter;

public class CustomerActivity extends AppCompatActivity implements CustomerAddContract, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText Et_houseNumber, Et_residentName, et_residentMobileNumber, et_advanceAmount,
            Et_rendAmount, Et_ebUnit, Et_waterAmount, Et_maintenceAmount;
    private CheckBox Cb_advanceReceived;
    private Switch Sv_waterCharge, Sv_maintenceCharge;

    private Button Bt_AddResident;

    private CustomerAddPresenter presenter;
    private boolean isAdvance, isWater, isMaintence;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add);

        presenter = new CustomerAddPresenter(this);
    }

    @Override
    public void initView() {

        Et_houseNumber = findViewById(R.id.Et_houseNumber);
        Et_residentName = findViewById(R.id.Et_residentName);
        et_residentMobileNumber = findViewById(R.id.et_residentMobileNumber);
        et_advanceAmount = findViewById(R.id.et_advanceAmount);
        Et_rendAmount = findViewById(R.id.Et_rendAmount);
        Et_ebUnit = findViewById(R.id.Et_ebUnit);
        Et_waterAmount = findViewById(R.id.Et_waterAmount);
        Et_maintenceAmount = findViewById(R.id.Et_maintenceAmount);
        Cb_advanceReceived = findViewById(R.id.Cb_advanceReceived);
        Sv_waterCharge = findViewById(R.id.Sv_waterCharge);
        Sv_maintenceCharge = findViewById(R.id.Sv_maintenceCharge);
        Bt_AddResident = findViewById(R.id.Bt_AddResident);

        Bt_AddResident.setOnClickListener(this);

        Cb_advanceReceived.setOnCheckedChangeListener(this);
        Sv_waterCharge.setOnCheckedChangeListener(this);
        Sv_maintenceCharge.setOnCheckedChangeListener(this);
    }

    @Override
    public void addResident() {

        Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean validation(String houseNumber, String residentName, String residentMobileNumber,
                              String advanceAmount, boolean isAdvanceDone, String rendAmount,
                              String ebUnit, boolean isWater, String waterAmount,
                              boolean isMaintenace, String maintenceAmount) {


        boolean house, name, mobileNumber, advance, rent, eb, water, maintenance;


        house = houseNumber != null && houseNumber.length() > 0;
        name = residentName != null && residentName.length() > 0;
        mobileNumber = residentMobileNumber != null && residentMobileNumber.length() == 10;
        advance = advanceAmount != null && advanceAmount.length() > 0;
        rent = rendAmount != null && rendAmount.length() > 0;
        eb = ebUnit != null && ebUnit.length() > 0;
        water = waterAmount != null && waterAmount.length() > 0;
        maintenance = maintenceAmount != null && maintenceAmount.length() > 0;


        if (house) {
            Et_houseNumber.setError(null);
        } else {
            Et_houseNumber.setError("Invalid house details");
        }


        if (name) {
            Et_residentName.setError(null);
        } else {
            Et_residentName.setError("Invalid Resident Name");
        }

        if (mobileNumber) {
            et_residentMobileNumber.setError(null);
        } else {
            et_residentMobileNumber.setError("Invalid Mobile Number");
        }


        if (advance) {
            et_advanceAmount.setError(null);
        } else {
            et_advanceAmount.setError("Invalid Advance Amount");
        }


        if (rent) {
            Et_rendAmount.setError(null);
        } else {
            Et_rendAmount.setError("Invalid Rent Amount");
        }


        if (eb) {
            Et_ebUnit.setError(null);
        } else {
            Et_ebUnit.setError("Invalid Eb Unit");
        }


        if (isWater) {
            if (water) {
                Et_waterAmount.setError(null);
            } else {
                Et_waterAmount.setError("Invalid Water Amount");

                water = false;
            }

        } else {
            water = true;
        }


        if (isMaintenace) {

            if (maintenance) {
                Et_maintenceAmount.setError(null);
            } else {
                Et_maintenceAmount.setError("Invalid Maintenance Amount");
            }

        } else {
            maintenance = true;
        }

        return house && name && mobileNumber && advance && rent && eb && water && maintenance;


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.Bt_AddResident) {

            presenter.Validation(Et_houseNumber.getText().toString().trim(),
                    Et_residentName.getText().toString().trim(),
                    et_residentMobileNumber.getText().toString().trim(),
                    et_advanceAmount.getText().toString().trim(),
                    isAdvance, Et_rendAmount.getText().toString().trim(),
                    Et_ebUnit.getText().toString().trim(),
                    isWater, Et_waterAmount.getText().toString().trim(),
                    isMaintence, Et_maintenceAmount.getText().toString().trim());
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


        if (buttonView.getId() == R.id.Cb_advanceReceived) {

            isAdvance = isChecked;
        } else if (buttonView.getId() == R.id.Sv_waterCharge) {
            isWater = isChecked;
        } else if (buttonView.getId() == R.id.Sv_maintenceCharge) {
            isMaintence = isChecked;
        }
    }
}
