package com.aug22.avinashchintareddy.thedoctors.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aug22.avinashchintareddy.thedoctors.R;
import com.aug22.avinashchintareddy.thedoctors.adapter.AppointmentAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class AppointmentF extends Fragment {
    ListView lstview;
    List<String> appointment= new ArrayList<>();
    AppointmentAdapter adapt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_appointment, container, false);
        lstview = (ListView) view.findViewById(R.id.lst_apt);
        creatdata();
        // Inflate the layout for this fragment
        return view;
    }
    private void addData() {

        appointment.add("Monday");
        appointment.add("Tuesday");
        appointment.add("Wednesday");
        appointment.add("Thursday");
        appointment.add("Friday");
        appointment.add("Saturday");
        appointment.add("Sunday");


    }

    private void creatdata() {

        addData();
        //pref=getContext().getSharedPreferences("MyPref", 2);
        /*//String st=getContext()("MyPref", 2);
        editor = pref.edit();
        gson= new Gson();
        String  jsonProducts = gson.toJson(appointment);
        Log.i("orderdetails",""+jsonProducts);
        editor.putString("app_value", jsonProducts);
        editor.commit();*/
        adapt=new AppointmentAdapter(getContext(),appointment);
        lstview.setAdapter(adapt);
    }


}
