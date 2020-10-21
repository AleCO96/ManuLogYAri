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
public class OperacionesAritmeticas {
    double res;
    public double Suma(double a, double b){
        res=a+b;
        return res;
    }
    public double Resta(double a, double b){
        res=a-b;
        return res;
    }
    public double Multi(double a, double b){
        res= a*b;
        return res;
    }
    public double Div(double a, double b){
        res= a/b;
        return res;
    }
    public double Pow(double a, double b){
        res=Math.pow(a, b);
        return res;
    }
}
