package com.soufang.soufang.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class HouseDTO {
    // Long 类型的数据，后端一般建议转换成 string
    // 这是因为前端的 number 类型只有 16 位，后端的 long 的长度会比前端的 number 类型大
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String title;
    private String street;
    private String cityEnName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCityEnName() {
        return cityEnName;
    }

    public void setCityEnName(String cityEnName) {
        this.cityEnName = cityEnName;
    }
}
