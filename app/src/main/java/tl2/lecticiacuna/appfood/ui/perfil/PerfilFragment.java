package tl2.lecticiacuna.appfood.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import tl2.lecticiacuna.appfood.R;


public class PerfilFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_perfil, container,false);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}