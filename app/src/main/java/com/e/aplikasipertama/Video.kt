package com.e.aplikasipertama

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class Video : YouTubeBaseActivity(),
YouTubePlayer.OnInitializedListener{

    lateinit var yb: YouTubePlayerView


    override fun onCreate(p0: Bundle?) {
        super.onCreate(p0)
        setContentView(R.layout.activity_video)
        yb=findViewById(R.id.youtubePlayer)
        yb.initialize("AIzaSyBLAd45N_zabo0aHZg_Hbgw3PRzTrfWGEM",this)
        requestedOrientation=
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean) {

        p1!!.setFullscreen(true)
        p1.cueVideo("YmF2WA9NwaY&list")
        p1.play()

    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        if (p1!!.isUserRecoverableError){
            p1.getErrorDialog(this,1).show()
        }

    }

}
