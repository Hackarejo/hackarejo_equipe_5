package com.quebragelo.quebragelo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import com.quebragelo.quebragelo.R;

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
