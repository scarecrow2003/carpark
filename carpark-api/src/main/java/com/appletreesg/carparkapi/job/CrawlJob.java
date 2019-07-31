package com.appletreesg.carparkapi.job;

import com.appletreesg.carparkapi.object.domain.Carpark;
import com.appletreesg.carparkapi.object.domain.CarparkAvailabity;
import com.appletreesg.carparkapi.service.CarparkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

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
    @Value("${carpark.availability.url}")
    private String carparkAvailabilityUrl;

    @Value("${carpark.data.url}")
    private String carparkDataUrl;

    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    private final CarparkService carparkService;

    @Autowired
    public CrawlJob(CarparkService carparkService) {
        this.carparkService = carparkService;
    }

    @Scheduled(cron = "0 0/2 7,8,9,12,13,17,18,19 * * *")
    public void peekHourCraw() {
        crawlData();
    }

    @Scheduled(cron = "0 0/5 0,1,2,3,4,5,6,10,11,14,15,16,20,21,22,23 * * *")
    public void offPeekHourCrawl() {
        crawlData();
    }

    private void crawlData() {
        RestTemplate restTemplate = new RestTemplate();
        CarparkAvailabity response = restTemplate.getForObject(carparkAvailabilityUrl, CarparkAvailabity.class);
        log.info(response.getItems().get(0).getCarpark_data().size()+"");
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        RestTemplate restTemplate = new RestTemplate();
        Carpark response = restTemplate.getForObject(carparkDataUrl, Carpark.class);
        carparkService.loadCarpark(response.getResult().getRecords());
    }
}
