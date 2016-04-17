package com.hackarejo.divulgarejo.task;

import android.os.AsyncTask;
import com.hackarejo.divulgarejo.helper.URLMaker;
import com.hackarejo.divulgarejo.vo.PersonVO;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bruno on 11/06/15.
 */
public class AddPersonTask extends AsyncTask<PersonVO, Void, Void> {

    @Override
    protected Void doInBackground(PersonVO... params) {
        try {
            PersonVO person = params[0];
            String msg = person.toJSON();
            URL url = URLMaker.create(person);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setReadTimeout(10000);
            con.setConnectTimeout(15000);
            con.setRequestMethod("POST");

            con.setDoInput(true);
            con.setDoOutput(false);

            con.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            con.setRequestProperty("X-Request-With", "XMLHttpRequest");

            con.setFixedLengthStreamingMode(msg.getBytes().length);

            OutputStream os = new BufferedOutputStream(con.getOutputStream());
            os.write(msg.getBytes());
            os.flush();

            os.close();
            con.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
