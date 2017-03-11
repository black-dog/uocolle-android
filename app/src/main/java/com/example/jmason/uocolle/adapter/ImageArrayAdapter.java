package com.example.jmason.uocolle.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jmason.uocolle.R;
import com.example.jmason.uocolle.container.FishContainer;
import com.example.jmason.uocolle.model.Fish;

import java.util.List;

/**
 * Created by yuyaseko on 17/03/08.
 */

public class ImageArrayAdapter extends ArrayAdapter<Fish> {
    private int resourceId;
    private List<Fish> items;
    private LayoutInflater inflater;
    private Activity activity;

    public ImageArrayAdapter(Context context, int resourceId, List<Fish> items, Activity activity) {
        super(context, resourceId, items);

        this.resourceId = resourceId;
        this.items = items;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView != null) {
            view = convertView;
        } else {
            view = this.inflater.inflate(this.resourceId, null);
        }

        Fish item = this.items.get(position);

        // テキストをセット
        TextView appInfoText = (TextView)view.findViewById(R.id.item_text);
        appInfoText.setText(item.getName());

        // アイコンをセット
        ImageView appInfoImage = (ImageView)view.findViewById(R.id.item_image);
        int index = activity.getResources().getIdentifier(item.getImageId(), "drawable", activity.getPackageName());

        appInfoImage.setImageResource(index);

        return view;
    }
}
