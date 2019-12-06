package br.com.equipe01.minhalista.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import br.com.equipe01.minhalista.MainActivity;
import br.com.equipe01.minhalista.R;

/**
 *
 *   Classe do fragmento principal que possui a lista com os produtos
 *
 *   Dentro dessa classe, temos a classe que extende o fragmento Home
 * que é a parte principal onde tem as listas com os produtos.
 * Possuindo uma forma de marcar a linha clicada para melhor entendimento
 * do usuário. Dentro do XML temos dois botões, um para adicionar novos
 * produtos e outro para adicionar os produtos selecionados dentro
 * da lista.
 *
 *
 * @author          Matheus Vinícius <matheusgeiser@gmail.com>
 *
 */


public class HomeFragment extends Fragment {

    //Botão de adicionar produtos ao array da Main
    Button add;

    //List com todos os produtos cadastrados
    private List<String> produtos = todosOsProdutos();

    //List com todos os produtos selecionados
    public static List<String> listaProdutos = new ArrayList<>();

    //List com as posições dos itens que foram clicados
    private ArrayList<Integer> verif = new ArrayList<>();


    /**
     *
     *  View do fragmento da tela principal com a lista dos produtos e dois botões
     *
     *  Esta view possui dois botões e uma função de onItemClick.
     *  no onItemClick ele pinta de azul o item clicado da ListView, possui uma verificação
     *  se o item já foi clicado ou não. Se for clicado, fica azul se não, fica branco.
     *
     *  Botão que adiciona os produtos selecionados à lista da MainActivity para ser utilizada
     *  em outro fragmento
     *
     *
     * @author Matheus Vinícius <matheusgeiser@gmail.com>
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        //List view dos produtos
        final ListView lvProdutos = root.findViewById(R.id.lvProdutos);

        ArrayAdapter<String> ad = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, produtos);

        lvProdutos.setAdapter(ad);


        //Adicionando valor aleatório ao vetor para não der erro de IndexOutOfBounds no FOR do OnItemClick
        verif.add(32313213);

        lvProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Mudando a cor para azul quando selecionado
                view.setBackgroundColor(Color.parseColor("#33b5e5"));

                boolean a = false;

                Object obj = parent.getItemAtPosition(position);

                String aaa = obj.toString();

                    //For que verifica se o item já foi clicado uma vez, se sim ele muda a cor do fundo
                    //E retira os valores dos arrays
                    for(int i = 0; i < verif.size(); i++){

                        if(verif.get(i) == position) {

                            view.setBackgroundColor(Color.parseColor("#ffffff"));
                            verif.remove(i);

                            for (int j = 0; j < listaProdutos.size(); j++){

                                if( aaa.equals(listaProdutos.get(j))){
                                    listaProdutos.remove(j);
                                }

                            }

                            a = true;

                            break;
                        }
                    a=false;
                }

                if(!a){
                    verif.add(position);
                    listaProdutos.add(aaa);
                }

            }
        });


        add = root.findViewById(R.id.buttonadd);

        //Ação do botão que adiciona os produtos à lista
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> listMain = MainActivity.listaProdutosSelecionados; //Array com as informações dos produtos que já foram selecionados

                //Verificação
                for(int j = 0; j < listaProdutos.size(); j++){

                    if(listMain.size() == 0){

                        MainActivity.listaProdutosSelecionados.add(listaProdutos.get(j));
                        Toast.makeText(getContext(),"Produtos adicionados", Toast.LENGTH_LONG).show();

                    }else{

                        for(int i = 0; i<listMain.size(); i++){
                            if (!listMain.get(i).equalsIgnoreCase(listaProdutos.get(j))){
                                //Adicionando valores selecionados no arrayList da Main
                                MainActivity.listaProdutosSelecionados.add(listaProdutos.get(j));
                                Toast.makeText(getContext(),"Produtos adicionados", Toast.LENGTH_LONG).show();
                            }
                        }
                    }


                }


                //Laço que pinta de branco todas as views dentro do ListView
                //
                for(int i = 0; i < lvProdutos.getChildCount(); i++){

                    View viewPintada =  lvProdutos.getChildAt(i);
                    viewPintada.setBackgroundColor(Color.parseColor("#ffffff"));

                    for(int j = 0; j < verif.size(); j++){

                        if(verif.get(j) == lvProdutos.getChildCount()){
                            verif.remove(j);
                        }

                    }


                }

            }
        });


        return root;

    }


    /**
     * Pré cadastrando produtos
     *
     * Esse método pega a lista da classe MainActivity para
     * adicionar produtos.
     *
     * @return retorna uma lista com os produtos adicionados
     */
    public List<String> todosOsProdutos(){

        List<String> produtos = new ArrayList<>();
        produtos.add("Batata");
        produtos.add("Pão Francês");
        produtos.add("Margarina");
        produtos.add("Geléia");

        return produtos;
    }




}






