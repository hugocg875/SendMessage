package com.example.sendessage.model

import java.io.Serializable

/**
 * Datos identificativos de una persona que participa en el envío de un mensaje.
 *
 * <p>Implementa <code>Serializable</code> para poder viajar dentro del <code>Bundle</code>
 * utilizado por las actividades de la aplicación.</p>
 *
 * @property dni documento de identidad de la persona.
 * @property name nombre de la persona.
 * @property surname apellidos de la persona.
 * @see Message
 */
data class Person(
    val dni: String,
    val name: String,
    val surname: String
) : Serializable
