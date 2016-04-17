package com.hackarejo.divulgarejo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookSdk;
import com.hackarejo.divulgarejo.R;

/**
 * Created by bruno on 15/06/15.
 */
public class WelcomeActivity extends Activity {

    private static final long SPLASH_TIME_OUT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        FacebookSdk.sdkInitialize(getApplicationContext());

        new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken newAccessToken) {
                updateWithToken(newAccessToken);
            }
        };

        updateWithToken(AccessToken.getCurrentAccessToken());
    }

    private void updateWithToken(AccessToken currentAccessToken) {
        if (currentAccessToken != null) {
            startNewActivity(SearchPeopleActivity.class);
        } else {
            startNewActivity(LoginActivity.class);
        }
    }

    private void startNewActivity(final Class<?> klass){
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), klass);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
