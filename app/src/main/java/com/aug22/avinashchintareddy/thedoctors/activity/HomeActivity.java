package com.aug22.avinashchintareddy.thedoctors.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aug22.avinashchintareddy.thedoctors.fragments.AppointDetailF;
import com.aug22.avinashchintareddy.thedoctors.fragments.AppointmentF;
import com.aug22.avinashchintareddy.thedoctors.fragments.CategoriesF;
import com.aug22.avinashchintareddy.thedoctors.R;
import com.aug22.avinashchintareddy.thedoctors.fragments.DoctorDetailF;
import com.aug22.avinashchintareddy.thedoctors.fragments.DoctorlistF;
import com.aug22.avinashchintareddy.thedoctors.fragments.Homescreen;
import com.aug22.avinashchintareddy.thedoctors.fragments.RemainderF;
import com.aug22.avinashchintareddy.thedoctors.interfaces.Appoint;
import com.aug22.avinashchintareddy.thedoctors.interfaces.Categoreis;
import com.aug22.avinashchintareddy.thedoctors.interfaces.Doclist;
import com.aug22.avinashchintareddy.thedoctors.interfaces.Doctordetail;
import com.aug22.avinashchintareddy.thedoctors.interfaces.Remainders;

public class HomeActivity extends AppCompatActivity implements Doctordetail,Categoreis,Remainders,Doclist,Appoint {



    Fragment appointment;
    Fragment home;
    Fragment categories;
    Fragment remaind;
    Fragment doclist;
    Fragment aptdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        appointment = new AppointmentF();
        home= new Homescreen();
        categories= new CategoriesF();
        remaind= new RemainderF();
        doclist= new DoctorlistF();
        aptdetail= new AppointDetailF();


        //create a shared preference if it is null


        FragmentManager fg1= getSupportFragmentManager();
        FragmentTransaction ft1=fg1.beginTransaction();
        ft1.add(R.id.lyt_home,home);
        ft1.commit();

    }

    @Override
    public void send() {
        FragmentManager fg1= getSupportFragmentManager();
        FragmentTransaction ft1=fg1.beginTransaction();
        ft1.replace(R.id.lyt_home,categories);
        ft1.commit();

    }

    @Override
    public void set(int i) {
        Bundle bundle= new Bundle();
        bundle.putInt("id",i);
        doclist.setArguments(bundle);
        FragmentManager fg1= getSupportFragmentManager();
        FragmentTransaction ft1=fg1.beginTransaction();
        ft1.replace(R.id.lyt_home,doclist);
        ft1.commit();
    }

    @Override
    public void sendRemaind(){

        FragmentManager fg1= getSupportFragmentManager();
        FragmentTransaction ft1=fg1.beginTransaction();
        ft1.replace(R.id.lyt_home,remaind);
        ft1.commit();
    }

    @Override
    public void senderdata(String id, int cat) {
        Bundle bundle = new Bundle();


        bundle.putString("doctorId", id);
        bundle.putInt("Id", cat);
        Log.i("inner","");
        DoctorDetailF detailF= new DoctorDetailF();
        detailF.setArguments(bundle);
        FragmentManager fg= getSupportFragmentManager();
        FragmentTransaction ft= fg.beginTransaction();
        ft.replace(R.id.lyt_home, detailF);
        ft.commit();
    }

    @Override
    public void appoint() {
        FragmentManager fg1= getSupportFragmentManager();
        FragmentTransaction ft1=fg1.beginTransaction();
        ft1.replace(R.id.lyt_home,aptdetail);
        ft1.commit();
    }

    }



