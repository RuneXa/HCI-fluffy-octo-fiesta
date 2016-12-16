package com.runexa.hci_uas;

import java.util.ArrayList;

/**
 * Created by Richie on 16/12/2016.
 */
public class userDataSet {

    public int id;
    public String email;
    public String password;
    public cvDataset cv;

    public userDataSet(int i, String e, String p,cvDataset c){
        id = i;
        email = e;
        password = p;
        cv = c;
    }

}
