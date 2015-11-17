package vn.fpt.se0866.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.fpt.se0866.activity.R;
import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 11/15/2015.
 */
public class ResultAdapter extends BaseAdapter {
    public static final int LAYOUT_RESOURCES_ID = R.id.search_result_lv;

    List<Food> list;
    Context context;
    private static LayoutInflater inflater = null;

    public ResultAdapter(Context context, List<Food> foods) {
        this.list = foods;
        this.context = context;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        View rowView = inflater.inflate(R.layout.item_search_result, null);
        viewHolder.ivThumb = (ImageView) rowView.findViewById(R.id.item_search_thumb_iv);
        viewHolder.tvName = (TextView) rowView.findViewById(R.id.item_search_name_tv);
        viewHolder.tvDetails = (TextView) rowView.findViewById(R.id.item_search_material_tv);
        return rowView;
    }

    public class ViewHolder{
        ImageView ivThumb;
        TextView tvName, tvDetails;
    }
}
