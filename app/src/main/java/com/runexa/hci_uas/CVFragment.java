package com.runexa.hci_uas;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CVFragment extends Fragment {


    public CVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cv, container, false);

        final View rootV = container.getRootView().findViewById(R.id.coordinator_layout_main);

        v.findViewById(R.id.cv_button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootV,"CV Berhasil Disimpan",Snackbar.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}
