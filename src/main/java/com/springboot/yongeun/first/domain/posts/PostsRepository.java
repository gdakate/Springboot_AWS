// Posts 클래스로 db를 접근하게 해줄 Jpa Repository
package com.springboot.yongeun.first.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // db layer 접근자 JPA에선 repository로 부름, 인터페이스 생성
    // JpaRepository<Entity 클래스, PK 타입> 상속 -> 기본적 crud 메소드 자동 생성
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
