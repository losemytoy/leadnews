package com.heima.model.article.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleHomeDto {

    /**
     * 最大时间
     */
    Date maxBehotTime;

    Date minBehotTime;

    Integer size;

    String tag;
}
