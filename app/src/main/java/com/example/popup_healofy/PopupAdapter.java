package com.example.popup_healofy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopupAdapter extends RecyclerView.Adapter<PopupAdapter.CityHolder> {

    private CharSequence[] strings;
    private Context context;

    public PopupAdapter(CharSequence[] strings, Context context) {
        this.strings = strings;
        this.context = context;
    }

    @NonNull
    @Override
    public CityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.string_layout, null, true);
        CityHolder cityHolder = new CityHolder(view);
        return cityHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CityHolder holder, int position) {
        holder.cityName.setText(strings[position]);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    public class CityHolder extends RecyclerView.ViewHolder {

        TextView cityName;

        public CityHolder(View itemView) {
            super(itemView);
            setIsRecyclable(false);
            cityName = itemView.findViewById(R.id.comment);
        }

        public void bind(int position){
            cityName.setText(strings[position]);
        }
    }
}
