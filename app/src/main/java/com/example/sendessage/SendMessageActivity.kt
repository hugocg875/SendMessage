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
 * Pantalla principal desde la que el usuario redacta y envía un mensaje.
 *
 * <p>Esta actividad muestra el flujo básico para navegar entre pantallas y
 * transferir datos introducidos por el usuario:</p>
 *
 * <ol>
 *     <li>Obtiene las referencias al campo de texto y al botón definidos en XML.</li>
 *     <li>Escucha la pulsación del botón de envío.</li>
 *     <li>Crea un <code>Message</code> con el contenido escrito.</li>
 *     <li>Incluye el objeto mensaje serializado en un <code>Bundle</code>.</li>
 *     <li>Abre <code>RecieveMessageActivity</code> para mostrarlo.</li>
 * </ol>
 *
 * @author Hugo de Cristobal Gomez
 * @version 1.0
 * @see Message
 * @see RecieveMessageActivity
 */
class SendMessageActivity : AppCompatActivity() {

    /** Campo en el que el usuario escribe el contenido que desea enviar. */
    lateinit var mensaje: EditText

    /** Botón que inicia el envío del mensaje. */
    lateinit var boton: Button

    /** Constantes utilizadas por la actividad. */
    companion object {

        /** Etiqueta empleada para identificar en Logcat los eventos del ciclo de vida. */
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
     * Construye y envía el mensaje escrito a la pantalla de recepción.
     *
     * <p>El objeto <code>Message</code>, junto con sus datos de remitente y destinatario, se
     * serializa bajo la clave <code>KEY_MESSAGE</code>. La actividad receptora usa
     * esa misma clave para recuperarlo.</p>
     */
    private fun sendMessage() {
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
