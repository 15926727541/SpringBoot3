package com.hbpu.springboot2.repository;
import com.hbpu.springboot2.domain.Discuss;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface DiscussReqository extends JpaRepository<Discuss,Integer> {
    public List<Discuss> findByAuthorNotNull();
    @Query("select c from t_comment c where c.Id = ?1")
    public List<Discuss> getDiscussPaged(Integer aid,Pageable pageable);
    @Query(value = "select * from t_comment c where a_Id = ?1",nativeQuery = true)
    public List<Discuss> getDiscussPage2(Integer aid, Pageable pageable);
    @Transactional
    @Modifying
    @Query("UPDATE t_comment c set c.author = ?1 where c.id = ?2")
    public int updateDiscuss(String author,Integer id);
    @Transactional
    @Modifying
    @Query("delete  t_comment c where c.id = ?1")
    public int deleteDiscuss(Integer id);

}
