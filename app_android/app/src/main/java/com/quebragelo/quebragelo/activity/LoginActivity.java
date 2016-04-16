package com.quebragelo.quebragelo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.*;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.quebragelo.quebragelo.R;
import com.quebragelo.quebragelo.helper.Constraint;
import com.quebragelo.quebragelo.task.AddPersonTask;
import com.quebragelo.quebragelo.vo.PersonVO;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class LoginActivity extends Activity {

    private CallbackManager callbackManager;
    private PersonVO person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(com.quebragelo.quebragelo.R.layout.activity_login);

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        setImprovedIcon(loginButton);

        loginButton.setReadPermissions(Arrays.asList("user_status", "user_birthday", "email", "user_about_me"));

        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(final LoginResult loginResult) {
                        person = new PersonVO();

                        new ProfileTracker() {
                            @Override
                            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                                person.setImage(currentProfile.getProfilePictureUri(Constraint.PROFILE_IMAGE_WIDTH,
                                        Constraint.PROFILE_IMAGE_HEIGHT).getPath());

                                createPerson(loginResult.getAccessToken());
                            }
                        };
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        System.out.println(exception);
                    }
                });

        TextView txt = (TextView) findViewById(R.id.txtTitle);
        Typeface font = Typeface.createFromAsset(getAssets(), "Generally Speaking.ttf");
        txt.setTextSize(102);
        txt.setTypeface(font);

        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setImageResource(R.mipmap.image_grid);
    }

    private void setImprovedIcon(LoginButton loginButton) {
        float fbIconScale = 2.05F;
        Drawable drawable = ContextCompat.getDrawable(this, com.facebook.R.drawable.com_facebook_button_icon);

        drawable.setBounds(0, 0, (int) (drawable.getIntrinsicWidth() * fbIconScale), (int) (drawable.getIntrinsicHeight() * fbIconScale));
        loginButton.setCompoundDrawables(drawable, null, null, null);

        loginButton.setCompoundDrawablePadding(this.getResources().getDimensionPixelSize(R.dimen.fb_margin_override_textpadding));

        loginButton.setPadding(this.getResources().getDimensionPixelSize(R.dimen.fb_margin_override_lr),
                this.getResources().getDimensionPixelSize(R.dimen.fb_margin_override_top), 0,
                this.getResources().getDimensionPixelSize(R.dimen.fb_margin_override_bottom));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    public void createPerson(final AccessToken accessToken){
        GraphRequest request = GraphRequest.newMeRequest(accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try {
                            person.setFbAccessToken(accessToken.getToken());
                            person.setUserId(accessToken.getUserId());

                            if (object.has("email"))
                                person.setEmail(object.getString("email"));

                            if (object.has("phone"))
                                person.setPhone(object.getString("phone"));

                            if (object.has("name"))
                                person.setName(object.getString("name"));

                            if (object.has("bio"))
                                person.setBio(object.getString("bio"));

                            person.setBirthdayAt(new Date(new SimpleDateFormat("MM/dd/yyyy").parse(object.getString("birthday")).getTime()));

                            new AddPersonTask().execute(person);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link,email,bio,birthday,about");
        request.setParameters(parameters);
        request.executeAsync();

        Intent intent = new Intent(getApplicationContext(), SearchPeopleActivity.class);
        startActivity(intent);
    }
}

