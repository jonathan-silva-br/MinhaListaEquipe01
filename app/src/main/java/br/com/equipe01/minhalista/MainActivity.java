package br.com.equipe01.minhalista;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    public NavigationView navigationView;

    //Variável que armazenará o nome do usuário
    public static String nomeUsuario;

    //Variável que armazenará o email
    public static String emailUsuario;

    //Variáveis que armazenarão os textviews do menu lateral
    public TextView nomeU;
    public TextView emailU;

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
                R.id.nav_principal, R.id.nav_usuario, R.id.nav_listas,
                R.id.nav_configuracoes, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

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
     *
     *
     * return void
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
     * Através de SharedPreferences, recupera os dados salvados anteriormente no método saveData()
     *
     * return void
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



}
