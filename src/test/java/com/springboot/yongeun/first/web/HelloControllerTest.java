package com.springboot.yongeun.first.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class) //test 진행시 junit에 내장된 실행자 외 실행자 실행. springboot test와  junit연결
@WebMvcTest
public class HelloControllerTest {

    @Autowired //bean 주입받음
    private MockMvc mvc; //웹 api test시 사용 / 스프링 mvc 테스트 시작점/ 이 클래스 통해 http get, post등 api test가능

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello="hello";

        mvc.perform(get("/hello")) //MockMvc 클래스를 통해 /hello 주소로 HTTP GET 요청을 함
                .andExpect(status().isOk()) // mvc.perform 결과 검증 -> http header의 status 검증 (200,400,500)
                .andExpect(content().string(hello)); //응답 본문의 내용 검증 ->hello return 해줬는지
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name ="hello";
        int amount =1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))
        )
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.name",is(name)))
                .andExpect((ResultMatcher) jsonPath("$.amount",is(amount)));

    }
}
