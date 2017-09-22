package com.aug22.avinashchintareddy.thedoctors.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.aug22.avinashchintareddy.thedoctors.R;
import com.aug22.avinashchintareddy.thedoctors.model.DoctorListM;

import java.util.ArrayList;

/**
 * Created by avinashchintareddy on 9/18/17.
 */

public class DoctorListAdapter extends BaseAdapter{
    ArrayList<DoctorListM> doctorList;
    Context context;
    LayoutInflater layoutInflater;

    public DoctorListAdapter(ArrayList<DoctorListM> doctorList,Context context){
        this.doctorList=  doctorList;
        this.context=context;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return doctorList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Handler handler= new Handler();
        if(view==null){
            view=layoutInflater.inflate(R.layout.list_docs,viewGroup,false);
            handler.name=view.findViewById(R.id.txt_name);
            handler.experience= view.findViewById(R.id.txt_experience);
            handler.rating=view.findViewById(R.id.txt_rating);
            view.setTag(handler);
        }
        else{
            handler= (Handler) view.getTag();
        }
        handler.name.setText(doctorList.get(i).getName());
        handler.experience.setText(doctorList.get(i).getExperience()+" Years");
        handler.rating.setNumStars(5);
        handler.rating.setRating(Float.parseFloat(doctorList.get(i).getRating()));

        return view;
    }
    public  class Handler{
        TextView experience,name;
        RatingBar rating;

    }
}
