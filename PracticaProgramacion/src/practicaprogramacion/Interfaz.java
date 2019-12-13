package practicaprogramacion;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author cergutiv
 */
public class Interfaz {

    public static void main(String[] args) {
        /**/
        Logica logica = new Logica();
        Scanner sc = new Scanner(System.in);
        String nickname;
        int rappelMonedas = logica.rappelMonedas;
        boolean continuar = true;
        String proseguir = "";
        /**/
        /////////////////////////////////////////
        System.out.println("¡¡Bienvenido!!");
        System.out.println("Para comenzar indica tu nombre: (sin espacios, el primer caracter no puede ser un número)");
        System.out.println("Los unicos valores especiales aceptados son: punto (.), coma(,), barra baja(_), arroba(@) y almohadilla(#)");
        nickname = sc.nextLine();
        logica.comprobarNick(nickname);
        logica.jugador = nickname;
        System.out.println("Bienvenido " + nickname);
        while (continuar) {
            System.out.println("Se ha generado una fecha aleatoria, " + nickname + " ¡a ver cuánto puedes tardar!");
            LocalDate fechaAleatoria = logica.fechaRandom();
            String fechaAleatoriaFormateada = logica.LocalDateFormateado(fechaAleatoria);

            System.out.println(fechaAleatoriaFormateada);
            int diaFechaAleatoria = logica.diaFechas(fechaAleatoria);
            int mesFechaAleatoria = logica.diaMes(fechaAleatoria);

            /*System.out.println(diaFechaAleatoria + " " + mesFechaAleatoria);*/
            long tiempoInicio = Logica.startTiempo();
            System.out.println("Introduce una fecha (formato dd-MM-yyyy)");
            String fechaUsuarioString = sc.nextLine();
            LocalDate fechaUsuarioLocalDate = Logica.localDateUsuario(fechaUsuarioString);

            System.out.println("Has introducido " + fechaUsuarioLocalDate);
            int diaFechaUsuario = logica.diaFechas(fechaUsuarioLocalDate);
            int mesFechaUsuario = logica.diaMes(fechaUsuarioLocalDate);

            System.out.println(diaFechaUsuario + " " + mesFechaUsuario);

            if (!logica.acertarMesYDia(mesFechaUsuario, mesFechaAleatoria, diaFechaUsuario, diaFechaAleatoria)) {
                do {
                    fechaUsuarioString = sc.nextLine();
                    fechaUsuarioLocalDate = Logica.localDateUsuario(fechaUsuarioString);
                    diaFechaUsuario = logica.diaFechas(fechaUsuarioLocalDate);
                    mesFechaUsuario = logica.diaMes(fechaUsuarioLocalDate);
                    System.out.println("Vuelve a intentarlo" + nickname);
                } while (!logica.acertarMesYDia(mesFechaUsuario, mesFechaAleatoria, diaFechaUsuario, diaFechaAleatoria));
            }
            long tiempoFinal = Logica.finishTiempo();
            long compararInicioConFinalMils = Logica.compararInicioConFin(tiempoInicio, tiempoFinal);
            int minutos = Logica.toMinutes(compararInicioConFinalMils);
            rappelMonedas = logica.sumarRappelMonedas(minutos);
            System.out.println("Tienes " + rappelMonedas + " RappelMonedas.");
            System.out.println("¿Quieres continuar? (S/N (Por defecto es N))");
            proseguir = sc.nextLine();
            continuar = Logica.comprobarFinal(proseguir);
        }
    }
}
