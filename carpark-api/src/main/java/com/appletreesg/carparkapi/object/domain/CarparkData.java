package com.appletreesg.carparkapi.object.domain;

import lombok.Getter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: zhihua.su
 * @date: 2019-07-20
 * @time: 00:18
 */

@Getter
public class CarparkData {
    private List<CarparkTimeData> items;

    @Getter
    public static class CarparkTimeData {
        private String timestamp;

        private List<CarparkItem> carpark_data;
    }

    @Getter
    public static class CarparkItem {
        private List<CarparkInfo> carpark_info;

        private String carpark_number;

        private String update_datetime;
    }

    @Getter
    public static class CarparkInfo {
        private String total_lots;

        private String lot_type;

        private String lots_available;
    }
}
