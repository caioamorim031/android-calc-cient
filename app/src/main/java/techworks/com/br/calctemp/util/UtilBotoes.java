package techworks.com.br.calctemp.util;

import techworks.com.br.calctemp.controlador.ControllerOperacoesMatematicas;

public class UtilBotoes {

    public static boolean isValorOperacao(String textoBotao){

        if( textoBotao.equals(ConstantesOperacoes.BOTAO_SUBTRACAO)      ||
                textoBotao.equals(ConstantesOperacoes.BOTAO_SOMA)           ||
                textoBotao.equals(ConstantesOperacoes.BOTAO_DIVISAO)        ||
                textoBotao.equals(ConstantesOperacoes.BOTAO_MULTIPLICACAO)  ||
                textoBotao.equals(ConstantesOperacoes.BOTAO_FATORIAL)       ||
                textoBotao.equals(ConstantesOperacoes.BOTAO_POTENCIA)       ||
                textoBotao.equals(ConstantesOperacoes.BOTAO_RDIVISAO)    ){
            return true;
        }
        return false;
    }

    public static boolean isBotaoPressionadoValido(String display, String botaoPressionado){
        if(!display.isEmpty()){
            char ultimoCaractere = display.charAt(display.length() - 1);
            if(isValorOperacao(Character.toString(ultimoCaractere)) && isValorOperacao(botaoPressionado)){
                return false;
            }
        }else if(isValorOperacao(botaoPressionado)){
            return false;
        }
            return true;
    }

    public static String persistirValorBotao(String caractere){
        if(caractere.equals("x!")){
            return Character.toString(ConstantesOperacoes.BOTAO_FATORIAL);
        }else if(caractere.equals("xy")){
            return Character.toString(ConstantesOperacoes.BOTAO_POTENCIA);
        }else {
            return caractere;
        }
    }

}
