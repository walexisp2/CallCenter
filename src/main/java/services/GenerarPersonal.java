/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class GenerarPersonal implements Runnable{
    
    public boolean ejecucion;
    
    private long ExpiracionLlamada;
    

    private SimpleDateFormat formato;
    
    public GenerarPersonal()
    {
        formato = new SimpleDateFormat( "HH:mm:ss" );
    }

    @Override
    public void run() {
        
        
        
    }
    
    public void start()
    {
        
        ejecucion = true;
        
        new Thread(this).start();
        
    }
    
    public void stop()
    {
        
        ejecucion = false;
        
    }
    
    private void log( String s )
    {
        //System.out.println( "[" + formato.format( new Date() ) + "][Empleado][Agente " + getNombre() + "] " + s );
    }
    
}
