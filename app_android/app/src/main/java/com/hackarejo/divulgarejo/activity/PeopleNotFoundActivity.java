package com.hackarejo.divulgarejo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import com.hackarejo.divulgarejo.R;

/**
 * Created by Jhony on 17/06/2015.
 */
public class PeopleNotFoundActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView img = (ImageView) findViewById(R.id.imageView5);
        img.setImageResource(R.mipmap.notpeople);




    }
}
