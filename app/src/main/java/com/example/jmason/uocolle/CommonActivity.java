package com.example.jmason.uocolle;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jmason.uocolle.container.FishContainer;
import com.example.jmason.uocolle.model.Fish;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CommonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!FishContainer.isInitialized()) {
            List<Fish> fishes = convertFishJsonToObject("fish");
            FishContainer.init(fishes);
        }
    }

    private List<Fish> convertFishJsonToObject(String fileName) {
        List<Fish> fishes = new ArrayList<Fish>();
        Resources res = this.getResources();
        int id = getResources().getIdentifier(fileName,"raw",this.getPackageName());

        try (InputStream is = res.openRawResource(id)) {
            ObjectMapper mapper = new ObjectMapper();
            fishes = mapper.readValue(is, new TypeReference<List<Fish>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fishes;
    }
}
