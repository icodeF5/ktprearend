package edu.ktp.service;

import edu.ktp.controller.Result;
import edu.ktp.dao.MessageDao;
import edu.ktp.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    public void sendMessage(Message message){
        messageDao.sendMessage(message);
    }

    public void readAllMessage(String accountName){
        messageDao.readAllMessage(accountName);
    }

    public void readMessage(String  messageId){
        messageDao.readMessage(messageId);
    }

    public List<Message> getAll(String accountName){
        return messageDao.getAll(accountName);
    }

    public List<Message> getNoRead(String accountName){
        return messageDao.getNoRead(accountName);
    }

}
