package com.quebragelo.quebragelo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.quebragelo.quebragelo.R;

/**
 * Created by bruno on 14/06/15.
 */
public class SearchPeopleActivity extends Activity {
    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.search_people_load);

        CircularProgressView circular = (CircularProgressView) findViewById(R.id.progress_view);
        circular.startAnimation();

        TextView myText = (TextView) findViewById(R.id.searching_people_text);

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(460);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        myText.startAnimation(anim);

        gestureDetectorCompat = new GestureDetectorCompat(this, new My2ndGestureListener());
    }

//    @Override
//    public void onBackPressed() {
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_HOME);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class My2ndGestureListener extends GestureDetector.SimpleOnGestureListener {
        //handle 'swipe right' action only

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            if(event2.getX() > event1.getX()){
                Intent intent = new Intent(SearchPeopleActivity.this, ProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
            }else{
                finish();
                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
            }

            return true;
        }
    }
}
