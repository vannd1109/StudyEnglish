package vn.edu.tdc.hoctienganh.baihoc;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import vn.edu.tdc.hoctienganh.R;


public class SetViewHolder extends RecyclerView.ViewHolder {

    public TextView txt_tieude;
    public TextView txt_nghia;
    public TextView txt_phienam;

    public SetViewHolder(View itemView) {
        super(itemView);

        txt_tieude = (TextView) itemView.findViewById(R.id.text_chude);
        txt_nghia = (TextView)itemView.findViewById(R.id.text_nghia);
    }
}