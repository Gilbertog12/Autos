package com.example.android.carros;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistrarAuto extends AppCompatActivity {

    private EditText Placa,Precio;
    private Resources res;
    private Spinner Marca;
    private  Spinner Modelo;
    private  Spinner Color;
    private  String [] Marcas;
    private  String [] Modelos;
    private  String [] Colores;
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_auto);
        Placa = (EditText)findViewById(R.id.txtPlaca);
        Precio = (EditText)findViewById(R.id.txtPrecio);
        Marca = (Spinner)findViewById(R.id.cmbMarca);
        Modelo = (Spinner)findViewById(R.id.cmbModelo);
        Color = (Spinner)findViewById(R.id.cmbColor);
        res = this.getResources();


        fotos = new ArrayList<>();
        fotos.add(R.drawable.imagen1);
        fotos.add(R.drawable.imagen2);
        fotos.add(R.drawable.imagen3);
        fotos.add(R.drawable.imagen4);

        Marcas =res.getStringArray(R.array.Marcas);
        ArrayAdapter<String>adapter1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Marcas);
        Marca.setAdapter(adapter1);

        Modelos =res.getStringArray(R.array.Modelos);
        ArrayAdapter<String>Adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Modelos);
        Modelo.setAdapter(Adapter);

        Colores =res.getStringArray(R.array.Colores);
        ArrayAdapter<String>adapter2=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Colores);
        Color.setAdapter(adapter2);}




    public void guardar(View v){
        String Plac,Preci;
        int Marc;
        int Model;
        int Colo;
        Plac = Placa.getText().toString();
        Marc = Marca.getSelectedItemPosition();
        Model = Modelo.getSelectedItemPosition();
        Colo = Color.getSelectedItemPosition();
        Preci = Precio.getText().toString();
        Auto p = new Auto(Metodos.fotoAleatoria(fotos),Plac,Marc,Model,Colo,Preci);
        p.guardar();





        Toast.makeText(this,res.getString(R.string.mensaje_guardado),Toast.LENGTH_SHORT).show();

    }
    public void limpiar(View v){
        limpiar();
    }

    private void limpiar(){
        Placa.setText("");
        Modelo.setSelection(0);
        Marca.setSelection(0);

        Color.setSelection(0);
        Precio.setText("");
    }



    }

