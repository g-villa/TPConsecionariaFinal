package ConcesionariaFinal;
import java.util.*;
import java.io.*;

class Concesionaria <T extends VehiculoBase> implements Serializable {
    private Taller taller;
    // almacena vehiculos en stock
    private LinkedList<T> stock;
    // inicializa lista de stock 
    public Concesionaria() {
        stock = new LinkedList<>();
    }
    // agrega un vehiculo a stock
    public void ingresaVehiculo(T vehiculo) {
        stock.add(vehiculo);
    }
    // elimina un vehiculo de stock
     public boolean borraVehiculo(int id) {
        for (T vehiculo : stock) {
            if (vehiculo.getId()== id) {
                stock.remove(vehiculo);
                return true;
            }
        }
        return false;
    }
    // obtiene tamaño del stock
    public int tamañoStock() {
        return stock.size();
    }
    // verifica si un vehículo esta en stock
    public boolean hayVehiculos (T vehiculo) {
        return stock.contains(vehiculo);
    }
    //muestra todos los vehiculos que hay en el stock
    public void muestraStock() {
        if(tamañoStock()!=0){
            for (T vehiculo : stock) {
                System.out.println(vehiculo);
            }
        }else{
            System.out.println("**El Stock de la Concesionaria, se encuentra completamente vacio!!!");
        }
    }
    // obtiene vehiculo de stock por indice en la lista
    public T obtenerVehiculo(int indice) {
        for (T Vehiculo : stock){
            if (Vehiculo.getId() == indice){
                return Vehiculo;
            }
        }
        return null;//si no lo encuentra
    }
    public void faltaMantenimiento(){
        for (T Vehiculo : stock){
            if (Vehiculo.getNecesitaMantenimiento() == false){
                System.out.println(Vehiculo);
            }
        }
    }
    // ordena vehiculos en el stock por su id
    public void ordenarID(){
        Collections.sort(stock, Comparator.comparingInt(VehiculoBase::getId));
    }
    
}
