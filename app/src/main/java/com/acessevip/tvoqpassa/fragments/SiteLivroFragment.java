package com.acessevip.tvoqpassa.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acessevip.tvoqpassa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiteLivroFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

             View view =   inflater.inflate(R.layout.fragment_site_livro, container, false);
        return view;
    }


}
