package com.aug22.avinashchintareddy.thedoctors.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.aug22.avinashchintareddy.thedoctors.R;
import com.aug22.avinashchintareddy.thedoctors.adapter.DoctorListAdapter;
import com.aug22.avinashchintareddy.thedoctors.interfaces.Appoint;
import com.aug22.avinashchintareddy.thedoctors.model.DoctorListM;

import org.json.JSONArray;
import org.json.JSONObject;

import it.sephiroth.android.library.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class DoctorDetailF extends Fragment {
    TextView txt_name,txt_qualification,txt_experience,txt_rating,txt_address;

    Button btn_book;

    ImageView img_doctor;
    String Id,doctorName,experience,qualification,doctorPhoto,address,rating;
    int cat;
    Appoint apt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Id=getArguments().getString("doctorId");

        cat=getArguments().getInt("Id");
        Log.i("Doctor",""+Id);
        qualification="MBBS";

        View view=inflater.inflate(R.layout.fragment_doctordeta, container, false);
        txt_name=view.findViewById(R.id.textViewName);
        txt_qualification=view.findViewById(R.id.textViewQualification);
        txt_experience=view.findViewById(R.id.textViewExperience);
        txt_address=view.findViewById(R.id.textViewAddress);
        txt_rating=view.findViewById(R.id.textViewRating);
        img_doctor=view.findViewById(R.id.imageView4);
        btn_book=view.findViewById(R.id.buttonBook);
        txt_qualification.setText(qualification);
        callDoctors(cat);
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apt.appoint();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        apt= (Appoint) getActivity();
    }

    private void callDoctors(int a) {
        String url="http://rjtmobile.com/medictto/find_doctor.php?&%20location_id=&%20specialization_id="+a;
        Log.i("url",""+url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject jsonObject)
            {
                try{

                        JSONArray doctors=jsonObject.getJSONArray("doctor_details");
                        for(int i=0;i<doctors.length();i++)
                        {
                            JSONObject c=doctors.getJSONObject(i);
                            String doctorId=c.getString("doctor_id");
                            String doctorName=c.getString("doctor_name");
                            String experience=c.getString("Experience");
                            String rating=c.getString("Rating");
                            String doctorPhoto=c.getString("DoctorsPhoto");
                            String address=c.getString("Address");
                            Log.i("matchded id",""+doctorId);
                            if(doctorId.equals(Id)){
                                txt_name.setText(doctorName);
                                txt_experience.setText(experience);
                                txt_address.setText(address);
                                txt_rating.setText(rating);
                                Picasso.with(getContext())
                                        .load(doctorPhoto)
                                        .into(img_doctor);

                            }

                        }




                }
                catch(Exception e)
                {
                    System.out.println(e);
                }

            }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {


            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonObjectRequest);



    }
}
