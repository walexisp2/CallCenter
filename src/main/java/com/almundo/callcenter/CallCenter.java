/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter;

import domain.Llamada;
import domain.Operador;
import services.Dispatcher;
import services.GenerarLlamada;

/**
 *
 * @author Asus
 */
public class CallCenter {
    
    public static void main(String[] args)
    {
        /*for ( int i = 0; i < 3; i++ )
        {
            new Operador( i + 1 ).start();
        }*/

        //new Dispatcher().start();
        new GenerarLlamada().start();
        new Dispatcher().dispatchCall();
    }
    
}
