package org.imw.easybi.pojo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mail")
@Getter
@Setter
public class Mail {
    @Id
    private  String id;
    @Column
    private  String mailUrl;
    @Column
    private  String mailPassword;
}
