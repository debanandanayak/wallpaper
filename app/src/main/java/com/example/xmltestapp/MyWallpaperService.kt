package com.example.xmltestapp

import android.graphics.Color
import android.graphics.Paint
import android.media.MediaPlayer
import android.provider.CalendarContract.Colors
import android.service.wallpaper.WallpaperService
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import com.google.android.gms.common.SignInButton.ColorScheme
import com.google.android.material.color.MaterialColors
import java.util.logging.Handler
import kotlin.random.Random


class MyWallpaperService : WallpaperService() {

    override fun onCreateEngine(): WallpaperService.Engine {
        return VideoEngine()
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("VideoEngine oncreate", "( VideoEngine )")
    }
    internal inner class VideoEngine : WallpaperService.Engine() {

        private val TAG = javaClass.simpleName
        private val mediaPlayer: MediaPlayer

        init {
            Log.i(TAG, "( VideoEngine )")
            mediaPlayer = MediaPlayer.create(baseContext, R.raw.video2)

        }

        override fun onSurfaceCreated(holder: SurfaceHolder) {
            Log.i(TAG, "onSurfaceCreated")
            mediaPlayer.setSurface(holder.surface)
            mediaPlayer.start()
        }


        override fun onSurfaceDestroyed(holder: SurfaceHolder) {
            Log.i(TAG, "( INativeWallpaperEngine ): onSurfaceDestroyed")
            playheadTime = mediaPlayer.currentPosition
            mediaPlayer.reset()
            mediaPlayer.release()
        }

        override fun onVisibilityChanged(visible: Boolean) {
            super.onVisibilityChanged(visible)
            if (visible){
                mediaPlayer.start()
                android.os.Handler().postDelayed({
                   mediaPlayer.pause()
                },3000)
            }
        }
    }

    companion object {
        protected var playheadTime = 0
    }

}





//class MyWallpaperService : WallpaperService() {
//    override fun onCreateEngine(): Engine {
//        return MyWallpaperEngine()
//    }
//    private inner class MyWallpaperEngine : WallpaperService.Engine(){
////        override fun onCreate(surfaceHolder: SurfaceHolder?) {
////            super.onCreate(surfaceHolder)
////            surfaceHolder
////        }
//        var number = 0
//        var _holder: SurfaceHolder? = null
//        override fun onSurfaceCreated(holder: SurfaceHolder?) {
//            super.onSurfaceCreated(holder)
//            _holder = holder
//            val canvas = holder?.lockCanvas()
//            val paint = Paint().apply {
//                color = Color.CYAN
//                style = Paint.Style.FILL
//            }
//            canvas?.drawPaint(paint)
//
////            canvas?.drawPaint(paint)
//            Log.d("MAIN_ACTIVITY","SURFACE created")
//            holder?.unlockCanvasAndPost(canvas)
//        }
//
//        override fun onTouchEvent(event: MotionEvent?) {
//            super.onTouchEvent(event)
//            number += 1
//            val canvas = _holder?.lockCanvas()
//            val paint = Paint().apply {
//                color = Color.YELLOW
//                style = Paint.Style.FILL
//            }
//            canvas?.drawPaint(paint)
//            Log.d("MAIN_ACTIVITY","touch created")
//            _holder?.unlockCanvasAndPost(canvas)
//            Log.d("MAIN_ACTIVITY","TOUCH  created")
//        }
//    }
//
//}