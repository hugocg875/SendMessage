package com.example.sendessage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.BundleCompat
import com.example.sendessage.model.Message

class RecieveMessageActivity: AppCompatActivity() {
    companion object{
        const val TAG: String = "LogViewMessageActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_message)
        val texto = findViewById<TextView>(R.id.view2_text)
        val boton = findViewById<Button>(R.id.btn2)
        val sender = findViewById<TextView>(R.id.text_sender)
        val reciever = findViewById<TextView>(R.id.text_reciever)
        val bundle: Bundle = intent.extras!!
        val message = BundleCompat.getSerializable(
            bundle,
            "KEY_MESSAGE",
            Message::class.java
        )

        sender.text = message?.sender?.name + " " + message?.sender?.surname
        reciever.text = message?.receiver?.name + " " + message?.receiver?.surname
        texto.text = message?.content



        boton.setOnClickListener {
            val intent = Intent(this, SendMessageActivity::class.java)
            startActivity(intent)
        }

    }
//region ciclo de vida
    override fun onStart() {
        super.onStart()
    Log.d(TAG, "LogViewMessageActivity -> onStart()")
    }

    override fun onStop() {
        super.onStop()
    Log.d(TAG, "LogViewMessageActivity -> onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
    Log.d(TAG, "LogVie wMessageActivity -> onDestroy()")
    }

    override fun onPause() {
        super.onPause()
    Log.d(TAG, "LogViewMessageActivity -> onPause()")
    }

    override fun onResume() {
        super.onResume()
    Log.d(TAG, "LogViewMessageActivity -> onResume()")
    }
//endregion
}