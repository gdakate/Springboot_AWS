package com.springboot.yongeun.first.domain.posts;
// 실제 DB의 table과 매칭될 클래스(=Entity 클래스)
//
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Getter //모든 getter 메소드 자동생성
@NoArgsConstructor //기본생성자 자동추가
@Entity //table과 링크될 클래스임을 알림
public class Posts {
    @Id //해당 table의 pk필드 나타냄 (PK= Primary Key)
    @GeneratedValue(strategy=GenerationType.IDENTITY) // PK생성 규칙 나타냄, GenerationType.IDENTITY 추가해야 auto_increment 가능
    private Long id;

    @Column(length=500, nullable=false) //굳이 선언하지 않아도 해당 클래스의 필드는 모두 column이 됨.
    // 기본값 외의 추가로 변경 사항 있을 때 사용
    private String title;

    @Column(columnDefinition ="TEXT", nullable=false)
    private String content;

    private String author;

    @Builder //빌더 패턴 클래스 생성
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }
}
