package com.hediapps.messaging.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    private UserDto fromUser;
    private String destination;
    private Date creationDate;
    private String text;
    private boolean read;
}
