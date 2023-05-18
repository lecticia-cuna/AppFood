package tl2.lecticiacuna.appfood.ui.categorias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import tl2.lecticiacuna.appfood.R;


public class CategoriaFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_categorias, container, false);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}