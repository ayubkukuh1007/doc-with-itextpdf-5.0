package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.documentPDF.DokumenPDF;
import com.example.myapplication.documentPDF.Modeldokumen;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btncetak = findViewById(R.id.cetak);
        btncetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestStoragePermission();
            }
        });
    }

    private void Cetak(){
        //buat objek model
        Modeldokumen.DatapaketEntity datapaketEntity = new Modeldokumen.DatapaketEntity();
        Modeldokumen.DatapesertastatusOpenEntity datapesertastatusOpenEntity = new Modeldokumen.DatapesertastatusOpenEntity();
        Modeldokumen.StatusDokumenEntity dokumenEntity = new Modeldokumen.StatusDokumenEntity();
        Modeldokumen.StatusPembayaranEntity pembayaranEntity = new Modeldokumen.StatusPembayaranEntity();

        //header
        datapaketEntity.setNamapaket("Paket ka'bah");
        datapaketEntity.setNopesanan("10");

        //data perserta
        datapesertastatusOpenEntity.setNamapeserta("Ayub kukuh P");
        datapesertastatusOpenEntity.setNohp("0881238406000");
        datapesertastatusOpenEntity.setNoktp("17012000099");
        datapesertastatusOpenEntity.setNopaspor("00001234AB");

        //data dokument
        dokumenEntity.setKtp(true);
        dokumenEntity.setBukunikah(false);
        dokumenEntity.setKartukeluarga(true);
        dokumenEntity.setKitas(false);
        dokumenEntity.setFoto(true);
        dokumenEntity.setKartukuning(true);
        dokumenEntity.setPaspor(true);

        //pembayaran
        pembayaranEntity.setKamar("Single");
        pembayaranEntity.setTotal(10000000);
        pembayaranEntity.setSisa(4000000);
        pembayaranEntity.setJenispembayaran("Kredit");
        pembayaranEntity.setTanggal("14-09-2019");
        pembayaranEntity.setPenerima("Si A");
        //buat dokumentPDF
        DokumenPDF dokumenPDF = new DokumenPDF();
        dokumenPDF.createdokumenPDF(datapaketEntity,
                datapesertastatusOpenEntity,
                dokumenEntity,
                pembayaranEntity,
                "Approve",
                "Open",
                "Open");

        Toast.makeText(this,"Dokument tersimpan",Toast.LENGTH_SHORT).show();
    }

    private void requestStoragePermission() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                          Cetak();
                        }
                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions,PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(),"Error occurred! ",Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }
}
