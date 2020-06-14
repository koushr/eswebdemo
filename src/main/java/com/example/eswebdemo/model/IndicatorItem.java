package com.example.eswebdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author shengruikou
 */
@Data
@NoArgsConstructor
public class IndicatorItem {

    private int id;

    private String name;

    private String sname;

    private String code;

    private String scode;

    private String standard;

    private String user;

    private int type;

    private String typeName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date insertTime;

    private String thirdClassify;

    private String hospital;

}
