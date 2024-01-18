package com.example.xmltestapp

import android.app.Service
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log

class IRRemoteService:IRemoteService.Stub() {
    override fun getName():String{
        return "Debananda"
    }

    override fun basicTypes(
        anInt: Int,
        aLong: Long,
        aBoolean: Boolean,
        aFloat: Float,
        aDouble: Double,
        aString: String?
    ) {
        TODO("Not yet implemented")
    }
}

class MyService(val num:Int) : Service() {
//    val rs = IRRemoteService()


    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("DEBA MAIN","Hello")
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboardManager.setPrimaryClip(ClipData.newPlainText("some","Deba may be"))
        clipboardManager.addPrimaryClipChangedListener {
            Log.d("DEBA NAYAK","send data to DB")
        }
        return START_STICKY
    }
}