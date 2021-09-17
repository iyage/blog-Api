package com.blog.restapi_blog.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private Date timpeStamp;
    private  String message;
    private  String details;
}
