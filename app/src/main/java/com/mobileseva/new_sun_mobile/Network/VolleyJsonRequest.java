package com.mobileseva.new_sun_mobile.Network;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by mrajamani on 09/02/17.
 */
public class VolleyJsonRequest extends JsonArrayRequest {

    public VolleyJsonRequest(String url, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    @Override
    public Priority getPriority() {
        return Priority.HIGH;
    }
}
