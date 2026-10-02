package com.example.sendessage

import android.app.Application

/**
 * Ejemplo de clase en kotlin.
 *
 * <p>Android crea una única instancia de esta clase antes de iniciar cualquiera
 * de las actividades de la aplicación. Puede utilizarse para mantener estado o
 * servicios compartidos durante todo el ciclo de vida del proceso.</p>
 *
 * @see Application
 */
class SendMessageAplication : Application() {

    /**
     * Valor de ejemplo disponible de forma global durante la ejecución de la aplicación.
     */
    val numero = 1
}

