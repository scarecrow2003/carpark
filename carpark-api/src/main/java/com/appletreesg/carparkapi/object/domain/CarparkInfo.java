package com.appletreesg.carparkapi.object.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: zhihua.su
 * @date: 2019-07-31
 * @time: 16:40
 */

@Getter
@Setter
public class CarparkInfo {
    private String short_term_parking;

    private String car_park_type;

    private String y_coord;

    private String x_coord;

    private String free_parking;

    private String gantry_height;

    private String car_park_basement;

    private String night_parking;

    private String address;

    private String car_park_decks;

    private String _id;

    private String car_park_no;

    private String type_of_parking_system;
}
