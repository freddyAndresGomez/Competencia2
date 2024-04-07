
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author YULIETH
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
       
      public static List<Atleta> atletas = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menú:\n" +
                            "1. Registrar atleta\n" +
                            "2. Ver datos del campeón\n" +
                            "3. Buscar atletas por nacionalidad\n" +
                            "4. Calcular promedio de tiempos de llegada\n" +
                            "5. Salir"
            ));

            switch (opcion) {
                case 1:
                    registrarAtleta();
                    break;
                case 2:
                    datosCampeon();
                    break;
                case 3:
                    buscarPorNacionalidad();
                    break;
                case 4:
                    promedioTiempos();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void registrarAtleta() {
        String nombre = JOptionPane.showInputDialog("Nombre del atleta:");
        String nacionalidad = JOptionPane.showInputDialog("Nacionalidad del atleta:");
        double tiempoLlegada = Double.parseDouble(JOptionPane.showInputDialog("Tiempo de llegada del atleta:"));

        atletas.add(new Atleta(nombre, nacionalidad, tiempoLlegada));
    }

   public static void datosCampeon() {
        if (atletas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay atletas registrados.");
            return;
        }

        Atleta campeon = atletas.get(0);
        for (Atleta atleta : atletas) {
            if (atleta.tiempoLlegada < campeon.tiempoLlegada) {
                campeon = atleta;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Datos del campeón:\n" +
                        "Nombre: " + campeon.nombre + "\n" +
                        "Nacionalidad: " + campeon.nacionalidad + "\n" +
                        "Tiempo de llegada: " + campeon.tiempoLlegada
        );
    }

    public static void buscarPorNacionalidad() {
        String nacionalidadBuscar = JOptionPane.showInputDialog("Ingrese la nacionalidad a buscar:");
        StringBuilder atletasNacionalidad = new StringBuilder("Atletas de la nacionalidad " + nacionalidadBuscar + ":\n");

        boolean encontrado = false;
        for (Atleta atleta : atletas) {
            if (atleta.nacionalidad.equalsIgnoreCase(nacionalidadBuscar)) {
                atletasNacionalidad.append(atleta.nombre).append("\n");
                encontrado = true;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontraron atletas con la nacionalidad " + nacionalidadBuscar);
        } else {
            JOptionPane.showMessageDialog(null, atletasNacionalidad.toString());
        }
    }

   public static void promedioTiempos() {
        if (atletas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay atletas registrados.");
            return;
        }

        double sumaTiempos = 0;
        for (Atleta atleta : atletas) {
            sumaTiempos += atleta.tiempoLlegada;
        }
        double promedio = sumaTiempos / atletas.size();

        JOptionPane.showMessageDialog(null, "Promedio de tiempos de llegada: " + promedio);
    }
}

