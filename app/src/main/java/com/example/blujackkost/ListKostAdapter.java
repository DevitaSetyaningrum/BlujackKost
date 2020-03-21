package com.example.blujackkost;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListKostAdapter  extends RecyclerView.Adapter<ListKostAdapter.CategoryViewHolder> {

    private Context context;
    ItemListener itemListener;

    ArrayList<Kost> getListKost(){
        return listKost;
    }

    void setListKost(ArrayList<Kost> listKost){
        this.listKost=listKost;
    }

    private ArrayList<Kost> listKost;

    ListKostAdapter(Context context){
        this.context=context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent. getContext()).inflate(R.layout.item_row_kost, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(final CategoryViewHolder holder, final int position) {
        holder.tvName.setText(getListKost().get(position).getName());
        holder.tvPrice.setText(getListKost(). get(position). getPrice());
        holder.tvFacility.setText(getListKost().get(position).getFacility());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
                itemListener.onItemClick(position);
               // Toast.makeText(context, itemListener+"interface", Toast.LENGTH_SHORT).show();
            }
        });


        Glide.with(context)
                .load(R.drawable.kost4)
                .override(55, 55)
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListKost().size();
    }

     class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice, tvFacility;
        ImageView imgPhoto;

        CategoryViewHolder( View itemView) {
             super(itemView);
             tvName= itemView.findViewById(R.id.tvItemName);
             tvPrice = itemView.findViewById(R.id.tvItemPrice);
             tvFacility = itemView.findViewById(R.id.tvItemFacility);

             imgPhoto = itemView.findViewById(R.id.img_item_photo);
         }
     }

     public void setOnItemClickListener(ItemListener itemListener){
        this.itemListener = itemListener;
     }
     public static class ListenerHolder extends RecyclerView.ViewHolder{
        public ListenerHolder(View itemView){
            super(itemView);
        }
     }
}
