package com.mobileseva.new_sun_mobile.Parser;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.mobileseva.new_sun_mobile.Mapper.FeedMapper;
import com.orhanobut.logger.Logger;

import org.json.JSONArray;

/**
 * Created by mrajamani on 10/02/17.
 */

public class FeedParser {

    public FeedMapper[] parse(JSONArray response){
        Gson gson = new Gson();
        return gson.fromJson(String.valueOf(response),FeedMapper[].class);
    }

}
