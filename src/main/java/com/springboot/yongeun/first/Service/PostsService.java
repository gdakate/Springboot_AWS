package com.springboot.yongeun.first.Service;

import com.springboot.yongeun.first.domain.posts.Posts;
import com.springboot.yongeun.first.domain.posts.PostsRepository;
import com.springboot.yongeun.first.web.dto.PostsListResponseDto;
import com.springboot.yongeun.first.web.dto.PostsResponseDto;
import com.springboot.yongeun.first.web.dto.PostsSaveRequestDto;
import com.springboot.yongeun.first.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성해줌. -> 생성자를 통해 bean 객체를 받음
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts=postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
    public PostsResponseDto findById(Long id)
    {
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) //조회만
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream() //postRepository의 결과로 넘어온 Posts의 Stream을
                .map(PostsListResponseDto::new) //map을 통해 PostListResponseDto로 변환
                .collect(Collectors.toList()); //List로 변환
            }

   @Transactional
   public void delete(Long id){
        Posts posts =postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다.id="+id));
        postsRepository.delete(posts);
   }

}
