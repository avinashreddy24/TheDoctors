package com.aug22.avinashchintareddy.thedoctors.fragments;





import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.aug22.avinashchintareddy.thedoctors.R;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * A
 */
public class AppointDetailF extends Fragment implements View.OnClickListener {
    EditText edit_name,edit_phone;
    Button btnDatePicker, btnTimePicker,btn_endTime,btn_book;
    EditText txtDate, txtStartTime,txtEndTime;
    private int mYear, mMonth, mDay, mHourStart, mMinuteStart,mHourEnd,mMinuteEnd;
    public static final String TAG = "";
    String startTime,endTime,date,timeToStart,timeToEnd;
    String phoneNo;
    String message;

    public String BASE_URL_App="http://rjtmobile.com/medictto/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_appoint_detail, container, false);


        btnDatePicker = (Button) view.findViewById(R.id.btn_date);
        btnTimePicker = (Button) view.findViewById(R.id.btn_time);
        btn_endTime=(Button)view.findViewById(R.id.buttonEndTime);
        btn_book=(Button)view.findViewById(R.id.buttonBook);

        txtDate = (EditText) view.findViewById(R.id.in_date);
        txtStartTime = (EditText) view.findViewById(R.id.in_time);
        txtEndTime=view.findViewById(R.id.editTextEndTime);
        edit_name=view.findViewById(R.id.editTextName);
        edit_phone=view.findViewById(R.id.editTextPhone);

        btnDatePicker.setOnClickListener(this);
        /*btnTimePicker.setOnClickListener(this);
        btn_endTime.setOnClickListener(this);*/



        //btn_book.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {
        if (view == btnDatePicker) {
        Calendar calendar= Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                // logic for available slots
                date=dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

            }
        }, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(day);
        datePickerDialog.show();
        }

        if (view == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHourStart = c.get(Calendar.HOUR_OF_DAY);
            mMinuteStart = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute)
                        {
                            timeToStart=hourOfDay+":"+minute;

                            txtStartTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHourStart, mMinuteStart, false);
            timePickerDialog.show();
        }

        if (view == btn_endTime) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHourEnd = c.get(Calendar.HOUR_OF_DAY);
            mMinuteEnd = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog1 = new TimePickerDialog(getContext(),
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {



                            txtEndTime.setText(hourOfDay + ":" + minute);
                            timeToEnd=txtEndTime.getText().toString();
                        }
                    }, mHourEnd, mMinuteEnd, false);
            timePickerDialog1.show();
        }
    }
}
