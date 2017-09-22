package com.aug22.avinashchintareddy.thedoctors.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aug22.avinashchintareddy.thedoctors.R;

import java.util.List;

/**
 * Created by avinashchintareddy on 9/9/17.
 */

public class AppointmentAdapter extends BaseAdapter {

    List<String> appointment;
    Context context;
    LayoutInflater layoutInflater;
    public AppointmentAdapter(Context context, List<String> appointment){
        this.appointment = appointment;
        this.context = context;
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return appointment.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class Handler{
        TextView tx_prodname;




    }

    @Override
    public View getView(int i, View myview, ViewGroup viewGroup) {
        Handler handler = new Handler();
        if(myview == null){
            myview=layoutInflater.inflate(R.layout.list_apt,viewGroup,false);
            handler.tx_prodname=(TextView) myview.findViewById(R.id.txt_day);



            myview.setTag(handler);
        }
        else
        {
            handler = (Handler) myview.getTag();

        }



        handler.tx_prodname.setText(""+appointment.get(i));

        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        return myview;
    }
}
