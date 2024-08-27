package com.example.cdv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cdv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        amb.abraBt.setOnClickListener {
            val anotherIntent: Intent = Intent(this, AnotherActivity::class.java).also{
                startActivity(it)
            }
        }

        Log.v(getString(R.string.app_name), "onCreate: Iniciando ciclo de vida completo.") //Inicia
        }

    override fun onStart() {
        super.onStart()
        Log.v(getString(R.string.app_name), "onStart: Iniciando ciclo de vida visível.") //Inicia
    }

    override fun onResume() {
        super.onResume()
        Log.v(getString(R.string.app_name), "onResume: Iniciando ciclo de vida primeiro plano.") //Inicia
    }

    override fun onPause() {
        super.onPause()
        Log.v(getString(R.string.app_name), "onPause: Finalizando ciclo de vida primeiro plano.") //Encerra onResume, sai do executando e entra no estado pausada.
    }

    override fun onStop() {
        super.onStop()
        Log.v(getString(R.string.app_name), "onStop: Finalizando ciclo de vida visível.") //Entra no estado parada.
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(getString(R.string.app_name), "onDestroy: Finalizando ciclo de vida completo.")//Libera memória da Activity.
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(getString(R.string.app_name), "onRestart: Preparando o onStart.")
    }
}
