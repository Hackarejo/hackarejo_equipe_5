package com.quebragelo.quebragelo.preference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by bruno on 16/06/15.
 */
public class ProfilePreference {

    private static final String USER_PREFS = "USER_PREFS";
    private SharedPreferences appSharedPrefs;
    private SharedPreferences.Editor prefsEditor;
    private String user_id = "user_id_prefs";

    public ProfilePreference(Context context){
        this.appSharedPrefs = context.getSharedPreferences(USER_PREFS, Activity.MODE_PRIVATE);
        this.prefsEditor = appSharedPrefs.edit();
    }

    public int getUserID() {
        return appSharedPrefs.getInt(user_id, 0);
    }

    public void setUserID(int userID) {
        prefsEditor.putInt(user_id, userID).commit();
    }
}
