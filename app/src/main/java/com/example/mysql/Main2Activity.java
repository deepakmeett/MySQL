package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    EditText editText1, editText2;
    Button button1, button2;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        editText1 = findViewById( R.id.emaill );
        editText2 = findViewById( R.id.passwordl );
        button1 = findViewById( R.id.loginl );
        button2 = findViewById( R.id.next );

        requestQueue = Volley.newRequestQueue( this );

        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Main2Activity.this, Main3Activity.class );
                startActivity( intent );
            }
        } );

        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String s3 = editText1.getText().toString();
                final String s4 = editText2.getText().toString();

                if (s3.isEmpty() || s4.isEmpty()) {
                    Toast.makeText( Main2Activity.this,
                                    "Enter Email Or Password", Toast.LENGTH_SHORT ).show();
                } else {
                    StringRequest stringRequest = new StringRequest
                            ( Request.Method.POST, links.url1, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText( Main2Activity.this, response, Toast.LENGTH_SHORT ).show();
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            } ) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> map = new HashMap<>();
                            map.put( "email", s3 );
                            map.put( "password", s4 );
                            return map;
                        }
                    };
                    requestQueue.add( stringRequest );
                }
            }
        } );
    }
}
