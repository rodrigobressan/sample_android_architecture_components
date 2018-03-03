package com.rodrigobresan.samplearchitcturecomponents.lifecycle

import android.content.Context
import android.media.MediaPlayer
import com.rodrigobresan.samplearchitcturecomponents.R

class MusicManager(context: Context) {

    private var mediaPlayer: MediaPlayer = MediaPlayer.create(context, R.raw.music)

    fun start() {
        mediaPlayer.start()
    }

    fun pause() {
        mediaPlayer.pause()
    }

    fun stop() {
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}