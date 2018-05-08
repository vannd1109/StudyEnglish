package vn.edu.tdc.hoctienganh.nguphap;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import vn.edu.tdc.hoctienganh.R;

public class SetViewHolderGrammer extends RecyclerView.ViewHolder {

    public TextView txt_nguphap;
    public TextView txt_nghia;
    public TextView txt_phienam;

    public SetViewHolderGrammer(View itemView) {
        super(itemView);

        txt_nguphap = (TextView) itemView.findViewById(R.id.text_nguphap);
        txt_nghia = (TextView)itemView.findViewById(R.id.text_nghianguphap);
    }
}
