package com.hbpu.springboot2.mapper;

import com.hbpu.springboot2.domain.Comment;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentMapper {

    @Select("select * from t_comment where id = #{id}")
    public Comment findById(Integer id);

    @Delete("delete * from t_comment where id = #{id}")
    public int deleteComment(Integer id);

    @Insert("INSERT INTO t_comment(content,author,a_id)"+
            "values (#{content},#{author},#{aId})")
    public int insertComment(Comment comment);

    @Update("update t_comment set content=#{content} where id=#{id}")
    public int updateComment(Comment comment);
}
