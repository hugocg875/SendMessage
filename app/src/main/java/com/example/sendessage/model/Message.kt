package com.example.sendessage.model

import java.io.Serializable

/**
 * Mensaje intercambiado entre dos personas.
 *
 * <p>El modelo agrupa el texto y sus participantes en un objeto <code>Serializable</code>,
 * de modo que pueda transferirse entre actividades mediante un
 * <code>Bundle</code>.</p>
 *
 * @property id identificador numérico del mensaje.
 * @property content texto escrito por el remitente.
 * @property sender persona que envía el mensaje.
 * @property receiver persona que recibe el mensaje.
 * @see Person
 */
data class Message(
    val id: Int,
    val content: String,
    val sender: Person,
    val receiver: Person
) : Serializable
