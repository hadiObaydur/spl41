package com.example.iit.androidnewsappspl2;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class LanguageFragment extends Fragment implements View.OnClickListener {
    private AlertDialog mAlertDialog = null;
    private TextView txtView = null;
    ArrayList<String>mArray=new ArrayList<String>();
    View view;
    Button buttonOk;
    Button buttonCancel;
    View vanishSelectedTextView;
    String selectedLanguage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,@Nullable Bundle savedInstanceState) {

       // Toast.makeText(getContext(),"fffffffffff",Toast.LENGTH_LONG).show();


        view= inflater.inflate(R.layout.selected_laguage_text, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view , @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Toast.makeText(getContext(),""+SingletonForUserInformation.getSingletonForUserInformation().getBlockSourcesForAdapter().get(0),Toast.LENGTH_LONG).show();
        //mArray=this.getArguments().getStringArrayList("mArray");
        mArray=SingletonForUserInformation.getSingletonForUserInformation().getAllLanguageName();
        vanishSelectedTextView=view.findViewById(R.id.vanish_view);
        txtView = view.findViewById(R.id.txt_id);
        //txtView.setText(selectedLanguage);
        buttonOk=view.findViewById(R.id.ok);
        buttonCancel=view.findViewById(R.id.cancel);
        txtView.setOnClickListener(this);
        buttonOk.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);

    }
    public void onClick(View view){

        switch ((view.getId())) {
            case R.id.txt_id:
                new CustomDialog(getActivity(), mArray, mAlertDialog, (TextView) view);
                break;

            case R.id.ok:
                  // Toast.makeText(getContext(),txtView.getText(),Toast.LENGTH_LONG).show();
                   SingletonForUserInformation.getSingletonForUserInformation().addSelectedLanguage((String) txtView.getText());
                   DropDownAnim.collapse(vanishSelectedTextView);
                   Intent intent = getActivity().getIntent();
                   getActivity().finish();
                   startActivity(intent);
                   break;

            case R.id.cancel:
                DropDownAnim.collapse(vanishSelectedTextView);
                break;

        }



    }
}
