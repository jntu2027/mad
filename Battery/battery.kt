package com.example.battery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.Toast

class battery  : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var level = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL , -1)
        if (level != null) {
            if (level <= 20){
                Toast.makeText(context , "Please charge the Phone" , Toast.LENGTH_SHORT).show()
            }
        }

    }
}