package techworks.com.br.calctemp.controlador;

import techworks.com.br.calctemp.model.ValorCalculadora;
import techworks.com.br.calctemp.util.ConstantesOperacoes;
import techworks.com.br.calctemp.util.UtilBotoes;

public class ControllerOperacoesMatematicas {
    private static final ControllerOperacoesMatematicas ourInstance = new ControllerOperacoesMatematicas();

    public static ControllerOperacoesMatematicas getInstance() {
        return ourInstance;
    }

    public void isValorBotaoOperacaoNumerica(String textoBotao){

    }

    public float resolverEquacao(String expressao){
        String[] expressaoDividida = {};
        String[] operacoesExpressao = {};
        int qtdExpressoes = 0;
        int qtdOperacoes = 0;

        if(!expressao.isEmpty()){

            for(int i = 0; i < expressao.length(); i++){
                String expressaoAtual = "";

                if(expressao.charAt(i) == ConstantesOperacoes.BOTAO_DIVISAO  ||
                   expressao.charAt(i) == ConstantesOperacoes.BOTAO_MULTIPLICACAO   ||
                    Character.isDigit(expressao.charAt(i)) ){
                    expressaoAtual = expressaoAtual.concat(""+ expressao.charAt(i));

                    if(i == expressao.length() - 1){
                        expressaoDividida[qtdExpressoes] = expressaoAtual;
                        qtdExpressoes++;
                    }

                }else{
                    expressaoDividida[qtdExpressoes] = expressaoAtual;
                    expressaoAtual = "";
                    qtdExpressoes++;
                    operacoesExpressao[qtdOperacoes] = ""+ expressao.charAt(i);
                    qtdOperacoes++;
                }
            }

            return calcularArrayExpressao(expressaoDividida, operacoesExpressao, 0, 0);


        }
        return 0;
    }

    private float obterValorCelula(String[] arrayValores, int posicaoAtual){
        String celulaAtual = arrayValores[posicaoAtual];
        String[] valores = {};
        String[] operacoes = {};
        int qtdValores = 0;
        int qtdOperacoes = 0;
        String valorAtual = "";

        for(int i = 0; i < celulaAtual.length(); i++){
            if(Character.isDigit(celulaAtual.charAt(i))){
                valorAtual = valorAtual.concat("" + celulaAtual.charAt(i));

                if(i == celulaAtual.length() - 1){
                    valores[qtdValores] = valorAtual;
                    qtdValores++;
                }

            }else {
                valores[qtdValores] = valorAtual;
                valorAtual = "";
                operacoes[qtdOperacoes] = "" + celulaAtual.charAt(i);
                qtdValores++;
                qtdOperacoes++;
            }
        }
        return calcularArrayCelulaPrioritaria(operacoes,valores,0,0);
    }

    private float calcularArrayExpressao(String[] expressao, String[] operacoes, int celAtual, int opAtual){
        if(celAtual == expressao.length - 1){
            return obterValorCelula(expressao, celAtual);
        }else{
            float valorFinal = obterValorCelula(expressao, celAtual);
            if(operacoes[opAtual].equals(ConstantesOperacoes.BOTAO_SOMA)){
                return valorFinal + calcularArrayExpressao(expressao,operacoes,celAtual++,opAtual++);
            }else{
                return valorFinal - calcularArrayExpressao(expressao,operacoes,celAtual++,opAtual++);
            }
        }
    }

    private float calcularArrayCelulaPrioritaria(String[] operacoes, String[] valores, int opAtual, int vlAtual){
        if(vlAtual == valores.length - 1){
            return Float.parseFloat(valores[vlAtual]);
        }else{
            float valorFinal = Float.parseFloat(valores[vlAtual]);
            if(operacoes[opAtual].equals(ConstantesOperacoes.BOTAO_DIVISAO)){
                return valorFinal / calcularArrayCelulaPrioritaria(operacoes,valores,opAtual++,vlAtual++);
            }else{
                return valorFinal * calcularArrayCelulaPrioritaria(operacoes,valores,opAtual++,vlAtual++);
            }
        }
    }

    public String inserirNovoBotao(String expressao, String botaoApertado){

        if(!expressao.isEmpty()){

        }

        ValorCalculadora vlCalculadora = ValorCalculadora.getInstance();

        if(!UtilBotoes.isValorOperacao(botaoApertado)){
            String ultimoValorAdicionado = vlCalculadora.getValorAtual();
            vlCalculadora.setValorAtual(ultimoValorAdicionado.concat(botaoApertado));
        } else {

        }



        return "";
    }


}
