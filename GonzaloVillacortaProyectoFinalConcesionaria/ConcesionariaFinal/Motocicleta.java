package ConcesionariaFinal;
import java.util.*;
import java.io.*;

public class Motocicleta extends VehiculoBase implements Serializable{
    private MarcasDeMotocicletas marca;
    private String modelo;
    //constructores
    public Motocicleta() {}
    public Motocicleta(String tipo, Colores color, Integer km, Integer año, MarcasDeMotocicletas marca, String modelo) {
        super(tipo,color,año,km);
        this.marca = marca;
        this.modelo = modelo;
    }
    //getters y setters
    public MarcasDeMotocicletas getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setMarca(MarcasDeMotocicletas marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    // metodo para crear una motocicleta segun seleccion de usuario
    public static Motocicleta crearMotocicleta() {
        Scanner sc = new Scanner(System.in);
        int seleccion;
        //Honda, Yamaha, Suzuki, Guerrero, Otros
        System.out.printf("\n******************************************************\n");
        System.out.printf("\n***A Continuacion Seleccione la Marca o Fabricante de la Motocicleta:\n1->Honda\n2->Yamaha\n3->Suzuki\n4->Guerrero\n5->Otros\n");
        //seleccion marca
        seleccion = sc.nextInt();
        MarcasDeMotocicletas marca;
        switch (seleccion) {
            case 1:
                System.out.println("La marca Honda ha sido seleccionada!");
                marca = MarcasDeMotocicletas.Honda;
                break;
            case 2:
                System.out.println("La marca Yamaha ha sido seleccionada!");
                marca = MarcasDeMotocicletas.Yamaha;
                break;
            case 3:
                System.out.println("La marca Suzuki ha sido seleccionada!");
                marca = MarcasDeMotocicletas.Suzuki;
                break;
            case 4:
                System.out.println("La marca Guerrero ha sido seleccionada!");
                marca = MarcasDeMotocicletas.Guerrero;
                break;
            case 5:
                System.out.println("Ha seleccionado como marca, Otros!");
                marca = MarcasDeMotocicletas.Otros;
                break;    
            default:
                System.out.println("Ha ingresado una opcion no valida!! Se ingresa como marca, Otros");
                marca = MarcasDeMotocicletas.Otros;
                break;
        }
        System.out.printf("\n******************************************************\n");
        System.out.printf("\n***A Continuacion Seleccione el Modelo Correspondiente:\n");
        //seleccion modelo
        int a;
        String modSelecc = null;
        switch (marca) {
            case Honda:
                String[] listamodelos = {"Tornado", "Twister", "Shadow","Otros"};
                System.out.printf("1->Tornado\n2->Twister\n3->Shadow\n4->Otros\n");
                a = sc.nextInt();
                if (a<=4 && a>=1) {
                    modSelecc = listamodelos[a - 1];
                    System.out.println("Ha Seleccionado el modelo:" + modSelecc);
                }else{
                    System.out.println("Ha ingresado una opcion no valida!! Se ingresa como modelo, Otros");
                    modSelecc = listamodelos[3];

                }
                break;
            case Yamaha:
                String[] listamodelos1 = {"Xtz", "Fx25", "DragStar", "Otros"};
                System.out.printf("1->Xtz\n2->Fx25\n3->DragStar\n4->Otros\n");
                a = sc.nextInt();
                if (a<=4 && a>=1) {
                    modSelecc = listamodelos1[a - 1];
                    System.out.println("Ha Seleccionado el modelo:" + modSelecc);
                }else{
                    System.out.println("Ha ingresado una opcion no valida!! Se ingresa como modelo, Otros");
                    modSelecc = listamodelos1[3];

                }
                break;
            case Suzuki:
                String[] listamodelos2 = {"Ax-100", "Gn-125", "Gsxs-750", "Otros"};
                System.out.printf("1->Ax-100\n2->Gn-125\n3->Gsxs-750\n4->Otros\n");
                a = sc.nextInt();
                if (a<=4 && a>=1) {
                    modSelecc = listamodelos2[a - 1];
                    System.out.println("Ha Seleccionado el modelo:" + modSelecc);
                }else{
                    System.out.println("Ha ingresado una opcion no valida!! Se ingresa como modelo, Otros");
                    modSelecc = listamodelos2[3];

                }
                break;
            case Guerrero:
                String[] listamodelos3 = {"Day-70", "Trip", "Gxr-300", "Otros"};
                System.out.printf("1->Day-70\n2->Trip\n3->Gxr-300\n4->Otros\n");
                a = sc.nextInt();
                if (a<=4 && a>=1) {
                    modSelecc = listamodelos3[a - 1];
                    System.out.println("Ha Seleccionado el modelo:" + modSelecc);
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
        System.out.printf("\n***A Continuacion Introduzca Kilometraje de la Motocicleta: ");
        //seleccion kilometraje
        int KM = sc.nextInt();
        //control que no ingresen numeros negativos
        if(KM<0){
            KM= 0;
        }
        System.out.printf("\n******************************************************\n");
        System.out.printf("\n***A continuacion Seleccione Color de la Motocicleta:\n1->Negro\n2->Blanco\n3->Azul\n4->Rojo\n5->Amarillo\n6->Otros\n");
        //seleccion color
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
        return new Motocicleta("Motocicleta", color, KM, año, marca, modSelecc);
    }
    private static int obtenerAño(Scanner sc) {
        int año = 0;
        boolean añoValido = false;
        do {
            try {
                System.out.printf("***A Continuacion Seleccione Año de la Motocicleta: ");
                año = sc.nextInt();
                verificarAño(año);
                añoValido = true;
            } catch (ExcepcionPropia e) {
                System.out.println(e.getMessage());
                System.out.println("Se asigna al año 2023");
                año = 2023; // Asigna 2023 por defecto si se lanza excepcion
                añoValido = true; // Termina el ciclo
            } catch (Exception ex) {
                System.out.println("Error: Debes ingresar un número entero.");
                sc.nextLine(); // Limpia buffer de scanner
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
