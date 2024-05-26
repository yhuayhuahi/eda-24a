import java.util.Scanner;
public class MainClass {
    public static void main(String[] args) {
        boolean seguir = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese el primer número: ");
            double num1 = sc.nextDouble();
            System.out.println("Ingrese el segundo número: ");
            double num2 = sc.nextDouble();
            System.out.println("Ingrese la operación a realizar: ");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            int operacion = sc.nextInt();
            Operaciones op = new Operaciones();
            switch (operacion) {
                case 1:
                    System.out.println("El resultado de la suma es: " + op.suma(num1, num2));
                    break;
                case 2:
                    System.out.println("El resultado de la resta es: " + op.resta(num1, num2));
                    break;
                case 3:
                    System.out.println("El resultado de la multiplicación es: " + op.multiplicacion(num1, num2));
                    break;
                case 4:
                    try {
                        System.out.println("El resultado de la división es: " + op.division(num1, num2));
                    } catch (ArithmeticException e) {
                        System.out.println("No se puede dividir entre 0");
                    }
                    break;
                default:
                    System.out.println("Operación no válida");
                    break;
            }
            System.out.println("¿Desea realizar otra operación? (s/n)");
            String respuesta = sc.next();
            if (respuesta.equals("n")) {
                seguir = false;
            }
        } while (seguir);
        sc.close();
    }
}
