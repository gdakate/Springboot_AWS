package com.springboot.yongeun.first.web;
import com.springboot.yongeun.first.Service.PostsService;
import com.springboot.yongeun.first.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
//페이지에 관한 컨트롤러 모두 index controller 사용

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return  "index";
    }
    @GetMapping("/posts/save") // /posts/save를 호출하면
    public String postsSave(){
        return "posts-save"; //posts-save.mustache를 호출하는 method
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
