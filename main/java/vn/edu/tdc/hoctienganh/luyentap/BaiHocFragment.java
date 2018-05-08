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
import vn.edu.tdc.hoctienganh.baihoc.ChuDe;
import vn.edu.tdc.hoctienganh.baihoc.ChuDeActivity;
import vn.edu.tdc.hoctienganh.baihoc.ChuDeAdapter;
import vn.edu.tdc.hoctienganh.question.DBHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaiHocFragment extends Fragment {

    private RecyclerView recyclerView;
    private DBHelper dbHelper;
    private ArrayList<ChuDe> arrayList = new ArrayList<ChuDe>();
    private Cursor cursor;
    private ChuDeAdapter chuDeAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_bai_hoc, container, false);

        recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view);

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
            cursor = dbHelper.QueryData("select * from chude");

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        ChuDe chuDe = new ChuDe();
                        chuDe.setChude(cursor.getString(1));
                        chuDe.setNghia(cursor.getString(3));
                        arrayList.add(chuDe);

                    } while (cursor.moveToNext());
                }
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        chuDeAdapter = new ChuDeAdapter(getActivity(), arrayList);
//        chuDeAdapter.setOnTapListener(new OnTapListener() {
//            @Override
//            public void OnTapView(int position) {
////                Toast.makeText(getContext(), "Click to" + position, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getActivity(),ChuDeActivity.class);
//                startActivity(intent);
//            }
//        });

        chuDeAdapter.setOnItemClickListener(new SetOnItemListener() {
            @Override
            public void setItemView(View itemView, int position) {
                Intent intent = new Intent(getActivity(), ChuDeActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(chuDeAdapter);
    }


}
