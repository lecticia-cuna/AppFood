package tl2.lecticiacuna.appfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import tl2.lecticiacuna.appfood.R;
import tl2.lecticiacuna.appfood.models.CategoriaHome;

public class CategoryHomeAdapter extends RecyclerView.Adapter<CategoryHomeAdapter.ViewHolder> {

    /*depois de criar a classe com os componentes da categoria, criamos o adapter e extendemos o
    * recycleView e importamos todos os metodos e tal */

    //criar o context e a lista que ira receber o model que foi anteriormente criado

    Context context;
    List<CategoriaHome> listaCategorias;

    public CategoryHomeAdapter(Context context, List<CategoriaHome> listaCategorias) {
        this.context = context;
        this.listaCategorias = listaCategorias;
    }

    @NonNull
    @Override
    public CategoryHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_home,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHomeAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(listaCategorias.get(position).getImg_url()).into(holder.catImg);
        holder.nome.setText(listaCategorias.get(position).getNome());

    }

    @Override
    public int getItemCount() {
        return listaCategorias.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView catImg;
        TextView nome;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            catImg = itemView.findViewById(R.id.home_categoria_img);
            nome = itemView.findViewById(R.id.home_categoria_nome);
        }
    }
}
