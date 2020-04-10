package com.njuiot.iotcloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloPage {

    @RequestMapping("/")
    public String index() {
        return "NJU-IoT-Cloud-Platform.";
    }
}
