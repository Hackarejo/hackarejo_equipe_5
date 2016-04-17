package com.hackarejo.divulgarejo.helper;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bruno on 11/06/15.
 */
public class URLMaker {
    public static URL create(WebAddressable addressable){
        URL url = null;

        try {
            String part = Constraint.WEB_API_DOMAIN + Constraint.WEB_API_VERSION + addressable.getPath();

            if (addressable.hasId())
                url = new URL(part + addressable.getId());
            else
                url = new URL(part);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }
}
