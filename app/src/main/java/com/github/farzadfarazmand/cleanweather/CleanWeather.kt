package com.github.farzadfarazmand.cleanweather

import android.app.Application
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump


class CleanWeather : Application() {


    override fun onCreate() {
        super.onCreate()

        //set default font
        initCalligraphy()
    }

    private fun initCalligraphy() {
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath(getString(R.string.montserrat_regular))
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )
    }

}