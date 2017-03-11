package com.example.jmason.uocolle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

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
        fishs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fish fish = FishContainer.fishes.get(position);
                Intent intent = new Intent(FishsActivity.this, FishActivity.class);
                intent.putExtra("id", fish.getId());
                startActivity(intent);
            }
        });
    }
}
