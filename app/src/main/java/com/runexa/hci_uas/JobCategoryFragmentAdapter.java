package com.runexa.hci_uas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by richi on 11/11/2016.
 */

public class JobCategoryFragmentAdapter extends BaseAdapter {

    private Context mContext;

    public JobCategoryFragmentAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, final ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);

        return imageView;

    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.ilmu_hayati_360x360,
            R.drawable.information_technology_360x360,
            R.drawable.jurnalisme_360x360,
            R.drawable.komunikasi_digital_360x360,
            R.drawable.kuliner_360x360,
            R.drawable.pekerjaan_kantor_360x360,
            R.drawable.pendidikan_360x360,
            R.drawable.seni_360x360,
            R.drawable.teknik_mesin_360x360
    };
}