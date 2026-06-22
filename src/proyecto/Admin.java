package proyecto;

public class Admin extends Usuario {

    private String nivelAcceso;

    public Admin() {
        super();
    }

    public Admin(String nombre, String apellido, int edad,
                 String pais, String email, String clave,
                 String nivelAcceso) {

        super(nombre, apellido, edad, pais, email, clave);
        this.nivelAcceso = nivelAcceso;
    }

    public String getNivelAcceso() {
        return nivelAcceso;
    }
    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }
}
