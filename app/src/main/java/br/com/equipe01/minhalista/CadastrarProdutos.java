package br.com.equipe01.minhalista;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;

/**Nova Activity para Cadastro de Novos Produtos no app
 * @author  Jonathan Silva <>silva_jonathan@outlook.com.br</>
 */

public class CadastrarProdutos extends AppCompatActivity {

    /** Método onCreate que inicia a Activity.
     *  Inicia a Activity baseada no layout desenvolvido na activity_cadastrar_produtos.     *
     * @param savedInstanceState Salva o estado da Activity para recria-la no mesmo ponto em que foi destruída.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produtos);
        Toolbar toolbar = findViewById(R.id.toolbar);
    }
}


