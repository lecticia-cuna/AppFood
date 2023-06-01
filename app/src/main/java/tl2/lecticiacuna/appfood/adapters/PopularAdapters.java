package tl2.lecticiacuna.appfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import tl2.lecticiacuna.appfood.R;
import tl2.lecticiacuna.appfood.models.NavCategoriaModel;
import tl2.lecticiacuna.appfood.models.PopularModel;

public class PopularAdapters extends RecyclerView.Adapter<PopularAdapters.ViewHolder> {

    private Context context;
    private List<PopularModel> popularModelList;

    public PopularAdapters(Context context, List<PopularModel> popularModelList) {
        this.context = context;
        this.popularModelList = popularModelList;
    }

    public PopularAdapters(FragmentActivity activity, List<NavCategoriaModel> categoriaModelList) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(popularModelList.get(position).getImg_url()).into(holder.popularImg);
        holder.nome.setText(popularModelList.get(position).getNome());
        holder.avalicao.setText(popularModelList.get(position).getAvaliacao());
        holder.descricao.setText(popularModelList.get(position).getDescricao());
        holder.desconto.setText(popularModelList.get(position).getDesconto());

    }

    @Override
    public int getItemCount() {
        return popularModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView popularImg;
        TextView nome,descricao, avalicao,desconto;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);


            popularImg=itemView.findViewById(R.id.popular_img);
            nome=itemView.findViewById(R.id.popular_name);
            descricao=itemView.findViewById(R.id.popular_descricao);
            avalicao=itemView.findViewById(R.id.popular_avaliacao);
            desconto=itemView.findViewById(R.id.popular_desconto);


        }
    }
}
