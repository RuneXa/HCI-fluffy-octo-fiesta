package com.runexa.hci_uas;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Log;

import java.io.Serializable;
/**
 * Created by richi on 12/8/2016.
 */

public class jobDataset implements Serializable {

    public String title;
    public String position;
    public String address;
    public String email;
    public String description;
    public boolean applied;

    public jobDataset(String t, String p, String e, String a, String d, boolean ap) {
        title = t;
        position = p;
        email = e;
        address = a;
        description = d;
        applied = ap;
    }

}
