package cn.kgc.tangcco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Integer id;
  private String userName;
  private String password;
  private String nickName;
  private String telephone;
  private String email;
  private String createTime;
  private String updateTime;
  private Integer accountStatus;//默认为0 被锁定为1
  private Integer status;//默认为0,超级管理员为1
  
}
