
package utils;

import java.util.concurrent.ThreadLocalRandom;


public class Asignacion {
    
    String[] nombreOperador;
    String[] nombreSupervisor;
    String[] nombreDirector;
    
    public Asignacion()
    {
        nombreOperador = new String[]{"Ope. Alex", "Ope. Juan", "Ope. Carlos", "Ope. Carolina",
        "Ope. Catalina", "Ope. Isabel","Ope. Luis","Ope. Cristian", "Ope. Sofia"};
        
        nombreSupervisor = new String[]{"Sup. Hernan", "Sup. Reinal", "Sup. Marisol", "Sup. Carolina"};
        
        nombreDirector = new String[]{"Dir. George", "Dir. Raul", "Dir. Mariana"};
    }
    
    
    
    public enum Cargos
    {
        OPERADOR,
        SUPERVISOR,
        DIRECTOR
    }
    
    public enum EstadoEmpleado
    {
        OCUPADO,
        LIBRE
    }
    
    public long getDuracionLlamada(int inicio, int fin)
    {
        long callDuration;
        return  callDuration = ThreadLocalRandom.current().nextLong(inicio, fin);
    }
    
    
    public String generarNombre(Cargos cargo, int id)
    {
        String nombre = "no valido";
        switch(cargo)
        {
            case OPERADOR:
                if (id< nombreOperador.length) {
                    
                    nombre = nombreOperador[id].toString();
                    
                }
                break;
            case SUPERVISOR:
                if (id< nombreSupervisor.length) {
                    
                    nombre = nombreSupervisor[id].toString();
                    
                }
                break;
                
                case DIRECTOR:
                if (id< nombreDirector.length) {
                    
                    nombre = nombreDirector[id].toString();
                    
                }
                break;
            
        }
        
        return nombre;
    }
    
}
