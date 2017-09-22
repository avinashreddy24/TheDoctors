package com.aug22.avinashchintareddy.thedoctors.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aug22.avinashchintareddy.thedoctors.R;
import com.aug22.avinashchintareddy.thedoctors.interfaces.Categoreis;
import com.aug22.avinashchintareddy.thedoctors.interfaces.Doctordetail;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class CategoriesF extends Fragment implements View.OnClickListener {

    Categoreis cat;

    CardView card_dentist,card_pyso;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_categories, container, false);
        init(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        cat= (Categoreis) getActivity();
    }

    private void init(View view) {
        card_pyso=view.findViewById(R.id.card_pysio);
        card_dentist=view.findViewById(R.id.card_dentist);
        card_dentist.setOnClickListener(this);
        card_pyso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cat.set(2);}});
    }


    @Override
    public void onClick(View view) {
        cat.set(1);
    }
}
