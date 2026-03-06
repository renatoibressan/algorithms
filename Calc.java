import java.util.Locale;
import java.util.Scanner;

public class Calc {
    static Scanner sc = new Scanner(System.in);
    public static void limpar_tela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static int contar_casas_decimais(double n) {
        String valor = String.valueOf(n);
        int count = valor.length() - valor.indexOf('.') - 1;
        if (count <= 0) return 0;
        else if (count > 12) return 12;
        else return count;
    }
    public static int adicao(int a, int b) {
        return a + b;
    } // Função 01 - Adição
    public static int subtracao(int a, int b) {
        return a - b;
    } // Função 02 - Subtração
    public static int multiplicacao(int a, int b) {
        return a * b;
    } // Função 03 - Multiplicação
    public static double divisao(int a, int b) {
        return (double) a / (double) b;
    } // Função 04 - Divisão
    public static int resto(int a, int b) {
        return a % b;
    } // Função 05 - Resto
    public static double potenciacao(int a, int b) {
        double p = 1.0;
        int i;
        if (b == 0) {
            return 1;
        } else if (b > 0) {
            for (i = 0; i < b; i++) {
                p *= a;
            }
        } else {
            for (i = 0; i > b; i--) {
                p /= a;
            }
        }
        return p;
    } // Função 06 - Potenciação
    public static long fatorial(int n) {
        if (n < 0) return -1;
        if (n == 0) return 1;
        long f = 1;
        for (int i = n; i >= 1; i--) {
            f *= i;
        }
        return f;
    } // Função 07 - Fatorial
    public static double media_de_dois(int a, int b) {
        return ((double)a + (double)b) / 2;
    } // Função 08 - Média de dois
    public static long somatorio(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        long s = 0;
        for (int i = a; i <= b; i++) {
            s += i;
        }
        return s;
    } // Função 09 - Somatório
    public static long produtorio(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        long p = 1;
        for (int i = a; i <= b; i++) {
            p *= i;
        }
        return p;
    } // Função 10 - Produtório
    public static int maior_de_dois(int a, int b) {
        if (a > b) return a;
        else return b;
    } // Função 11 - Maior de dois
    public static int menor_de_dois(int a, int b) {
        if (a < b) return a;
        else return b;
    } // Função 12 - Menor de dois
    public static boolean igual_a(int a, int b) {
        if (a == b) return true;
        else return false;
    } // Função 13 - Igual a
    public static boolean diferente_de(int a, int b) {
        if (a != b) return true;
        else return false;
    } // Função 14 - Diferente de
    public static boolean maior_que(int a, int b) {
        if (a > b) return true;
        else return false;
    } // Função 15 - Maior que
    public static boolean menor_que(int a, int b) {
        if (a < b) return true;
        else return false;
    } // Função 16 - Menor que
    public static boolean maior_ou_igual_a(int a, int b) {
        if (a >= b) return true;
        else return false;
    } // Função 17 - Maior ou igual a
    public static boolean menor_ou_igual_a(int a, int b) {
        if (a <= b) return true;
        else return false;
    } // Função 18 - Menor ou igual a
    public static void aba_A() throws InterruptedException {
        int option = -1;
        int casas;
        int a, b, resultado;
        double resultadoDouble;
        String load = "...\n";
        limpar_tela();
        System.out.println("===== ABA A =====");
        Thread.sleep(2000);
        do {
            a = 0;
            b = 0;
            casas = 0;
            System.out.println("1. Adicao");
            Thread.sleep(1000);
            System.out.println("2. Subtracao");
            Thread.sleep(1000);
            System.out.println("3. Multiplicacao");
            Thread.sleep(1000);
            System.out.println("4. Divisao");
            Thread.sleep(1000);
            System.out.println("5. Resto");
            Thread.sleep(1000);
            System.out.println("6. Potenciacao");
            Thread.sleep(1000);
            System.out.println("0. Voltar ao menu principal");
            Thread.sleep(1000);
            System.out.print("Selecione uma das opcoes acima: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultado = adicao(a, b);
                    System.out.println(a + " + " + b + " = " + resultado);
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 2:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultado = subtracao(a, b);
                    System.out.println(a + " - " + b + " = " + resultado);
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 3:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultado = multiplicacao(a, b);
                    System.out.println(a + " * " + b + " = " + resultado);
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 4:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    while (b == 0) {
                        System.out.print("Digite o segundo numero: ");
                        b = sc.nextInt();
                        if (b == 0) System.out.println("Nao e possivel dividir por 0!");
                    }
                    resultadoDouble = divisao(a, b);
                    if (resto(a, b) != 0) casas = contar_casas_decimais(resultadoDouble);
                    System.out.println(a + " / " + b + " = " + String.format("%." + casas + "f", resultadoDouble));
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 5:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    while (b == 0) {
                        System.out.print("Digite o segundo numero: ");
                        b = sc.nextInt();
                        if (b == 0) System.out.println("Nao e possivel dividir por 0!");
                    }
                    resultado = resto(a, b);
                    System.out.println(a + " % " + b + " = " + resultado);
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 6:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultadoDouble = potenciacao(a, b);
                    if (b < 0) casas = contar_casas_decimais(resultadoDouble);
                    System.out.println(a + " ^ " + b + " = " + String.format("%." + casas + "f", resultadoDouble));
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 0:
                    System.out.print("Retornando ao menu do programa principal");
                    Thread.sleep(750);
                    for (char c : load.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(150);
                    }
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    sc.nextLine();
                    System.out.print("Retornando ao menu da aba A");
                    Thread.sleep(750);
                    for (char c : load.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(150);
                    }
                    limpar_tela();
            }
        } while (option != 0);
        limpar_tela();
    }
    public static void aba_B() throws InterruptedException {
        int option = -1;
        int casas;
        int n, a, b, resultado;
        long resultadoLong;
        double resultadoDouble;
        String load = "...\n";
        limpar_tela();
        System.out.println("===== ABA B =====");
        Thread.sleep(2000);
        do {
            n = -1;
            a = 0;
            b = 0;
            casas = 0;
            System.out.println("7. Fatorial");
            Thread.sleep(1000);
            System.out.println("8. Media de dois");
            Thread.sleep(1000);
            System.out.println("9. Somatorio");
            Thread.sleep(1000);
            System.out.println("10. Produtorio");
            Thread.sleep(1000);
            System.out.println("11. Maior de dois");
            Thread.sleep(1000);
            System.out.println("12. Menor de dois");
            Thread.sleep(1000);
            System.out.println("0. Voltar ao menu principal");
            Thread.sleep(1000);
            System.out.print("Selecione uma das opcoes acima: ");
            option = sc.nextInt();
            switch (option) {
                case 7:
                    limpar_tela();
                    while (n < 0) {
                        System.out.print("Digite um numero: ");
                        n = sc.nextInt();
                        if (n < 0) System.out.println("Nao ha fatorial de numeros negativos!");
                    }
                    resultadoLong = fatorial(n);
                    System.out.println(n + "! = " + resultadoLong);
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 8:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultadoDouble = media_de_dois(a, b);
                    if (resto(adicao(a, b), 2) != 0) casas = contar_casas_decimais(resultadoDouble);
                    System.out.println("Media de " + a + " e " + b + ": " + String.format("%." + casas + "f", resultadoDouble));
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 9:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultadoLong = somatorio(a, b);
                    System.out.println("Somatorio de " + a + " -> " + b + ": " + resultadoLong);
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 10:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultadoLong = produtorio(a, b);
                    System.out.println("Produtorio de " + a + " -> " + b + ": " + resultadoLong);
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 11:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultado = maior_de_dois(a, b);
                    System.out.println("Maior de " + a + " e " + b + ": " + resultado);
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 12:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultado = menor_de_dois(a, b);
                    System.out.println("Menor de " + a + " e " + b + ": " + resultado);
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 0:
                    System.out.print("Retornando ao menu do programa principal");
                    Thread.sleep(750);
                    for (char c : load.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(150);
                    }
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    sc.nextLine();
                    System.out.print("Retornando ao menu da aba B");
                    Thread.sleep(750);
                    for (char c : load.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(150);
                    }
                    limpar_tela();
            }
        } while (option != 0);
        limpar_tela();
    }
    public static void aba_C() throws InterruptedException {
        int option = -1;
        int a, b;
        boolean resultado;
        String load = "...\n";
        limpar_tela();
        System.out.println("===== ABA C =====");
        Thread.sleep(2000);
        do {
            a = 0;
            b = 0;
            System.out.println("13. Igual a");
            Thread.sleep(1000);
            System.out.println("14. Diferente de");
            Thread.sleep(1000);
            System.out.println("15. Maior que");
            Thread.sleep(1000);
            System.out.println("16. Menor que");
            Thread.sleep(1000);
            System.out.println("17. Maior ou igual a");
            Thread.sleep(1000);
            System.out.println("18. Menor ou igual a");
            Thread.sleep(1000);
            System.out.println("0. Voltar ao menu principal");
            Thread.sleep(1000);
            System.out.print("Selecione uma das opcoes acima: ");
            option = sc.nextInt();
            switch (option) {
                case 13:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultado = igual_a(a, b);
                    System.out.print(a + " == " + b + ": ");
                    if (resultado == true) System.out.println("afirmacao verdadeira");
                    else System.out.println("afirmacao falsa");
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 14:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultado = diferente_de(a, b);
                    System.out.print(a + " != " + b + ": ");
                    if (resultado == true) System.out.println("afirmacao verdadeira");
                    else System.out.println("afirmacao falsa");
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 15:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultado = maior_que(a, b);
                    System.out.print(a + " > " + b + ": ");
                    if (resultado == true) System.out.println("afirmacao verdadeira");
                    else System.out.println("afirmacao falsa");
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 16:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultado = menor_que(a, b);
                    System.out.print(a + " < " + b + ": ");
                    if (resultado == true) System.out.println("afirmacao verdadeira");
                    else System.out.println("afirmacao falsa");
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 17:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultado = maior_ou_igual_a(a, b);
                    System.out.print(a + " >= " + b + ": ");
                    if (resultado == true) System.out.println("afirmacao verdadeira");
                    else System.out.println("afirmacao falsa");
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 18:
                    limpar_tela();
                    System.out.print("Digite o primeiro numero: ");
                    a = sc.nextInt();
                    System.out.print("Digite o segundo numero: ");
                    b = sc.nextInt();
                    resultado = menor_ou_igual_a(a, b);
                    System.out.print(a + " <= " + b + ": ");
                    if (resultado == true) System.out.println("afirmacao verdadeira");
                    else System.out.println("afirmacao falsa");
                    Thread.sleep(1500);
                    limpar_tela();
                    break;
                case 0:
                    System.out.print("Retornando ao menu do programa principal");
                    Thread.sleep(750);
                    for (char c : load.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(150);
                    }
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    sc.nextLine();
                    System.out.print("Retornando ao menu da aba C");
                    Thread.sleep(750);
                    for (char c : load.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(150);
                    }
                    limpar_tela();
            }
        } while (option != 0);
        limpar_tela();
    }
    public static void main(String[] args) throws InterruptedException {
        Locale.setDefault(Locale.US);
        char selecionar_abas = 'X';
        limpar_tela();
        System.out.print("Iniciando");
        Thread.sleep(1000);
        String load = "...\n";
        for (char c : load.toCharArray()) {
            System.out.print(c);
            Thread.sleep(100);
        }
        System.out.println("Pronto!");
        Thread.sleep(1000);
        limpar_tela();
        System.out.println("===== CALCULADORA BRESSAN =====");
        Thread.sleep(2000);
        while (selecionar_abas != '0') {
            System.out.println("A. Aba A (operacoes 1 a 6)");
            Thread.sleep(1000);
            System.out.println("B. Aba B (operacoes 7 a 12)");
            Thread.sleep(1000);
            System.out.println("C. Aba C (operacoes 13 a 18)");
            Thread.sleep(1000);
            System.out.println("0. Encerrar o programa");
            Thread.sleep(1000);
            System.out.print("Selecione uma das opcoes acima: ");
            selecionar_abas = Character.toUpperCase(sc.next().charAt(0));
            switch (selecionar_abas) {
                case 'A':
                    aba_A();
                    break;
                case 'B':
                    aba_B();
                    break;
                case 'C':
                    aba_C();
                    break;
                case '0':
                    System.out.print("Encerrando o programa");
                    Thread.sleep(750);
                    for (char c : load.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(150);
                    }
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    sc.nextLine();
                    System.out.print("Retornando ao menu do programa principal");
                    Thread.sleep(750);
                    for (char c : load.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(150);
                    }
                    limpar_tela();
            }
        }
        limpar_tela();
        sc.close();
    }
}