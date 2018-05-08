package vn.edu.tdc.hoctienganh.luyentap;


import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.tdc.hoctienganh.MainActivity;
import vn.edu.tdc.hoctienganh.R;
import vn.edu.tdc.hoctienganh.SetTuListener;
import vn.edu.tdc.hoctienganh.question.DBHelper;
import vn.edu.tdc.hoctienganh.tudien.TranslateController;
import vn.edu.tdc.hoctienganh.tudien.TuVung;
import vn.edu.tdc.hoctienganh.tudien.TuVungAdapter;
import vn.edu.tdc.hoctienganh.tudien.TuVungHelper;
import vn.edu.tdc.hoctienganh.tudien.WordModify;


/**
 * A simple {@link Fragment} subclass.
 */
public class TraTuFragment extends Fragment {

    private RecyclerView recyclerView;
    private DBHelper dbHelper;

    private TuVungHelper tuVungHelper;
    private ArrayList<TuVung> arrayList = new ArrayList<TuVung>();
    private Cursor cursor;
    TuVung tuVung;
    private TuVungAdapter tuVungAdapter;

    private Button btnAdd;
    private Button btnSearch;
    WordModify wordModify;

    TranslateController translateController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_tra_tu, container, false);

        recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view_word);

        btnAdd = (Button) viewGroup.findViewById(R.id.btnAdd);
        btnSearch = (Button) viewGroup.findViewById(R.id.btnSearch);

        loadDatabase();


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = TraTuFragment.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.alert_dialog_save_word, null);
                builder1.setView(view);

                final EditText edtWord = (EditText) viewGroup.findViewById(R.id.edtWord_Translate);
                final EditText edtMean = (EditText) viewGroup.findViewById(R.id.edtNghia_Translate);


                builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog b = builder1.create();
                b.show();

            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Bạn muốn kiếm từ!", Toast.LENGTH_SHORT).show();
            }
        });


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
            cursor = dbHelper.QueryData("select * from translate");

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        TuVung tuVung = new TuVung();
                        tuVung.setId(cursor.getInt(0));
                        tuVung.setTu(cursor.getString(1));
                        tuVung.setNghia(cursor.getString(2));
                        arrayList.add(tuVung);

                    } while (cursor.moveToNext());
                }
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        tuVungAdapter = new TuVungAdapter(getActivity(), arrayList);

        tuVungAdapter.setOnItemClickListener(new SetTuListener() {
            @Override
            public void setTuView(View itemView, final int position) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choose option");
                builder.setMessage("Update or delete Word?");

                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                        LayoutInflater inflater = TraTuFragment.this.getLayoutInflater();
                        View view = inflater.inflate(R.layout.alert_dialog_edit_word, null);
                        builder1.setView(view);


                        final EditText edtWord = (EditText) view.findViewById(R.id.edtWord_Name);
                        final EditText edtMean = (EditText) view.findViewById(R.id.edtNghia_Mean);


                        builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
 

                            }
                        });

                        builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog b = builder1.create();
                        b.show();
                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {

                    EditText editTextId = (EditText)getActivity().findViewById(R.id.editText_id);
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Integer deletedRows = tuVungHelper.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(getActivity(),"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getActivity(),"Data not Deleted",Toast.LENGTH_LONG).show();

                    }


            });
                builder.create().show();
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(tuVungAdapter);
    }


}
