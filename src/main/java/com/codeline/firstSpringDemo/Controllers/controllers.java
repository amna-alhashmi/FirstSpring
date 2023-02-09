package com.codeline.firstSpringDemo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class controllers {

    @GetMapping(name="hello")
    public String HelloWord(){
        return "Hello words";
    }
    @GetMapping(value="Name")
    public String MyName(String firstName,String LastName){
        firstName="Amna";
        LastName="Al-hashmi";
        return "My name is "+firstName+" "+LastName;
    }
}
