/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.menulogyari;

import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class Menu {
    Scanner entrada = new Scanner (System.in);

    int opc;
    public void Inicio(){
        do{
            System.out.println("");
            System.out.println("MENU\n1.-Aritmética\n2.-Lógica\n3.-Separación\n4.-Salir");
            opc=entrada.nextInt();
        switch (opc){
                case 1:
                    new ExpresionAritmetica();
                    //new CodigoParaLeer();
                    break;
                case 2:
                    new ExpresionLogica();
                    break;                           
                case 3:
                    new SeparacionDeLeYNum();
                    break;
                case 4:
                    System.out.println("Hasta luego!!");
                    break;
                default:
                    System.out.println("Opción no valida!!");
            break;
            }    
        }while(opc!=4);
    }
}
