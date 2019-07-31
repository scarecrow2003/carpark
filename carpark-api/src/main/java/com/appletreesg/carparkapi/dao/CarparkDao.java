package com.appletreesg.carparkapi.dao;

import com.appletreesg.carparkapi.object.domain.CarparkInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: zhihua.su
 * @date: 2019-07-30
 * @time: 16:14
 */
public interface CarparkDao {
    int insertCarpark(CarparkInfo carparkInfo);
}
