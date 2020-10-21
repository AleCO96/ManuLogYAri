/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.menulogyari;

/**
 *
 * @author aleja
 */
public class ExpresionLogica {

    String[] p = {"v", "v", "f", "f"};
    String[] q = {"v", "f", "v", "f"};

    //char p[] = new char[4];
    //char q[] = new char[4];

    public ExpresionLogica() {
        System.out.println("[(p->q)^p]->q");
        Resolucion();
    }

    private void Resolucion() {
        String aux[];
        OperacionesLogicas ol=new OperacionesLogicas();
        /*for(int i=0;i<p.length;i++){
            System.out.println("p en pos: "+i+": "+p[i]);
        }
        for(int i=0;i<q.length;i++){
            System.out.println("q en pos: "+i+": "+q[i]);
        }*/
        
        aux=ol.Condicionalidad(p,q);
        /*for(int i=0;i<aux.length;i++){
            System.out.println("Condicionalidad 1: "+aux[i]);
        }*/
        
        aux=ol.Conjuncion(aux,p);
        //p=ol.Negación(p);
        /*for(int i=0;i<aux.length;i++){
            System.out.println("Conjunción 1: "+aux[i]);
        }*/
        
        aux=ol.Condicionalidad(aux,q);
        for(int i=0;i<aux.length;i++){
            System.out.println("Resultado: "+aux[i]);
        }
    }
}
