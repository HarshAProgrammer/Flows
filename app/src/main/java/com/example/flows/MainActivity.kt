package com.example.flows

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val channel = Channel<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        CoroutineScope(Dispatchers.Main).launch {
//            getUserList().forEach{
//                Log.d("Harsh",it)
//        }
//            }
        producer()
        consumer()

    }

//    private suspend fun getUserList():List<String>{
//        val list = mutableListOf<String>()
//        list.add(getUser(1))
//        list.add(getUser(2))
//        list.add(getUser(3))
//        return list
//    }
//    private suspend fun getUser(id:Int):String{
//        delay(1000)
//        return "user$id"
//    }

    fun producer(){
        CoroutineScope(Dispatchers.Main).launch {
            channel.send(1)
            channel.send(2)
        }
    }
    fun consumer(){
        CoroutineScope(Dispatchers.Main).launch {
            Log.d("Harsh",channel.receive().toString())
            Log.d("Harsh",channel.receive().toString())

        }
    }

}