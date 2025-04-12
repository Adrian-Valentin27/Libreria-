/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 *
 * @author Adrian Gonzalez
 */
public class Validar {
    private static final Locale ESPAÑOL = new Locale("es", "ES");

    public static boolean validarCorreo(String usuario) {
        if (usuario.trim().isEmpty()) {
            return false;
        }
        String valida = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|es|net|org|edo|mx)$";
        return Pattern.matches(valida, usuario);
    }

    public static boolean validarContra(String contra) {
        if (contra.trim().isEmpty()) {
            return false;
        }
        return contra.length() >= 8;
    }

    //Validamos el Formato 
    public static String FechaTexto(Date fecha, String formato) {
        if (fecha == null || formato == null || formato.isEmpty()) {
            throw new IllegalArgumentException("Fecha o formato no válidos.");
        }
        return new SimpleDateFormat(formato, ESPAÑOL).format(fecha);
    }
}
