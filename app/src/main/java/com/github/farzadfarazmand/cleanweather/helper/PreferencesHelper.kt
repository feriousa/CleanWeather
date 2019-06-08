package com.github.farzadfarazmand.cleanweather.helper

import android.content.Context
import android.content.SharedPreferences

object PreferencesHelper {

    private const val PREF_NAME = "clean_weather_pref"

    //keys
    private const val CACHED_WEATHER_DATA_PREF = "cached_weather_data_pref"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    // save methods
    private fun save(context: Context, key: String, value: String) {
        val editor = getPreferences(context).edit()
        editor.putString(key, value).apply()
    }

    private fun save(context: Context, key: String, value: Int) {
        val editor = getPreferences(context).edit()
        editor.putInt(key, value).apply()
    }

    private fun save(context: Context, key: String, value: Boolean) {
        val editor = getPreferences(context).edit()
        editor.putBoolean(key, value).apply()
    }

    //get methods
    private fun getStringValue(context: Context, key: String): String? {
        return getPreferences(context).getString(key, null)
    }

    private fun getIntValue(context: Context, key: String): Int {
        return getPreferences(context).getInt(key, 0)
    }

    private fun getBooleanValue(context: Context, key: String): Boolean {
        return getPreferences(context).getBoolean(key, false)
    }

    private fun getBooleanValue(context: Context, key: String, default: Boolean): Boolean {
        return getPreferences(context).getBoolean(key, default)
    }

    //clear and remove

    fun clearAll(context: Context) {
        val editor = getPreferences(context).edit()
        editor.clear()
        editor.apply()
    }

    fun removeKey(context: Context, key: String) {
        val editor = getPreferences(context).edit()
        editor.remove(key).apply()
    }

    // functions
    fun saveWeatherData(context: Context, reponseJson: String) {
        save(context, CACHED_WEATHER_DATA_PREF, reponseJson)
    }

    fun getCachedWeatherData(context: Context): String? {
        return getStringValue(context, CACHED_WEATHER_DATA_PREF)
    }


}