package com.soufang.soufang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SupportAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String belongTo;
    private String enName;
    private String cnName;
    private String level;
    private Double baiduMapLng;
    private Double baiduMapLat;

    public Integer getId() {
        return id;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public String getEnName() {
        return enName;
    }

    public String getCnName() {
        return cnName;
    }

    public String getLevel() {
        return level;
    }

    public Double getBaiduMapLng() {
        return baiduMapLng;
    }

    public Double getBaiduMapLat() {
        return baiduMapLat;
    }

    public enum Level {
        CITY("city"),
        REGION("region");

        private String value;

        Level(String level) {
            this.value = level;
        }

        public String getValue() {
            return this.value;
        }

        public static Level of(String value) {
            for (Level level : Level.values()) {
                if (level.getValue().equals(value)) {
                    return level;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
