package com.live.vmvp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.live.vmvp.model.DataModelAddCustomer;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "RentDb";


    private static final String TABLE_CUSTOMER = "table_customer";
    private static final String TABLE_CALCULATION = "table_calculation";
    private static final String TABLE_HISTORY = "table_history";


    private static final String KEY_CUSTOMER_ID = "key_customer_id";
    private static final String CUSTOMER_NAME = "customer_name";
    private static final String CUSTOMER_MOBILE_NUMBER = "customer_mobile_number";
    private static final String CUSTOMER_HOUSE_NO = "customer_house_no";
    private static final String CUSTOMER_ADVANCE = "customer_advance";
    private static final String CUSTOMER_RENT_AMOUNT = "customer_rent_amount";
    private static final String CUSTOMER_HOUSE_JOIN = "customer_house_join";
    private static final String CUSTOMER_FIRST_TIME_EB_UNIT = "customer_first_time_eb_unit";
    private static final String CUSTOMER_FIRST_EB_UNIT = "customer_first_eb_unit";
    private static final String CUSTOMER_LAST_EB_UNIT = "customer_last_eb_unit";
    private static final String CUSTOMER_IS_WATER = "customer_is_water";
    private static final String CUSTOMER_IS_WATER_AMOUNT = "customer_is_water_amount";
    private static final String CUSTOMER_IS_MAINTENANCE = "customer_is_maintenance";
    private static final String CUSTOMER_MAINTENANCE_CHARGE = "customer_maintenance_charge";

    private static final String KEY_CALUCULATE_ID = "key_caluculate_id";
    private static final String CALUCULATE_CUSTOMER_ID = "caluculate_customer_id";
    private static final String CALUCULATE_DATE = "caluculate_date";
    private static final String CALUCULATE_CUSTOMER_NAME = "caluculate_customer_name";
    private static final String CALUCULATE_HOUSE_NO = "caluculate_house_no";
    private static final String CALUCULATE_RENT_AMOUNT = "caluculate_rent_amount";
    private static final String CALUCULATE_IS_WATER = "caluculate_is_water";
    private static final String CALUCULATE_WATER_AMOUNT = "caluculate_water_amount";
    private static final String CALUCULATE_IS_EB = "caluculate_is_eb";
    private static final String CALUCULATE_EB_AMOUNT = "caluculate_eb_amount";
    private static final String CALUCULATE_IS_MAINTAIN = "caluculate_is_maintain";
    private static final String CALUCULATE_MAINTAIN_CHARGE = "caluculate_maintain_charge";
    private static final String CALUCULATE_TOTAL_AMOUNT = "caluculate_total_amount";
    private static final String CALUCULATE_RECEIVE_DATE = "caluculate_receive_date";
    private static final String CALUCULATE_RECEIVED_AMOUNT = "caluculate_received_amount";
    private static final String CALUCULATE_PENDING_AMOUNT = "caluculate_pending_amount";

    private static final String KEY_HISTORY_ID = "key_history_id";
    private static final String HISTORY_CUSTOMER_ID = "history_customer_id";
    private static final String HISTORY_CALCULATE_DATE = "history_calculate_date";
    private static final String HISTORY_RECEIVE_DATE = "history_receive_date";
    private static final String HISTORY_CALUCULATE_ID = "history_caluculate_id";
    private static final String HISTORY_CUSTOMER_NAME = "history_customer_name";
    private static final String HISTORY_HOUSE_NO = "history_house_no";
    private static final String HISTORY_TOTAL_AMOUNT = "history_total_amount";
    private static final String HISTORY_RECEIVED_AMOUNT = "history_received_amount";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String CREATE_TABLE_CUSTOMER = "CREATE TABLE " + TABLE_CUSTOMER + "("
                + KEY_CUSTOMER_ID + " INTEGER PRIMARY KEY," + CUSTOMER_NAME + " TEXT,"
                + CUSTOMER_MOBILE_NUMBER + " TEXT," + CUSTOMER_HOUSE_NO + " TEXT,"
                + CUSTOMER_ADVANCE + " TEXT," + CUSTOMER_RENT_AMOUNT + " TEXT,"
                + CUSTOMER_HOUSE_JOIN + " TEXT," + CUSTOMER_FIRST_TIME_EB_UNIT + " TEXT,"
                + CUSTOMER_FIRST_EB_UNIT + " TEXT," + CUSTOMER_LAST_EB_UNIT + " TEXT,"
                + CUSTOMER_IS_WATER + " TEXT," + CUSTOMER_IS_WATER_AMOUNT + " TEXT,"
                + CUSTOMER_IS_MAINTENANCE + " TEXT,"
                + CUSTOMER_MAINTENANCE_CHARGE + " TEXT" + ")";


        String CREATE_TABLE_CALCULATION = "CREATE TABLE " + TABLE_CALCULATION + "("
                + KEY_CALUCULATE_ID + " INTEGER PRIMARY KEY," + CALUCULATE_CUSTOMER_ID + " TEXT,"
                + CALUCULATE_DATE + " TEXT," + CALUCULATE_CUSTOMER_NAME + " TEXT,"
                + CALUCULATE_HOUSE_NO + " TEXT," + CALUCULATE_RENT_AMOUNT + " TEXT,"
                + CALUCULATE_IS_WATER + " TEXT," + CALUCULATE_WATER_AMOUNT + " TEXT,"
                + CALUCULATE_IS_EB + " TEXT," + CALUCULATE_EB_AMOUNT + " TEXT,"
                + CALUCULATE_IS_MAINTAIN + " TEXT," + CALUCULATE_MAINTAIN_CHARGE + " TEXT,"
                + CALUCULATE_TOTAL_AMOUNT + " TEXT," + CALUCULATE_RECEIVE_DATE + " TEXT,"
                + CALUCULATE_RECEIVED_AMOUNT + " TEXT,"
                + CALUCULATE_PENDING_AMOUNT + " TEXT" + ")";


        sqLiteDatabase.execSQL(CREATE_TABLE_CUSTOMER);
        sqLiteDatabase.execSQL(CREATE_TABLE_CALCULATION);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALCULATION);


        // Create tables again
        onCreate(db);
    }


    public long INSERT_CUSTOMER(DataModelAddCustomer data) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();

        values.put(CUSTOMER_NAME, data.getCustomerAdd_residentName());
        values.put(CUSTOMER_MOBILE_NUMBER, data.getCustomerAdd_residentMobileNumber());
        values.put(CUSTOMER_HOUSE_NO, data.getCustomerAdd_houseNumber());
        values.put(CUSTOMER_ADVANCE, data.getCustomerAdd_advanceAmount());
        values.put(CUSTOMER_RENT_AMOUNT, data.getCustomerAdd_rendAmount());
        values.put(CUSTOMER_HOUSE_JOIN, data.getCustomerAdd_joinDate());
        values.put(CUSTOMER_FIRST_TIME_EB_UNIT, data.getCustomerAdd_ebUnit());
        values.put(CUSTOMER_FIRST_EB_UNIT, data.getCustomerAdd_FirstEbUnit());
        values.put(CUSTOMER_LAST_EB_UNIT, data.getCustomerAdd_SecondEbUnit());
        values.put(CUSTOMER_IS_WATER, data.isCustomerAdd_isWater());
        values.put(CUSTOMER_IS_WATER_AMOUNT, data.getCustomerAdd_waterAmount());
        values.put(CUSTOMER_IS_MAINTENANCE, data.isCustomerAdd_isMaintenace());
        values.put(CUSTOMER_MAINTENANCE_CHARGE, data.getCustomerAdd_maintenceAmount());

        long id = -1;

        id = db.insert(TABLE_CUSTOMER, null, values);

        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
        return id;
    }


    public ArrayList<DataModelAddCustomer> GETALL_CUSTOMER() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<DataModelAddCustomer> dataList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_CUSTOMER;

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.getCount() > 0) {

            if (cursor.moveToFirst()) {
                do {
                    DataModelAddCustomer modelData = new DataModelAddCustomer();


                    modelData.setCustomerAdd_KeyId(String.valueOf(cursor.getInt(0)));
                    modelData.setCustomerAdd_residentName(cursor.getString(1));
                    modelData.setCustomerAdd_residentMobileNumber(cursor.getString(2));
                    modelData.setCustomerAdd_houseNumber(cursor.getString(3));
                    modelData.setCustomerAdd_advanceAmount(cursor.getString(4));
                    modelData.setCustomerAdd_rendAmount(cursor.getString(5));


                    modelData.setCustomerAdd_joinDate(cursor.getString(6));
                    modelData.setCustomerAdd_ebUnit(cursor.getString(7));
                    modelData.setCustomerAdd_FirstEbUnit(cursor.getString(8));
                    modelData.setCustomerAdd_SecondEbUnit(cursor.getString(9));
                    modelData.setCustomerAdd_isWater(Boolean.parseBoolean(cursor.getString(10)));
                    modelData.setCustomerAdd_waterAmount(cursor.getString(11));
                    modelData.setCustomerAdd_isMaintenace(Boolean.parseBoolean(cursor.getString(12)));
                    modelData.setCustomerAdd_maintenceAmount(cursor.getString(13));
                    dataList.add(modelData);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        return dataList;
    }


    public void DELETE_CUSTOMER(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CUSTOMER, KEY_CUSTOMER_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }


    public void DELETE_ALL_CUSTOMER() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_CUSTOMER, null, null);

        db.close();
    }

/*
    public boolean checkAlreadyTrip(String favourite_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        String sql = "SELECT * FROM " + TABLE_FAVOURITE + " WHERE "
                + FAVOURITE_ID + "='" + favourite_id + "'";
        cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0) {
            cursor.close();
            db.close();
            return true;
        } else {
            cursor.close();
            db.close();
            return false;
        }
    }
*/


}
