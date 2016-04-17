package com.hackarejo.divulgarejo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import com.facebook.FacebookSdk;
import com.hackarejo.divulgarejo.R;
import com.hackarejo.divulgarejo.helper.Constraint;
import com.hackarejo.divulgarejo.task.ImageDownloaderTask;
import com.hackarejo.divulgarejo.task.LoadPersonTask;
import com.hackarejo.divulgarejo.task.UpdatePersonTask;
import com.hackarejo.divulgarejo.vo.PersonVO;
import com.software.shell.fab.ActionButton;

import java.text.SimpleDateFormat;

/**
 * Created by bruno on 16/06/15.
 */
public class ProfileActivity extends Activity {
    private PersonVO currentUser;
    private ActionButton actionButton;

    private RoundedImageView imageView;

    private EditText editBirthday;
    private TextView viewBirthday;
    private ViewSwitcher birthdaySwitcher;

    private EditText editName;
    private TextView viewName;
    private ViewSwitcher nameSwitcher;

    private EditText editBio;
    private TextView viewBio;
    private ViewSwitcher bioSwitcher;

    private GestureDetectorCompat gestureDetectorCompat;

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());

        try {
            FacebookSdk.sdkInitialize(getApplicationContext());
            setContentView(R.layout.activity_profile);

            currentUser = new LoadPersonTask(this).execute().get();

            initializeElements();
            turnRedButton();
            loadUserInfos();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void initializeElements(){
        imageView = (RoundedImageView) findViewById(R.id.profile_image);

        actionButton = (ActionButton) findViewById(R.id.action_button);

        editBirthday = (EditText) findViewById(R.id.hidden_edit_birthday);
        viewBirthday = (TextView) findViewById(R.id.label_birthday);
        birthdaySwitcher = (ViewSwitcher) findViewById(R.id.birthday_switcher);

        editName = (EditText) findViewById(R.id.hidden_edit_name);
        viewName = (TextView) findViewById(R.id.label_name);
        nameSwitcher = (ViewSwitcher) findViewById(R.id.name_switcher);

        editBio = (EditText) findViewById(R.id.hidden_edit_bio);
        viewBio = (TextView) findViewById(R.id.label_bio);
        bioSwitcher = (ViewSwitcher) findViewById(R.id.bio_switcher);
    }

    public void turnRedButton(){
        actionButton.setButtonColor(getResources().getColor(R.color.fab_material_red_500));
        actionButton.setButtonColorPressed(getResources().getColor(R.color.fab_material_red_900));
        actionButton.setImageResource(R.drawable.ic_mode_edit_white_18dp);

        if (actionButton.getButtonColor() != getResources().getColor(R.color.fab_material_red_500))
            turnShowableView();
    }

    public void turnGreenButton(View view){
        actionButton.setButtonColor(getResources().getColor(R.color.fab_material_green_500));
        actionButton.setButtonColorPressed(getResources().getColor(R.color.fab_material_green_900));
        actionButton.setImageResource(R.drawable.ic_done_white_18dp);

        turnEditableView();
        loadUserInfos();

        actionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateInfos(view);
                    }
                });
    }

    private void loadUserInfos(){
        try{
            Bitmap image = new ImageDownloaderTask().execute(currentUser.getImageLink(Constraint.PROFILE_IMAGE_LARGE)).get();
            imageView.setImageBitmap(image);

            viewName.setText(currentUser.getName());
            editName.setText(currentUser.getName());

            viewBio.setText(currentUser.getBio());
            editBio.setText(currentUser.getBio());

            editBirthday.setText(format.format(currentUser.getBirthdayAt()));
            viewBirthday.setText(format.format(currentUser.getBirthdayAt()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateInfos(View view){
        try {
            PersonVO person = new PersonVO();
            person.setApiId(currentUser.getApiId());

            person.setBirthdayAt(format.parse(editBirthday.getText().toString()));
            person.setBio(editBio.getText().toString());
            person.setName(editName.getText().toString());

            new UpdatePersonTask().execute(person);

            turnRedButton();
            turnShowableView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void turnShowableView(){
        birthdaySwitcher.showPrevious();
        bioSwitcher.showPrevious();
        nameSwitcher.showPrevious();
    }

    public void turnEditableView(){
        birthdaySwitcher.showNext();
        bioSwitcher.showNext();
        nameSwitcher.showNext();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
       @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            if(event2.getX() < event1.getX()){
                Intent intent = new Intent(ProfileActivity.this, SearchPeopleActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
            }
            return true;
        }
    }
}







