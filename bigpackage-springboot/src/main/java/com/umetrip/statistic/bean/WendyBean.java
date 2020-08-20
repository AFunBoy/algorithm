package com.umetrip.statistic.bean;

import lombok.Data;

/**
 * @ClassName WendyBean
 * @Description TODO
 * @Author 王帆
 * @Date 2020/2/9 22:08
 * @Version 1.0
 */
@Data
public class WendyBean {
    /**
     * 公司名称
     */
    private String businessName;
    private String proName;
    private String province;
    private String city;
    /**
     * 物业分类
     */
    private String category;

    /**
     * 建筑面积
     */
    private Double floorage;
    /**
     * 每日口罩消耗量
     */
    private Double maskWastage;
    /**
     * 每日消毒水消耗量
     */
    private Double waterWastage;
}
