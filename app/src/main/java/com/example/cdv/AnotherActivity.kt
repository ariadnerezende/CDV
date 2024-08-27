package com.example.cdv

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AnotherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
        Log.v(getString(R.string.app_name), "onCreate-A: Iniciando ciclo de vida completo.") //Inicia
    }

    override fun onStart() {
        super.onStart()
        Log.v(getString(R.string.app_name), "onStart-A: Iniciando ciclo de vida visível.") //Inicia
    }

    override fun onResume() {
        super.onResume()
        Log.v(getString(R.string.app_name), "onResume-A: Iniciando ciclo de vida primeiro plano.") //Inicia
    }

    override fun onPause() {
        super.onPause()
        Log.v(getString(R.string.app_name), "onPause-A: Finalizando ciclo de vida primeiro plano.") //Encerra onResume, sai do executando e entra no estado pausada.
    }

    override fun onStop() {
        super.onStop()
        Log.v(getString(R.string.app_name), "onStop-A: Finalizando ciclo de vida visível.") //Entra no estado parada.
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(getString(R.string.app_name), "onDestroy-A: Finalizando ciclo de vida completo.")//Libera memória da Activity.
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(getString(R.string.app_name), "onRestart-A: Preparando o onStart.")
    }
}