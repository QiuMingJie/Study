package com.springStudy;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @author QiuMingJie
 * @date 2019-11-19 10:36
 * @Description
 */
public class CStopEventHandler implements ApplicationListener<ContextClosedEvent> {
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("ContextStoppedEvent Received");
    }
}
