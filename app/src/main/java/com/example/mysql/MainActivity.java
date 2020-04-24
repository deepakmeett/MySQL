package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button button1, button2;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        editText1 = findViewById( R.id.emailr );
        editText2 = findViewById( R.id.passwordr );
        editText3 = findViewById( R.id.rolll );
        button1 = findViewById( R.id.register );
        button2 = findViewById( R.id.loginr );

        requestQueue = Volley.newRequestQueue( this );

        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, Main2Activity.class );
                startActivity( intent );
            }
        } );

        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String s1 = editText1.getText().toString();
                final String s2 = editText2.getText().toString();
                final String s8 = editText3.getText().toString();

                if (s1.isEmpty() || s2.isEmpty() || s8.isEmpty()) {
                    Toast.makeText( MainActivity.this,
                                    "Enter Email Or Password or Roll_no", Toast.LENGTH_SHORT ).show();
                } else {
                    StringRequest stringRequest = new StringRequest
                            ( Request.Method.POST, links.url, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText( MainActivity.this,
                                                    response, Toast.LENGTH_SHORT ).show();

                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText( MainActivity.this,
                                                    error.getMessage(), Toast.LENGTH_SHORT ).show();

                                }
                            }
                            ) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> map = new HashMap<>();
                            map.put( "email", s1 );
                            map.put( "password", s2 );
                            map.put( "roll_no", s8 );
                            return map;
                        }
                    };
                    requestQueue.add( stringRequest );

                }

            }
        } );


    }
}
