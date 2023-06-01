package tl2.lecticiacuna.appfood.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
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
import tl2.lecticiacuna.appfood.adapters.CategoryHomeAdapter;
import tl2.lecticiacuna.appfood.adapters.PopularAdapters;
import tl2.lecticiacuna.appfood.adapters.RecommendedAdapter;
import tl2.lecticiacuna.appfood.databinding.FragmentHomeBinding;
import tl2.lecticiacuna.appfood.models.CategoriaHome;
import tl2.lecticiacuna.appfood.models.PopularModel;
import tl2.lecticiacuna.appfood.models.RecommendedModel;


public class HomeFragment extends Fragment {

    RecyclerView popularRV, categoriaRV, recommendedRV;
    FirebaseFirestore db;

    private FragmentHomeBinding binding;


    //Popular Items
    PopularAdapters popularAdapters;
    List<PopularModel> popularModelList;

    //Categoria Home
    List<CategoriaHome> categoriasList;
    CategoryHomeAdapter categoryAdapter;

    // Recommended Home
    List<RecommendedModel> recommendedModelList;
    RecommendedAdapter recommendedAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        db = FirebaseFirestore.getInstance();

        popularRV = root.findViewById(R.id.popular_rec);
        categoriaRV = root.findViewById(R.id.explore_rec);
        recommendedRV = root.findViewById(R.id.recomendados_rec);




        //Popular Items
        popularRV.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
        popularModelList = new ArrayList<>();
        popularAdapters = new PopularAdapters(getActivity(),popularModelList);
        popularRV.setAdapter(popularAdapters);


        db.collection("PopularProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {



                                PopularModel popularModel = document.toObject(PopularModel.class);
                                popularModelList.add(popularModel);
                                popularAdapters.notifyDataSetChanged();

                            }

                        }else {
                            Toast.makeText(getActivity(), "Error"+ task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        //Category Items
        categoriaRV.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
        categoriasList = new ArrayList<>();
        categoryAdapter = new CategoryHomeAdapter(getActivity(),categoriasList);
        categoriaRV.setAdapter(categoryAdapter);


        db.collection("CategoriasHome")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                CategoriaHome categoriaHome = document.toObject(CategoriaHome.class);
                                categoriasList.add(categoriaHome);
                                categoryAdapter.notifyDataSetChanged();

                            }

                        }else {
                            Toast.makeText(getActivity(), "Error"+ task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });



        //Recommended Items

        recommendedRV.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
        recommendedModelList = new ArrayList<>();
        recommendedAdapter = new RecommendedAdapter(getActivity(),recommendedModelList);
        recommendedRV.setAdapter(recommendedAdapter);


        db.collection("RecommendedProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                RecommendedModel recommendedModel = document.toObject(RecommendedModel.class);
                                recommendedModelList.add(recommendedModel);
                                recommendedAdapter.notifyDataSetChanged();

                            }

                        }else {
                            Toast.makeText(getActivity(), "Error"+ task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });



        // final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}