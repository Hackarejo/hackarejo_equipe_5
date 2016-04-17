package com.hackarejo.divulgarejo.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;

import java.net.URL;

/**
 * Created by bruno on 17/06/15.
 */
public class ImageDownloaderTask extends AsyncTask<Uri, Void, Bitmap> {

    @Override
    protected Bitmap doInBackground(Uri... params) {
        try {
            URL url = new URL(params[0].toString());

            return BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (Exception e) {
            return null;
        }
    }
}
