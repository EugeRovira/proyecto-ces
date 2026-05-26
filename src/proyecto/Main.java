package proyecto;

import java.util.Scanner;

public class Main {

        static Scanner scanner = new Scanner(System.in);

        //usuario administrador
        static Usuario admin = new Usuario();

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

            if (admin.email != null) {
                System.out.println("Ya existe administrador registrado");
                return;
            }
                    System.out.println("Registro de Administrador");

                    System.out.println("Nombre: ");
                    admin.nombre = scanner.nextLine();

                    System.out.println("Apellido: ");
                    admin.apellido = scanner.nextLine();

                    System.out.println("Edad: ");
                    admin.edad = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Pais: ");
                    admin.pais = scanner.nextLine();

                    System.out.println("Email: ");
                    admin.email = scanner.nextLine();

                    System.out.println("Contraseña: ");
                    admin.clave = scanner.nextLine();

                    System.out.println("Administrador registrado con éxito");
                }
   //Login

    public static void login() {
        if (admin.email == null) {
            System.out.println("Debe registrar un administrador");
            return;
        }
        System.out.println("Login");

        System.out.println("Email");
        String email = scanner.nextLine();

        System.out.println("Contraseña");
        String clave = scanner.nextLine();

        if (email.equals(admin.email) && clave.equals(admin.clave)) {
            System.out.println("Login exitoso");

        } else {
            System.out.println("Datos incorrectos");
        }
    }

}

