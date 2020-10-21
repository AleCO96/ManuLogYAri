/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.menulogyari;

import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class SeparacionDeLeYNum {

    public SeparacionDeLeYNum() {
        Separar("23efgy789olkjuy6543w");
    }

    private void Separar(String oracion) {
        System.out.println("La cadena original es: " + oracion);
        String separador = "(?=[abcdefghijklmnñopqrstuvwxyz1234567890])";
        String arreglo[] = oracion.split(separador);
        Clasificador(arreglo);
    }

    private void Clasificador(String[] arreglo) {

        ArrayList<String> cadenaNumeros = new ArrayList<>();
        ArrayList<String> cadenaLetras = new ArrayList<>();
        int letras = 0, numeros = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (isNumeric(arreglo[i])) {
                cadenaNumeros.add(arreglo[i]);
                numeros++;
            } else {
                cadenaLetras.add(arreglo[i]);
                letras++;
            }
        }
        System.out.println("Números: " + cadenaNumeros);
        System.out.println("Hay " + numeros + " Numeros");
        System.out.println("Letras: " + cadenaLetras);
        System.out.println("Hay " + letras + " Letras");
    }

    private boolean isNumeric(String string) {
        try {
            double d = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
