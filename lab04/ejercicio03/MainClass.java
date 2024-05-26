import java.util.ArrayList;
import java.util.Scanner;
public class MainClass {
    public static void main(String[] args) {
        ArrayList<Turista<?>> registroAduanas = new ArrayList<Turista<?>>();
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;
        do {
            System.out.println("1. Registrar turista");
            System.out.println("2. Mostrar registro de turistas");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.next();
                    System.out.print("Identificador: ");
                    String identificador = sc.next();
                    if (identificador.matches("[0-9]+")) {
                        Turista<Integer> turista = new Turista<Integer>();
                        turista.setNombre(nombre);
                        turista.setIdentificador(Integer.parseInt(identificador));
                        registroAduanas.add(turista);
                    } else {
                        Turista<String> turista = new Turista<String>();
                        turista.setNombre(nombre);
                        turista.setIdentificador(identificador);
                        registroAduanas.add(turista);
                    }
                    break;
                case 2:
                    for(Turista<?> turista : registroAduanas) {
                        System.out.println("Nombre: " + turista.getNombre());
                        System.out.println("Identificador: " + turista.getIdentificador());
                        System.out.println("------------------------------");
                    }
                    break;
                case 3:
                    seguir = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while(seguir);
        sc.close();
    }
}
