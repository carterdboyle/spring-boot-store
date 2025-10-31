package com.carterdboyle.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime createdAt;

    // To filter out null values
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private String phoneNumber;
}
