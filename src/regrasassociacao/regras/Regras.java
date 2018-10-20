package regrasassociacao.regras;

import java.util.ArrayList;
import regrasassociacao.interfaces.IRegras;

public class Regras implements IRegras{
    private String[][] transacao = {
                                    {"não", "sim", "não", "sim", "sim", "não", "não"}, 
                                    {"sim", "não", "sim", "sim", "sim", "não", "não"},
                                    {"não", "sim", "não", "sim", "sim", "não", "não"},
                                    {"sim", "sim", "não", "sim", "sim", "não", "não"},
                                    {"não", "não", "sim", "não", "não", "não", "não"},
                                    {"não", "não", "não", "não", "sim", "não", "não"},
                                    {"não", "não", "não", "sim", "não", "não", "não"},
                                    {"não", "não", "não", "não", "não", "não", "sim"},
                                    {"não", "não", "não", "não", "não", "sim", "sim"},
                                    {"não", "não", "não", "não", "não", "sim", "não"}
    };
    private ArrayList<String> nomeList = new ArrayList<String>();
    private int linhas;
    private int colunas;
    
    public Regras() {
        nomeList.add("Leite");
        nomeList.add("Café");
        nomeList.add("Cerveja");
        nomeList.add("Pão");
        nomeList.add("Manteiga");
        nomeList.add("Arroz");
        nomeList.add("Feijão");
    }
    
    @Override
    public double calcularSuporte(double x, double y) {
        return (getRegistros(x) * getRegistros(y)) / tamanhoMatriz();
    }
    
    @Override
    public double calcularConfianca(double x, double y) {
        return (getRegistros(x) * getRegistros(y)) / getRegistros((int)x);
    }
    
    @Override
    public String getNomeLista(int pos) {
        return nomeList.get(pos);
    }
    
    private int tamanhoMatriz() {
        if(transacao.length > 0) {
            linhas = transacao.length;
            colunas = transacao[0].length;
        }
        return linhas * colunas;
    }
    
    private double getRegistros(double val) {
        int aux = 0;
        for(int i = 0; i < transacao.length; ++i) {
            if(transacao[i][(int)val].equals("sim")) {
                aux++;
            }
        }
        return aux;
    }
}
