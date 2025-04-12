La librería llevara un control de las fechas y horarios para poder calcular cuantos dias hay entre una fecha y otra, muestra las fechas tanto en números como en texto, sumar dias y dar el
dia que cae de esa suma entre otras cosas, y así por ejemplo se puede llevar acabo un hotel o una central de autobuses para saber sus horarios.

CLASE VALIDAR.
Clase utilitaria encargada de validar datos como correos electrónicos, contraseñas y formatear fechas. Se utiliza para garantizar la integridad de los datos ingresados por el usuario.

Atributos:

private static final Locale ESPAÑOL
Representa la configuración regional en español (España), usada principalmente para el formato de fechas.

Métodos:

public static boolean validarCorreo(String usuario)
Valida si el correo electrónico proporcionado tiene un formato adecuado.
- Parámetros:
usuario: dirección de correo electrónico que se desea validar.
-Retorno:
true si el formato es válido (por ejemplo: nombre@dominio.com), false en caso contrario.
-Validaciones:
El campo no debe estar vacío.
Se evalúa con una expresión regular que acepta dominios comunes como .com, .es, .mx, etc.

public static boolean validarContra(String contra)
Verifica que una contraseña cumpla con el mínimo de seguridad.
-Parámetros:
contra: la contraseña que se desea verificar.
-Retorno:
true si la contraseña tiene al menos 8 caracteres, false en caso contrario.
-Validaciones:
El campo no debe estar vacío.
La longitud debe ser igual o mayor a 8 caracteres.

public static String FechaTexto(Date fecha, String formato)
Convierte una fecha en formato Date a texto, utilizando un formato personalizado.
-Parámetros:
fecha: la fecha que se quiere formatear.
formato: el patrón con el que se desea mostrar la fecha (por ejemplo: "dd/MM/yyyy" o "EEEE dd MMMM yyyy").
-Retorno:
Cadena de texto con la fecha formateada.
-Validaciones:
Si la fecha o el formato son null o vacíos, lanza una excepción IllegalArgumentException.
Usa el Locale español para mostrar la fecha en ese idioma.

CLASE FECHA.
Clase utilitaria para realizar operaciones con fechas como conversión de texto a fecha, formateo, suma de días, comparación de rangos, etc.

Atributos privados:
-private static final Locale ESPAÑOL:
Define la configuración regional en español (España), usada para dar formato en texto a las fechas.

-private static final String[] FORMATOS_COMUNES:
Arreglo de formatos de fecha comunes utilizados al intentar convertir una cadena de texto en un objeto Date.

Métodos públicos:
-public static Date getDia():
Devuelve la fecha actual sin hora (establece hora en 00:00:00.000).

-public static String FechaTexto(Date fecha, String formato):
Convierte un objeto Date a una cadena de texto con el formato deseado.

-public static Date TextoFecha(String fechaTexto):
Convierte una cadena de texto en una fecha, intentando varios formatos definidos en FORMATOS_COMUNES.
Devuelve null si no se puede convertir.

-public static String SumarDiasTexto(Date fecha, int dias):
Suma una cantidad de días a una fecha y devuelve una cadena con el día y el nombre del día (ejemplo: "10 jueves").

-public static String getDia(Date fecha):
Devuelve el día del mes como texto (formato "dd").

-public static String getMes(Date fecha):
Devuelve el nombre del mes (ejemplo: "abril").

-public static String getAño(Date fecha):
Devuelve el año en formato de texto ("yyyy").

-public static int getDiaNum(Date fecha):
Devuelve el día del mes como número entero.

-public static int getMesNum(Date fecha):
Devuelve el número del mes (1 a 12).

-public static int getAñoNum(Date fecha):
Devuelve el año como número entero.

-public static Date SumarDias(Date fecha, int dias):
Suma una cantidad de días a una fecha y devuelve el nuevo objeto Date.

-public static long DiasDiferencia(Date inicio, Date fin):
Calcula la diferencia en días entre dos fechas.

-public static boolean DiaRango(Date fecha, Date inicio, Date fin):
Verifica si una fecha está dentro de un rango (inclusive).

-public static Date fechaIntermedia(Date fecha1, Date fecha2):
Calcula la fecha intermedia exacta entre dos fechas.

Método de prueba:
public static void main(String[] args):
Demuestra el uso de los métodos de la clase Fecha.
Muestra en consola:

-La fecha actual formateada.
-Conversión de texto a fecha.
-Suma de días y nombre del día resultante.
-Fecha intermedia entre dos fechas.
-Día, mes, año en texto y como número.

CLASE FECHATESTER.
Interfaz gráfica basada en Swing donde probaremos las funcionalidades de la clase Fecha mediante botones y campos de entrada.

Componentes principales de la interfaz:
-JTextArea resultadoArea:
Muestra los resultados de las pruebas realizadas.
-JTextField fechaTextoField:
Campo de entrada para una fecha en formato de texto.
-JTextField formatoField:
Permite introducir un formato personalizado para formatear fechas.
-JTextField diasField:
Número de días a sumar o restar a una fecha.
-JTextField fechaInicioField, fechaFinField:
Campos para introducir fechas de inicio y fin de un rango.

constructor FechasTester()
-Establece el título, tamaño y cierre del JFrame.
-Define un JPanel con disposición en cuadrícula para los controles.
-Agrega campos de texto y botones para probar métodos específicos.
-Añade un área de resultados con scroll.

Botones y funcionalidades conectadas:
Cada botón ejecuta una prueba relacionada con un método de la clase Fecha:


IMPORTAR EL ARCHIVO .JAR.
Para poder importar el archivo .Jar a un nuevo proyecto se debe de dar clic derecho sobre la librería de la clase que teiene el proyecto al que se le quiere introducir la libreria y dar clic izquierdo sobre
abrir un archivo .Jar y solo deberás de buscar el archivo en donde tengas guardado el archivo .Jar y lo abres y eso seria todo.


VIDEO DE EXPLICACION DE LA LIBRERIA.
https://youtu.be/7NFc6U8mkkE?si=oFPj23vpH9mrw7ZB
