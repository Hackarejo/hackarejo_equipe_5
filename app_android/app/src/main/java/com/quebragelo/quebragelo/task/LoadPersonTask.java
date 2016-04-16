package com.quebragelo.quebragelo.task;

import android.os.AsyncTask;
import com.facebook.AccessToken;
import com.google.gson.*;
import com.quebragelo.quebragelo.activity.ProfileActivity;
import com.quebragelo.quebragelo.helper.URLMaker;
import com.quebragelo.quebragelo.vo.PersonVO;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bruno on 11/06/15.
 */
public class LoadPersonTask extends AsyncTask<Void, PersonVO, PersonVO> {

    private ProfileActivity activity;

    public LoadPersonTask(ProfileActivity activity) {
        this.activity = activity;
    }

    @Override
    protected PersonVO doInBackground(Void... params) {
        PersonVO p = null;

        try {
            URL url = new URL(URLMaker.create(new PersonVO()).toString() + "find_by?hash[user_id]=" +
                    AccessToken.getCurrentAccessToken().getUserId());

            System.out.print(AccessToken.getCurrentAccessToken().getUserId());

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);

            Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

            JsonElement jelement = new JsonParser().parse(reader);
            JsonObject jobject = jelement.getAsJsonObject();

            p = gs.fromJson(jobject.getAsJsonObject("person"), PersonVO.class);

            reader.close();
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }
}
