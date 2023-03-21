package com.techreturners.movieApi.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actor {
    private String imdb_id;
    private String name;
    private String image_url;
    private String type;
    private String birth_date;
    private String birth_place;
    private String partial_bio;
    private String height;
    private String star_sigh;
}
