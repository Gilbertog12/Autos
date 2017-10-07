package com.example.android.carros;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class LIstado_Listview extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Auto> autos;
    private Context contexto;
    private adaptadorAuto adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado__listview);

        lista =(ListView)findViewById(R.id.lstListadoAutos);
        contexto = this.getApplicationContext();
        autos = Datos.obtenerAutos();
        adapter = new adaptadorAuto(contexto,autos);
        lista.setAdapter(adapter);
    }

}
