package org.imw.easybi.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
@Setter
@Getter
@ToString
public class UserInfo {

    @Id
    private String id;
    @Column
    private  String nickname;
    @Column(length = 32,nullable = false,unique = true)
    private String tel;
    @Column
    private String gender;
    @Column
    private String birthday;
}
