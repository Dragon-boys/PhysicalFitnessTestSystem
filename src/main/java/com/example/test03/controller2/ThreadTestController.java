package com.example.test03.controller2;

import com.example.test03.service2.ThreadTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadTestController {
    @Autowired
    private ThreadTestService threadTestService;

    @RequestMapping("test")
    public Object t1(){
        for (int i =1; i < 100; i++){
            threadTestService.executeThread(i);
        }
        return "ok";
    }
}
