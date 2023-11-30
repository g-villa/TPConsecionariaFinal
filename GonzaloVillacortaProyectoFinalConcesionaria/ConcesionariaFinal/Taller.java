package ConcesionariaFinal;
import java.util.*;
import java.io.*;

public class Taller implements MaxCapacidad, Serializable {
    // implementa metodo de interfaz contratada MaxCapacidad
    //@Override
    public int maximaCapacidad() {
        return MaxCapacidad.maximaCapacidad;
    }   
    private LinkedList<VehiculoBase> colaDeEsperaEnTaller;
    //constructor inicializa cola de espera en taller
    public Taller() {
        colaDeEsperaEnTaller = new LinkedList<>();
    }
    // controla si queda lugar disponible en taller
    public boolean quedaLugarDisponible(){
        if (colaDeEsperaEnTaller.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    // muestra la cola de espera en taller
    public void muestraColaDeTaller() {       
        if (colaDeEsperaEnTaller.isEmpty()) {
            System.out.println("***En estos momentos el taller esta completamente vacio!!!. Intente mas tarde!!!");
        } else {
            for (VehiculoBase vehiculo : colaDeEsperaEnTaller) {
            System.out.println(vehiculo);
        }
        }
    }
    // ingresa vehiculo a taller
    public void ingresoTaller (VehiculoBase vehiculo) {
        if (colaDeEsperaEnTaller.size() < maximaCapacidad) {
            colaDeEsperaEnTaller.offer(vehiculo);
            System.out.println("***Se ha ingresado satisfactoriamente el siguiente vehiculo al Taller:\n" + vehiculo);

        } else {
            System.out.println("***No se puede ingresar!! Espera a que se vacie y vuelva a intentarlo mas tarde!!!");
        }
    }
    // saca vehiculo de taller 
    public VehiculoBase saleTaller () {
        if (!colaDeEsperaEnTaller.isEmpty()) {
            VehiculoBase vehiculoSaliente = colaDeEsperaEnTaller.poll();
            System.out.println("***El siguiente vehículo se encuentra saliendo del taller: " + vehiculoSaliente);
            vehiculoSaliente.setNecesitaMantenimiento(true);
            return vehiculoSaliente;
        } else {
            System.out.println("***En estos momentos el taller esta completamente vacio!!!. Intente mas tarde!!!");
            return null;
        }

    }

}
