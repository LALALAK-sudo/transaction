package hzy.changJiang.dao;

import hzy.changJiang.pojo.OutFall;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface OutFallMapper extends Mapper<OutFall> {
    @Select("SELECT * FROM outFall \n" +
            "WHERE river_id = 2 \n" +
            "AND isIntake = 0 \n" +
            "ORDER BY numbers DESC LIMIT 0 , 1")
    public OutFall findByMaxHuang();
    @Select("SELECT * FROM outFall \n" +
            "WHERE river_id = 1 \n" +
            "AND isIntake = 0 \n" +
            "ORDER BY numbers DESC LIMIT 0 , 1")
    public OutFall findByMaxChang();
}
