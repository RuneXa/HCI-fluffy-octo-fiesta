package com.runexa.hci_uas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class JobListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private mDataset[] myDataset = {
            new mDataset("Lecturer at SU","Lecturer","aaa@aaaa.aa","Disini"),
            new mDataset("Not Lecturer at SU","Not Lecturer","aaa@aaaa.aa","Disini"),
            new mDataset("Certainly Not Lecturer at SU","Another","aaa@aaaa.aa","Disini"),
            new mDataset("Internship at ship","Ship wrecker","aaa@aaaa.aa","Disanaaaaaaaaaaaaaaaaaaaaaaaaa"),
            new mDataset("aaa","asb","aaa@aaaa.ab","Di"),
            new mDataset("bbb","asd","aaa@aaaa.ac","sini"),
            new mDataset("ccc","ase","aaa@aaaa.ad","isin"),

    };

    public JobListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_job_list, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.jobList_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new JobListFragmentAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        // Inflate the layout for this fragment
        return v;
    }

}
