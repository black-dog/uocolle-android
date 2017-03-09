package com.example.jmason.uocolle;

import android.os.Bundle;
import android.widget.ListView;

import com.example.jmason.uocolle.adapter.ImageArrayAdapter;
import com.example.jmason.uocolle.container.FishContainer;
import com.example.jmason.uocolle.model.Fish;

import java.util.ArrayList;
import java.util.List;

public class FishsActivity extends CommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishs);

        // adapterのインスタンスを作成
        ImageArrayAdapter adapter =
                new ImageArrayAdapter(this, R.layout.list_view_image_item, FishContainer.fishes, this);

        ListView fishs = (ListView) findViewById(R.id.listView1);
        fishs.setAdapter(adapter);
    }
}
