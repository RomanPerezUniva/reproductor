package com.soyaaroncervantes.videoplaylist

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.soyaaroncervantes.videoplaylist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = ActivityMainBinding.inflate( layoutInflater )
    setContentView( binding.root );

    /** Media Controller */
    val mediaController = MediaController(this)

    /** TextView */
    val title = binding.textTitle

    /** Buttons */
    val buttonVideo1 = binding.buttonVideo1
    val buttonVideo2 = binding.buttonVideo2
    val buttonVideo3 = binding.buttonVideo3

    /** Video View */
    val videoView = binding.videoView

    val videoFile1: Uri = Uri.parse( "android.resource://$packageName/${ R.raw.video1 }" )
    val videoFile2: Uri = Uri.parse( "android.resource://$packageName/${ R.raw.video2 }" )
    val videoFile3: Uri = Uri.parse( "android.resource://$packageName/${ R.raw.video3 }" )

    videoView.setMediaController( mediaController )

    buttonVideo1.setOnClickListener {
      videoPlayer( videoView, videoFile1, mediaController )
    }

    buttonVideo2.setOnClickListener {
      videoPlayer( videoView, videoFile2, mediaController )
    }

    buttonVideo3.setOnClickListener {
      videoPlayer( videoView, videoFile3, mediaController )
    }

  }

  private fun videoPlayer(videoView: VideoView, uri: Uri, mediaController: MediaController ) {
    if ( videoView.isPlaying ) { videoView.stopPlayback(); }

    videoView.setVideoURI( uri )

    mediaController.setAnchorView( videoView )

    videoView.requestFocus()

    videoView.start()

  }
}