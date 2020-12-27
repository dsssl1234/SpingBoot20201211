package com.example.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import javax.xml.crypto.Data;

public class user {
    //设置成IdType.AUTO表示自增,数据库的字段也必须设置成自增
    @TableId(type = IdType.AUTO)
    private long id;

    //字段添加填充内容(修改的时候)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Data updateTime;

    //字段添加填充内容(添加的时候)
    @TableField(fill = FieldFill.INSERT)
    private Data createTime;
}
