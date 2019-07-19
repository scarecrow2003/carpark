package com.appletreesg.carparkapi.job;

import com.appletreesg.carparkapi.object.domain.CarparkData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: zhihua.su
 * @date: 2019-07-19
 * @time: 22:55
 */

@Slf4j
@Configuration
@EnableScheduling
public class CrawlJob {
    @Value("${carpark.data.url}")
    private String carparkDataUrl;

    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    @Scheduled(cron = "0 0/2 7,8,9,12,13,17,18,19 * * *")
    public void peekHourCraw() {
        crawlData();
    }

    @Scheduled(cron = "0 0/5 0,1,2,3,4,5,6,10,11,14,15,16,20,21,22,23 * * *")
    public void offPeekHourCrawl() {
        crawlData();
    }

    @Scheduled(cron = "0/5 * * * * * ")
    public void testCrawl() {
        crawlData();
    }

    private void crawlData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = carparkDataUrl + "?date_time=" + DATE_FORMAT.format(new Date());
        log.info(url);
        CarparkData response = restTemplate.getForObject(url, CarparkData.class);
        log.info(response.getItems().get(0).getCarpark_data().size()+"");
    }
}
