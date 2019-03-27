package com.itbooking.web;

import com.itbooking.pojo.User;
import com.itbooking.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Response;

/**
 * @Author 徐柯老师
 * @Description
 * @Tel/微信：15074816437
 * @Version 1.0
 **/
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @GetMapping("/getuser/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id")Long userId){
        User user = userService.getUserById(userId);
        if(user!=null) {
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
