package com.invisiblefury.android.fragmentlearn;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ViewMessageFragment extends Fragment {


    public ViewMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Message message = (Message)getArguments().getSerializable(AddMessageFragment.ARG_MESSAGE);

        View v = inflater.inflate(R.layout.fragment_view_message, container, false);
        TextView textViewTitle = (TextView)v.findViewById(R.id.textViewTitle);
        TextView textViewMessage = (TextView)v.findViewById(R.id.textViewMessage);
        TextView textViewDate = (TextView)v.findViewById(R.id.textViewDate);



        textViewTitle.setText(message.getTitle().toString());
        textViewMessage.setText(message.getDescription().toString());
        textViewDate.setText(message.getDateCreated().toString());

        // Inflate the layout for this fragment
        return v;
    }


}
