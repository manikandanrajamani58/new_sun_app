package com.mobileseva.new_sun_mobile.Mapper;

import android.icu.lang.UScript;

import java.util.List;

/**
 * Created by mrajamani on 09/02/17.
 */
public class FeedMapper {
    String type;
    String slug;
    String image;
    String title;
    String summary;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}


