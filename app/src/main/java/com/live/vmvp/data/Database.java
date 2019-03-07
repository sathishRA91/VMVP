/*
package com.live.vmvp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ufours.fusedlocationtest.model.ItemModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "AramDB";


    private static final String TABLE_FAVOURITE = "table_favourite";
    private static final String TABLE_CUSTOMER = "table_customer";
    private static final String TABLE_CALCULATION = "table_calculation";
    private static final String TABLE_HISTORY = "table_history";


    private static final String KEY_FAVOURITE_ID = "key_favourite_id";
    private static final String FAVOURITE_ID = "favourite_id";
    private static final String FAVOURITE_TITLE_NAME = "favourite_title_name";
    private static final String FAVOURITE_DESCRIPTION= "favourite_description";
    private static final String FAVOURITE_AUTHOR = "favourite_author";
    private static final String FAVOURITE_DATE_TIME_AGO = "favourite_date_time_ago";

    private static final String KEY_CUSTOMER_ID = "key_favourite_id";
    private static final String CUSTOMER_NAME = "favourite_id";
    private static final String CUSTOMER_MOBILE_NUMBER = "favourite_id";
    private static final String CUSTOMER_HOUSE_NO = "favourite_id";
    private static final String CUSTOMER_ADVANCE = "favourite_id";
    private static final String CUSTOMER_RENT_AMOUNT = "favourite_id";
    private static final String CUSTOMER_HOUSE_JOIN = "favourite_id";
    private static final String CUSTOMER_IS_EB = "favourite_id";
    private static final String CUSTOMER_FIRST_TIME_EB_UNIT = "favourite_id";
    private static final String CUSTOMER_FIRST_EB_UNIT = "favourite_id";
    private static final String CUSTOMER_LAST_EB_UNIT = "favourite_id";
    private static final String CUSTOMER_IS_WATER = "favourite_id";
    private static final String CUSTOMER_IS_WATER_AMOUNT = "favourite_id";
    private static final String CUSTOMER_IS_MAINTENANCE = "favourite_id";
    private static final String CUSTOMER_MAINTENANCE_CHARGE = "favourite_id";

    private static final String KEY_CALUCULATE_ID = "favourite_id";
    private static final String CALUCULATE_CUSTOMER_ID = "favourite_id";
    private static final String CALUCULATE_DATE = "favourite_id";
    private static final String CALUCULATE_CUSTOMER_NAME = "favourite_id";
    private static final String CALUCULATE_HOUSE_NO = "favourite_id";
    private static final String CALUCULATE_RENT_AMOUNT = "favourite_id";
    private static final String CALUCULATE_IS_WATER = "favourite_id";
    private static final String CALUCULATE_WATER_AMOUNT = "favourite_id";
    private static final String CALUCULATE_IS_EB = "favourite_id";
    private static final String CALUCULATE_EB_AMOUNT = "favourite_id";
    private static final String CALUCULATE_IS_MAINTAIN = "favourite_id";
    private static final String CALUCULATE_MAINTAIN_CHARGE = "favourite_id";
    private static final String CALUCULATE_TOTAL_AMOUNT = "favourite_id";
    private static final String CALUCULATE_RECEIVE_DATE = "favourite_id";
    private static final String CALUCULATE_RECEIVED_AMOUNT = "favourite_id";
    private static final String CALUCULATE_PENDING_AMOUNT = "favourite_id";

    private static final String KEY_HISTORY_ID = "favourite_id";
    private static final String HISTORY_CUSTOMER_ID = "favourite_id";
    private static final String HISTORY_CALCULATE_DATE = "favourite_id";
    private static final String HISTORY_RECEIVE_DATE = "favourite_id";
    private static final String HISTORY_CALUCULATE_ID= "favourite_id";
    private static final String HISTORY_CUSTOMER_NAME = "favourite_id";
    private static final String HISTORY_HOUSE_NO = "favourite_id";
    private static final String HISTORY_TOTAL_AMOUNT = "favourite_id";
    private static final String HISTORY_RECEIVED_AMOUNT = "favourite_id";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String CREATE_TABLE_FAVOURITE = "CREATE TABLE " + TABLE_FAVOURITE + "("
                + KEY_FAVOURITE_ID + " INTEGER PRIMARY KEY," + FAVOURITE_ID + " TEXT,"
                + FAVOURITE_TITLE_NAME + " TEXT," + FAVOURITE_DESCRIPTION + " TEXT,"
                + FAVOURITE_AUTHOR + " TEXT,"
                + FAVOURITE_DATE_TIME_AGO + " TEXT" + ")";



        sqLiteDatabase.execSQL(CREATE_TABLE_FAVOURITE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVOURITE);


        // Create tables again
        onCreate(db);
    }


    public long INSERT_FAVOURITE(ItemModel data) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();


        values.put(FAVOURITE_ID, data.getFavourite_id());
        values.put(FAVOURITE_TITLE_NAME, data.getFavourite_title_name());
        values.put(FAVOURITE_DESCRIPTION, data.getFavourite_description());
        values.put(FAVOURITE_AUTHOR, data.getFavourite_author());
        values.put(FAVOURITE_DATE_TIME_AGO, data.getFavourite_date_time_ago());

        long id = -1;

        id = db.insert(TABLE_FAVOURITE, null, values);

        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
        return id;
    }


    public ArrayList<ItemModel> GETALL_FAVOURITE() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<ItemModel> dataList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_FAVOURITE;

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.getCount() > 0) {

            if (cursor.moveToFirst()) {
                do {
                    ItemModel modelData = new ItemModel();

                    modelData.setKey_favourite_id(Integer.parseInt(cursor.getString(0)));
                    modelData.setFavourite_id(cursor.getString(1));
                    modelData.setFavourite_title_name(cursor.getString(2));
                    modelData.setFavourite_description(cursor.getString(3));
                    modelData.setFavourite_author(cursor.getString(4));
                    modelData.setFavourite_date_time_ago(cursor.getString(5));

                    dataList.add(modelData);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        return dataList;
    }


    public void DELETE_FAVOURITE(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FAVOURITE, KEY_FAVOURITE_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }


    public void DELETE_ALL_FAVOURITE() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_FAVOURITE, null, null);

        db.close();
    }

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


}*/
