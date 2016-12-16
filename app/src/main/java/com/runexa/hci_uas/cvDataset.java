package com.runexa.hci_uas;

import android.text.SpannableString;
import android.text.Spanned;

import java.util.ArrayList;

/**
 * Created by Richie on 16/12/2016.
 */
public class cvDataset {
    public String nama;
    public int jenisKelamin;
    public String ttl;
    public String alamat;
    public String telp;
    public String mail;
    public String riwayatEdukasi;
    public String riwayatKerja;
    public String kemampuan;
    public String portofolio;

    public cvDataset() {
        this.nama = "";
        this.jenisKelamin = 0;
        this.ttl = "";
        this.alamat = "";
        this.telp = "62";
        this.mail = "";
        this.riwayatEdukasi = "";
        this.riwayatKerja = "";
        this.kemampuan = "";
        this.portofolio = "";
    }

    public cvDataset(String nama, int jenisKelamin, String ttl, String alamat, String telp, String mail, String riwayatEdukasi, String riwayatKerja, String kemampuan, String portofolio) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.ttl = ttl;
        this.alamat = alamat;
        this.telp = telp;
        this.mail = mail;
        this.riwayatEdukasi = riwayatEdukasi;
        this.riwayatKerja = riwayatKerja;
        this.kemampuan = kemampuan;
        this.portofolio = portofolio;
    }
}
