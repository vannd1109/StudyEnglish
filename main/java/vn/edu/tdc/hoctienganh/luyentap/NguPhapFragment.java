package vn.edu.tdc.hoctienganh.luyentap;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.tdc.hoctienganh.R;
import vn.edu.tdc.hoctienganh.SetOnItemListener;
import vn.edu.tdc.hoctienganh.nguphap.NguPhap;
import vn.edu.tdc.hoctienganh.nguphap.NguPhapActivity;
import vn.edu.tdc.hoctienganh.nguphap.NguPhapAdapter;
import vn.edu.tdc.hoctienganh.question.DBHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class NguPhapFragment extends Fragment {

    private RecyclerView recyclerView;
    private DBHelper dbHelper;
    private ArrayList<NguPhap> arrayList = new ArrayList<NguPhap>();
    private Cursor cursor;
    private NguPhapAdapter nguPhapAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_ngu_phap, container, false);

        recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view_grammer);

        loadDatabase();

        return viewGroup;
    }

    public void loadDatabase() {
        dbHelper = new DBHelper(getActivity());
        try {
            dbHelper.checkDataBase();
            dbHelper.openDataBase();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        try {
            cursor = dbHelper.QueryData("select * from nguphap");

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        NguPhap nguPhap = new NguPhap();
                        nguPhap.setNguphap(cursor.getString(1));
                        nguPhap.setNghia(cursor.getString(3));
                        arrayList.add(nguPhap);

                    } while (cursor.moveToNext());
                }
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        nguPhapAdapter = new NguPhapAdapter(getActivity(), arrayList);
//        nguPhapAdapter.setCheDeListener(new ChuDeListener() {
//            @Override
//            public void ChuDeView(int positon) {
//                Toast.makeText(getContext(), "Click to" + positon, Toast.LENGTH_SHORT).show();
//            }
//        });

        nguPhapAdapter.setOnItemClickListener(new SetOnItemListener() {
            @Override
            public void setItemView(View itemView, int position) {
                Intent intent = new Intent(getActivity(), NguPhapActivity.class);
                startActivity(intent);
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(nguPhapAdapter);

    }


}

