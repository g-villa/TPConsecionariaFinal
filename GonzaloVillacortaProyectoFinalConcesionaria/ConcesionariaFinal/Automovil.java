package ConcesionariaFinal;
import java.util.*;
import java.io.*;

public class Automovil extends VehiculoBase implements Serializable {
    private MarcasDeAutos marca;
    private String modelo;
    //constructores
    public Automovil(){}
    public Automovil(String tipo, Colores color, Integer km, Integer año, MarcasDeAutos marca, String modelo) {
        super(tipo,color,año,km);
        this.marca = marca;
        this.modelo = modelo;
    }
    //getters y setters
    public MarcasDeAutos getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setMarca(MarcasDeAutos marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    // metodo para crear un automovil segun seleccion de usuario
    public static Automovil crearAuto(){
        Scanner sc = new Scanner(System.in);
        int seleccion;
        //Toyota, Renault, Fiat, Chevrolet, Otros
        System.out.printf("\n******************************************************\n");
        System.out.printf("\n***A Continuacion Seleccione la Marca o Fabricante del Automovil:\n1->Toyota\n2->Renault\n3->Fiat\n4->Chevrolet\n5->Otros\n");
        //selecciona marca
        seleccion = sc.nextInt();
        MarcasDeAutos marca;
        switch (seleccion) {
            case 1:
                System.out.println("La marca Toyota ha sido seleccionada!");
                marca = MarcasDeAutos.Toyota;
                break;
            case 2:
                System.out.println("La marca Renault ha sido seleccionada!");
                marca = MarcasDeAutos.Renault;
                break;
            case 3:
                System.out.println("La marca Fiat ha sido seleccionada!");
                marca = MarcasDeAutos.Fiat;
                break;
            case 4:
                System.out.println("La marca Chevrolet ha sido seleccionada!");
                marca = MarcasDeAutos.Chevrolet;
                break;
            case 5:
                System.out.println("Ha seleccionado como marca, Otros!");
                marca = MarcasDeAutos.Otros;
                break;
            default:
                System.out.println("Ha ingresado una opcion no valida!! Se ingresa como marca, Otros");
                marca= MarcasDeAutos.Otros;
                break;
        }
        System.out.printf("\n******************************************************\n");
        System.out.printf("\n***A Continuacion Seleccione el Modelo Correspondiente:\n");
        //selecciona modelo
        int a;
        String modSelecc = null;
        switch (marca) {
            case Toyota:
                String[] listamodelos = {"Etios", "Yaris", "Corolla", "Otros"};
                System.out.printf("1->Etios\n2->Yaris\n3->Corolla\n4->Otros\n");
                a = sc.nextInt();
                if (a<=4 && a>=1) {
                    modSelecc = listamodelos[a - 1];
                    System.out.println("Ha Seleccionado el modelo: " + modSelecc);
                }else{
                    System.out.println("Ha ingresado una opcion no valida!! Se ingresa como modelo, Otros");
                    modSelecc = listamodelos[3];

                }
                break;
            case Renault:
                String[] listamodelos1 ={"Clio", "Logan", "Sandero", "Otros"};
                System.out.printf("1->Clio\n2->Logan\n3->Sandero\n4->Otros\n");
                a = sc.nextInt();
                if (a<=4 && a>=1) {
                    modSelecc = listamodelos1[a - 1];
                    System.out.println("Ha Seleccionado el modelo: " + modSelecc);
                }else{
                    System.out.println("Ha ingresado una opcion no valida!! Se ingresa como modelo, Otros");
                    modSelecc = listamodelos1[3];

                }
                break;
            case Fiat:
                String[] listamodelos2 ={"Palio", "Cronos", "Pulse", "Otros"};
                System.out.printf("1->Palio\n2->Cronos\n3->Pulse\n4->Otros\n");
                a = sc.nextInt();
                if (a<=4 && a>=1) {
                    modSelecc = listamodelos2[a - 1];
                    System.out.println("Ha Seleccionado el modelo: " + modSelecc);
                }else{
                    System.out.println("Ha ingresado una opcion no valida!! Se ingresa como modelo, Otros");
                    modSelecc = listamodelos2[3];

                }
                break;
            case Chevrolet:
                String[] listamodelos3 ={"Corsa", "Onix", "Prisma", "Otros"};
                System.out.printf("1->Corsa\n2->Onix\n3->Prisma\n4->Otros\n");
                a = sc.nextInt();
                if (a<=4 && a>=1) {
                    modSelecc = listamodelos3[a - 1];
                    System.out.println("Ha Seleccionado el modelo: " + modSelecc);
                }else{
                    System.out.println("Ha ingresado una opcion no valida!! Se ingresa como modelo, Otros");
                    modSelecc = listamodelos3[3];

                }
                break;    
            case Otros:
                System.out.printf("A Seleccionado Otros!");
                modSelecc = "Otros";
                break;     
                
        }
        System.out.printf("\n******************************************************\n");
        int año = obtenerAño(sc);
        System.out.printf("\n******************************************************\n");
        System.out.printf("\n***A Continuacion Introduzca Kilometraje del Automovil: ");
        //selecciona kilometraje
        int KM = sc.nextInt();
        //control que no ingresen numeros negativos
        if(KM<0){
            KM= 0;
        }
        System.out.printf("\n******************************************************\n");
        System.out.printf("\n***A continuacion Seleccione Color del Automovil:\n1->Negro\n2->Blanco\n3->Azul\n4->Rojo\n5->Amarillo\n6->Otros\n");
        //selecciona color
        seleccion = sc.nextInt();
        Colores color;
        switch (seleccion){
            case 1:
                System.out.println("Color Negro Seleccionado!");
                color = Colores.Negro;
                break;
            case 2:
                System.out.println("Color Blanco Seleccionado!");
                color = Colores.Blanco;
                break;
            case 3:
                System.out.println("Color Azul Seleccionado!");
                color = Colores.Azul;
                break;
            case 4:
                System.out.println("Color Rojo Seleccionado!");
                color = Colores.Rojo;
                break;
            case 5:
                System.out.println("Color Amarillo Seleccionado!");
                color = Colores.Amarillo;
                break;
            case 6:
                System.out.println("Color Seleccionado Otros!");
                color = Colores.Otros;
                break;
            default:
                System.out.println("Ha ingresado una opcion no valida!! Se ingresa como Color, Otros");
                color = Colores.Otros;
                break;
        }
       return new Automovil("Automovil",color, KM, año, marca, modSelecc);
    }
    private static int obtenerAño(Scanner sc) {
        int año = 0;
        boolean añoValido = false;
        do {
            try {
                System.out.printf("***A Continuacion Seleccione Año del Automovil: ");
                año = sc.nextInt();
                verificarAño(año);
                añoValido = true;
            } catch (ExcepcionPropia e) {
                System.out.println(e.getMessage());
                System.out.println("Se asigna al año 2023");
                año = 2023; // Asigna 2023 por defecto si se lanza la excepcion
                añoValido = true; // Termina el ciclo
            } catch (Exception ex) {
                System.out.println("Error: Debes ingresar un número entero.");
                sc.nextLine(); // Limpia buffer del scanner
            }
        } while (!añoValido);
        return año;
    }
    private static void verificarAño(int año) throws ExcepcionPropia {
        if (año > 2023) {
            throw new ExcepcionPropia("Año ingresado incorrecto!!!");
        }
    }
    //@Override 
    public String toString() {
        return super.toString() + "\n|| marca: " + marca + "|| modelo: " + modelo + "\n";
    }
}