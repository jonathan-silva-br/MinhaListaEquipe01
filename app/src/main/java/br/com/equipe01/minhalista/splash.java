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

/**
 * Classe para a splash screen
 * Colocando todos os métodos que vou ultilizar na activity
 * @author  Eduarda <eduarda.jen@gmail.com>
 */
public class splash extends AppCompatActivity {
    Animation letras;
    ImageView principal;
    TextView titulo;

    /**
     * Está criando uma nova Activity para implementar a Splash Screen
     * @param savedInstanceState
     * @return void
     * @author  Eduarda <eduarda.jen@gmail.com>
     *
     */


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            principal = findViewById(R.id.principal);
            setContentView(R.layout.activity_splash);
            delaySplash();


        }

    /**
     * Inicia a main activity após o surgimento da splash sreen
     *
     * Utilizando a intent para iniciar a main activity.
     *
     * @return void
     *
     *
     */
        private void mostrarMainActivity() {
            Intent intent = new Intent(
                splash.this, MainActivity.class
            );
            startActivity(intent);
            finish();

        }

    /**
     * Mostrando a splash screen
     *
     * Chamando a animacao do titulo
     * Ultilizando O Handler para fazer um encadeamento de Menssagem/Metodo
     * Ultilizando o Runnable para iniciar outra tarefa, no caso Mostra a MainActivity
     *
     *
     * @param delay - Determina o tempo que a Activity sera executada
     * @return void
     */
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



    /**Iniciando animação "Aparecer o titulo"
     * Está inflando o textView na tela e dando start na animacao
     * @return void
     */

    private void animationSplash() {
        titulo = findViewById(R.id.titulo);
        Animation AparecerTitulo = AnimationUtils.loadAnimation(this, R.anim.letras);
        titulo.startAnimation(AparecerTitulo);

    }

    /** Determinando o tempo de delay
     * @return void
     */
    private void delaySplash(){

        mostrarSplash(1500);

        }
    }
