package vn.edu.tdc.hoctienganh.tudien;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import vn.edu.tdc.hoctienganh.R;

public class SetTuHolder extends RecyclerView.ViewHolder {

    public TextView txt_word_translate;
    public TextView txt_mean_translate;
    public EditText edt_STT;

    public SetTuHolder(View itemView) {
        super(itemView);

        txt_word_translate = (TextView) itemView.findViewById(R.id.txt_word_translate);
        txt_mean_translate = (TextView) itemView.findViewById(R.id.txt_mean_translate);
        edt_STT = (EditText) itemView.findViewById(R.id.editText_id);

    }
}
