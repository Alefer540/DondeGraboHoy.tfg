package com.example.dondegrabohoytfg

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.dondegrabohoytfg.databinding.ActivityMainBinding
import com.google.android.gms.common.util.ArrayUtils.contains
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mostrarCiudad: String = ""
    private var mostrarAbiertoCerrado: String = ""
    private var mostrarEspacio: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val email = bundle?.getString("email")
        setup(email ?: "")


        val abiertoCerrado = listOf("--selecciona uno--","Abierto", "Cerrado")
        val listaCiudades = listOf( "Madrid", "Toledo", "Sevilla", "Barcelona")
        val listaEspacioCerrado= listOf("Apartamento","Bar","Chalet","Centro de culto","Discoteca","Hotel","Museo","Restaurante")
        val listaEspacioAbierto= listOf("Azotea","Parque","Parking","Polideportivo/piscina","Jardin")

        val adaptador: ArrayAdapter<String> =
            ArrayAdapter(this, R.layout.spinner_personalizado, listaCiudades)
        binding.spinnerCiudad.adapter = adaptador
        val adaptador2: ArrayAdapter<String> =
            ArrayAdapter(this, R.layout.spinner_personalizado, abiertoCerrado)
        binding.spinnerAbiertoCerrado.adapter = adaptador2
        val adaptador3: ArrayAdapter<String> =
            ArrayAdapter(this, R.layout.spinner_personalizado, listaEspacioAbierto)
        binding.spinnerEspacioAbierto.adapter = adaptador3
        val adaptador4: ArrayAdapter<String> =
            ArrayAdapter(this, R.layout.spinner_personalizado, listaEspacioCerrado)
        binding.spinnerEspacioCerrado.adapter = adaptador4

        binding.spinnerCiudad.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(
                    this@MainActivity,
                    "Seleccione uno para continuar",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onItemSelected(p0: AdapterView<*>, p1: View?, clickado1: Int, p3: Long) {
                Toast.makeText(
                    this@MainActivity,
                    "Has seleccionado: " + listaCiudades[clickado1],
                    Toast.LENGTH_LONG
                ).show()

                if (clickado1 == 0) {
                    //mostar = getSpinnersSelections()
                    mostrarCiudad = "Madrid"
                    binding.tvMostrarseleccion.text = mostrarCiudad
                }
                if (clickado1 == 1) {
                    mostrarCiudad = "Toledo"
                    binding.tvMostrarseleccion.text = mostrarCiudad
                }
                if (clickado1 == 2) {
                    mostrarCiudad = "Sevilla"
                    binding.tvMostrarseleccion.text = mostrarCiudad
                }
                if (clickado1 == 3) {
                    mostrarCiudad = "Barcelona"
                    binding.tvMostrarseleccion.text = mostrarCiudad
                }
            }

        }
        binding.spinnerAbiertoCerrado.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    Toast.makeText(
                        this@MainActivity,
                        "Seleccione uno para continuar",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onItemSelected(p0: AdapterView<*>, p1: View?, clickado: Int, p3: Long
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        "Has seleccionado: " + abiertoCerrado[clickado],
                        Toast.LENGTH_LONG
                    ).show()
                    if (clickado == 0) {
                        binding.spinnerEspacioAbierto.visibility = View.GONE
                        binding.spinnerEspacioCerrado.visibility = View.GONE
                    }

                    if (clickado == 1){
                        mostrarAbiertoCerrado = "Abierto"
                        binding.tvMostrarseleccion1.text = mostrarAbiertoCerrado
                        binding.spinnerEspacioAbierto.visibility = View.VISIBLE
                        binding.spinnerEspacioCerrado.visibility = View.GONE

                    }
                    if (clickado == 2){
                        mostrarAbiertoCerrado = "Cerrado"
                        binding.tvMostrarseleccion1.text = mostrarAbiertoCerrado
                        binding.spinnerEspacioCerrado.visibility = View.VISIBLE
                        binding.spinnerEspacioAbierto.visibility = View.GONE

                    }

                }

            }
        binding.spinnerEspacioAbierto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(
                    this@MainActivity,
                    "Seleccione uno para continuar",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onItemSelected(p0: AdapterView<*>, p1: View?, clickado2: Int, p3: Long) {
                Toast.makeText(
                    this@MainActivity,
                    "Has seleccionado: " + listaEspacioAbierto[clickado2],
                    Toast.LENGTH_LONG
                ).show()
                if (clickado2 == 0) {
                    //mostar = getSpinnersSelections()
                    mostrarEspacio = "Azotea"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }
                if (clickado2 == 1) {
                    mostrarEspacio = "Parque"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }
                if (clickado2 == 2) {
                    mostrarEspacio = "Parking"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }
                if (clickado2 == 3) {
                    mostrarEspacio = "Polideportivo/Piscina"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }
                if (clickado2 == 4) {
                    mostrarEspacio = "Jardin"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }
            }

        }
        binding.spinnerEspacioCerrado.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(
                    this@MainActivity,
                    "Seleccione uno para continuar",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onItemSelected(p0: AdapterView<*>, p1: View?, clickado3: Int, p3: Long) {
                Toast.makeText(
                    this@MainActivity,
                    "Has seleccionado: " + listaEspacioCerrado[clickado3],
                    Toast.LENGTH_LONG
                ).show()
                if (clickado3 == 0) {
                    //mostar = getSpinnersSelections()
                    mostrarEspacio = "Apartamento"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }
                if (clickado3 == 1) {
                    mostrarEspacio = "Bar"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }
                if (clickado3 == 2) {
                    mostrarEspacio = "Chalet"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }
                if (clickado3 == 3) {
                    mostrarEspacio = "Centro de culto"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }
                if (clickado3 == 4) {
                    mostrarEspacio = "Discoteca"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }
                if (clickado3 == 5) {
                    mostrarEspacio = "Hotel"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }
                if (clickado3 == 6) {
                    mostrarEspacio = "Museo"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }
                if (clickado3 == 7) {
                    mostrarEspacio = "Restaurante"
                    binding.tvMostrarseleccion2.text = mostrarEspacio
                }



            }


        }
        binding.botonBuscar.setOnClickListener{
            showMainActivity()
        }
    }



    private fun showMainActivity (){

        val mainIntent=Intent(this,BusquedaActivity::class.java)

        startActivity(mainIntent)

    }
    private fun setup(email:String){

        binding.tvNombreTextView.text=email
    }


}








