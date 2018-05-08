package vn.edu.tdc.hoctienganh.baihoc;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import vn.edu.tdc.hoctienganh.R;
import vn.edu.tdc.hoctienganh.chude.animal.Animal;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChuDePageFragment extends Fragment {

    ArrayList<Animal> arr_ChuDe;

    public static final String ARG_PAGE = "page";

    private int mPageNumber; // Vi tri trang hien tai

    ImageView btnLoa;
    ImageView imgHinh;
    TextView txt_nameWord;
    TextView txt_phatamWord;
    TextView txt_nghiaWord;




    public ChuDePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_chu_de_page, container, false);

        imgHinh = (ImageView) rootView.findViewById(R.id.imgHinh);
        txt_nameWord = (TextView) rootView.findViewById(R.id.txt_nameWord);
        txt_phatamWord = (TextView) rootView.findViewById(R.id.txt_phatamWord);
        txt_nghiaWord = (TextView) rootView.findViewById(R.id.txt_nghiaWord);
        btnLoa = (ImageView) rootView.findViewById(R.id.btnLoa);

        return rootView;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        arr_ChuDe = new ArrayList<Animal>();
//        ChuDeActivity chuDeActivity = (ChuDeActivity) getActivity();
//        arr_ChuDe = chuDeActivity.getData();
//        mPageNumber = getArguments().getInt(ARG_PAGE);
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        imgHinh.setImageResource(mPageNumber +1);
//        txt_nameWord.setText(arr_ChuDe.get(mPageNumber).getName());
//        txt_phatamWord.setText(arr_ChuDe.get(mPageNumber).getPro());
//        txt_nghiaWord.setText(arr_ChuDe.get(mPageNumber).getMean());
//    }
//
//    public Animal getItem(int position) {
//        return arr_ChuDe.get(position);
//    }
}
