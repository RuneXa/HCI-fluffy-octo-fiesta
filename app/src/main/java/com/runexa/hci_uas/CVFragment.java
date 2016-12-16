package com.runexa.hci_uas;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class CVFragment extends Fragment {


    public CVFragment() {
        // Required empty public constructor
    }

        EditText nama;
        RadioButton jenisKelamin0;
        RadioButton jenisKelamin1;
        EditText ttl;
        EditText alamat;
        EditText telp;
        EditText mail;
        EditText riwayatEdukasi;
        EditText riwayatKerja;
        EditText kemampuan;
        EditText portofolio;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cv, container, false);

        nama = (EditText) v.findViewById(R.id.cv_text_nama_PH);
        jenisKelamin0 = (RadioButton) v.findViewById(R.id.cv_text_gender_PH_0);
        jenisKelamin1 = (RadioButton) v.findViewById(R.id.cv_text_gender_PH_1);
        ttl = (EditText) v.findViewById(R.id.cv_text_ttl_PH);
        alamat = (EditText) v.findViewById(R.id.cv_text_address_PH);
        telp = (EditText) v.findViewById(R.id.cv_text_telp_PH);
        mail = (EditText) v.findViewById(R.id.cv_text_email_PH);
        riwayatEdukasi = (EditText) v.findViewById(R.id.cv_text_edukasi_PH);
        riwayatKerja = (EditText) v.findViewById(R.id.cv_text_kerja_PH);
        kemampuan = (EditText) v.findViewById(R.id.cv_text_skill_PH);
        portofolio = (EditText) v.findViewById(R.id.cv_text_portofolio_PH);

        nama.setText(currentUser.user.cv.nama);
        if(currentUser.user.cv.jenisKelamin == 0){
            jenisKelamin0.setChecked(true);
        } else {
            jenisKelamin1.setChecked(true);
        }
        ttl.setText(currentUser.user.cv.ttl);
        alamat.setText(currentUser.user.cv.alamat);
        telp.setText(currentUser.user.cv.telp);
        mail.setText(currentUser.user.cv.mail);
        riwayatEdukasi.setText(new SpannableString(Html.fromHtml(currentUser.user.cv.riwayatEdukasi)));
        riwayatKerja.setText(new SpannableString(Html.fromHtml(currentUser.user.cv.riwayatKerja)));
        kemampuan.setText(new SpannableString(Html.fromHtml(currentUser.user.cv.kemampuan)));
        portofolio.setText(new SpannableString(Html.fromHtml(currentUser.user.cv.portofolio)));


        final View rootV = container.getRootView().findViewById(R.id.coordinator_layout_main);

        v.findViewById(R.id.cv_button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentUser.user.cv.nama = nama.getText().toString();
                if(jenisKelamin0.isChecked()){
                    currentUser.user.cv.jenisKelamin = 0;
                } else {
                    currentUser.user.cv.jenisKelamin = 1;
                }
                currentUser.user.cv.ttl = nama.getText().toString();
                currentUser.user.cv.alamat = alamat.getText().toString();
                currentUser.user.cv.telp = telp.getText().toString();
                currentUser.user.cv.mail = mail.getText().toString();
                currentUser.user.cv.riwayatEdukasi = Html.toHtml(riwayatEdukasi.getText());
                currentUser.user.cv.riwayatKerja = Html.toHtml(riwayatKerja.getText());
                currentUser.user.cv.kemampuan = Html.toHtml(kemampuan.getText());
                currentUser.user.cv.portofolio = Html.toHtml(portofolio.getText());

                Snackbar.make(rootV,"CV Berhasil Disimpan",Snackbar.LENGTH_SHORT).show();

            }
        });



        return v;
    }

}
