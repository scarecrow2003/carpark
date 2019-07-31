package com.appletreesg.carparkapi.service;

import com.appletreesg.carparkapi.object.domain.CarparkInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: zhihua.su
 * @date: 2019-07-25
 * @time: 23:38
 */
public interface CarparkService {
    void loadCarpark(List<CarparkInfo> carparkInfoList);
}
