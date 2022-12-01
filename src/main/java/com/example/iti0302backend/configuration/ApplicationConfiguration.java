package com.example.iti0302backend.configuration;


import com.example.iti0302backend.dto.ActivitySuggestionsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;



@Slf4j
@Configuration
@EnableScheduling
public class ApplicationConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Scheduled(fixedDelay = 20000)
    public void printAJoke() {
        String url = "https://www.boredapi.com/api/activity";
        var response = restTemplate().getForObject(url, ActivitySuggestionsDTO.class);
        assert response != null;
        if (response.getActivity() != null) {
            log.info("Suggested activities to do is " + response.getActivity());
        } else {
            log.info("No available activities to promote");
        }
    }
}
