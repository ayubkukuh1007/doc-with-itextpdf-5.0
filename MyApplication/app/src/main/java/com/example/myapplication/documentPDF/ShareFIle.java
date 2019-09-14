package com.example.myapplication.documentPDF;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;

import java.io.File;

/**
 * @author ayubkukuh <ayubkukuhprasetyo434@gmail.com>
 * @since 1.0
 */
public class ShareFIle {

    private Uri bmpUri;

    public ShareFIle() {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }

    public Intent ShareImage(File file) {
        this.bmpUri = Uri.fromFile(file);
        if (bmpUri != null) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM,bmpUri);
            shareIntent.setType("image/*");
            return shareIntent;
        }else {
            return  null;
        }
    }

    public Intent SharePDF(File file) {
        this.bmpUri = Uri.fromFile(file);
        if (bmpUri != null) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM,bmpUri);
            shareIntent.setType("application/pdf");
            return shareIntent;
        }else {
            return  null;
        }
    }
}
