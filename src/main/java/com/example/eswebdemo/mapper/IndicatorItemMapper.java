package com.example.eswebdemo.mapper;

import com.example.eswebdemo.model.IndicatorItem;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * @author shengruikou
 */
public interface IndicatorItemMapper {

    /**
     * @return 查询所有数据
     */
    @Select("select * from t_indicator_item")
    @Results({
            @Result(property = "id", column = "Fid", javaType = Integer.class),
            @Result(property = "name", column = "Fname", javaType = String.class),
            @Result(property = "sname", column = "Fsname", javaType = String.class),
            @Result(property = "code", column = "Fcode", javaType = String.class),
            @Result(property = "scode", column = "Fscode", javaType = String.class),
            @Result(property = "standard", column = "Fstandard", javaType = String.class),
            @Result(property = "user", column = "Fuser", javaType = String.class),
            @Result(property = "type", column = "Ftype", javaType = Integer.class),
            @Result(property = "typeName", column = "Ftype_name", javaType = String.class),
            @Result(property = "updateTime", column = "Fupdate_time", javaType = Date.class),
            @Result(property = "insertTime", column = "Finsert_time", javaType = Date.class),
            @Result(property = "thirdClassify", column = "Fthird_classify", javaType = String.class),
            @Result(property = "hospital", column = "Fhospital", javaType = String.class)
    })
    List<IndicatorItem> getAll();

}