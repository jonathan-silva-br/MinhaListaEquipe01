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

public class ToolsFragment extends Fragment {

    EditText txtNome;
    EditText txtEmail;
    Button btnDados;

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