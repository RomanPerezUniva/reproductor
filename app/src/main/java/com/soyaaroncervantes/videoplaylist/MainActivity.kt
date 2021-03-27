package com.soyaaroncervantes.videoplaylist

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
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

    /** URI Video Resources */
    val videoFile1: Uri = Uri.parse( "android.resource://$packageName/${ R.raw.video1 }" )
    val videoFile2: Uri = Uri.parse( "android.resource://$packageName/${ R.raw.video2 }" )
    val videoFile3: Uri = Uri.parse( "android.resource://$packageName/${ R.raw.video3 }" )

    videoView.setMediaController( mediaController )

    buttonVideo1.setOnClickListener {
      if ( videoView.isPlaying ) {
        videoView.stopPlayback()
      }

      videoView.setVideoURI( videoFile1 )
      // Asignar videoView al Media Controller
      mediaController.setAnchorView( binding.videoView )
      videoView.requestFocus()
      videoView.start()
    }

    buttonVideo2.setOnClickListener {
      if ( videoView.isPlaying ) {
        videoView.stopPlayback()
      }
      videoView.setVideoURI( videoFile2 )
      // Asignar videoView al Media Controller
      mediaController.setAnchorView( binding.videoView )
      videoView.requestFocus()
      videoView.start()
    }


    buttonVideo3.setOnClickListener {
      if ( videoView.isPlaying ) {
        videoView.stopPlayback()
      }
      videoView.setVideoURI( videoFile3 )
      // Asignar videoView al Media Controller
      mediaController.setAnchorView( binding.videoView )
      videoView.requestFocus()
      videoView.start()
    }

  }

}