package com.aug22.avinashchintareddy.thedoctors.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aug22.avinashchintareddy.thedoctors.R;
import com.aug22.avinashchintareddy.thedoctors.interfaces.Doctordetail;
import com.aug22.avinashchintareddy.thedoctors.interfaces.Remainders;


/**
 * A simple {@link Fragment} subclass.

 */
public class Homescreen extends Fragment{
    private TextView doctor,pharma,message,remaind;
    Doctordetail detail;
    Remainders remainders;

    CardView card_docs,card_remaind,card_message;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_homescreen, container, false);
        init(view);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        detail= (Doctordetail) getActivity();
        remainders=(Remainders) getActivity();
    }

    private void init(View view) {
        doctor= view.findViewById(R.id.txt_doctors);
        pharma=view.findViewById(R.id.txt_pharmacis);
        message= view.findViewById(R.id.txt_msg);
        remaind= view.findViewById(R.id.txt_remaind);
        card_docs= view.findViewById(R.id.card_doctors);
        card_remaind= view.findViewById(R.id.card_remainders);
        card_docs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detail.send();
            }
        });

        card_remaind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remainders.sendRemaind();
            }
        });


    }



}
