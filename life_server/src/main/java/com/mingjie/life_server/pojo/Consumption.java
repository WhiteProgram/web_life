package com.mingjie.life_server.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 消费表
 */
@Entity
@Table(name = "life_consumption")
@Data
public class Consumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(255) default '' COMMENT '消费名称'")
    private String name;
    @Column(columnDefinition = "numeric(10,2) default '0.00' COMMENT '消费金额'")
    private BigDecimal fee;
    @Column(columnDefinition = "varchar(10) default '' COMMENT '消费者'")
    private String username;

    @ApiModelProperty(hidden = true)
    @Column(columnDefinition = "int(10) default 0 COMMENT '创建时间'")
    private Integer createdTime;

    @ApiModelProperty(hidden = true)
    @Column(columnDefinition = "int(1) default 1 COMMENT '逻辑状态，1为正常，0为删除'")
    private Integer status;

    @ApiModelProperty(value = "消费备注")
    @Column(columnDefinition = "varchar(255) default '' COMMENT '消费备注'")
    private String marks;

}
