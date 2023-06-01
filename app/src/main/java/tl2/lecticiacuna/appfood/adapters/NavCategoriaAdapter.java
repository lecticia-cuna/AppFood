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
import tl2.lecticiacuna.appfood.models.NavCategoriaModel;

public class NavCategoriaAdapter extends RecyclerView.Adapter<NavCategoriaAdapter.ViewHolder> {

    Context context;
    List<NavCategoriaModel> navCategoriaList;


    public NavCategoriaAdapter(Context context, List<NavCategoriaModel> navCategoriaList) {
        this.context = context;
        this.navCategoriaList = navCategoriaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_cat_item,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(navCategoriaList.get(position).getImg_url()).into(holder.imageView);
        holder.nome.setText(navCategoriaList.get(position).getNome());
        holder.descricao.setText(navCategoriaList.get(position).getDescricao());
        holder.desconto.setText(navCategoriaList.get(position).getDesconto());


    }



    @Override
    public int getItemCount() {
        return navCategoriaList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nome, descricao, desconto;

       /* public ViewHolder(@NonNull View itemView, ImageView imageView, TextView nome, TextView descricao, TextView desconto) {
            super(itemView);
            this.imageView = imageView;
            this.nome = nome;
            this.descricao = descricao;
            this.desconto = desconto;
        }*/

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.rec_img);
            nome = itemView.findViewById(R.id.rec_nome);
            descricao = itemView.findViewById(R.id.rec_descricao);
            imageView= itemView.findViewById(R.id.rec_descricao);
        }
    }
}
