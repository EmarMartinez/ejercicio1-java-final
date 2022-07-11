package Lector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

public class Lector {
    public void leerDatos(String direccion) {
        try {
            List<Persona> listaPersonas = new ArrayList<>();
            String[] datosPersona;
            FileReader entrada = new FileReader(direccion);

            BufferedReader bf = new BufferedReader(entrada);

            String linea;

            while((linea = bf.readLine()) != null) {

                String ciudadTest = null;
                String nombreTest = null;
                String edadTest = null;

                datosPersona = linea.split(":");

                nombreTest = datosPersona[0];

                if(datosPersona.length > 1) {
                    ciudadTest = datosPersona[1];
                }

                if(datosPersona.length > 2) {
                    edadTest = datosPersona[2];
                }

                Persona persona = new Persona(nombreTest, ciudadTest, edadTest);
                listaPersonas.add(persona);

            }

            List<Persona> listaMenores = this.menorDe25(listaPersonas);
            this.pintarPersonas(listaMenores);

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
    public List menorDe25(List<Persona> listaPersonas) {
        List<Persona> listaMenores25 =
                listaPersonas.stream()
                .filter(n-> (n.getEdad() != "Desconocida" && parseInt(n.getEdad()) < 25 ))
                .collect(toList());

                return listaMenores25;
    }

    public void pintarPersonas(List<Persona> listaPersonas) {
        int contador = 1;
        listaPersonas.stream()
        .forEach(e -> System.out.println("Linea " + contador + ": Nombre: " + e.getNombre() + " Ciudad: " + e.getCiudad() + " Edad: " + e.getEdad()));
    }
}
