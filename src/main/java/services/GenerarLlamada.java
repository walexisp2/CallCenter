
package services;

import java.text.SimpleDateFormat;
import java.util.Date;
import utils.Asignacion;


public class GenerarLlamada implements Runnable{
    
    private boolean ejecucion;
    
    private Asignacion aleatorio;
    private SimpleDateFormat formato;
    
    public GenerarLlamada()
    {
        aleatorio = new Asignacion();
        formato = new SimpleDateFormat( "HH:mm:ss" );
    }
    
    @Override
    public void run()
    {
        while (ejecucion)
        {
            long duracion = aleatorio.getDuracionLlamada(3, 5);
            if ( duracion > 1 )
            {
                log( "Creando una llamada con una duracion de " + duracion + " segundos" );
                LlamadaCola.colaLlamada(duracion);
                
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
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
        System.out.println( "[" + formato.format( new Date() ) + "][Generando Llamada] " + s );
    }
    
}
