package com.example.sunday.kotlinmusicplayer.application

import android.app.Application
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import com.example.sunday.kotlinmusicplayer.player.PlayService

/**
 * Created by Sunday on 2018/11/10
 */
class MyApplication : Application() {


    private val mServiceConnection = MyServiceConnection()
    lateinit var mPlayService: PlayService
    //bindService


    override fun onCreate() {
        super.onCreate()
        bindService()
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d("sunshuo" ,"Terminate")
        unbindService()
    }

    private fun bindService() {
        val intent = Intent()
        intent.setClass(this, PlayService::class.java)
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE)
    }

    private fun unbindService() {
        unbindService(mServiceConnection)
    }


    inner class MyServiceConnection : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {


        }

    }


}