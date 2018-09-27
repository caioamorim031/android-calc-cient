package techworks.com.br.calctemp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import techworks.com.br.calctemp.R;

public class telaCalculadora extends Activity {

   private String expressao = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calculadora);
        EditText campoDisplay = (EditText)findViewById(R.id.vlResultado);

        campoDisplay.setKeyListener(null);
    }

    public void onClick(View v){
        //Recuperando dados
        Button botaoSelecionado = (Button)findViewById(v.getId());
        String valorBotao = (String) botaoSelecionado.getText();

        EditText campoDisplay = (EditText)findViewById(R.id.vlResultado);
        campoDisplay.setText(campoDisplay.getText() + valorBotao);

    }

}
