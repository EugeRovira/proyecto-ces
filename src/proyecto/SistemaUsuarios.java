package proyecto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaUsuarios {

    private static SistemaUsuarios instancia;
    private ArrayList<Usuario> usuarios;
    private static final int LONGITUD_MINIMA_CLAVE = 4;

    private SistemaUsuarios() {

        usuarios = new ArrayList<>();

        try {

            agregarUsuario(new Admin(
                    "Pablo",
                    "Martinez",
                    "Uruguay",
                    "admin@gmail.com",
                    "1234"
            ));

            agregarUsuario(new Tester(
                    "Juan",
                    "Lopez",
                    "Uruguay",
                    "tester@gmail.com",
                    "1234",
                    "FUNCIONAL"
            ));
        }
        catch (EmailDuplicadoException | DatosInvalidosException e) {

            System.out.println(
                    "Error al cargar los usuarios iniciales: "
                            + e.getMessage()
            );
        }
    }

    public static SistemaUsuarios getInstancia() {

        if (instancia == null) {
            instancia = new SistemaUsuarios();
        }

        return instancia;
    }

    public void agregarUsuario(Usuario usuario)
            throws EmailDuplicadoException, DatosInvalidosException {

        if (usuario == null) {
            throw new DatosInvalidosException(
                    "No se puede registrar un usuario vacío."
            );
        }

        if (usuario.getNombre() == null ||
                usuario.getNombre().trim().isEmpty()) {

            throw new DatosInvalidosException(
                    "El nombre no puede estar vacío."
            );
        }

        if (usuario.getApellido() == null ||
                usuario.getApellido().trim().isEmpty()) {

            throw new DatosInvalidosException(
                    "El apellido no puede estar vacío."
            );
        }

        if (usuario.getPaisNacimiento() == null ||
                usuario.getPaisNacimiento().trim().isEmpty()) {

            throw new DatosInvalidosException(
                    "El país de nacimiento no puede estar vacío."
            );
        }

        if (usuario.getEmail() == null ||
                usuario.getEmail().trim().isEmpty()) {

            throw new DatosInvalidosException(
                    "El email no puede estar vacío."
            );
        }

        String formatoEmail =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if (!usuario.getEmail().matches(formatoEmail)) {
            throw new DatosInvalidosException(
                    "El email ingresado no tiene un formato válido."
            );
        }

        if (usuario.getClave() == null ||
                usuario.getClave().trim().isEmpty()) {

            throw new DatosInvalidosException(
                    "La contraseña no puede estar vacía."
            );
        }

        if (usuario.getClave().length() < LONGITUD_MINIMA_CLAVE) {
            throw new DatosInvalidosException(
                    "La contraseña debe tener como mínimo "
                            + LONGITUD_MINIMA_CLAVE
                            + " caracteres."
            );
        }

        if (usuarioExiste(usuario.getEmail())) {
            throw new EmailDuplicadoException(
                    "Ya existe un usuario registrado con el email "
                            + usuario.getEmail()
            );
        }
        if (usuario instanceof Tester) {

            Tester tester = (Tester) usuario;

            if (tester.getTipoTester() == null ||
                    tester.getTipoTester().trim().isEmpty()) {

                throw new DatosInvalidosException(
                        "El tipo de tester no puede estar vacío."
                );
            }
        }

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

                if (usuario.getEmail().equalsIgnoreCase(email)) {
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

    public Usuario buscarUsuario(String email)
            throws UsuarioNoEncontradoException {

        for (Usuario usuario : usuarios) {

            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }

        throw new UsuarioNoEncontradoException(
                "No se encontró ningún usuario con el email ingresado: " + email
        );
    }

    public void listarUsuarios() {

        for (Usuario usuario : usuarios) {

            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("País de nacimiento: " + usuario.getPaisNacimiento());

            usuario.mostrarRol();

            System.out.println("----------------------");
        }
    }

    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }
}