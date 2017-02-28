package com.mobileseva.new_sun_mobile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobileseva.new_sun_mobile.Activity.MainActivity;
import com.mobileseva.new_sun_mobile.Mapper.FeedMapper;
import com.mobileseva.new_sun_mobile.R;

import org.w3c.dom.Text;

import java.util.List;

import static android.R.attr.resource;

/**
 * Created by mrajamani on 10/02/17.
 */

public class FeedAdapter extends BaseAdapter {


    FeedMapper[] fm;
    Context mcontext;
    int resource;
    int textViewResourceId;

    private static class ViewHolder {
        TextView txtType;
        TextView txtSlug;
        TextView txtImage;
        TextView txtTitle;
        TextView txtSummary;
    }

    public FeedAdapter(Context context, FeedMapper[] objects) {
        super();
        this.mcontext = context;
        this.fm=objects;
    }


    @Override
    public int getCount() {
        return fm.length;
    }

    @Override
    public FeedMapper getItem(int i) {
        return fm[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        FeedMapper feedMapper = getItem(i);
        ViewHolder viewHolder;
        if (view==null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
            view = layoutInflater.inflate(R.layout.row_item,viewGroup,false);
            viewHolder.txtType = (TextView) view.findViewById(R.id.txtType);
            viewHolder.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            viewHolder.txtImage = (TextView) view.findViewById(R.id.txtImage);
            viewHolder.txtSummary = (TextView) view.findViewById(R.id.txtSummary);
            viewHolder.txtSlug = (TextView) view.findViewById(R.id.txtSlug);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.txtSlug.setText(feedMapper.getSlug());
        viewHolder.txtSummary.setText(feedMapper.getSummary());
        viewHolder.txtType.setText(feedMapper.getType());
        viewHolder.txtTitle.setText(feedMapper.getTitle());
        viewHolder.txtImage.setText(feedMapper.getImage());
        return  view;
    }
}
