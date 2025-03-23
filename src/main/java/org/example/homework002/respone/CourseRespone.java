package org.example.homework002.respone;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseRespone <T>{
    private String message ;
    private T payload;
    private HttpStatus status ;
    private LocalDateTime time;
    public CourseRespone(String message,HttpStatus status,LocalDateTime time){
        this.message=message;
        this.status=status;
        this.time=time;
    }
}
