package com.example.covid19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MycustomAdapter extends ArrayAdapter<countrymodal> {

    private Context context;
    private List<countrymodal> countrymodalList;
    private List<countrymodal> countrymodalFiltered;

    public MycustomAdapter( Context context, List<countrymodal> countrymodalList) {
        super(context, R.layout.list_custom_item,countrymodalList);
        this.context = context;
        this.countrymodalList = countrymodalList;
        this.countrymodalFiltered = countrymodalList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView tvCountryName =view.findViewById(R.id.tvCountryName);
        ImageView imageView = view.findViewById(R.id.imageFlag);

        tvCountryName.setText(countrymodalFiltered.get(position).getCountry());
        Glide.with(context).load(countrymodalFiltered.get(position).getFlag()).into(imageView);

        return view;
    }

    @Override
    public int getCount() {
        return countrymodalFiltered.size();
    }

    @Nullable
    @Override
    public countrymodal getItem(int position) {
        return countrymodalFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0){
                filterResults.count = countrymodalList.size();
                filterResults.values = countrymodalList;
                }else{
                    List<countrymodal> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for (countrymodal itemsModel:countrymodalList){
                        if (itemsModel.getCountry().toLowerCase().contains(searchStr)){
                            resultsModel.add(itemsModel);
                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                countrymodalFiltered = (List<countrymodal>)results.values;
                AffectedCountries.countrymodalList = (List<countrymodal>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }
}
