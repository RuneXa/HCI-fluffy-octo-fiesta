package com.runexa.hci_uas;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    OnHomeButtonSelected mCallBack;

    public interface OnHomeButtonSelected {
        void OnButtonSelected(int i);
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView daftar = (ImageView) v.findViewById(R.id.home_daftar);
        ImageView cv = (ImageView) v.findViewById(R.id.home_cv);
        ImageView list = (ImageView) v.findViewById(R.id.home_list);
        ImageView help = (ImageView) v.findViewById(R.id.home_help);

        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        mCallBack = (OnHomeButtonSelected) getActivity();
        mCallBack.OnButtonSelected(0);

        final View frame = container;

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(frame.getId(),new JobCategoryFragment()).addToBackStack(null).commit();
                mCallBack.OnButtonSelected(1);
            }
        });

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(frame.getId(),new CVFragment()).addToBackStack(null).commit();
                mCallBack.OnButtonSelected(2);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundl = new Bundle();
                bundl.putBoolean("AppliedOnly",true);
                Fragment f = new JobListFragment();
                f.setArguments(bundl);
                getFragmentManager().beginTransaction().replace(frame.getId(),f).addToBackStack(null).commit();
                mCallBack.OnButtonSelected(3);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(frame.getId(),new BantuanFragment()).addToBackStack(null).commit();
                mCallBack.OnButtonSelected(4);
            }
        });

        return v;
    }

}
