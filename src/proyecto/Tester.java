package proyecto;

public class Tester extends Usuario {

    private String tipoPrueba;

    public Tester() {

        super();
    }

    public Tester(String nombre, String apellido, int edad,
                  String pais, String email, String clave,
                  String tipoPrueba) {
        super(nombre, apellido, edad, pais, email, clave);
        this.tipoPrueba = tipoPrueba;
    }

    public String getTipoPrueba() {

        return tipoPrueba;
    }

    public void setTipoPrueba(String tipoPrueba) {

        this.tipoPrueba = tipoPrueba;
    }
    @Override
    public void mostrarRol() {
        System.out.println("Soy un tester y realizo pruebas de tipo: " + tipoPrueba);
    }
}

