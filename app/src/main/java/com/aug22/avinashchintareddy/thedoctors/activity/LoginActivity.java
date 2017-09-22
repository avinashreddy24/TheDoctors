package com.aug22.avinashchintareddy.thedoctors.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aug22.avinashchintareddy.thedoctors.Constants;
import com.aug22.avinashchintareddy.thedoctors.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText number,password;
    TextView register;
    Button btn_lgin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        btn_lgin.setOnClickListener(this);
        
    }

    private void init() {
        number= (EditText) findViewById(R.id.et_mnumber);
        password= (EditText) findViewById(R.id.et_pswd);
        register= (TextView) findViewById(R.id.txt_register);
        btn_lgin= (Button) findViewById(R.id.btn_login);
    }

    @Override
    public void onClick(View view) {
        String pno=number.getText().toString();
        Log.i("TestMain",""+pno);
        String pswd=password.getText().toString();
        Log.i("TestMain",""+pswd);
        if((pno.length()==10 || pno.length()==12)&& password.length()>=6){
            String url = Constants.LOGIN_URL.replace("---",pno)+""+pswd;
            //"http://rjtmobile.com/ansari/shopingcart/androidapp/shop_login.php?mobile=9887139847&password=android";
            Log.i("TestMain", "" + url);
            checkEntries(url);
        }
        else{
            if(pno.length()<10){
                number.setError("Number must be atleast of 10 digits");
            }
            if(pno.length()>10 && pno.length()<12){
                number.setError("Number must be atleast of 10 or 12 digits ");
            }

            if(pswd.length()<6){
                password.setError("Password must be atleadt of 6 digits");

            }


        }

    }

    private void checkEntries(String url) {
        StringRequest str= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.contains("login_ok")){
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Not_User", Toast.LENGTH_SHORT).show();
                }

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(str);
    }
}
