package com.spring.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

@Entity
@Table(name = "movies")
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL )
public class Movie {
    @Id
    @Column(name="tconst")
    private String tconst;
    @Column(name="titletype")
    private String titletype;
    @Column(name="primarytitle")
    private String primarytitle;
    @Column(name="runtimeminutes")
    private int runtimeminutes;
    @Column(name="genres")
    private String genres;
    // getters and setters
}