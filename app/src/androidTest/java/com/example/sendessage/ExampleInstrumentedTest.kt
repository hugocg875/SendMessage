package com.example.sendessage

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Pruebas instrumentadas que se ejecutan en un dispositivo o emulador Android.
 *
 * <p>Permiten acceder a componentes reales de Android, como el contexto de la
 * aplicación sometida a prueba.</p>
 *
 * @see <a href="https://developer.android.com/training/testing/instrumented-tests">Pruebas instrumentadas</a>
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    /** Verifica que el contexto pertenece al paquete de la aplicación. */
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.sendessage", appContext.packageName)
    }
}
