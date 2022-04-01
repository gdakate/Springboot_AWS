package com.springboot.yongeun.first.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // controller를 json을 반환하는 controler로 만들어줌
// 이전에는 각 method마다 @ResponseBody를 붙였던 것을 한번에 사용할 수 있게 함
public class HelloController  {

    @GetMapping("/hello") // /hello로 요청이 오면 return값 반환
    public String hello(){
        return "hello";
    }
}
