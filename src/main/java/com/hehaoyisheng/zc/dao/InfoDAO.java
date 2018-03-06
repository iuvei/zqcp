package com.hehaoyisheng.zc.dao;

import com.hehaoyisheng.zc.entity.Info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface InfoDAO {

    @Insert("insert into info (name1, name2, type, lunci, source1, source2, rank1, rank2, all1, all2, integral1, integral2) values (#{name1}, #{name2}, #{type}, #{lunci}, #{source1}, #{source2}, #{rank1}, #{rank2}, #{all1}, #{all2}, #{integral1}, #{integral2})")
    int insert(Info info);

    @Update("update help set title=#{title} where id=#{id}")
    int update(Info info);

    @Delete("delete from info where id=#{id}")
    int delete(int id);

    int select(Info info);
}
