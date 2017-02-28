package com.mobileseva.new_sun_mobile.Network;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.mobileseva.new_sun_mobile.Mapper.FeedMapper;
import com.mobileseva.new_sun_mobile.Parser.FeedParser;
import com.orhanobut.logger.Logger;

import org.json.JSONArray;

/**
 * Created by mrajamani on 10/02/17.
 */

public  class VolleyConnection {
    RequestQueue requestQueue;

    public RequestQueue getInstance(Context context){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }



    public void fetchFeeds(final APIFeeds context) {
        //Get the Feeds
        VolleyJsonRequest myJsonObjectRequest = new VolleyJsonRequest("http://10.195.169.57:8000/feed.json", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    FeedParser feedParser = new FeedParser();
                    FeedMapper[] feedMappers = feedParser.parse(response);
                    context.OnFeedCompleted(feedMappers);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logger.d(error);
            }
        });

        //Retry policy
        myJsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        myJsonObjectRequest.setTag("jsonRequest");

        requestQueue.add(myJsonObjectRequest);
    }

    public interface APIFeeds{
        void OnFeedCompleted(FeedMapper[] feedMappers);
    }
}
