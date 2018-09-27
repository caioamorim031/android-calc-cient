package techworks.com.br.calctemp.controlador;

public class ControllerOperacoesMatematicas {
    private static final ControllerOperacoesMatematicas ourInstance = new ControllerOperacoesMatematicas();

    public static ControllerOperacoesMatematicas getInstance() {
        return ourInstance;
    }

    private ControllerOperacoesMatematicas() {
    }
}
