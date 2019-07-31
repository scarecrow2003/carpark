package com.appletreesg.carparkapi.service;

import com.appletreesg.carparkapi.dao.CarparkDao;
import com.appletreesg.carparkapi.object.domain.CarparkInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: zhihua.su
 * @date: 2019-07-25
 * @time: 23:39
 */

@Slf4j
@Service
public class CarparkServiceImpl implements CarparkService {
    private final Map<String, Map<String, CarparkInfo>> map = new HashMap<>(100);

    private final CarparkDao carparkDao;

    @Autowired
    public CarparkServiceImpl(CarparkDao carparkDao) {
        this.carparkDao = carparkDao;
    }

    @Override
    public void loadCarpark(List<CarparkInfo> carparkInfoList) {
        CarparkInfo carparkInfo = carparkInfoList.get(0);
        carparkDao.insertCarpark(carparkInfo);
    }
}
