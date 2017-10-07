package com.example.android.carros;

import java.util.ArrayList;

/**
 * Created by android on 07/10/2017.
 */

public class Datos {
    private static ArrayList<Auto> Autos = new ArrayList();

    public static void guardarAuto(Auto p){
        Autos.add(p);
    }

    public static ArrayList<Auto> obtenerAutos(){
        return Autos;
    }

}
