package com.invisiblefury.android.fragmentlearn;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jason on 11/1/2014.
 */
public class MessageArchive {
    private static MessageArchive instance = null;
    private List<Message> messages;

    protected MessageArchive(){
        messages = new ArrayList<Message>();

        Message message1 = new Message();
        message1.setTitle("title1");
        message1.setDescription("description1");
        messages.add(message1);

        Message message2 = new Message();
        message2.setTitle("title2");
        message2.setDescription("description2");
        messages.add(message2);

    }

    public static MessageArchive getInstance(){
        if(instance == null){
            instance = new MessageArchive();
        }
        return instance;
    }

    public void AddMessage(Message messageToAdd){
        messages.add(messageToAdd);
    }

    public void RemoveMessage(Message messageToRemove){
        messages.remove(messageToRemove);
    }

    public List<Message> GetAllMessages(){
        return messages;
    }

    public Message GetMessage(UUID messageId){
        for(Message mess:messages){
            if(mess.getId().equals(messageId)){
                return mess;
            }
        }
        return null;
    }

    public Message GetMessageByPosition(int position){
        if(position <= messages.size()){
            return messages.get(position);
        }
        return null;
    }
}
