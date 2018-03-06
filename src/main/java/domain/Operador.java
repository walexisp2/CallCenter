/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import services.LlamadaCola;
import utils.Asignacion;

/**
 *
 * @author Asus
 */
public class Operador extends Empleado implements Runnable{
    
    public boolean ejecucion;
    
    private long ExpiracionLlamada;
    

    private SimpleDateFormat formato;
    
    public Operador(int codigo,String nombre,Asignacion.EstadoEmpleado estado, Asignacion.Cargos cargo)
    {
        super(codigo,nombre,estado,cargo);
        formato = new SimpleDateFormat( "HH:mm:ss" );
    }
    
    public Operador(int codigo,String nombre,Asignacion.Cargos cargo)
    {
        super(codigo,nombre,cargo);
        formato = new SimpleDateFormat( "HH:mm:ss" );
    }
    
    public Operador(int id)
    {
        super(id);
        setEstado(Asignacion.EstadoEmpleado.LIBRE);
        formato = new SimpleDateFormat( "HH:mm:ss" );
    }
    
    
    @Override
    public void run()
    {
        while(ejecucion)
        {
            if(getEstado() == Asignacion.EstadoEmpleado.LIBRE)
            {
                Llamada llamada = LlamadaCola.recuperarLlamada();
                //Llamada llamada = getLlamada();
                if ( llamada != null )
                {
                    log( "Respondiendo Llamadas " + llamada.getNumero());
                    //ExpiracionLlamada = System.currentTimeMillis() + ( llamada.getDuracion() * 60 * 1000 );
                    ExpiracionLlamada = llamada.getDuracion();
                    
                    setEstado(Asignacion.EstadoEmpleado.OCUPADO);
                }
            }
            else
            {
                if ( System.currentTimeMillis() > ExpiracionLlamada )
                {
                    log( "Colgando" );
                    //status = ServiceAgentStatus.FREE;
                    setEstado(Asignacion.EstadoEmpleado.LIBRE);
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                    
                   
            
        }
        
    }
    
    /*@Override
    public void getLlamada()
    {
        setEstado(Asignacion.EstadoEmpleado.OCUPADO);
        
        Llamada llamada = LlamadaCola.recuperarLlamada();
        System.out.println("El Operador: " + getNombre() + " recibe la llamada");
    }*/
    
    @Override 
    public Llamada getLlamada()
    {
        return LlamadaCola.recuperarLlamada();
    }
        
    public void start()
    {
        ejecucion = true;
        new Thread( this ).start();
    }

    public void stop()
    {
        ejecucion = false;
    }

    private void log( String s )
    {
        System.out.println( "[" + formato.format( new Date() ) + "][Empleado][Agente " + getNombre() + "] " + s );
    }
    
}
