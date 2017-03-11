package com.example.jmason.uocolle.container;

import android.support.v7.app.AppCompatActivity;

import com.example.jmason.uocolle.model.Fish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuyaseko on 17/03/09.
 */

public class FishContainer {

    public static List<Fish> fishes;
    public static Map<Integer, Fish> fishesMap = new HashMap<Integer, Fish>();

    public static boolean isInitialized() {
        return fishes != null;
    }

    public static void init(List<Fish> argFishes) {
        if (fishes == null) {
            fishes = argFishes;
            for (Fish fish : fishes) {
                fishesMap.put(fish.getId(), fish);
            }
        }
    }
}
