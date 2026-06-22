package proyecto;

import java.util.Scanner;

public class Main {

        static Scanner scanner = new Scanner(System.in);
        static SistemaUsuarios sistema = new SistemaUsuarios();

        public static void main(String[] args) {

            int opcion = 0;

            while (opcion != 3) { //Recordar: Mientras la opcion sea distinta de 3, se sigue repitiendo el menú.

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

       //Registro de admin
                public static void registrar() {

                    System.out.println("Registro de Usuario:");

                    System.out.println("Email:");
                    String email = scanner.nextLine();

                    if (sistema.usuarioExiste(email)) {
                        System.out.println("El usuario ya existe");
                        return;
                    }

                    Usuario usuario = new Admin();

                    usuario.setEmail(email);

                    System.out.println("Nombre: ");
                    usuario.setNombre(scanner.nextLine());

                    System.out.println("Apellido: ");
                    usuario.setApellido(scanner.nextLine());

                    System.out.println("Edad: ");
                    usuario.setEdad(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Pais: ");
                    usuario.setPais(scanner.nextLine());

                    System.out.println("Contraseña: ");
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

        if (sistema.login(email, clave)) {
            System.out.println("Login exitoso");
        } else {
            System.out.println("Datos incorrectos");
        }
    }

}

