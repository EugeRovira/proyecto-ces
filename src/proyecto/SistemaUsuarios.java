package proyecto;
import java.util.ArrayList;

public class SistemaUsuarios {

    private ArrayList<Usuario> usuarios;

    public SistemaUsuarios() {

        usuarios = new ArrayList<>();

        usuarios.add(new Admin(
                "Pablo",
                "Martinez",
                29,
                "Uruguay",
                "admin@gmail.com",
                "1234",
                "TOTAL"));

        usuarios.add(new Tester(
                "Juan",
                "Lopez",
                24,
                "Uruguay",
                "tester@gmail.com",
                "1234",
                "FUNCIONAL"));
    }

    public void agregarUsuario(Usuario usuario) {

        usuarios.add(usuario);
    }

    public Usuario login(String email, String clave) {

        for (Usuario usuario : usuarios) {

            if (usuario.getEmail().equals(email)
                    && usuario.getClave().equals(clave)) {

                return usuario;
            }
        }

        return null;
    }

        public boolean usuarioExiste(String email) {

            for (Usuario usuario : usuarios) {

                if (usuario.getEmail().equals(email)) {
                    return true;
                }
        }
        return false;
    }

        public boolean existeAdministrador() {

            for (Usuario usuario : usuarios) {

                if (usuario instanceof Admin) {
                    return true;
                }
            }

            return false;
        }

    public void mostrarRolesUsuarios() {

        for (Usuario usuario : usuarios) {
            usuario.mostrarRol();
        }
    }
    public Usuario buscarUsuario(String email) {

        for (Usuario usuario : usuarios) {

            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }

        return null;
    }

    public void listarUsuarios() {

        for (Usuario usuario : usuarios) {

            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Pais: " + usuario.getPais());

            usuario.mostrarRol();

            System.out.println("----------------------");
        }
    }

    public ArrayList<Usuario> getUsuarios() {

        return usuarios;
    }
}