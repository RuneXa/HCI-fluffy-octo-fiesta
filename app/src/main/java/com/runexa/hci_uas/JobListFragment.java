package com.runexa.hci_uas;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class JobListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    boolean appliedOnly = false;

    /*
    private jobDataset[] myDataset = {
            new jobDataset("Lecturer at SU","Lecturer","aaa@aaaa.aa","Disini","Dicari....",false),
            new jobDataset("Not Lecturer at SU","Not Lecturer","aaa@aaaa.aa","Disini",null,true),
            new jobDataset("Certainly Not Lecturer at SU","Another","aaa@aaaa.aa","Disini",null,false),
            new jobDataset("Internship at ship","Ship wrecker","aaa@aaaa.aa","Disanaaaaaaaaaaaaaaaaaaaaaaaaa",null,false),
            new jobDataset("aaa","asb","aaa@aaaa.ab","Di","Lorem Ipsum",false),
            new jobDataset("bbb","asd","aaa@aaaa.ac","sini","blabalbalbalblablalba",true),
            new jobDataset("ccc","ase","aaa@aaaa.ad","isin","ballbalbalbalab",true)
    };*/

    ArrayList<jobDataset> myDataset = new ArrayList<>();

    public JobListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        appliedOnly = getArguments().getBoolean("AppliedOnly");

        Resources res = getResources();
        String[] str_list = res.getStringArray(R.array.Job);
        Log.d("String App",str_list[0]);
        for (String s: str_list) {
             Log.d("String :",s);
            try{
                JSONObject data = new JSONObject(s);
                Log.d("String :",data.getString("description"));
                myDataset.add(new jobDataset(data.getString("title"),data.getString("position"),data.getString("email"),data.getString("address"), data.getString("description"),data.getBoolean("applied")));
            } catch (Exception e){
                Log.e("Error",e.toString());
            }
        }



        View v = inflater.inflate(R.layout.fragment_job_list, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.jobList_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new JobListFragmentAdapter(myDataset,appliedOnly);
        mRecyclerView.setAdapter(mAdapter);


        // Inflate the layout for this fragment
        return v;
    }

}
