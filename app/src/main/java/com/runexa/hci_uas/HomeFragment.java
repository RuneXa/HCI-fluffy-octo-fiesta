package com.runexa.hci_uas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView daftar = (ImageView) v.findViewById(R.id.home_daftar);
        ImageView cv = (ImageView) v.findViewById(R.id.home_cv);
        ImageView list = (ImageView) v.findViewById(R.id.home_list);
        ImageView pengaturan = (ImageView) v.findViewById(R.id.home_option);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(container.getId(),new JobCategoryFragment()).addToBackStack(null).commit();
            }
        });

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(container.getId(),new CVFragment()).addToBackStack(null).commit();
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(container.getId(),new JobListFragment()).addToBackStack(null).commit();
            }
        });

        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(getContext(),"Not Implemented yet",Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}
