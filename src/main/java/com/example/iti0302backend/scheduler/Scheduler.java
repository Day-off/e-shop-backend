package com.example.iti0302backend.scheduler;

import com.example.iti0302backend.dto.ActivitySuggestionsDTO;
import com.example.iti0302backend.service.ActivityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Component

public class Scheduler {
    private final RestTemplate restTemplate;
    private final ActivityService activityService;

    @Scheduled(fixedDelay = 20000)
    public void printActivity() {
        String url = "https://www.boredapi.com/api/activity";
        ActivitySuggestionsDTO response = restTemplate.getForObject(url, ActivitySuggestionsDTO.class);
        assert response != null;
        if (response.getActivity() != null) {
            activityService.setActivity(response.getActivity());
            log.info("Suggested activities to do is " + response.getActivity());
        } else {
            log.info("No available activities to promote");
        }
    }
}
