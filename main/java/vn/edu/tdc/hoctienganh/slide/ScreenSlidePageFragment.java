package vn.edu.tdc.hoctienganh.slide;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Queue;

import vn.edu.tdc.hoctienganh.R;
import vn.edu.tdc.hoctienganh.question.Question;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {

    ArrayList<Question> arr_Ques;

    public static final String ARG_PAGE = "page";
    public static final String ARG_CHECKANSWER = "checkAnswer";

    private int mPageNumber; // Vi tri trang hien tai
    private int checkAns; // bien kiem tra kq

    TextView tvNum, tvQuestion;
    RadioGroup radioGroup;
    RadioButton radA, radB, radC, radD;

    ImageView imgIcon;


    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        tvNum = (TextView) rootView.findViewById(R.id.tvNum);
        tvQuestion = (TextView) rootView.findViewById(R.id.tvQuestion);
        radA = (RadioButton) rootView.findViewById(R.id.radA);
        radB = (RadioButton) rootView.findViewById(R.id.radB);
        radC = (RadioButton) rootView.findViewById(R.id.radC);
        radD = (RadioButton) rootView.findViewById(R.id.radD);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radGroup);
        imgIcon = (ImageView) rootView.findViewById(R.id.ivIcon);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arr_Ques = new ArrayList<Question>();
        ScreenSlideActivity slideActivity = (ScreenSlideActivity) getActivity();
        arr_Ques = slideActivity.getData();
        mPageNumber = getArguments().getInt(ARG_PAGE);
        checkAns = getArguments().getInt(ARG_CHECKANSWER);

    }


    public static ScreenSlidePageFragment create(int pageNumber, int checkAnswer) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        args.putInt(ARG_CHECKANSWER,checkAnswer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("Câu" + (mPageNumber + 1));
        tvQuestion.setText(arr_Ques.get(mPageNumber).getQuestion());
        radA.setText(getItem(mPageNumber).getAns_a());
        radB.setText(getItem(mPageNumber).getAns_b());
        radC.setText(getItem(mPageNumber).getAns_c());
        radD.setText(getItem(mPageNumber).getAns_d());

        imgIcon.setImageResource(getResources().getIdentifier(getItem(mPageNumber).getImage()+"",
                "drawable","vn.edu.tdc.hoctienganh"));

        if (checkAns != 0){
            radA.setClickable(false);
            radB.setClickable(false);
            radC.setClickable(false);
            radD.setClickable(false);
            getCheckAns(getItem(mPageNumber).getResult().toString());
        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                arr_Ques.get(mPageNumber).checkID = checkedId;
                arr_Ques.get(mPageNumber).setTraloi(getChoiceFormID(checkedId));
//                Toast.makeText(getActivity(),"Đây là đáp an bạn chọn" +checkedId,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public Question getItem(int position) {
        return arr_Ques.get(position);
    }

    // Lấy giá trị (vị trí) radioGroup chuyển thành đáp án A,B,C,D
    private String getChoiceFormID(int ID) {
        if (ID == R.id.radA) {
            return "A";
        } else if (ID == R.id.radB) {
            return "B";
        } else if (ID == R.id.radC) {
            return "C";
        } else if (ID == R.id.radD) {
            return "D";
        } else return "";
    }

    // Ham kiem tra cau dung, neu cau dung thi doi mau background radiobutton tuong ung
    private void getCheckAns(String ans){
        if(ans.equals("A") == true){
            radA.setBackgroundColor(Color.RED);
        }else if (ans.equals("B") == true){
            radB.setBackgroundColor(Color.RED);
        }else if(ans.equals("C") == true){
            radC.setBackgroundColor(Color.RED);
        }else if(ans.equals("D") == true){
            radD.setBackgroundColor(Color.RED);
        }else ;
    }


}
