/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;
import Tiempo.Fecha;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 *
 * @author Adrian Gonzalez
 */
public class FechasTester extends JFrame {
    private JTextArea resultadoArea;
    private JTextField fechaTextoField;
    private JTextField formatoField;
    private JTextField diasField;
    private JTextField fechaInicioField;
    private JTextField fechaFinField;

    public FechasTester() {
        setTitle("Probador de Clase Fechas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de controles
        JPanel controlPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        
        // Campos de entrada
        fechaTextoField = new JTextField();
        formatoField = new JTextField("dd/MM/yyyy");
        diasField = new JTextField("0");
        fechaInicioField = new JTextField();
        fechaFinField = new JTextField();

        // Botones para probar cada método
        controlPanel.add(new JLabel("Fecha (texto):"));
        controlPanel.add(fechaTextoField);
        
        controlPanel.add(new JLabel("Formato:"));
        controlPanel.add(formatoField);
        
        controlPanel.add(new JLabel("Días a sumar/restar:"));
        controlPanel.add(diasField);
        
        controlPanel.add(new JLabel("Fecha inicio (rango):"));
        controlPanel.add(fechaInicioField);
        
        controlPanel.add(new JLabel("Fecha fin (rango):"));
        controlPanel.add(fechaFinField);
        
        controlPanel.add(crearBoton("Obtener fecha actual", e -> probarGetDia()));
        controlPanel.add(crearBoton("Convertir texto a fecha", e -> probarTextoFecha()));
        controlPanel.add(crearBoton("Convertir fecha a texto", e -> probarFechaTexto()));
        controlPanel.add(crearBoton("Sumar días", e -> probarSumarDias()));
        controlPanel.add(crearBoton("Sumar días con texto", e -> probarSumarDiasTexto()));
        controlPanel.add(crearBoton("Obtener día/mes/año", e -> probarGetters()));
        controlPanel.add(crearBoton("Obtener día/mes/año (num)", e -> probarGettersNum()));
        controlPanel.add(crearBoton("Diferencia en días", e -> probarDiasDiferencia()));
        controlPanel.add(crearBoton("Verificar rango", e -> probarDiaRango()));

        // Área de resultados
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JButton crearBoton(String texto, ActionListener listener) {
        JButton button = new JButton(texto);
        button.addActionListener(listener);
        return button;
    }

    private void mostrarResultado(String resultado) {
        resultadoArea.append(resultado + "\n\n");
    }

    // Métodos de prueba
    private void probarGetDia() {
        try {
            Date fechaActual = Fecha.getDia();
            mostrarResultado("Fecha actual (sin hora): " + Fecha.FechaTexto(fechaActual, "dd/MM/yyyy HH:mm:ss"));
        } catch (Exception e) {
            mostrarResultado("Error: " + e.getMessage());
        }
    }

    private void probarTextoFecha() {
        try {
            String textoFecha = fechaTextoField.getText();
            if (textoFecha.isEmpty()) {
                mostrarResultado("Error: Ingrese una fecha como texto");
                return;
            }
            
            Date fecha = Fecha.TextoFecha(textoFecha);
            if (fecha != null) {
                mostrarResultado("Fecha convertida: " + Fecha.FechaTexto(fecha, "d 'de' MMMM 'de' yyyy"));
            } else {
                mostrarResultado("Error: No se pudo convertir el texto a fecha con los formatos soportados");
            }
        } catch (Exception e) {
            mostrarResultado("Error: " + e.getMessage());
        }
    }

    private void probarFechaTexto() {
        try {
            Date fecha = Fecha.TextoFecha(fechaTextoField.getText());
            if (fecha == null) {
                fecha = new Date(); // Usar fecha actual si no se pudo convertir
            }
            
            String formato = formatoField.getText();
            String resultado = Fecha.FechaTexto(fecha, formato);
            mostrarResultado("Fecha formateada (" + formato + "): " + resultado);
        } catch (Exception e) {
            mostrarResultado("Error: " + e.getMessage());
        }
    }

    private void probarSumarDias() {
        try {
            Date fecha = Fecha.TextoFecha(fechaTextoField.getText());
            if (fecha == null) {
                fecha = new Date();
            }
            
            int dias = Integer.parseInt(diasField.getText());
            Date nuevaFecha = Fecha.SumarDias(fecha, dias);
            
            mostrarResultado("Fecha original: " + Fecha.FechaTexto(fecha, "dd/MM/yyyy") + 
                           "\nSumando " + dias + " días: " + 
                           Fecha.FechaTexto(nuevaFecha, "dd/MM/yyyy"));
        } catch (Exception e) {
            mostrarResultado("Error: " + e.getMessage());
        }
    }

    private void probarSumarDiasTexto() {
        try {
            Date fecha = Fecha.TextoFecha(fechaTextoField.getText());
            if (fecha == null) {
                fecha = new Date();
            }
            
            int dias = Integer.parseInt(diasField.getText());
            String resultado = Fecha.SumarDiasTexto(fecha, dias);
            
            mostrarResultado("Sumar " + dias + " días con texto:\n" + resultado);
        } catch (Exception e) {
            mostrarResultado("Error: " + e.getMessage());
        }
    }

    private void probarGetters() {
        try {
            Date fecha = Fecha.TextoFecha(fechaTextoField.getText());
            if (fecha == null) {
                fecha = new Date();
            }
            
            mostrarResultado("Fecha: " + Fecha.FechaTexto(fecha, "dd/MM/yyyy") +
                           "\nDía: " + Fecha.getDia(fecha) +
                           "\nMes: " + Fecha.getMes(fecha) +
                           "\nAño: " + Fecha.getAño(fecha));
        } catch (Exception e) {
            mostrarResultado("Error: " + e.getMessage());
        }
    }

    private void probarGettersNum() {
        try {
            Date fecha = Fecha.TextoFecha(fechaTextoField.getText());
            if (fecha == null) {
                fecha = new Date();
            }
            
            mostrarResultado("Fecha: " + Fecha.FechaTexto(fecha, "dd/MM/yyyy") +
                           "\nDía (num): " + Fecha.getDiaNum(fecha) +
                           "\nMes (num): " + Fecha.getMesNum(fecha) +
                           "\nAño (num): " + Fecha.getAñoNum(fecha));
        } catch (Exception e) {
            mostrarResultado("Error: " + e.getMessage());
        }
    }

    private void probarDiasDiferencia() {
        try {
            Date fecha1 = Fecha.TextoFecha(fechaInicioField.getText());
            Date fecha2 = Fecha.TextoFecha(fechaFinField.getText());
            
            if (fecha1 == null || fecha2 == null) {
                mostrarResultado("Error: Ingrese ambas fechas válidas");
                return;
            }
            
            long diferencia = Fecha.DiasDiferencia(fecha1, fecha2);
            mostrarResultado("Diferencia entre " + Fecha.FechaTexto(fecha1, "dd/MM/yyyy") + 
                            " y " + Fecha.FechaTexto(fecha2, "dd/MM/yyyy") + 
                            ": " + diferencia + " días");
        } catch (Exception e) {
            mostrarResultado("Error: " + e.getMessage());
        }
    }

    private void probarDiaRango() {
        try {
            Date fecha = Fecha.TextoFecha(fechaTextoField.getText());
            Date inicio = Fecha.TextoFecha(fechaInicioField.getText());
            Date fin = Fecha.TextoFecha(fechaFinField.getText());
            
            if (fecha == null || inicio == null || fin == null) {
                mostrarResultado("Error: Ingrese todas las fechas válidas");
                return;
            }
            
            boolean enRango = Fecha.DiaRango(fecha, inicio, fin);
            mostrarResultado("Fecha: " + Fecha.FechaTexto(fecha, "dd/MM/yyyy") +
                           "\nRango: " + Fecha.FechaTexto(inicio, "dd/MM/yyyy") + 
                           " a " + Fecha.FechaTexto(fin, "dd/MM/yyyy") +
                           "\n¿Está en rango? " + (enRango ? "Sí" : "No"));
        } catch (Exception e) {
            mostrarResultado("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FechasTester tester = new FechasTester();
            tester.setVisible(true);
     });
}
}
