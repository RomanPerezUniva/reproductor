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

    /** Video View */
    val videoView = binding.videoView

    mediaController.setAnchorView( videoView )

    /** Buttons */
    val buttonVideo1 = binding.buttonVideo1
    val buttonVideo2 = binding.buttonVideo2
    val buttonVideo3 = binding.buttonVideo3


    /** Submit button */
    val input = binding.urlInput

    /** Submit button */
    val submitButton = binding.submitURI

    /** Options buttons */
    val playButton = binding.playButton
    val pauseButton = binding.pauseButton

    val url = "https://www.videvo.net/videvo_files/converted/2016_01/preview/Forest_15_3b_Videvo.mov47209.webm"
    val videoFile2: Uri = Uri.parse( url )
    val videoFile1: Uri = Uri.parse( "android.resource://$packageName/${ R.raw.video1 }" )
    val videoFile4: Uri = Uri.parse( "android.resource://$packageName/${ R.raw.video2 }" )

    videoView.setMediaController( mediaController )

    submitButton.setOnClickListener {
      val text = input.editText?.text.toString()
      val videoFile: Uri = Uri.parse( text );
      videoPlayer( videoFile, videoView )
    }

    buttonVideo1.setOnClickListener {
      videoPlayer( videoFile1, videoView )
    }

    buttonVideo2.setOnClickListener {
      videoPlayer( videoFile2, videoView )
    }

    buttonVideo3.setOnClickListener {
      videoPlayer( videoFile4, videoView )
    }

    playButton.setOnClickListener { if ( !videoView.isPlaying ) { videoView.start() } }
    pauseButton.setOnClickListener { if ( videoView.isPlaying ) { videoView.pause() } }

  }

  private fun videoPlayer(
    uri: Uri,
    videoView: VideoView
  ) {
    if ( videoView.isPlaying ) { videoView.stopPlayback(); }

    videoView.setVideoURI( uri )

    videoView.requestFocus()

    videoView.start()

  }

}