package com.itbooking.web;

        import com.itbooking.service.user.message.IMessageProducerService;
        import com.itbooking.service.user.topic.IMessageTopicProducerService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 徐柯老师
 * @Description
 * @Tel/微信：15074816437
 * @Version 1.0
 **/
@RestController
public class MessageController {

    @Autowired
    private  IMessageProducerService messageProducerService;
    @Autowired
    private IMessageTopicProducerService messageTopicProducerService;

    @GetMapping("/send/{msg}")
    public String sendMessage(@PathVariable("msg")String msg){
        messageProducerService.sendMessage(msg);
        return "success";
    }

    @GetMapping("/topic/{msg}")
    public String sendTopicMessage(@PathVariable("msg")String msg){
        messageTopicProducerService.sendMessage(msg);
        return "success";
    }
}
