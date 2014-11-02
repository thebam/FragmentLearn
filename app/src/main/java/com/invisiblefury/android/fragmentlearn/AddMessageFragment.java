package com.invisiblefury.android.fragmentlearn;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;


public class AddMessageFragment extends Fragment {
    public final static String ARG_MESSAGE = "arg_message";
    private MessageAddedCallback mCallback;
    public AddMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_message, container, false);

        Button btnSubmit = (Button)v.findViewById(R.id.btnSubmit);
        final EditText editTextTitle = (EditText)v.findViewById(R.id.editTextTitle);
        final EditText editTextMessage = (EditText)v.findViewById(R.id.editTextMessage);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strTitle = editTextTitle.getText().toString().trim();
                String strDescription = editTextMessage.getText().toString().trim();
                if(TextUtils.isEmpty(strTitle)){
                    editTextTitle.setError("Please enter a title");
                }else {
                    if (TextUtils.isEmpty(strDescription)) {
                        editTextMessage.setError("Please enter a title");
                    } else {
                        final Message newMessage = new Message();
                        newMessage.setTitle(editTextTitle.getText().toString());
                        newMessage.setDescription(editTextMessage.getText().toString());
                        MessageArchive.getInstance().AddMessage(newMessage);
                        mCallback.messageAdded(newMessage);
                    }
                }
            }
        });


        return v;
    }

    public interface MessageAddedCallback{
        void messageAdded(Message newMessage);
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try {
            mCallback = (MessageAddedCallback) activity;
        }catch (ClassCastException e){
            //
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mCallback = null;
    }
}
