package proyecto;

public class Admin extends Usuario {

    public Admin() {

        super();
    }

    public Admin(String nombre, String apellido,
                 String paisNacimiento, String email, String clave) {

        super(nombre, apellido, paisNacimiento, email, clave);
    }

    @Override
    public void mostrarRol() {

        System.out.println("Soy un administrador");
    }
}
