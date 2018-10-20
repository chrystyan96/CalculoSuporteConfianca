package regrasassociacao.interfaces;

public interface IRegras {
    public double calcularSuporte(double x, double y);
    public double calcularConfianca(double x, double y);
    public String getNomeLista(int pos);
}
