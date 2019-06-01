package com.github.farzadfarazmand.cleanweather.util;

import android.util.SparseArray;
import com.github.farzadfarazmand.cleanweather.R;

public class WeatherConditionMap {

    private static SparseArray<Integer> conditions = new SparseArray<>();
    private static WeatherConditionMap instance = null;

    private WeatherConditionMap() {
        init();
    }

    public synchronized static WeatherConditionMap getInstance() {
        if (instance == null)
            instance = new WeatherConditionMap();
        return instance;
    }

    private static void init() {
        conditions.append(1000, R.drawable.ic_sunny);
        conditions.append(1003, R.drawable.ic_cloudy_day);
        conditions.append(1006, R.drawable.ic_cloudy);
        conditions.append(1009, R.drawable.ic_clouds);
        conditions.append(1030, R.drawable.ic_windy);
        conditions.append(1063, R.drawable.ic_raindrop);
        conditions.append(1066, R.drawable.ic_snow);
        conditions.append(1069, R.drawable.ic_icicles);
        conditions.append(1072, R.drawable.ic_raindrop);
        conditions.append(1087, R.drawable.ic_thunderstorm);
        conditions.append(1114, R.drawable.ic_snowy);
        conditions.append(1117, R.drawable.ic_hail);
        conditions.append(1135, R.drawable.ic_haze);
        conditions.append(1147, R.drawable.ic_haze);
        conditions.append(1150, R.drawable.ic_rain);
        conditions.append(1153, R.drawable.ic_rain);
        conditions.append(1168, R.drawable.ic_rain);
        conditions.append(1171, R.drawable.ic_rain);
        conditions.append(1180, R.drawable.ic_rain);
        conditions.append(1183, R.drawable.ic_rain);
        conditions.append(1186, R.drawable.ic_raindrop);
        conditions.append(1189, R.drawable.ic_rain);
        conditions.append(1192, R.drawable.ic_raindrop);
        conditions.append(1195, R.drawable.ic_rain);
        conditions.append(1198, R.drawable.ic_rain);
        conditions.append(1201, R.drawable.ic_rain);
        conditions.append(1204, R.drawable.ic_snowy);
        conditions.append(1207, R.drawable.ic_snowy);
        conditions.append(1210, R.drawable.ic_snow);
        conditions.append(1213, R.drawable.ic_snow);
        conditions.append(1216, R.drawable.ic_snow);
        conditions.append(1219, R.drawable.ic_snow);
        conditions.append(1222, R.drawable.ic_snow);
        conditions.append(1225, R.drawable.ic_snow);
        conditions.append(1237, R.drawable.ic_icicles);
        conditions.append(1240, R.drawable.ic_raindrop);
        conditions.append(1243, R.drawable.ic_raindrop);
        conditions.append(1246, R.drawable.ic_thunderstorm);
        conditions.append(1249, R.drawable.ic_thunderstorm);
        conditions.append(1252, R.drawable.ic_snowy);
        conditions.append(1255, R.drawable.ic_snowy);
        conditions.append(1258, R.drawable.ic_snowy);
        conditions.append(1261, R.drawable.ic_icicles);
        conditions.append(1264, R.drawable.ic_icicles);
        conditions.append(1273, R.drawable.ic_thunderstorm);
        conditions.append(1276, R.drawable.ic_thunderstorm);
        conditions.append(1279, R.drawable.ic_snowy);
        conditions.append(1282, R.drawable.ic_snowy);

    }

}
