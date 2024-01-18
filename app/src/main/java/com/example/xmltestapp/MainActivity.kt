package com.example.xmltestapp


import android.app.WallpaperManager
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.service.wallpaper.WallpaperService
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.xmltestapp.databinding.ActivityMainBinding
import com.google.android.gms.nearby.Nearby
import com.google.android.gms.nearby.messages.Message
import com.google.android.gms.nearby.messages.MessageListener
import java.util.ServiceLoader

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val intent = Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER,)
        intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,ComponentName(this,MyWallpaperService::class.java))
        startActivity(intent)
    }

    override fun onStop() {
        super.onStop()
        Log.d("DEBA NAYAK","end service")
    }



}