package com.hbpu.springboot2;

import com.hbpu.springboot2.domain.Article;
import com.hbpu.springboot2.domain.Comment;
import com.hbpu.springboot2.mapper.ArticleMapper;
import com.hbpu.springboot2.mapper.CommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.plaf.PanelUI;

@SpringBootTest
public class SpringBoot3Test {

    @Autowired
    private CommentMapper commentMapper;


    @Test
    public void selectComment(){
        Comment comment = commentMapper.findById(1);
        System.out.println(comment);
    }

    public void updateComment(){
        Comment comment = new Comment();
        comment.setaId(1);
        comment.setContent("不详细");
        commentMapper.updateComment(comment);
    }

    @Test
    public void deleteComment(){
        commentMapper.deleteComment(5);
    }

    @Autowired
    private ArticleMapper articleMapper;
    @Test
    public void selectArticle(){
        Article article = articleMapper.selectArticle(1);
        System.out.println(article);
    }

    @Test
    public  void updateArticle(){
        Article article = new Article();
       // article.setId(1);
        article.setTitle("springboot 精通");
        article.setContent("从静态到放弃");
        int i = articleMapper.updateArticle(article);
        System.out.println(i);
    }
}
