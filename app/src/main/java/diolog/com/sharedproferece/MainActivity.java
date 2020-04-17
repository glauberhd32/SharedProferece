package diolog.com.sharedproferece;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText textonome;
    private Button botao;
    private TextView textoExibicao;
    private static final String AQUIVO_PREFERENCIA ="ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textonome = (EditText)findViewById(R.id.textoNomeId);
        textoExibicao = (TextView)findViewById(R.id.resultadoId);
        botao =(Button)findViewById(R.id.botaoId);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(AQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor =sharedPreferences.edit();

                if(textonome.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"por favor prencheer o nome. ",Toast.LENGTH_LONG).show();
                }else{
                    editor.putString("nome",textonome.getText().toString());
                    editor.commit();
                    textoExibicao.setText("Ola,"+textonome.getText().toString());
                }
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences(AQUIVO_PREFERENCIA,0);
        if(sharedPreferences.contains("nome")){
            String nomeUsuario = sharedPreferences.getString("nome","Usuario n definido");
            textoExibicao.setText("Ola , " +nomeUsuario);
        }else{
            textoExibicao.setText("Ola usuario não definido");
        }
    }
}
