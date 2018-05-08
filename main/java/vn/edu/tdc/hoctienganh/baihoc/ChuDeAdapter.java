package vn.edu.tdc.hoctienganh.baihoc;

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

public class ChuDeAdapter extends RecyclerView.Adapter<SetViewHolder> {

    private Activity activity;
    View itemView;
    List<ChuDe> chudes = Collections.emptyList();

// private OnTapListener onTapListener;

    private SetOnItemListener setOnItemListener;

    public void setOnItemClickListener(SetOnItemListener listener) {
        this.setOnItemListener = listener;
    }

    public ChuDeAdapter(Activity activity, List<ChuDe> chudes) {
        this.activity = activity;
        this.chudes = chudes;
    }

    @NonNull
    @Override
    public SetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gv_baihoc, parent, false);
        return new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SetViewHolder holder, final int position) {

        holder.txt_tieude.setText(chudes.get(position).getChude());
        holder.txt_nghia.setText(chudes.get(position).getNghia());
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
        return chudes.size();
    }

//    public void setOnTapListener(OnTapListener onTapListener){
//        this.onTapListener = onTapListener;
//    }

    public void setSetOnItemListener(SetOnItemListener setOnItemListener) {
        this.setOnItemListener = setOnItemListener;
    }
}
