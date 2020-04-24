package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;

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

public class Main3Activity extends AppCompatActivity {
    EditText editText;
    Button button;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main3 );
        editText = findViewById( R.id.roll_no );
        button = findViewById( R.id.show );

        requestQueue = Volley.newRequestQueue( this );

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String s5 = editText.getText().toString();

                if (s5.isEmpty()) {
                    Toast.makeText( Main3Activity.this,
                                    "Enter roll_no", Toast.LENGTH_SHORT ).show();
                } else {

                    StringRequest stringRequest = new StringRequest
                            ( Request.Method.POST, links.url2, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText( Main3Activity.this,
                                                    response, Toast.LENGTH_SHORT ).show();

                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText( Main3Activity.this,
                                                    error.getMessage(), Toast.LENGTH_SHORT ).show();
                                }
                            } ) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> map = new HashMap<>();
                            map.put( "roll_no", s5 );

                            return map;
                        }
                    };
                    requestQueue.add( stringRequest );
                }
            }
        } );
    }
}
