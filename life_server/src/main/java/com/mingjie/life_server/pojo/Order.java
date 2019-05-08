package com.mingjie.life_server.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "life_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(255) default '' COMMENT '消费名称'")
    private String name;
    @Column(columnDefinition = "numeric(10,2) default '0.00' COMMENT '价格'")
    private BigDecimal price;
    @Column(columnDefinition = "int(3) default 0 COMMENT '数量'")
    private Integer count;
    @Column(columnDefinition = "varchar(10) default '' COMMENT '消费者'")
    private String username;

    @ApiModelProperty(hidden = true)
    @Column(columnDefinition = "int(10) default 0 COMMENT '创建时间'")
    private Integer createdTime;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", username='" + username + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }

    public Integer getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Integer createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
