package vn.edu.tdc.hoctienganh.nguphap;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import vn.edu.tdc.hoctienganh.R;
import vn.edu.tdc.hoctienganh.SetOnItemListener;

public class NguPhapAdapter extends RecyclerView.Adapter<SetViewHolderGrammer> {

    private Activity activity;
    View itemView;

    List<NguPhap> nguPhaps = Collections.emptyList();

//    private ChuDeListener chuDeListener;

    private SetOnItemListener setOnItemListener;

    public void setOnItemClickListener(SetOnItemListener listener) {
        this.setOnItemListener = listener;
    }

    public NguPhapAdapter(Activity activity, List<NguPhap> nguPhaps) {
        this.activity = activity;
        this.nguPhaps = nguPhaps;
    }

    @NonNull
    @Override
    public SetViewHolderGrammer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gv_nguphap,parent,false);
        return new SetViewHolderGrammer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SetViewHolderGrammer holder, final int position) {

        holder.txt_nguphap.setText(nguPhaps.get(position).getNguphap());
        holder.txt_nghia.setText(nguPhaps.get(position).getNghia());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setOnItemListener != null)
                    setOnItemListener.setItemView(itemView,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return nguPhaps.size();
    }

//    public void setCheDeListener(ChuDeListener chuDeListener){
//        this.chuDeListener = chuDeListener;
//    }

    public void setSetOnItemListener(SetOnItemListener setOnItemListener){
        this.setOnItemListener = setOnItemListener;
    }
}

