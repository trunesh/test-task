package com.spring.demo.Request;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {
   
    private String tconst;
  
    private String titletype;
   
    private String primarytitle;
   
    private int runtimeminutes;

    private String genres;

}
