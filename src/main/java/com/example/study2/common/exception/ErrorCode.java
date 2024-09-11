package com.example.study2.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    // 400 번대 에러
    TEST_ERROR_CODE(400, "ERROR-001", "올바르지 않은 입력값입니다."),
    USER_NOT_FOUND(400, "USER-001", "해당하는 유저가 없습니다"),


    // 500 번대 에러
    INTERNAL_SERVER_ERROR(500, "COMMON-002", "서버에서 요청을 처리하지 못했습니다.");


    private final int status;
    private final String code;
    private final String Description;

    ErrorCode(int status, String code, String Description) {
        this.status = status;
        this.code = code;
        this.Description = Description;
    }
}
