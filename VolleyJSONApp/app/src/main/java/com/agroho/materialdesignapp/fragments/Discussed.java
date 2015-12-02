package com.agroho.materialdesignapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.agroho.materialdesignapp.R;
import com.agroho.materialdesignapp.network.VolleySingleton;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by Edwin on 15/02/2015.
 */

public class Discussed extends Fragment {



    public static  Discussed newInstance() {
        return new Discussed();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.discussed, container, false);

        RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQueue();
        StringRequest request = new StringRequest(Request.Method.GET,"http://php.net/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Toast.makeText(getActivity(), "RESPONSE"+response, Toast.LENGTH_SHORT).show();

            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    Toast.makeText(getActivity(), "RESPONSE"+error.getMessage(), Toast.LENGTH_SHORT).show();

                }
                catch (Exception e){

                }

            }
        });

        requestQueue.add(request);

        return v;
    }
}
