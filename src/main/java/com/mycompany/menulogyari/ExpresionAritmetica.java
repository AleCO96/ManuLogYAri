/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.menulogyari;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author aleja
 */
public class ExpresionAritmetica {

    Stack pilaOperaciones = new Stack();
    Stack pilaFinal = new Stack();
    List cadena = new ArrayList();

    public ExpresionAritmetica() {
        separar("(6+2)*3/2^2-4"); //infija
    }

    private void separar(String operacion) {
        System.out.println("Operación Infija: " + operacion);
        String simbolos = "(?=[-+*/^()])|(?<=[-+*/^()])";
        String[] arreglo = operacion.split(simbolos);
        SeparaExpresion(arreglo);
    }

    private void SeparaExpresion(String[] arreglo) {
        String cadena2 = "";
        //Recorre el arreglo que hicimos con split
        for (int i = 0; i < arreglo.length; i++) {
            //necesitamos saber si el String es un número
            if (isNumeric(arreglo[i])) {
                //insertar a la pila numérica
                cadena.add(arreglo[i]);
                if (i == arreglo.length - 1) {
                    while (!pilaOperaciones.empty()) {
                        cadena.add(pilaOperaciones.peek());
                        pilaOperaciones.pop();
                    }
                }
            } else {
                //insertar a la pila Operaciones
                int prioridad = prioridad(arreglo[i]);
                switch (prioridad) {
                    case 0:
                        if (!pilaOperaciones.empty()) {
                            int prioridadPila = prioridad((String) pilaOperaciones.peek());
                            if (prioridadPila == prioridad) {
                                cadena.add(pilaOperaciones.peek());
                                pilaOperaciones.pop();
                            } else if (prioridadPila > prioridad) {
                                while (!pilaOperaciones.empty()) {
                                    cadena.add(pilaOperaciones.peek());
                                    pilaOperaciones.pop();
                                }
                            }
                        }
                        pilaOperaciones.push(arreglo[i]);
                        break;
                    case 1:
                        if (!pilaOperaciones.empty()) {
                            int prioridadPila = prioridad((String) pilaOperaciones.peek());
                            if (prioridadPila == prioridad) {
                                cadena.add(pilaOperaciones.peek());
                                pilaOperaciones.pop();
                            } else if (prioridadPila < prioridad) {
                                while (!pilaOperaciones.empty()) {
                                    cadena.add(pilaOperaciones.peek());
                                    pilaOperaciones.pop();
                                }
                            }
                        }
                        pilaOperaciones.push(arreglo[i]);
                        break;
                    case 2:
                        pilaOperaciones.push(arreglo[i]);
                        break;
                    case 3:
                        while (!pilaOperaciones.empty()) {
                            cadena.add(pilaOperaciones.peek());
                            pilaOperaciones.pop();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        for (int i = 0; i < cadena.size(); i++) {
            cadena2 = cadena2 + ((String) cadena.get(i));
        }
        System.out.println("Esta es la Cadena: " + cadena2);
        combierteeInsertaenPila(cadena);
    }

    private void combierteeInsertaenPila(List cadena) {
        for (int i = 0; i < cadena.size(); i++) {
            //Esta línea es para saber de qué tipo es el dato
            //System.out.println(cadena.get(i)+ " es de tipo: " +  ((Object)cadena.get(i)).getClass().getSimpleName());
            try {
                int numero = Integer.parseInt((String) cadena.get(i));
                pilaFinal.push(numero);
                //System.out.println("Numero en pila: "+pilaFinal.peek());
            } catch (NumberFormatException e) {
                pilaFinal.push(cadena.get(i));
                //System.out.println("String en pila: "+pilaFinal.peek());		
            }
        }
        realizaOperaciones();
    }

    private void realizaOperaciones() {
        OperacionesAritmeticas oa = new OperacionesAritmeticas();
        double a, b;
        for (int i = 0; i < cadena.size(); i++) {
            if (isNumeric((String) cadena.get(i))) {
                pilaFinal.push(cadena.get(i));
            } else {
                b = Double.parseDouble(pilaFinal.pop().toString());
                a = Double.parseDouble(pilaFinal.pop().toString());
                if ("+".equals((String) cadena.get(i))) {
                    pilaFinal.push(oa.Suma(a, b));
                }
                if ("-".equals((String) cadena.get(i))) {
                    pilaFinal.push(oa.Resta(a, b));
                }
                if ("*".equals((String) cadena.get(i))) {
                    pilaFinal.push(oa.Multi(a, b));
                }
                if ("/".equals((String) cadena.get(i))) {
                    pilaFinal.push(oa.Div(a, b));
                }
                if ("^".equals((String) cadena.get(i))) {
                    pilaFinal.push(oa.Pow(a, b));
                }
            }
        }
        System.out.println("Resultado: " + pilaFinal.pop());
    }

    //Solamente prioridad de símboloes
    private int prioridad(String arreglo) {
        if (arreglo.equals("+") || arreglo.equals("-")) {
            return 0;
        } else if (arreglo.equals("*") || arreglo.equals("/")) {
            return 1;
        } else if (arreglo.equals("^")) {
            return 2;
        } else if (arreglo.equals(")")) {
            return 3;
        }
        return -1;
    } //Fin de la funcion prioridad

    private boolean isNumeric(String string) {
        try {
            double d = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
