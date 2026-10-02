package com.example.sendessage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.sendessage.model.Message
import com.example.sendessage.model.Person
import org.w3c.dom.Text

/**
 * Esta es la primera actividad de la app desarrollada en clase de como pasar
 * de una ventana a ptra llevando datos escritos por el usuario:
 * <ol>
 *     <li>Crear componente EditText y Button en XML</li>
 *     <li>Lanzar un evento en un componente visual</li>
 *     <li>Crea el intent junto con el Bundle para pasar a otra actividad</li>
 *     <li>El ciclo de vida de la Activity</li>
 *     <li>Ver la pila de Actividades</li>
 * </ol>
 *
 * @author Hugo de Cristobal Gomez
 * @version 1.0
 * @see android.widget.TextView
 * @see android.widget.Button
 * @see android.os.Bundle
 * @see Intent
 */
class SendMessageActivity : AppCompatActivity() {
    lateinit var mensaje: EditText
    lateinit var boton: Button
    companion object{
        const val TAG: String = "LogSendMessageActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_message)

        mensaje = findViewById(R.id.et)
        boton = findViewById(R.id.bt)


        boton.setOnClickListener{
            sendMessage()
        }

        Log.d(TAG, "SendMessageActivity -> onCreate()")
    }

    /**
     * Funcion que construye un mensaje con reminente, la persona que envia y el mensaje
     * de manera que despues se pueda recuperar y mostrar por pantalla
     */
    private fun sendMessage(){
        val intent = Intent(this, RecieveMessageActivity::class.java)
        val bundle = Bundle()
        val sender = Person("18293048", "Maria", "Cortes Martin")
        val reciever = Person("79044053E", "Hugo", "de Cristobal Gomez")
        val message = Message(id = 2, mensaje.text.toString(), sender, reciever)
        bundle.putSerializable("KEY_MESSAGE", message)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    //region ciclo de vida
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "LogSendMessageActivity -> onStart()")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "LogSendMessageActivity -> onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "LogSendMessageActivity -> onDestroy()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "LogSendMessageActivity -> onPause()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "LogSendMessageActivity -> onResume()")
    }
//endregion
}