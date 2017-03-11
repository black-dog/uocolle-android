package com.example.jmason.uocolle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jmason.uocolle.container.FishContainer;
import com.example.jmason.uocolle.model.Fish;

public class FishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        Fish fish = FishContainer.fishesMap.get(id);

        // さなか名
        TextView appInfoText = (TextView)this.findViewById(R.id.textView);
        appInfoText.setText(fish.getName());

        // アイコンをセット
        ImageView appInfoImage = (ImageView)this.findViewById(R.id.item_image);
        int index = this.getResources().getIdentifier(fish.getImageId(), "drawable", this.getPackageName());
        appInfoImage.setImageResource(index);

        // 味
        TextView taste = (TextView)this.findViewById(R.id.taste);
        taste.setText(fish.getTaste());

        // 特徴
        TextView character = (TextView)this.findViewById(R.id.character);
        character.setText(fish.getCharacter());

        // 値段
        TextView value = (TextView)this.findViewById(R.id.value);
        value.setText(fish.getValue());

        // 生息地
        TextView habitat = (TextView)this.findViewById(R.id.habitat);
        habitat.setText(fish.getHabitat());

        // 毒
        TextView poison = (TextView)this.findViewById(R.id.poison);
        poison.setText(fish.getPoison());
    }
}
