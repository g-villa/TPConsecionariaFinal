package ConcesionariaFinal;
import java.util.*;
import java.io.*;

public class Camioneta extends VehiculoBase implements Serializable {
    private MarcasDeCamionetas marca;
    private String modelo;
    //constructores
    public Camioneta() {}
    public Camioneta(String tipo, Colores color, Integer km, Integer año, MarcasDeCamionetas marca, String modelo) {
        super(tipo,color,año,km);
        this.marca = marca;
        this.modelo = modelo;
    }
    //getters y setters
    public MarcasDeCamionetas getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setMarca(MarcasDeCamionetas marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    // metodo para crear una camioneta segun seleccion de usuario
    public static Camioneta crearCamioneta() {
        Scanner sc = new Scanner(System.in);
        int seleccion;
        //Toyota, Ford, Chevrolet, Fiat, Otros
        System.out.printf("\n******************************************************\n");
        System.out.printf("\n***A Continuacion Seleccione la Marca o Fabricante de la Camioneta:\n1->Toyota\n2->Ford\n3->Chevrolet\n4->Fiat\n5->Otros");
        //selecciona marca
        seleccion = sc.nextInt();
        MarcasDeCamionetas marca;
        switch (seleccion) {
            case 1:
                System.out.println("La marca Toyota ha sido seleccionada!");
                marca = MarcasDeCamionetas.Toyota;
                break;
            case 2:
                System.out.println("La marca Ford ha sido seleccionada!");
                marca = MarcasDeCamionetas.Ford;
                break;
            case 3:
                System.out.println("La marca Chevrolet ha sido seleccionada!");
                marca = MarcasDeCamionetas.Chevrolet;
                break;
            case 4:
                System.out.println("La marca Fiat ha sido seleccionada!");
                marca = MarcasDeCamionetas.Fiat;
                break;
            case 5:
                System.out.println("Ha seleccionado como marca, Otros!");
                marca = MarcasDeCamionetas.Otros;
                break;
            default:
                System.out.println("Ha ingresado una opcion no valida!! Se ingresa como marca, Otros");
                marca = MarcasDeCamionetas.Otros;
                break;
        }
        System.out.printf("\n******************************************************\n");
        System.out.printf("\n***A Continuacion Seleccione el Modelo Correspondiente:\n");
        //selleciona modelo
        int a;
        String modSelecc = null;
        switch (marca) {
            case Toyota:
                String[] listamodelos = {"Hilux", "SW4", "Rav4", "Otros"};
                System.out.printf("1->Hilux\n2->SW4\n3->Rav4\n4->Otros\n");
                a = sc.nextInt();
                if (a<=4 && a>=1) {
                    modSelecc = listamodelos[a - 1];
                    System.out.println("Ha Seleccionado el modelo:" + modSelecc);
                }else{
                    System.out.println("Ha ingresado una opcion no valida!! Se ingresa como modelo, Otros");
                    modSelecc = listamodelos[3];

                }
                break;
            case Ford:
                String[] listamodelos1 = {"F-100", "Ranger", "Raptor","Otros"};
                System.out.printf("1->F-100\n2->Ranger\n3->Raptor\n4->Otros\n");
                a = sc.nextInt();
                if (a<=4 && a>=1) {
                    modSelecc = listamodelos1[a - 1];
                    System.out.println("Ha Seleccionado el modelo:" + modSelecc);
                }else{
                    System.out.println("Ha ingresado una opcion no valida!! Se ingresa como modelo, Otros");
                    modSelecc = listamodelos1[3];

                }
                break;
            case Chevrolet:
                String[] listamodelos2 = {"C-10", "S-10", "Montana","Otros"};
                System.out.printf("1->C-10\n2->S-10\n3->Montana\n4->Otros\n");
                a = sc.nextInt();
                if (a<=4 && a>=1) {
                    modSelecc = listamodelos2[a - 1];
                    System.out.println("Ha Seleccionado el modelo:" + modSelecc);
                }else{
                    System.out.println("Ha ingresado una opcion no valida!! Se ingresa como modelo, Otros");
                    modSelecc = listamodelos2[3];

                }
                break;
            case Fiat:
                String[] listamodelos3 = {"125-Multicarga", "Strada", "Toro"};
                System.out.printf("1->125-Multicarga\n2->Strada\n3->Toro\n4->Otros\n");
                a = sc.nextInt();
                if (a<=4 && a>=1) {
                    modSelecc = listamodelos3[a - 1];
                    System.out.println("ELIGIO EL MODELO " + modSelecc);
                }else{
                    System.out.println("ERROR,OPCION INCORRECTA,SE ELIGIO EL MODELO NUMERO 1");
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
        System.out.printf("\n***A Continuacion Introduzca Kilometraje de la Camioneta: ");
        //selecciona kilometraje
        int KM = sc.nextInt();
        //control que no ingresen numeros negativos
        if(KM<0){
            KM= 0;
        }
        System.out.printf("\n******************************************************\n");
        System.out.printf("\n***A continuacion Seleccione Color de la Camioneta:\n1->Negro\n2->Blanco\n3->Azul\n4->Rojo\n5->Amarillo\n6->Otros\n");
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
        return new Camioneta("Camioneta", color, KM, año, marca, modSelecc);
    }
    private static int obtenerAño(Scanner sc) {
        int año = 0;
        boolean añoValido = false;

        do {
            try {
                System.out.printf("***A Continuacion Seleccione Año de la Camioneta: ");
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