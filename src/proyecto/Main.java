package proyecto;

import java.util.Scanner;

public class Main {

        static Scanner scanner = new Scanner(System.in);
        static SistemaUsuarios sistema = new SistemaUsuarios();

        public static void main(String[] args) {

            int opcion = 0;

            while (opcion != 3) {

                System.out.println("Seleccione una opción:");
                System.out.println("1 - Registro");
                System.out.println("2 - Login");
                System.out.println("3 - Salir");

                opcion = scanner.nextInt();
                scanner.nextLine();

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

       //Registro de usuario
       public static void registrar() {

           System.out.println("Registro de Usuario:");

           System.out.println("Tipo de usuario:");
           System.out.println("1 - Administrador");
           System.out.println("2 - Tester");

           int tipo = scanner.nextInt();
           scanner.nextLine();

           Usuario usuario;

           if (tipo == 1) {
               usuario = new Admin();

               ((Admin) usuario).setNivelAcceso("TOTAL");

           } else if (tipo == 2) {
               usuario = new Tester();

               System.out.println("Tipo de prueba:");
               ((Tester) usuario).setTipoPrueba(scanner.nextLine());

           } else {
               System.out.println("Tipo de usuario inválido");
               return;
           }

           System.out.println("Email:");
           String email = scanner.nextLine();

           if (sistema.usuarioExiste(email)) {
               System.out.println("El usuario ya existe");
               return;
           }

           usuario.setEmail(email);

           System.out.println("Nombre:");
           usuario.setNombre(scanner.nextLine());

           System.out.println("Apellido:");
           usuario.setApellido(scanner.nextLine());

           System.out.println("Edad:");
           usuario.setEdad(scanner.nextInt());
           scanner.nextLine();

           System.out.println("Pais:");
           usuario.setPais(scanner.nextLine());

           System.out.println("Contraseña:");
           usuario.setClave(scanner.nextLine());

           sistema.agregarUsuario(usuario);

           System.out.println("Usuario registrado con éxito");
       }
   //Login

    public static void login() {

        System.out.println("Login");

        System.out.println("Email");
        String email = scanner.nextLine();

        System.out.println("Contraseña");
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

            while (opcion != 3) {

                System.out.println("Menú de administrador:");
                System.out.println("1 - Listar usuarios");
                System.out.println("2 - Buscar usuario");
                System.out.println("3 - Cerrar sesión");

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        sistema.listarUsuarios();
                        break;

                    case 2:
                        buscarUsuario();
                        break;

                    case 3:
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

                opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion == 1) {
                    System.out.println("Sesión cerrada");
                } else {
                    System.out.println("Opción inválida");
                }
            }
        }
    }
    public static void buscarUsuario() {

        System.out.println("Ingrese el email de un usuario para buscarlo:");
        String email = scanner.nextLine();

        Usuario usuario = sistema.buscarUsuario(email);

        if (usuario != null) {
            System.out.println("Usuario encontrado:");
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Pais: " + usuario.getPais());

            usuario.mostrarRol();
        } else {
            System.out.println("Usuario no encontrado");
        }
    }
}

