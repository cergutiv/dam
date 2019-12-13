package practicaprogramacion;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cergutiv
 */
public class Logica {

    //variables y demas
    static Scanner sc = new Scanner(System.in);
    public int rappelMonedas = 0;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    Random r = new Random();
    public String jugador; //para almacenar el nombre del jugador
////////////////////////////////////////////////////////////

    public boolean comprobarNick(String input) {
        char letter;
        int i = 0;
        boolean permitido = true;
        //Comprobar si el nick está vacío y si el primer valor es un número
        if (input.isEmpty() || Character.isDigit(input.charAt(0))) {
            do {
                System.out.println("Error, vuelve a introducirlo (no puede estar vacío \n o tener un número en la primera posición)");
                
            } while (input.isEmpty() || Character.isDigit(input.charAt(0)));
        }
        //Comprobar todos los valores para ver si son punto (.), coma(,), _, @ o #.
        for (i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            String diccionario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz@#,._ÁÉÍÓÚáéíóú0123456789Üü";
            if (diccionario.contains(String.valueOf(inputChar))) {
                permitido = true;
            } else {
                permitido = false;
                System.out.println("Carácter no soportado");
                i = input.length();
            }
        }
         return permitido;
         
    }

    public static boolean comprobarFinal(String input) {
        boolean continuar;
        switch (input.toLowerCase().charAt(0)) {
            case 's':
                return continuar = true;
            case 'n':
                return continuar = false;
            case 0:
                return continuar = false;
            default:
                return continuar = false;
        }
    }

    public static long instTiempo() {
        long now = System.currentTimeMillis();
        return now;
    }

    public static long compararInicioConFin(long principio, long acabado) {
        long tiempoPasadoMils = acabado - principio;
        return tiempoPasadoMils;
    }

    public static int toMinutes(long tiempoPasadoMils) {
        int minutos = (int) (tiempoPasadoMils / 60000);
        return minutos;
    }

    public int sumarRappelMonedas(int minutos) {
        int monedas = rappelMonedas;
        if (minutos == 0) {
            monedas = rappelMonedas + 100;
        } else if (minutos <= 15 || minutos != 0) {
            monedas = rappelMonedas + 50;
        } else if (minutos <= 30 || minutos != 15 || minutos != 0) {
            monedas = rappelMonedas + 25;
        } else {
            monedas = rappelMonedas + 5;
        }
        return monedas;
    }

    //Creacion de fecha aleatoria del mismo año de ejecucion
    public LocalDate fechaRandom() {
        //instancia actual
        LocalDate hoy = LocalDate.now();
        //año actual
        int annoJuego = hoy.getYear();
        //fecha minima
        LocalDate fechaMin = LocalDate.of(annoJuego, Month.JANUARY, 1);
        //fecha maxima
        LocalDate fechaMax = LocalDate.of(annoJuego, Month.DECEMBER, 31);
        //numero aleatorio entre 
        int numMesRandom = r.nextInt(12);
        if (numMesRandom == 0) {
            while (numMesRandom == 0) {
                numMesRandom = r.nextInt(12);
            }
        }
        //mes aleatorio
        LocalDate conversionAMes = LocalDate.of(annoJuego, numMesRandom, 1);
        Month mesRandom = conversionAMes.getMonth();
        //año bisiesto
        boolean bisiesto = true;
        if (LocalDate.now().lengthOfYear() == 366) {
            bisiesto = true;
        } else {
            bisiesto = false;
        }
        //dia aleatorio
        int maxDias = mesRandom.length(bisiesto);
        int diaRandom = r.nextInt(maxDias);
        if (diaRandom == 0) {
            while (diaRandom == 0) {
                diaRandom = r.nextInt(maxDias);
            }
        }
        //Fecha aleatoria definitiva
        LocalDate fechaRandom = LocalDate.of(annoJuego, mesRandom, diaRandom);
        //return
        return fechaRandom;
    }

    public String LocalDateFormateado(LocalDate localdate) {
        String fechaFormateada = formatter.format(localdate);
        return fechaFormateada;

    }

    public static LocalDate localDateUsuario(String userInput) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(userInput, dateFormat);
        return date;
    }
//obtener los dias y los meses de las fechas

    public int diaFechas(LocalDate fechaAleatoria) {
        int dia = fechaAleatoria.getDayOfMonth();
        return dia;
    }

    public int diaMes(LocalDate fechaAleatoria) {
        int mes = fechaAleatoria.getMonthValue();
        return mes;
    }


    public boolean acertarMesYDia(int mes1, int mes2, int dia1, int dia2) {
        boolean haAcertadoMeses = mes1 == mes2;
        boolean haAcertadoDias = dia1 == dia2;
        int diferenciaDias = Math.abs(dia1 - dia2);
        if (!haAcertadoMeses) {
            System.out.println("Pista: has fallado el mes");
        }
        if (haAcertadoDias && haAcertadoMeses) {
            /*Mirar lo de las rappelmonedas*/
            System.out.println("¡Enhorabuena! " + jugador + " ¡Has acertado la fecha!");
            return true;
        } else if (haAcertadoMeses && !haAcertadoDias) {
            System.out.println("Has acertado el mes, pero no el día " + jugador);
            if (diferenciaDias <= 15) {
                System.out.println("Caliente caliente (El dia esta en un rango de entre 1 y 15 días respecto a tu fecha)");
            } else {
                System.out.println("Sigue probando " + jugador);
            }
        }
        return false;
    }

}
