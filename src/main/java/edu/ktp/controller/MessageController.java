package edu.ktp.controller;

import edu.ktp.entity.Message;
import edu.ktp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/readAllMessage")
    public Result readAllMessage(@RequestParam String accountName){
        messageService.readAllMessage(accountName);
        return new Result(true,"success","已读！");
    }

    @GetMapping("/readMessage")
    public Result readMessage(@RequestParam String messageId){
        messageService.readMessage(messageId);
        return  new Result(true,"success","已读");
    }

    @GetMapping("/getAll")
    public Result getAll(@RequestParam String accountName){
        return new Result(true,messageService.getAll(accountName),"所有信息");
    }

    @GetMapping("/getNoRead")
    public Result getNoRead(@RequestParam String accountName){
        return  new Result(true,messageService.getNoRead(accountName),"所有未读信息");
    }



}
