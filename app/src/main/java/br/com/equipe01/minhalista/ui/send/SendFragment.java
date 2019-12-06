package br.com.equipe01.minhalista.ui.send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import br.com.equipe01.minhalista.R;

public class SendFragment extends Fragment {

    /**
     * Criando fragemnto para tela ajuda
     * @param inflater
     * @param container
     * @param savedInstanceState
     *
     * @return root
     *
     * @author Eduarda <eduarda.jen@gmail.com>
     *
     */

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_send, container, false);


        return root;
    }
}