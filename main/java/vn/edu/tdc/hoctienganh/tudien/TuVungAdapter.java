package vn.edu.tdc.hoctienganh.tudien;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vn.edu.tdc.hoctienganh.R;
import vn.edu.tdc.hoctienganh.SetTuListener;
import vn.edu.tdc.hoctienganh.luyentap.Exam;

public class TuVungAdapter extends RecyclerView.Adapter<SetTuHolder> {

    private Activity activity;
    View itemView;
    List<TuVung> tuVungs = Collections.emptyList();

    private SetTuListener setOnItemListener;

    public void setOnItemClickListener(SetTuListener listener) {
        this.setOnItemListener = listener;
    }

// private OnTapListener onTapListener;

//    private SetOnItemListener setOnItemListener;
//
//    public void setOnItemClickListener(SetOnItemListener listener) {
//        this.setOnItemListener = listener;
//    }

    public TuVungAdapter(Activity activity, List<TuVung> tuVungs) {
        this.activity = activity;
        this.tuVungs = tuVungs;
    }

    @NonNull
    @Override
    public SetTuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_word, parent, false);
        return new SetTuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SetTuHolder holder, final int position) {

        holder.txt_word_translate.setText(tuVungs.get(position).getTu());
        holder.txt_mean_translate.setText(tuVungs.get(position).getNghia());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (setOnItemListener != null)
                    setOnItemListener.setTuView(itemView, position);


            }
        });
    }


    @Override
    public int getItemCount() {
        return tuVungs.size();
    }

//    public void setOnTapListener(OnTapListener onTapListener){
//        this.onTapListener = onTapListener;
//    }

//    public void setSetOnItemListener(SetOnItemListener setOnItemListener) {
//        this.setOnItemListener = setOnItemListener;
//    }
}