package com.ckeeda.kisanhubassignment.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ckeeda.kisanhubassignment.Model.WeatherData;
import com.ckeeda.kisanhubassignment.R;
import com.ckeeda.kisanhubassignment.RealmController;

import io.realm.Realm;


public class WeatherAdapter extends RealmRecyclerViewAdapter<WeatherData> {

    final Context context;
    private Realm realm;
    private LayoutInflater inflater;

    public WeatherAdapter(Context context) {

        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewholder, int position) {
         realm = RealmController.with((Activity) context).getRealm();
          WeatherData data = getItem(position);
          CardViewHolder holder = (CardViewHolder) viewholder;

          holder.year.setText(String.valueOf(data.getYear()));
          holder.text_jan.setText(data.getJan_data());
          holder.text_feb.setText(data.getFeb_data());
          holder.text_mar.setText(data.getMar_data());
          holder.text_apr.setText(data.getApr_data());
          holder.text_may.setText(data.getMay_data());
          holder.text_jun.setText(data.getJun_data());
          holder.text_jul.setText(data.getJul_data());
          holder.text_aug.setText(data.getAug_data());
          holder.text_sep.setText(data.getSep_data());
          holder.text_oct.setText(data.getOct_data());
          holder.text_nov.setText(data.getNov_data());
          holder.text_dec.setText(data.getDec_data());

          holder.text_win.setText(data.getWin_data());
          holder.text_spr.setText(data.getSpr_data());
          holder.text_sum.setText(data.getSum_data());
          holder.text_aut.setText(data.getAut_data());
          holder.text_fal.setText(data.getAnn_data());
    }

    @Override
    public int getItemCount() {
        if(getRealmAdapter() != null)
            return getRealmAdapter().getCount();
        return 0;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        public CardView card;
        public TextView year;
        public TextView text_jan;
        public TextView text_feb;
        public TextView text_mar;
        public TextView text_apr;
        public TextView text_may;
        public TextView text_jun;
        public TextView text_jul;
        public TextView text_aug;
        public TextView text_sep;
        public TextView text_oct;
        public TextView text_nov;
        public TextView text_dec;

        public TextView text_win;
        public TextView text_spr;
        public TextView text_sum;
        public TextView text_aut;
        public TextView text_fal;


        public CardViewHolder(View itemView) {
            // standard view holder pattern with Butterknife view injection
            super(itemView);

            card = (CardView) itemView.findViewById(R.id.card_weather);
            year = (TextView) itemView.findViewById(R.id.text_year);
            text_jan = (TextView) itemView.findViewById(R.id.text_january);
            text_feb = (TextView) itemView.findViewById(R.id.text_february);
            text_mar = (TextView) itemView.findViewById(R.id.text_march);
            text_apr = (TextView) itemView.findViewById(R.id.text_april);
            text_may = (TextView) itemView.findViewById(R.id.text_may);
            text_jun = (TextView) itemView.findViewById(R.id.text_june);
            text_jul = (TextView) itemView.findViewById(R.id.text_july);
            text_aug = (TextView) itemView.findViewById(R.id.text_august);
            text_sep = (TextView) itemView.findViewById(R.id.text_september);
            text_oct = (TextView) itemView.findViewById(R.id.text_october);
            text_nov = (TextView) itemView.findViewById(R.id.text_november);
            text_dec = (TextView) itemView.findViewById(R.id.text_december);

            text_win = (TextView) itemView.findViewById(R.id.text_winter);
            text_spr = (TextView) itemView.findViewById(R.id.text_spring);
            text_sum = (TextView) itemView.findViewById(R.id.text_summer);
            text_aut = (TextView) itemView.findViewById(R.id.text_autumn);
            text_fal = (TextView) itemView.findViewById(R.id.text_fall);


        }
    }
}
