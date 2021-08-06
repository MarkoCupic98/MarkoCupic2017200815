package com.example.markocupic2017200815;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<PcPart> pcParts;

    public Adapter(Context ctx, List<PcPart> pcParts) {
        this.inflater = LayoutInflater.from(ctx);
        this.pcParts = pcParts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.partName.setText(pcParts.get(position).getName());
        holder.partDescripton.setText(pcParts.get(position).getDescription());
        holder.partBuy.setText(pcParts.get(position).getWhereToBuy());
        //Ovde mozda treba getovati URL, pa ga proslediti u invisible TextView ili tako nesto u metodi View Holder dole
//        holder.partUrl.setText(pcParts.get(position).getUrlSite()); //maybe works
        Picasso.get().load(pcParts.get(position).getImage()).into(holder.partImage);
        //ATTEMPT TO MAKE ONCLICK GO TO SET URL
        /*holder.partBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(urlSite[holder.getAdapterPosition()]));
                context.startActivity(i);
            }
        }); */
    }

    @Override
    public int getItemCount() {
        return pcParts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView partName, partDescripton, partBuy, partUrl; //dodati url  i u samom xml dodati invisible text polje ????
        ImageView partImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            partName = itemView.findViewById(R.id.partName);
            partDescripton = itemView.findViewById(R.id.partDescription);
            partBuy = itemView.findViewById(R.id.partBuy);
            partImage = itemView.findViewById(R.id.partImage);
//            partUrl = itemView.findViewById(R.id.partUrl); //maybe works
//            String partUrlSring = partUrl.getText().toString(); //maybe works

            //ATTEMPT TO MAKE ONCLICK GO TO SET URL
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Loading the website...", Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(partUrlSring)); //maybe works
//                    v.getContext().startActivity(i); //maybe works
                }
            });
        }
    }

}
