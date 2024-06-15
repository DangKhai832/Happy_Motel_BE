package com.HappyMotelBE.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Long id;
    private String username;
    private String password;
    private String phoneNumber;
    private String realName;
    private String email;
    private int gender;
    private Date createTime;
    private Date updateTime;
    private int isDelete;
}
