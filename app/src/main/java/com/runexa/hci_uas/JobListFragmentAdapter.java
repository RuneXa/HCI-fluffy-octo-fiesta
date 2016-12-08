package com.runexa.hci_uas;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by richi on 12/3/2016.
 */

public class JobListFragmentAdapter extends RecyclerView.Adapter<JobListFragmentAdapter.ViewHolder> {

   private mDataset[] mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public JobListFragmentAdapter(mDataset[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public JobListFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_job_list, parent, false);
        // set the view's size, margins, paddings and layout parameters

        //ViewHolder vh = new ViewHolder(v);
        return new ViewHolder((CardView) v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.vTitle.setText(mDataset[position].title);
        holder.vPos.setText(mDataset[position].position);
        holder.vAddress.setText(mDataset[position].address);
        holder.vEmail.setText(mDataset[position].email);

    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView vTitle;
        protected TextView vPos;
        protected TextView vAddress;
        protected TextView vEmail;
        protected ImageView vImage;


        // each data item is just a string in this case
        public CardView mCardView;
        public ViewHolder(CardView v) {
            super(v);
            vTitle = (TextView) v.findViewById(R.id.info_text_title);
            vPos = (TextView) v.findViewById(R.id.info_job_PH);
            vAddress = (TextView) v.findViewById(R.id.info_contact_address_PH);
            vEmail = (TextView) v.findViewById(R.id.info_contact_email_PH);
            vImage = (ImageView) v.findViewById(R.id.info_image);
            mCardView = v;
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}