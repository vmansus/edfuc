package com.ljh.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor//生成全参数构造函数
@NoArgsConstructor//生成无参构造函数
public class User {
    private String name;
    private int age;
    private String sex;
}
