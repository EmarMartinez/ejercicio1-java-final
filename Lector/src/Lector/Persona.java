package Lector;

import java.util.Optional;

import static java.lang.Integer.parseInt;

public class Persona {
    private String nombre;
    private String ciudad;
    private String edad;

    public Persona(String nombre, String ciudad, String edad) {
        this.nombre = nombre;

        if(ciudad == "") {
            this.ciudad = "Desconocida";
        }
        else {
            this.ciudad = ciudad;
        }
        Optional<String> edadTest = Optional.ofNullable(edad);
        if(edadTest.isPresent()) {
            this.edad = edadTest.get();
        }
        else {
            this.edad = "Desconocida";
        }

    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEdad() {

        return this.edad;
    }

}