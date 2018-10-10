package techworks.com.br.calctemp.model;

public class ValorCalculadora {
    private static final ValorCalculadora ourInstance = new ValorCalculadora();

    public static ValorCalculadora getInstance() {
        return ourInstance;
    }

    private String valorAtual;
    private String[] expressao;
    private int qtdExpressoes;

    private ValorCalculadora() {
        this.valorAtual = "";
        this.qtdExpressoes = 0;
    }

    public void setValorAtual(String valorAtual) {
        this.valorAtual = valorAtual;
    }

    public void setExpressao(String[] expressao) {
        this.expressao = expressao;
    }

    public String getValorAtual() {
        return valorAtual;
    }

    public String[] getExpressao() {
        return expressao;
    }
}
