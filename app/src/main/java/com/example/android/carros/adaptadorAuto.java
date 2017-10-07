package com.example.android.carros;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 07/10/2017.
 */

public class adaptadorAuto extends BaseAdapter{
    private Context contexto;
    private ArrayList<Auto> autos;
    private Resources res;
    private String[]Marca1,Model1;

    public adaptadorAuto(Context contexto, ArrayList<Auto> autos) {
        this.contexto = contexto;
        this.autos = autos;
        res = contexto.getResources();
        Marca1 = res.getStringArray(R.array.Marcas);
        Model1 = res.getStringArray(R.array.Modelos);

    }

    @Override
    public int getCount() {
        return autos.size();
    }

    @Override
    public Object getItem(int i) {
        return autos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Definición de las variables a utilizar
        res = contexto.getResources();
        View v = view;

        //Crear el objeto LayoutInflater para modificar la vista
        LayoutInflater inf = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inf.inflate(R.layout.item_autos,null);

        //Creamos un objeto Persona
        Auto p = autos.get(i);

        //Capturar elemento de la vista
        ImageView foto = (ImageView)v.findViewById(R.id.imgFoto);
        TextView Placa = (TextView) v.findViewById(R.id.lblPlaca);
        TextView Marca = (TextView)v.findViewById(R.id.lblMarca);
        TextView Modelo = (TextView)v.findViewById(R.id.lblModelo);
        TextView Precio = (TextView)v.findViewById(R.id.lblPrecio);

        //Setear elementos a la vista

        //foto.setImageDrawable(res.getDrawable(p.getFoto()));
        foto.setImageDrawable(ResourcesCompat.getDrawable(res,p.getFoto(),null));
        Placa.setText(p.getPlaca());
        Marca.setText(Marca1[p.getMarca()]);
        Modelo.setText(Model1[p.getModelo()]);
        Precio.setText(p.getPrecio());

        return v;
    }
}
