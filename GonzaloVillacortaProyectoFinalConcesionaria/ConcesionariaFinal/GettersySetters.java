package ConcesionariaFinal;
//considere al conjunto de getters y setters como interfaz contemplando la posibilidad de que a futuro la consecionaria quiera agregar otras clases
//de vehiculobase distinta a la ya creada, permitiendo se respete esta parte del diseño
public interface GettersySetters{
    // Getters
    String getTipo();
    Colores getColor();
    Integer getAño();
    static int getCuentaId() {
        return VehiculoBase.getCuentaId();
    }
    Integer getId();
    Integer getKilometraje();
    boolean getNecesitaMantenimiento();
    boolean getUsado();
    // Setters
    void setTipo(String tipo);
    void setColor(Colores color);
    void setAño(Integer año);
    static void setCuentaId(int cuentaId) {
        VehiculoBase.setCuentaId(cuentaId);
    }
    void setId(Integer id);
    void setKilometraje(Integer km);
    void setNecesitaMantenimiento(boolean necesitaMantenimiento);
    void setUsado(boolean usado);
}

