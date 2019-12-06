package br.com.equipe01.minhalista;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public NavigationView navigationView;

    //Variável que armazenará o nome do usuário
    public static String nomeUsuario;
    AnimationDrawable rocketAnimation;

    //Variável que armazenará o email
    public static String emailUsuario;

    //Variáveis que armazenarão os textviews do menu lateral
    public TextView nomeU;
    public TextView emailU;
    

    //Array com os produtos
    public static List<String> listaProdutosSelecionados = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_menu);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_usuario, R.id.nav_listas, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        loadData();

    }


    /**
     *
     *  Ação de guardar informações nos TextViews
     *
     * Através do NavController, temos acesso aos ids dos componentes que
     * estão dentro da nav_host_fragment.xml que possui acesso à todas os
     * fragmentos através do mobile_navigation.xml.
     *
     * Temos duas variáveis globais que são os TextViews que eu desejo
     * alterar com as informações do usuário. Logo após pegar o id de cada
     * TextView, setamos o textviews com as informações das variáveis
     * globais que foram instanciadas no começo da Classe.
     *
     * Depois de fazer as alterações, é chamado o método saveData() que
     * realiza o salvamento dos dados que o usuário digitou.
     *
     *
     * @author Matheus Vinícius <matheusgeiser@gmail.com>
     *
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);


        nomeU =  navigationView.findViewById(R.id.nomeUsuario);
        emailU = navigationView.findViewById(R.id.emailUsuario);

        nomeU.setText(nomeUsuario);
        emailU.setText(emailUsuario);

        saveData();

        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    /**
     *  Método que salva dados do usuário
     *
     *
     * Através de SharedPreferences armazena as informações de nome e email
     * para que essas não se percam ao reiniciar o aplicativo
     * Intanciando o SharedPreferences e logo após iniciando o editor
     * para que possa ser possível inserir os dados que serão guardados.
     *
     *
     *
     * @author Matheus Vinícius <matheusgeiser@gmail.com>
     *
     * @return void
     *
     */

    public void saveData(){

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("nome",nomeUsuario);
        editor.putString("email",emailUsuario);

        editor.apply();

    }

    /**
     *
     * Método que carrega os dados salvos do usuário
     *
     * Através de SharedPreferences, recupera os dados salvados anteriormente
     * no método saveData() e armazena os valores do sharedPreferences dentro
     * das variáveis globais nomeUsuario e emailUsuario que foram
     * criadas no início da classe
     *
     * @author Matheus Vinícius <matheusgeiser@gmail.com>
     *
     * @return void
     *
     */

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);

        nomeU =  navigationView.findViewById(R.id.nomeUsuario);
        emailU = navigationView.findViewById(R.id.emailUsuario);

        nomeUsuario = sharedPreferences.getString("nome", "Você");
        emailUsuario = sharedPreferences.getString("email"," ");

        Log.i("teste",nomeUsuario+" - "+emailUsuario);

    }

    /**Animação do botão
     * Inflando o botão
     * O botão buttonadd agora é uma imageView
     * Qunado o botão ser clicado dará start na animação
     * As ações do botão deveram ser feitas a parti deste método
     * TODO Organizar as imagens da animação
     * TODO rever o metodo para passar de uma imagemView para outro
     * TODO Colocar outros métodos desse botão aqui
     * 
     * @param view
     */
    public void animacaoBtn(View view) {
        Button buttonAdd =  findViewById(R.id.buttonadd);
        buttonAdd.setBackgroundResource(R.drawable.animbutton);
        rocketAnimation = (AnimationDrawable) buttonAdd.getBackground();

    }

    /**
     * Método de chamada para ação de clicar em um botão.
     * Esse método onClick inicia a Activity CadastrarProdutos através de uma new Intent.   *
     * @author  Jonathan Silva <>silva_jonathan@outlook.com.br</>
     */

    public void onClick(View view){
        Intent cadastro = new Intent(this, CadastrarProdutos.class);
        startActivity(cadastro);
    }

}
