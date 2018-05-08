package vn.edu.tdc.hoctienganh.luyentap;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.tdc.hoctienganh.MainActivity;
import vn.edu.tdc.hoctienganh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GhiChuFragment extends Fragment {


    public GhiChuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Ghi nhớ mỗi ngày");
        return inflater.inflate(R.layout.fragment_ghi_chu, container, false);
    }

}
