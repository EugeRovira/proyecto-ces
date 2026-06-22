package proyecto;

public class SistemaUsuarios {

    private Usuario[] usuarios;
    private int cantidad;

    public SistemaUsuarios() {

        usuarios = new Usuario[10];
        cantidad = 0;

        usuarios[cantidad++] = new Admin(
                "Pablo",
                "Martinez",
                29,
                "Uruguay",
                "admin@gmail.com",
                "1234",
                "TOTAL");

        usuarios[cantidad++] = new Tester(
                "Juan",
                "Lopez",
                24,
                "Uruguay",
                "tester@gmail.com",
                "1234",
                "FUNCIONAL");
    }

    public void agregarUsuario(Usuario usuario) {

        if (cantidad < usuarios.length) {
            usuarios[cantidad++] = usuario;
        }
    }

    public boolean login(String email, String clave) {

        for (int i = 0; i < cantidad; i++) {

            if (usuarios[i].getEmail().equals(email)
                    && usuarios[i].getClave().equals(clave)) {

                return true;
            }
        }

        return false;
    }

        public boolean usuarioExiste(String email) {

        for (int i = 0; i < cantidad; i++) {

            if (usuarios[i].getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

        public boolean existeAdministrador() {

            for (int i = 0; i < cantidad; i++) {

                if (usuarios[i] instanceof Admin) {
                    return true;
                }
            }

            return false;
        }

        public Usuario[] getUsuarios () {
            return usuarios;
        }
}