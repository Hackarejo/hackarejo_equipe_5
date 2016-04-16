package com.quebragelo.quebragelo.helper;

import com.google.gson.Gson;

/**
 * Created by bruno on 14/06/15.
 */
public abstract class JSONSerializer {
    public abstract String getSerializerKey();

    public String toJSON(){
        return "{\""+ this.getSerializerKey() +"\":" + new Gson().toJson(this) + "}";
    }
}
