package com.springboot.yongeun.first.domain.user;


//각 사용자 권한 관리할 enum class
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
        USER("ROLE_USER","일반 사용자");

    private final String Key;
    private final String title;
}
