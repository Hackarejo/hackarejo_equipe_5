package com.hackarejo.divulgarejo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hackarejo.divulgarejo.helper.URLMaker;
import com.hackarejo.divulgarejo.vo.ProductVO;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bruno on 18/06/15.
 */
public class ListProductsActivity extends Activity {

    protected ProductVO doInBackground(Void... params) {
        ProductVO p = null;

        try {
            URL url = new URL(URLMaker.create(new ProductVO()).toString());

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);

            Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

            JsonElement jelement = new JsonParser().parse(reader);
            JsonObject jobject = jelement.getAsJsonObject();

            p = gs.fromJson(jobject.getAsJsonObject("product"), ProductVO.class);

            reader.close();
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}
