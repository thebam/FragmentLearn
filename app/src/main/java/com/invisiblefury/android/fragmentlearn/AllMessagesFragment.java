package com.invisiblefury.android.fragmentlearn;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllMessagesFragment extends ListFragment {

    private DisplayMessageCallback mCallback;
    public AllMessagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_all_messages, container, false);
        List<Message> messages = MessageArchive.getInstance().GetAllMessages();

        MessageAdapter adapter = new MessageAdapter(messages);
        setListAdapter(adapter);

        return v;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Message newMessage = MessageArchive.getInstance().GetMessageByPosition(position);
        if(newMessage!=null) {
            mCallback.showMessage(newMessage);
        }
    }

    private class MessageAdapter extends ArrayAdapter<Message>{
        public MessageAdapter(List<Message> messages)
        {
            super(getActivity(),0,messages);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_message_item, null);
            }
            Message message = getItem(position);
            TextView quoteTextView = (TextView)convertView.findViewById(R.id.messageTextview_listItem);
            quoteTextView.setText(message.getTitle());
            return convertView;
        }
    }



    public interface DisplayMessageCallback{
        void showMessage(Message message);
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try {
            mCallback = (DisplayMessageCallback) activity;
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

