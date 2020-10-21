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
public class OperacionesLogicas {

    String res[] = new String[4];

    public String[] Conjuncion(String[] p, String[] q) {
        for (int i = 0; i < p.length; i++) {
            if ("v".equals(p[i]) & "v".equals(q[i])) {
                res[i] = "v";
            }
            if ("v".equals(p[i]) & "f".equals(q[i])) {
                res[i] = "f";
            }
            if ("f".equals(p[i]) & "v".equals(q[i])) {
                res[i] = "f";
            }
            if ("f".equals(p[i]) & "f".equals(q[i])) {
                res[i] = "f";
            }
        }
        return res;
    }

    public String[] Condicionalidad(String[] p, String[] q) {
        for (int i = 0; i < p.length; i++) {
            if ("v".equals(p[i]) & "v".equals(q[i])) {
                res[i] = "v";
            }
            if ("v".equals(p[i]) & "f".equals(q[i])) {
                res[i] = "f";
            }
            if ("f".equals(p[i]) & "v".equals(q[i])) {
                res[i] = "v";
            }
            if ("f".equals(p[i]) & "f".equals(q[i])) {
                res[i] = "v";
            }
        }
        return res;
    }

    /*public String[] Negación(String[] a) {
        for (int i = 0; i < a.length; i++) {
            if ("v".equals(a[i])) {
                res[i] = "f";
            }
            if ("f".equals(a[i])) {
                res[i] = "v";
            }
        }
        return res;
    }*/
}
