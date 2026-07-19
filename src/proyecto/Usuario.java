package proyecto;

public abstract class Usuario {

    private String nombre;
    private String apellido;
    private String paisNacimiento;
    private String email;
    private String clave;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String paisNacimiento,
                   String email, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.paisNacimiento = paisNacimiento;
        this.email = email;
        this.clave = clave;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getApellido() {

        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public abstract void mostrarRol();
}


