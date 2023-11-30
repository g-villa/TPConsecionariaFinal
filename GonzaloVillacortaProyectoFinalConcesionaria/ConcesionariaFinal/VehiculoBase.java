package ConcesionariaFinal;
import java.util.*;
import java.io.*;

abstract class VehiculoBase implements GettersySetters, Serializable {
    private String tipo;
    private Colores color;
    private Integer año;
    private Integer id;
    private static int cuentaId=1;
    private Integer km;
    private boolean necesitaMantenimiento;
    private boolean esUsado;
    //constructores
    public VehiculoBase() {
        this.id = cuentaId++;
    }
    public VehiculoBase(String tipo,Colores color, Integer año,Integer km) {
        this.tipo = tipo;
        this.color = color;
        this.año = año;
        this.id =cuentaId++;
        this.km = km;
        this.necesitaMantenimiento= (!getUsado());
        this.esUsado = (km > 50);
    }
    // implementa interfaz contratada de getters y setters
    //@Override
    public String getTipo() {
        return tipo;
    }
    //@Override
    public Colores getColor() {
        return color;
    }
    //@Override
    public Integer getAño() {
        return año;
    }
    //@Override
    public static int getCuentaId() {
        return cuentaId;
    }
    //@Override
    public Integer getId() {
        return id;
    }
    //@Override
    public Integer getKilometraje() {
        return km;
    }
    //@Override
    public boolean getNecesitaMantenimiento() {
        return necesitaMantenimiento;
    }
    //@Override
    public boolean getUsado() {
        return esUsado;
    }
    //@Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    //@Override
    public void setColor(Colores color) {
        this.color = color;
    }
    //@Override
    public void setAño(Integer año) {
        this.año = año;
    }
    //@Override
    public static void setCuentaId(int cuentaId) {
        VehiculoBase.cuentaId = cuentaId;
    }
    //@Override
    public void setId(Integer id) {
        this.id = id;
    }
    //@Override
    public void setKilometraje(Integer km) {
        this.km = km;
    }
    //@Override
    public void setNecesitaMantenimiento(boolean necesitaMantenimiento) {
        this.necesitaMantenimiento = necesitaMantenimiento;
    }
    //@Override
    public void setUsado(boolean usado) {
        this.esUsado = usado;
    }
    public String toString() {
        return "ID: " + id +"|| Tipo: "+tipo+ "|| Kilometraje: " + km + " km || Año: " + año +"|| Color: "+color+ "|| Es Usado: " + (esUsado?"Si" : "No")+"|| Requiere Mantenimiento: "+(necesitaMantenimiento?"Si" : "No");
    }
}
