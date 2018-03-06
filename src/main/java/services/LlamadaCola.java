
package services;

import domain.Llamada;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;


public class LlamadaCola {
    
    private static LlamadaCola instancia;

    private int contador;

    private SimpleDateFormat formato;

    private LinkedBlockingQueue<Llamada> cola;


    private LlamadaCola()
    {
        this.cola = new LinkedBlockingQueue<Llamada>();
        this.contador = 1;
        this.formato = new SimpleDateFormat( "HH:mm:ss" );
    }

    public static void colaLlamada( long duracion )
    {
        try
        {
            Llamada llamada = new Llamada( getInstancia().contador++, duracion );
            log( "Llamada en cola " + llamada.getNumero() + " con una duracion de " + llamada.getDuracion() + " segundos" );
            getInstancia().cola.put( llamada );
        }
        catch (InterruptedException e)
        {
            log( "Error en llamada en cola" );
        }
    }

    public static Llamada recuperarLlamada()
    {
        Llamada llamada = getInstancia().cola.poll();
        if ( llamada != null )
        {
            log( "Recuperando llamada " + llamada.getNumero() );
        }
        return llamada;
    }

    private static LlamadaCola getInstancia()
    {
        if ( instancia == null )
        {
            instancia = new LlamadaCola();
        }
        return instancia;
    }

    private static void log( String s )
    {
        System.out.println( "[" + getInstancia().formato.format( new Date() ) + "][LogColaLlamada] " + s );
    }


    
}
