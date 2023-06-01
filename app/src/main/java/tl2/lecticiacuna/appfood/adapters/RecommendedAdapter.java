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
import tl2.lecticiacuna.appfood.models.RecommendedModel;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {

    Context context;
    List<RecommendedModel> recommendedModelList;

    public RecommendedAdapter(Context context, List<RecommendedModel> recommendedModelList) {
        this.context = context;
        this.recommendedModelList = recommendedModelList;

        //com o constutor criado vamos instanciar o glide
    }

    @NonNull
    @Override
    public RecommendedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_home,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(recommendedModelList.get(position).getImg_url()).into(holder.imgView);
        holder.nome.setText(recommendedModelList.get(position).getNome());
        holder.descricao.setText(recommendedModelList.get(position).getDescricao());
        holder.avaliacao.setText(recommendedModelList.get(position).getAvaliacao());



    }

    @Override
    public int getItemCount() {
        return recommendedModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView nome, descricao, avaliacao;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.rec_img);
            nome = itemView.findViewById(R.id.rec_nome);
            descricao = itemView.findViewById(R.id.rec_descricao);
            avaliacao = itemView.findViewById(R.id.rec_avalicao);

        }
    }
}
