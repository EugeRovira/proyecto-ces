package proyecto;

public class Tester extends Usuario {

    private String tipoTester;

    public Tester() {

        super();
    }

    public Tester(String nombre, String apellido,
                  String paisNacimiento, String email, String clave,
                  String tipoTester) {
        super(nombre, apellido, paisNacimiento, email, clave);
        this.tipoTester = tipoTester;
    }

    public String getTipoTester() {

        return tipoTester;
    }

    public void setTipoTester(String tipoTester) {

        this.tipoTester = tipoTester;
    }
    @Override
    public void mostrarRol() {
        System.out.println("Soy un tester de tipo: " + tipoTester);
    }
}

