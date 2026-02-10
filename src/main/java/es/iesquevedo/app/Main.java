package es.iesquevedo.app;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Weld weld = new Weld();

        try (WeldContainer container = weld.initialize();
             Scanner scanner = new Scanner(System.in)) {

            ConsoleApp app = container.select(ConsoleApp.class).get();

            boolean running = true;
            while (running) {
                printMenu();
                System.out.print("Elige una opción: ");
                String opt = scanner.nextLine().trim();

                switch (opt) {
                    case "1" -> app.crearSocio(scanner);
                    case "2" -> app.eliminarSocio(scanner);
                    case "3" -> app.listarSocios();
                    case "0" -> {
                        running = false;
                        System.out.println("Saliendo...");
                    }
                    default -> System.out.println("Opción no válida");
                }
                System.out.println();
            }
        }
    }

    private static void printMenu() {
        System.out.println("--- Videoclub ---");
        System.out.println("1) Añadir Socio");
        System.out.println("2) Eliminar Socio");
        System.out.println("3) Listar Socios");
        System.out.println("0) Salir");
    }
}

