package com.aug22.avinashchintareddy.thedoctors.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.aug22.avinashchintareddy.thedoctors.R;
import com.aug22.avinashchintareddy.thedoctors.WebServices.AppController;
import com.aug22.avinashchintareddy.thedoctors.adapter.DoctorListAdapter;
import com.aug22.avinashchintareddy.thedoctors.interfaces.Doclist;
import com.aug22.avinashchintareddy.thedoctors.interfaces.Doctordetail;
import com.aug22.avinashchintareddy.thedoctors.model.DoctorListM;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A Display doctors
 *
 */
public class DoctorlistF extends Fragment {
    ArrayList<DoctorListM> doctorList=new ArrayList<>();
    DoctorListM mdoct;
    DoctorListAdapter adapter;
    Doclist doclist;
    int aid;

    ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        doctorList.clear();
        View view =inflater.inflate(R.layout.fragment_doctorlist, container, false);
        lv=(ListView) view.findViewById(R.id.lst_docs);
        // Inflate the layout for this fragment
         aid= getArguments().getInt("id");
        callDoctors(aid);
        Log.i("Received list",""+aid);
        return view;
    }
//url calls for doctors
    private void callDoctors(int a) {
        String url="http://rjtmobile.com/medictto/find_doctor.php?&%20location_id=1&%20specialization_id="+a;
        Log.i("url",""+url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject jsonObject)
            {
                try{
                    if (doctorList.isEmpty()) {
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
                            mdoct= new DoctorListM(doctorName,experience,rating,doctorPhoto,address,doctorId);

                            doctorList.add(mdoct);
                        }
                        adapter=new DoctorListAdapter(doctorList,getContext());
                         lv.setAdapter(adapter);
                    }

                   lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Log.i("adapter","");
                            doclist.senderdata(doctorList.get(i).getId(), aid);
                        }
                    });
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        doclist= (Doclist) getActivity();
    }
}



