package edu.ktp.dao;

import edu.ktp.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageDao {

    void sendMessage(Message message);

    List<Message> getAll(String accountName);

    List<Message> getNoRead(String accountName);

    void readAllMessage(String accountName);

    void readMessage(String  messageId);

}
