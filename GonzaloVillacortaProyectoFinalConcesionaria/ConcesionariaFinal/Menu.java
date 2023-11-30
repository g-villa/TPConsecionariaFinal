package ConcesionariaFinal;
import java.util.*;
import java.io.*;

public class Menu {
    public static void main(String[] args){
        Concesionaria stock = cargaArchivoDeConcesionaria();
        Integer devuelveUltimoId = cargaElUltimoId();
        VehiculoBase.setCuentaId(devuelveUltimoId);
        Taller taller = cargaArchivoDeTaller();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("*********************************************************************************************");
        System.out.println("*****************************************BIENVENIDOS*****************************************");
        System.out.println("************************************ A LA CONCESIONARIA**************************************");
        System.out.println("***********************************DE GONZALO J. VILLACORTA**********************************");
        System.out.println("*********************************************************************************************");
    

        while (true) {
            
            System.out.println("\n*** Por favor, a continuacion seleccione alguna de las opciones ");
            System.out.println("*Opc. 1 || Ingresa un Vehículo\n*Opc. 2 || Elimina un Vehiculo\n*Opc. 3 || Muestra Stock Actualizado\n*Opc. 4 || Ingresa al Menu del Taller\n*Opc. 5 || Salir del Programa");
            System.out.println("*********************************************************************************************");
            System.out.print("==>  ");
            int seleccion = scan.nextInt();

            switch (seleccion) {
                case 1: //opcion para ingreso de vehiculos
                    System.out.println("*** Excelente!!!, ha seleccionado ingresar un vehiculo, por favor seleccione de que tipo:");
                    System.out.println("1 || Automovil\n2 || Camioneta\n3 || Motocicleta ");
                    System.out.print("==>  ");
                    int tipo = scan.nextInt();

                    if (tipo == 1) {
                        // Ingresa automovil
                        Automovil auto = Automovil.crearAuto(); 
                        stock.ingresaVehiculo(auto);
                        System.out.println("*** El automovil fue ingresado a la Concesionaria Exitosamente!!!");
                    } else if (tipo == 2) {
                        // Ingresa camioneta
                        Camioneta camioneta = Camioneta.crearCamioneta(); 
                        stock.ingresaVehiculo(camioneta);
                        System.out.println("*** El automovil fue ingresado a la Concesionaria Exitosamente!!!");
                    } else if (tipo == 3) {
                        // Ingresa moto
                        Motocicleta moto = Motocicleta.crearMotocicleta(); 
                        stock.ingresaVehiculo(moto);
                        System.out.println("*** El automovil fue ingresado a la Concesionaria Exitosamente!!!");
                    } else {
                        System.out.println("*** Ha ingresado una opcion no valida!!");
                    }

                    break;

                case 2://opcion para eliminacion de vehiculos
                    System.out.print("*** Excelente!!!, ha seleccionado eliminar un vehiculo, por favor ingrese el ID del mismo: ");
                    int eliminaId = scan.nextInt();
                    boolean haSidoEliminado = stock.borraVehiculo(eliminaId);
                    if (!haSidoEliminado) {
                        System.out.println("*** Lamentablemente no se ha hayado el ID indicado");
                    }else{
                        System.out.println("*** El vehiculo seleccionado ha sido eleminado con exito!!!");
                    }
                    break;

                case 3:// opcion para ver stock de la concesionaria
                    System.out.println("*** Este es el stock disponible actualmente en la Concesionaria:  ");
                    stock.muestraStock();
                    break;
                case 4:// opcion para ingresar a menu de taller
                    System.out.println("*********************************************************************************************");
                    System.out.println("*********************Bienvenido al taller de la concesionaria********************************");
                    System.out.println("*********************************************************************************************");
                    System.out.println("\n*** Por favor, a continuacion seleccione alguna de las opciones ");
                    System.out.println("1 || Muestra cola de espera en Taller. \n2 || Ingresos de vehiculos a Taller.\n3 || Retiro de vehiculos del Taller");
                    System.out.print("==>  ");
                    int opc = scan.nextInt();
                    switch(opc){
                        case 1:
                            System.out.println("*** La cola de espera en el taller es la siguiente:");
                            taller.muestraColaDeTaller();
                            break;
                        case 2:
                            System.out.println("*** Por favor, ingrese la ID del vehiculo que desea realizar el mantenimiento:");
                            stock.faltaMantenimiento();
                            int Id = scan.nextInt();
                            if (taller.quedaLugarDisponible()&& stock.hayVehiculos(stock.obtenerVehiculo(Id))){
                                taller.ingresoTaller(stock.obtenerVehiculo(Id));
                                stock.borraVehiculo(Id);
                        }else{
                                System.out.println("*** Lamentablemente el vehiculo seleccionado no se encuentra disponible");
                            }
                            break;
                        case 3:
                            VehiculoBase P = taller.saleTaller();
                            stock.ingresaVehiculo(P);
                            stock.ordenarID();
                            break;
                        default:
                            System.out.println("*** Ha ingresado una opcion no valida!!");
                            break;

                    }
                    break;
                case 5:
                    // Salir del programa
                    guardaConcesionariaEnArchivo(stock);
                    guardaTallerEnArchivo(taller);
                    guardaElUltimoId(VehiculoBase.getCuentaId());
                    System.out.println("Muchas Gracias por utilizar nuestros servicios!!!");
                    System.out.println("Esperamos volver a verlo pronto!!!!");
                    System.exit(0);

                default:
                    System.out.println("*** Ha ingresado una opcion no valida, Reintente!!!");
                    break;
            }
        }
    }
    private static Concesionaria cargaArchivoDeConcesionaria() {
        File archivo = new File("ArchivoDeConcesionaria.txt");
        if (archivo.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
                return (Concesionaria) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new Concesionaria();
    }
    private static Taller cargaArchivoDeTaller() {
        File archivo = new File("ArchivoDeTaller.txt");
        if (archivo.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
                return (Taller) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new Taller();
    }
    private static void guardaConcesionariaEnArchivo(Concesionaria concesionaria) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ArchivoDeConcesionaria.txt"))) {
            out.writeObject(concesionaria);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void guardaTallerEnArchivo(Taller taller) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ArchivoDeTaller.txt"))) {
            out.writeObject(taller);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int cargaElUltimoId() {
        File archivo = new File("ArchivoLastID.txt");
        if (archivo.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
                return in.readInt();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    private static void guardaElUltimoId(int ultimoID) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ArchivoLastID.txt"))) {
            out.writeInt(ultimoID);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}