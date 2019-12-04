package br.com.equipe01.minhalista;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {
    Animation letras;
    ImageView principal;
    TextView titulo;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            principal = findViewById(R.id.principal);
            setContentView(R.layout.activity_splash);
            delaySplash();


        }

        //Metodo que inicia a main activity depois da splash
        private void mostrarMainActivity() {
            Intent intent = new Intent(
                splash.this, MainActivity.class
            );
            startActivity(intent);
            finish();

        }

        //Splash screen
        private void mostrarSplash(int delay) {

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mostrarMainActivity();
                }
            }, delay);

            animationSplash();


        }
    //Metodo que guarda a informação de que o aplicativo ja foi aberto outras vezes

    private void adicionarPreferenceJaAbriu(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("open", true);
        editor.commit();
    }
    //Iniciando animação Aparecer o titulo
    private void animationSplash() {
        titulo = findViewById(R.id.titulo);
        Animation AparecerTitulo = AnimationUtils.loadAnimation(this, R.anim.letras);
        titulo.startAnimation(AparecerTitulo);

    }
//Metodo que inicia a splash com o delay determinado;
    //Se o aplicativo nunca foi aberto o delay é maior

    private void delaySplash(){

        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);

        if (preferences.contains("open")) {
            mostrarSplash(1500);
        } else {
            adicionarPreferenceJaAbriu(preferences);
            mostrarSplash(2000);
        }
    }
}