package com.hbpu.springboot2.mapper;

import com.hbpu.springboot2.domain.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {

    public Article selectArticle(Integer id);

    public int updateArticle(Article article);
}
