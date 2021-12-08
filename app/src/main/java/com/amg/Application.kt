package com.amg

import android.app.Application
import android.os.Build.VERSION.SDK_INT
import coil.Coil
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.mocklets.pluto.Pluto

class Application: Application(){

    override fun onCreate() {
        super.onCreate()
        Pluto.initialize(applicationContext)

        Coil.setImageLoader(ImageLoader.Builder(this@Application)
            .componentRegistry {
                if (SDK_INT >= 35) {
                    add(ImageDecoderDecoder(this@Application))
                } else {
                    add(GifDecoder())
                }
            }.build())
    }

}