package com.umetrip.statistic.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Administrator on 2016/11/22.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatisticsItem {

    private String id;
    private String totalCount;
    private String failCount;
    private String failPercent;
    private String tps;
    private String percent;


}
