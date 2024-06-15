package com.HappyMotelBE.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error"),
    INVALID_KEY(1001, "Uncategorized error"),
    USER_EXISTED(1002, "User exited"),
    INVALID_PASSWORD(1004, "Password must be at least 8 characters"),
    INVALID_USERNAME(1003, "Username must be at least 8 characters"),
    USER_NOT_EXITED(1005, "User not exited"),
    UNAUTHENTICATED(1006, "Unauthenticated"),
    CANNOT_CREATE_TOKEN(1007, "Cannot create tokens"),
    DUPLICATE_EMAIL(1008, "Đã tồn tại email này"),
    DUPLICATE_USERNAME(1009, "Username đã bị trùng"),
    ;
    int code;
    String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
