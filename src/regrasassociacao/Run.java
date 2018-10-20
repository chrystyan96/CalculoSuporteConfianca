package regrasassociacao;

import java.util.Scanner;
import regrasassociacao.interfaces.IRegras;
import regrasassociacao.regras.Regras;

public class Run {
    public static void main(String[] args) {
        boolean controlador = false;
        double x = 0;
        double y = 0;
        String xString = "";
        String yString = "";
        String aux = "";
        Scanner ler = new Scanner(System.in);
        IRegras regras = new Regras();
        
        System.out.println("Atividade da Matéria Banco de Dados II");
        System.out.println("Ministrada por Pablo Florentino");
        System.out.println("Aluno: Chrystyan Byrnes");
        System.out.println();
        System.out.println("Regras de Associação - Calculo de Confiança e Suporte");
        System.out.println();
        
        controlador = true;
        while(controlador) {
            itensLista("primeiro");
            aux = ler.next();
            if(aux.matches("^[0-9]*$")) {
                x = Double.parseDouble(aux);
                if(x > 0 && x < 8) { 
                    xString = regras.getNomeLista((int)x-1);
                    clearConsole();
                    controlador = false; 
                } else {
                    clearConsole();
                    System.out.println("Opção inválida!!");
                    System.out.println();
                }
            } else {
                clearConsole();
                System.out.println("Digite somente números!");
                System.out.println();
            }
        }
        
        controlador = true;
        while(controlador) {
            itensLista("segundo");
            aux = ler.next();
            if(aux.matches("^[0-9]*$")) {
                y = Integer.parseInt(aux);
                if(y > 0 && y < 8) { 
                    yString = regras.getNomeLista((int)y-1);
                    clearConsole();
                    controlador = false; 
                } else {
                    clearConsole();
                    System.out.println("Opção inválida!!");
                    System.out.println();
                }
            } else {
                clearConsole();
                System.out.println("Digite somente números!");
                System.out.println();
            }
        }
        
        clearConsole();
        System.out.println("O calculo da confiança entre " + xString + " e " + yString + " é de:");
        System.out.printf("%.0f %n", regras.calcularConfianca((x-1), (y-1)));
        System.out.println();
        System.out.println("O calculo do suporte entre " + xString + " e " + yString + " é de:");
        System.out.printf("%.3f %n", regras.calcularSuporte((x-1), (y-1)));
    }
    
    private static void itensLista(String ordem) {
        System.out.println("Escolha o " + ordem + " valor para o calculo:");
        System.out.println("1 - Leite");
        System.out.println("2 - Café");
        System.out.println("3 - Cerveja");
        System.out.println("4 - Pão");
        System.out.println("5 - Manteiga");
        System.out.println("6 - Arroz");
        System.out.println("7 - Feijão");
    }
    
    private final static void clearConsole() {
        for(int i = 0; i < 1000; i++) {
            System.out.println();
        }
    }
}
