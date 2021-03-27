package com.soyaaroncervantes.videoplaylist

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import com.soyaaroncervantes.videoplaylist.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.io.File
import java.net.URI

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
    val playButton = binding.playButton
    val pauseButton = binding.pauseButton

    /** Video View */
    val videoView = binding.videoView

    val videoFile1: Uri = Uri.parse( "android.resource://$packageName/${ R.raw.video1 }" )
    val videoFile2: Uri = Uri.parse( "https://cdn.videvo.net/videvo_files/video/free/2017-08/small_watermarked/170724_15_Setangibeach_preview.webm" )
    val videoFile3: Uri = Uri.parse( "android.resource://$packageName/${ R.raw.video3 }" )
    val videoFile4: Uri = Uri.parse( "android.resource://$packageName/${ R.raw.video2 }" )

    videoView.setMediaController( mediaController )

    buttonVideo1.setOnClickListener {
      videoPlayer( mediaController, videoFile1, videoView, title )
    }

    buttonVideo2.setOnClickListener {
      videoPlayer( mediaController, videoFile2, videoView, title )
    }

    buttonVideo3.setOnClickListener {
      videoPlayer( mediaController, videoFile3, videoView, title )
    }

    playButton.setOnClickListener { if ( !videoView.isPlaying ) { videoView.start() } }
    pauseButton.setOnClickListener { if ( videoView.isPlaying ) { videoView.pause() } }

  }

  private fun videoPlayer(
    mediaController: MediaController,
    uri: Uri,
    videoView: VideoView,
    title: TextView,
  ) {
    if ( videoView.isPlaying ) { videoView.stopPlayback(); }

    Log.d("[DEBUG]", "$uri.path")

    videoView.setVideoURI( uri )

    mediaController.setAnchorView( videoView )

    val file = File("$uri")

    title.text = file.name

    videoView.requestFocus()

    videoView.start()

  }

}