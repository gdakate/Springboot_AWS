package com.springboot.yongeun.first.Service.posts;

import com.springboot.yongeun.first.domain.posts.PostsRepository;
import com.springboot.yongeun.first.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성해줌. -> 생성자를 통해 bean 객체를 받음
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
