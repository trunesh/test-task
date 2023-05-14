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

@Entity
@Table(name = "ratings")
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL )
public class Rating {
    @Id
    @Column(name="tconst")
    private String tconst;
    @Column(name="averagerating")
    private float averagerating;
    @Column(name="numvotes")
    private int numvotes;
    // getters and setters
}