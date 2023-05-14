package com.spring.demo.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovieRatingResponse {
    private String tconst;
    private String primaryTitle;
    private String genres;
    private float averageRating;
}