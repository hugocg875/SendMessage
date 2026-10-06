package com.example.sendessage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.BundleCompat
import com.example.sendessage.model.Message

/**
 * Pantalla que recibe y presenta el mensaje creado en [SendMessageActivity].
 *
 * <p>La actividad recupera de su <code>Bundle</code> un obejto <code>Message</code> serializado con la clave
 * <code>KEY_MESSAGE</code> y muestra la siguiente información:</p>
 *
 * <ul>
 *     <li>Nombre completo del remitente.</li>
 *     <li>Nombre completo del destinatario.</li>
 *     <li>Contenido del mensaje.</li>
 * </ul>
 *
 * <p>El botón de la pantalla permite volver a la actividad de envío.</p>
 *
 * @author Hugo de Cristobal Gomez
 * @see SendMessageActivity
 * @see Message
 *
 */
class RecieveMessageActivity : AppCompatActivity() {

    /** Constantes utilizadas por la actividad. */
    companion object {

        /** Etiqueta empleada para identificar en Logcat los eventos del ciclo de vida. */
        const val TAG: String = "LogViewMessageActivity"
    }

    /**
     * Inicializa la interfaz, recupera el mensaje recibido y configura la navegación
     * de vuelta a [SendMessageActivity].
     *
     * @param savedInstanceState estado previamente guardado por Android, o `null` si
     * la actividad se crea por primera vez.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_message)
        val texto = findViewById<TextView>(R.id.view2_text)
        val boton = findViewById<Button>(R.id.btn2)
        val sender = findViewById<TextView>(R.id.text_sender)
        val reciever = findViewById<TextView>(R.id.text_reciever)
        val bundle: Bundle = intent.extras!!
        val message = BundleCompat.getParcelable(
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
