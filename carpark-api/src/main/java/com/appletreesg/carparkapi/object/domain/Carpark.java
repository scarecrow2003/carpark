package com.appletreesg.carparkapi.object.domain;

import lombok.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: zhihua.su
 * @date: 2019-07-20
 * @time: 12:48
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carpark {

    private Result result;

    @Getter
    @Setter
    public static class Result {
        private List<CarparkInfo> records;
    }
}
