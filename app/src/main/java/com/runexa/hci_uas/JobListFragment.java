package com.runexa.hci_uas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class JobListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    boolean appliedOnly = false;

    private mDataset[] myDataset = {
            new mDataset("Lecturer at SU","Lecturer","aaa@aaaa.aa","Disini","Dicari....",false),
            new mDataset("Not Lecturer at SU","Not Lecturer","aaa@aaaa.aa","Disini",null,true),
            new mDataset("Certainly Not Lecturer at SU","Another","aaa@aaaa.aa","Disini",null,false),
            new mDataset("Internship at ship","Ship wrecker","aaa@aaaa.aa","Disanaaaaaaaaaaaaaaaaaaaaaaaaa",null,false),
            new mDataset("aaa","asb","aaa@aaaa.ab","Di","Lorem Ipsum",false),
            new mDataset("bbb","asd","aaa@aaaa.ac","sini","blabalbalbalblablalba",true),
            new mDataset("ccc","ase","aaa@aaaa.ad","isin","ballbalbalbalab",true)
    };

    public JobListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        appliedOnly = getArguments().getBoolean("AppliedOnly");

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
