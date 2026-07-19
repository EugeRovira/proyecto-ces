package proyecto;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static SistemaUsuarios sistema =
            SistemaUsuarios.getInstancia();

    public static void main(String[] args) {

        int opcion = 0;

        while (opcion != 3) {

            System.out.println("Seleccione una opción:");
            System.out.println("1 - Registro de administrador");
            System.out.println("2 - Login");
            System.out.println("3 - Salir");

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrar();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("No se ingresó una opción válida");
            }
        }
    }

    //Registro de admin
    public static void registrar() {

        try {

            System.out.println("Registro de Administrador:");

            Admin administrador = new Admin();

            System.out.println("Email:");
            String email = scanner.nextLine();

            administrador.setEmail(email);

            System.out.println("Nombre:");
            administrador.setNombre(scanner.nextLine());

            System.out.println("Apellido:");
            administrador.setApellido(scanner.nextLine());

            System.out.println("País de Nacimiento:");
            administrador.setPaisNacimiento(scanner.nextLine());

            System.out.println("Contraseña:");
            administrador.setClave(scanner.nextLine());

            sistema.agregarUsuario(administrador);

            System.out.println("Administrador registrado con éxito");

        } catch (EmailDuplicadoException | DatosInvalidosException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Ocurrió un error inesperado.");
        }
    }

    // Registro de tester realizado por un administrador
    public static void registrarTester() {

        try {

            System.out.println("Registro de tester:");

            Tester tester = new Tester();

            System.out.println("Email:");
            tester.setEmail(scanner.nextLine());

            System.out.println("Nombre:");
            tester.setNombre(scanner.nextLine());

            System.out.println("Apellido:");
            tester.setApellido(scanner.nextLine());

            System.out.println("País de nacimiento:");
            tester.setPaisNacimiento(scanner.nextLine());

            System.out.println("Contraseña:");
            tester.setClave(scanner.nextLine());

            System.out.println("Tipo de tester:");
            tester.setTipoTester(scanner.nextLine());

            sistema.agregarUsuario(tester);

            System.out.println("El tester se ha registrado con éxito");

        } catch (EmailDuplicadoException | DatosInvalidosException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {

            System.out.println(
                    "Ocurrió un error inesperado al registrar el tester."
            );
        }
    }

    //Login
    public static void login() {

        System.out.println("Login");

        System.out.println("Email:");
        String email = scanner.nextLine();

        System.out.println("Contraseña:");
        String clave = scanner.nextLine();

        Usuario usuarioLogueado = sistema.login(email, clave);

        if (usuarioLogueado != null) {
            System.out.println("Login exitoso");
            menuUsuario(usuarioLogueado);
        } else {
            System.out.println("Datos incorrectos");
        }
    }

    public static void menuUsuario(Usuario usuarioLogueado) {

        int opcion = 0;

        if (usuarioLogueado instanceof Admin) {

            while (opcion != 4) {

                System.out.println("Menú de administrador:");
                System.out.println("1 - Listar usuarios");
                System.out.println("2 - Buscar usuario");
                System.out.println("3 - Registrar tester");
                System.out.println("4 - Cerrar sesión");

                opcion = leerOpcion();

                switch (opcion) {
                    case 1:
                        sistema.listarUsuarios();
                        break;

                    case 2:
                        buscarUsuario();
                        break;

                    case 3:
                        registrarTester();
                        break;

                    case 4:
                        System.out.println("Sesión cerrada");
                        break;

                    default:
                        System.out.println("Opción inválida");
                }
            }

        } else {

            while (opcion != 1) {

                System.out.println("Menú principal de usuario:");
                System.out.println("1 - Cerrar sesión");

                opcion = leerOpcion();

                if (opcion == 1) {
                    System.out.println("Sesión cerrada");
                } else {
                    System.out.println("Opción inválida");
                }
            }
        }
    }

    public static void buscarUsuario() {

        try {

            System.out.println(
                    "Ingrese el email de un usuario para buscarlo:"
            );

            String email = scanner.nextLine();

            if (email.trim().isEmpty()) {
                throw new DatosInvalidosException(
                        "Debe ingresar un email."
                );
            }

            Usuario usuario = sistema.buscarUsuario(email);

            System.out.println("Usuario encontrado:");
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println(
                    "País de nacimiento: "
                            + usuario.getPaisNacimiento()
            );

            usuario.mostrarRol();

        } catch (UsuarioNoEncontradoException |
                 DatosInvalidosException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {

            System.out.println(
                    "Ocurrió un error inesperado durante la búsqueda."
            );
        }
    }
    public static int leerOpcion() {

        while (true) {

            try {

                String entrada = scanner.nextLine();
                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                System.out.println("Dato inválido. Debe ingresar un número.");
                System.out.println("Ingrese nuevamente una opción:");
            }
        }
    }
}

