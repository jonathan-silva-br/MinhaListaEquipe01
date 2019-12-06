package br.com.equipe01.minhalista.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import br.com.equipe01.minhalista.MainActivity;
import br.com.equipe01.minhalista.R;


/**
 *
 *  Classe do fragmento do usuário que contem todas as funcionalidades da tela
 *
 * Essa classe é a responsável pelas funcionalidades dos elementos que estão
 * no XML, contendo captura de dados dos EditTexts e a ação do botão que
 * altera os dados das variáveis globais da MainActivity para os dados
 * que o usuário digitou nos campos de input
 *
 * @author Matheus Vinícius <matheusgeiser@gmail.com>
 *
 */

public class ToolsFragment extends Fragment {

    EditText txtNome;
    EditText txtEmail;
    Button btnDados;


    /**
     *
     *  Método que contém todas as ações da tela do usuário
     *
     *  Logo ao criar a View, ele infla na tela o xml do fragmento,
     *  depois pega os componentes que estão dentro do xml para realizar
     *  as alterações.
     *
     *  Logo temos uma verificação para ver se é a primeira vez que o usuário
     *  entra nesta tela, pois o valor padrão da variável que está na
     *  MainActivity, pois se não for igual ao valor que está na Main, então
     *  o nome do botão é alterado e o hint (placeholder) do EditText
     *  recebe os valores que estão salvos.
     *
     *  Logo depois temos a ação do botão que atribui as informações dos campos
     *  para as variáveis. Guardando o valor dos inputs dentro de variáveis e
     *  verificando se o campo está sem caracteres para que a alteração não
     *  ocorra caso os inputs estejam vazios. Se os campos não estiverem
     *  vazios, a informação dos inputs são enviadas para as variáveis
     *  globais que estão dentro da Main, que são puxadas para o TextView
     *  do menu lateral.
     *
     *
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tools, container, false);

        //Pegando componentes de input do XML
        txtNome = (EditText)root.findViewById(R.id.txtNome);
        txtEmail = (EditText)root.findViewById(R.id.txtEmail);

        //Botão de alteração
        btnDados = root.findViewById(R.id.btnConfirmarInfos);

        TextView lblTexto = root.findViewById(R.id.lblCima);

        if(!MainActivity.nomeUsuario.equals("Você")){
            btnDados.setText("Alterar Dados");

            lblTexto.setText("Altere seus dados");

            txtNome.setHint(MainActivity.nomeUsuario);
            txtEmail.setHint(MainActivity.emailUsuario);

            txtNome.setText(MainActivity.nomeUsuario);
            txtEmail.setText(MainActivity.emailUsuario);

        }

        btnDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Capturando valores dos inputs
                String nome =  txtNome.getText().toString();
                String email =  txtEmail.getText().toString();


                //Verificação para ver se os valores capturados dos campos são nulos
                //Se não forem, prossegue com as alterações na navigation view
                if(nome.equals("") ||  email.equals("")) {
                    Toast.makeText(getActivity(), "Preencha os campos", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.emailUsuario=email;
                    MainActivity.nomeUsuario=nome;
                    Toast.makeText(getActivity(),"Informações alteradas",Toast.LENGTH_LONG).show();
                    btnDados.setEnabled(false);
                }

            }
        });

        return root;
    }




}