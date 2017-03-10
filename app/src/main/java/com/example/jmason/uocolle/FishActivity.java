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
        int position = intent.getIntExtra("position", 0);
        Toast.makeText(this, "position:" + position, Toast.LENGTH_SHORT).show();

        Fish fish = FishContainer.fishes.get(position);

        // テキストをセット
        TextView appInfoText = (TextView)this.findViewById(R.id.textView);
        appInfoText.setText(fish.getName());

        // アイコンをセット
        ImageView appInfoImage = (ImageView)this.findViewById(R.id.item_image);
        int index = this.getResources().getIdentifier(fish.getImageId(), "drawable", this.getPackageName());
        appInfoImage.setImageResource(index);

    }
}
