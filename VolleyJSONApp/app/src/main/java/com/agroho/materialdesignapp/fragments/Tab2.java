package com.agroho.materialdesignapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agroho.materialdesignapp.R;

/**
 * Created by Edwin on 15/02/2015.
 */
public class Tab2 extends Fragment {

    public Tab2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_2,container,false);
        return v;
    }
}
