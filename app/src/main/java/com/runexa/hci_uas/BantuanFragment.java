package com.runexa.hci_uas;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BantuanFragment extends Fragment {


    public BantuanFragment() {
        // Required empty public constructor
    }

    ImageView h1;
    ImageView h2;
    ImageView h3;
    ImageView h4;
    ImageView h5;
    ImageView h6;
    ImageView h7;
    ImageView h8;
    ImageView h9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bantuan, container, false);

        h1 = (ImageView) v.findViewById(R.id.help_image_1);
        h2 = (ImageView) v.findViewById(R.id.help_image_2);
        h3 = (ImageView) v.findViewById(R.id.help_image_3);
        h4 = (ImageView) v.findViewById(R.id.help_image_4);
        h5 = (ImageView) v.findViewById(R.id.help_image_5);
        h6 = (ImageView) v.findViewById(R.id.help_image_6);
        h7 = (ImageView) v.findViewById(R.id.help_image_7);
        h8 = (ImageView) v.findViewById(R.id.help_image_8);
        h9 = (ImageView) v.findViewById(R.id.help_image_9);

        h1.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.help_1,200,200));
        h2.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.help_2,200,200));
        h3.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.help_3,200,200));
        h4.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.help_4,200,200));
        h5.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.help_5,200,200));
        h6.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.help_6,200,200));
        h7.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.help_7,200,200));
        h8.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.help_8,200,200));
        h9.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.drawable.help_9,200,200));

        // Inflate the layout for this fragment
        return v;
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

}
