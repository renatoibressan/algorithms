import java.util.Locale;
import java.util.Scanner;

class aluno {
    String nome;
    int matricula;
    double[] notas = new double[3];
    double media;
    public aluno(String nome, int matricula, double nota1, double nota2, double nota3, double media) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas[0] = nota1;
        this.notas[1] = nota2;
        this.notas[2] = nota3;
        this.media = media;
    }
}

public class sistemaNotas {
    static Scanner sc = new Scanner(System.in);
    public static void mostrarMenu() {
        System.out.println("Opcoes:");
        System.out.println("A. Cadastrar aluno");
        System.out.println("B. Registrar notas");
        System.out.println("C. Listar alunos");
        System.out.println("D. Buscar aluno");
        System.out.println("0. Encerrar o programa");
        System.out.println("Qual opcao deseja executar?");
    }
    public static void inicializarVetor(aluno[] alunos, int n) {
        for (int i = 0; i < n; i++) {
            alunos[i] = new aluno("Aluno " + (i + 1), 0, 0.0, 0.0, 0.0, 0.0);
        }
    }
    public static int buscarIndiceNoVetor(aluno[] alunos, String nome, int[] total) {
        int i = 0;
        int resultado;
        while (i < total[0]) {
            resultado = nome.compareToIgnoreCase(alunos[i].nome);
            if (resultado == 0) break;
            i++;
        }
        return i;
    }
    public static void cadastrarAluno(aluno[] alunos, int[] total) {
        System.out.println("Por favor, insira os dados a seguir:");
        System.out.println("Nome do aluno:");
        sc.nextLine();
        alunos[total[0]].nome = sc.nextLine();
        while (alunos[total[0]].matricula < 1000 || alunos[total[0]].matricula > 9999) {
            System.out.println("Matricula do aluno:");
            alunos[total[0]].matricula = sc.nextInt();
            sc.nextLine();
            if (alunos[total[0]].matricula < 1000 || alunos[total[0]].matricula > 9999) {
                System.out.println("Numero de matricula invalido!");
            }
        }
        System.out.println("Aluno " + alunos[total[0]].matricula + " cadastrado com sucesso!");
        total[0]++;
    }
    public static void registrarNotas(aluno[] alunos, String nome, int[] total) {
        boolean encontrado = false;
        for (int i = 0; i < total[0]; i++) {
            if (nome.equalsIgnoreCase(alunos[i].nome)) {
                System.out.println("Por favor, insira as notas:");
                while (true) {
                    System.out.println("N1:");
                    alunos[i].notas[0] = Double.parseDouble(sc.nextLine());
                    if (alunos[i].notas[0] < 0.0 || alunos[i].notas[0] > 10.0) System.out.println("Nota invalida!");
                    else break;
                }
                while (true) {
                    System.out.println("N2:");
                    alunos[i].notas[1] = Double.parseDouble(sc.nextLine());
                    if (alunos[i].notas[1] < 0.0 || alunos[i].notas[1] > 10.0) System.out.println("Nota invalida!");
                    else break;
                }
                while (true) {
                    System.out.println("N3:");
                    alunos[i].notas[2] = Double.parseDouble(sc.nextLine());
                    if (alunos[i].notas[2] < 0.0 || alunos[i].notas[2] > 10.0) System.out.println("Nota invalida!");
                    else break;
                }
                System.out.println("Notas de " + alunos[i].nome + " cadastradas com sucesso!");
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            System.out.println("Nenhum aluno de nome " + nome + " foi encontrado.");
        }
    }
    public static double calcularMedia(double[] notas) {
        double media = 0.0;
        for (int i = 0; i < 3; i++) {
            media += notas[i];
        }
        media /= 3.0;
        return media;
    }
    public static void listarAlunos(aluno[] alunos, int[] total) {
        int option = 0;
        while (option < 1 || option > 3) {
            System.out.println("Como deseja ordenar os alunos?");
            System.out.println("1. Por nota");
            System.out.println("2. Por matricula");
            System.out.println("3. Por nome");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    ordenarAlunosPorNota(alunos, total);
                    break;
                case 2:
                    ordenarAlunosPorMatricula(alunos, total);
                    break;
                case 3:
                    ordenarAlunosPorNome(alunos, total);
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    sc.nextLine();
            }
        }
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < total[0]; i++) {
            System.out.println("Nome: " + alunos[i].nome);
            System.out.println("Matricula: " + alunos[i].matricula);
            System.out.println("Notas:");
            System.out.println("N1: " + String.format("%.2f", alunos[i].notas[0]) + ", N2: " + 
                String.format("%.2f", alunos[i].notas[1]) + ", N3: " + String.format("%.2f", alunos[i].notas[2]));
            System.out.println("Media: " + String.format("%.2f", alunos[i].media));
            System.out.println("-----------------------------------------------");
        }
    }
    public static void buscarAluno(aluno[] alunos, String nome, int[] total) {
        boolean encontrado = false;
        for (int i = 0; i < total[0]; i++) {
            if (nome.equalsIgnoreCase(alunos[i].nome)) {
                System.out.println("Aluno encontrado!");
                System.out.println("-----------------------------------------------");
                System.out.println("Nome: " + alunos[i].nome);
                System.out.println("Matricula: " + alunos[i].matricula);
                System.out.println("Notas:");
                System.out.println("N1: " + String.format("%.2f", alunos[i].notas[0]) + ", N2: " + 
                    String.format("%.2f", alunos[i].notas[1]) + ", N3: " + String.format("%.2f", alunos[i].notas[2]));
                System.out.println("Media: " + String.format("%.2f", alunos[i].media));
                System.out.println("-----------------------------------------------");
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            System.out.println("Nenhum aluno de nome " + nome + " foi encontrado.");
        }
    }
    public static void ordenarAlunosPorNota(aluno[] alunos, int[] total) {
        aluno temp;
        for (int i = 0; i < total[0] - 1; i++) {
            for (int j = i + 1; j < total[0]; j++) {
                if (alunos[i].media > alunos[j].media) {
                    temp = alunos[i];
                    alunos[i] = alunos[j];
                    alunos[j] = temp;
                }
            }
        }
    }
    public static void ordenarAlunosPorMatricula(aluno[] alunos, int[] total) {
        aluno temp;
        for (int i = 0; i < total[0] - 1; i++) {
            for (int j = i + 1; j < total[0]; j++) {
                if (alunos[i].matricula > alunos[j].matricula) {
                    temp = alunos[i];
                    alunos[i] = alunos[j];
                    alunos[j] = temp;
                }
            }
        }
    }
    public static void ordenarAlunosPorNome(aluno[] alunos, int[] total) {
        aluno temp;
        int resultado;
        for (int i = 0; i < total[0] - 1; i++) {
            for (int j = i + 1; j < total[0]; j++) {
                resultado = (alunos[i].nome).compareToIgnoreCase(alunos[j].nome);
                if (resultado > 0) {
                    temp = alunos[i];
                    alunos[i] = alunos[j];
                    alunos[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        int n = 9, checkup = 0, idx;
        char option = 'X';
        aluno[] a;
        int[] cadastros = {0};
        String nomeTeste;
        while (n < 10 || n > 60) {
            System.out.println("Com quantos alunos deseja operar?");
            n = sc.nextInt();
            if (n < 10 || n > 60) System.out.println("Nao podemos operar com esta quantidade.");
        }
        a = new aluno[n];
        sistemaNotas.inicializarVetor(a, n);
        while (option != '0') {
            sistemaNotas.mostrarMenu();
            option = Character.toUpperCase(sc.next().charAt(0));
            switch (option) {
                case 'A':
                    if (cadastros[0] == n) {
                        System.out.println("Limite do vetor atingido!");
                        break;
                    }
                    if (checkup == 0) inicializarVetor(a, n);
                    cadastrarAluno(a, cadastros);
                    checkup = 1;
                    break;
                case 'B':
                    if (checkup == 0) {
                        System.out.println("Nao ha alunos para registrar nota!");
                        break;
                    } else {
                        System.out.println("Insira um nome para a procura do aluno:");
                        sc.nextLine();
                        nomeTeste = sc.nextLine();
                        registrarNotas(a, nomeTeste, cadastros);
                        idx = buscarIndiceNoVetor(a, nomeTeste, cadastros);
                        a[idx].media = calcularMedia(a[idx].notas);
                    }
                    break;
                case 'C':
                    if (checkup == 0) {
                        System.out.println("Nao ha alunos para listar!");
                        break;
                    } else {
                        listarAlunos(a, cadastros);
                    }
                    break;
                case 'D':
                    if (checkup == 0) {
                        System.out.println("Nao ha alunos para buscar!");
                        break;
                    } else {
                        System.out.println("Insira um nome para a procura do aluno:");
                        sc.nextLine();
                        nomeTeste = sc.nextLine();
                        buscarAluno(a, nomeTeste, cadastros);
                    }
                    break;
                case '0':
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    sc.nextLine();
            }
        }
        sc.close();
    }
}