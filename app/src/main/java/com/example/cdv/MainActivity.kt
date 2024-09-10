package com.example.cdv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cdv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    companion object{
        const val VALOR_TELEFONE_UM = "VALOR_TELEFONE_UM"
        const val VALOR_TELEFONE_DOIS = "VALOR_TELEFONE_DOIS"
    }

    private val telefoneDoisEt: EditText by lazy{
        EditText(this)
    }

    //onCreate pode receber um Bundle (parametro) nulo, exceto se o onSave for chamado anteriormente!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        telefoneDoisEt.hint = "Segundo telefone"
        telefoneDoisEt.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        amb.root.addView(telefoneDoisEt)

        //Assim, não precisa do onRestore separado.
        savedInstanceState?.apply {
            getString(VALOR_TELEFONE_UM)?.let {
                amb.telefoneUmEt.setText(it)
            }
            getString(VALOR_TELEFONE_DOIS, "00000000").let {
                telefoneDoisEt.setText(it)
            }
        }
        Log.v((getString(R.string.app_name)), "onRestoreInstanceState: Restaurando dados de instância.")

        amb.abraBt.setOnClickListener {
            val anotherIntent: Intent = Intent(this, AnotherActivity::class.java).also{
                startActivity(it)
            }
        }

        Log.v(getString(R.string.app_name), "onCreate: Iniciando ciclo de vida completo.") //Inicia
        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(VALOR_TELEFONE_UM, amb.telefoneUmEt.text.toString())
        outState.putString(VALOR_TELEFONE_DOIS, telefoneDoisEt.text.toString())
        Log.v((getString(R.string.app_name)), "onSaveInstanceState: Salvando dados de instância.")
    }

    //onRestore NÃO pode receber um Bundle (parametro) nulo!
    /*override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.apply {
            getString(VALOR_TELEFONE_UM)?.let {
                amb.telefoneUmEt.setText(it)
            }
            getString(VALOR_TELEFONE_DOIS, "00000000").let {
                telefoneDoisEt.setText(it)
            }
        }
        Log.v((getString(R.string.app_name)), "onRestoreInstanceState: Restaurando dados de instância.")
    }*/

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
