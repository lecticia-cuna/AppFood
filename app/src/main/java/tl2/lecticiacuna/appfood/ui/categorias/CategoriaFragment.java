package tl2.lecticiacuna.appfood.ui.categorias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import tl2.lecticiacuna.appfood.R;
import tl2.lecticiacuna.appfood.adapters.NavCategoriaAdapter;
import tl2.lecticiacuna.appfood.adapters.PopularAdapters;
import tl2.lecticiacuna.appfood.models.NavCategoriaModel;
import tl2.lecticiacuna.appfood.models.PopularModel;


public class CategoriaFragment extends Fragment {

    List<NavCategoriaModel> categoriaModelList;
    RecyclerView categoriaRecycle;
    NavCategoriaAdapter navCategoriaAdapter;

    FirebaseFirestore db;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_categorias, container, false);

        db= FirebaseFirestore.getInstance();
        categoriaRecycle = root.findViewById(R.id.rec_categorias);

        //Popular Items
        categoriaRecycle.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
        categoriaModelList = new ArrayList<>();
        navCategoriaAdapter= new NavCategoriaAdapter(getActivity(),categoriaModelList);
        categoriaRecycle.setAdapter(navCategoriaAdapter);


        db.collection("NavCategorias")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {



                                NavCategoriaModel navCategoriaModel = document.toObject(NavCategoriaModel.class);
                                categoriaModelList.add(navCategoriaModel);
                                navCategoriaAdapter.notifyDataSetChanged();

                            }

                        }else {
                            Toast.makeText(getActivity(), "Error"+ task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}