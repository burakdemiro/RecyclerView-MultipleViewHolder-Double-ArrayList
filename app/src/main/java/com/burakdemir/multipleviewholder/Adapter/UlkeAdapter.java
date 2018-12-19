package com.burakdemir.multipleviewholder.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.burakdemir.multipleviewholder.Model.Reklam;
import com.burakdemir.multipleviewholder.Model.Ulke;
import com.burakdemir.multipleviewholder.R;

import java.util.ArrayList;

// Bu yöntemde tek arraylist içine object tipinde atmadım çünkü listeden eleman silinirse reklamlar alt alta çıkar
// Burada en önemli olan RecyclerView.ViewHolder super sınıfını kullanmak diğer türettiğin tüm holder'lar bundan extend eder
public class UlkeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    LayoutInflater inflater;
    ArrayList<Ulke> ulkeArrayList;
    ArrayList<Reklam> reklamArrayList;

    final int TYPE_ULKE = 100;
    final int TYPE_REKLAM = 50;

    public UlkeAdapter(Context context, ArrayList<Ulke> ulkeArrayList, ArrayList<Reklam> reklamArrayList) {
        this.context = context;
        this.ulkeArrayList = ulkeArrayList;
        this.reklamArrayList = reklamArrayList;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // burada ilk index 0 ile başlar gelen objeleri yaratılmadan önce değerlerini yakalayabilirsin
    @Override
    public int getItemViewType(int position) {

        // ilk index 0 ile başlar
        // 4 ve katı indexlerde reklam göstermek için TYPE_REKLAM döndür
        if (position % 4 == 0) {

            return TYPE_REKLAM;
        }
        else {

            return TYPE_ULKE;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // gelen TYPE'a göre tek satırı burada türet
        View v;
        RecyclerView.ViewHolder holder;

        switch (viewType) {

            case TYPE_REKLAM:
                v = inflater.inflate(R.layout.tek_satir_reklam, parent, false);
                holder = new ReklamViewHolder(v);
                break;

            case TYPE_ULKE:
                v = inflater.inflate(R.layout.tek_satir_ulke, parent, false);
                holder = new UlkeViewHolder(v);
                break;

            default:
                holder = null;
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        // hangi indexte hangi veri tipi atadık onu daha önce tanımladığım getItemViewType'dan al
        int viewType = getItemViewType(position);

        switch (viewType) {

            case TYPE_REKLAM:
                ((ReklamViewHolder)holder).ivReklamResmi.setImageResource(reklamArrayList.get(0).getReklamResmi()); // dizide tek eleman var
                break;

            case TYPE_ULKE:
                ((UlkeViewHolder)holder).ivBayrak.setImageResource(ulkeArrayList.get(position).getBayrakResmi());
                ((UlkeViewHolder)holder).tvUlkeAdi.setText(ulkeArrayList.get(position).getUlkeAdi());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return ulkeArrayList.size();
    }

    // Ulke ViewHolder
    public class UlkeViewHolder extends RecyclerView.ViewHolder {

        ImageView ivBayrak;
        TextView tvUlkeAdi;

        public UlkeViewHolder(View itemView) {
            super(itemView);

            ivBayrak = itemView.findViewById(R.id.ivReklamResmi);
            tvUlkeAdi = itemView.findViewById(R.id.tvUlkeAdi);
        }
    }

    // Reklam ViewHolder
    public class ReklamViewHolder extends RecyclerView.ViewHolder {

        ImageView ivReklamResmi;
        TextView tvReklamYazisi;

        public ReklamViewHolder(View itemView) {
            super(itemView);

            ivReklamResmi = itemView.findViewById(R.id.ivReklamResmi);
            tvReklamYazisi = itemView.findViewById(R.id.tvReklamYazisi);
        }
    }
}
