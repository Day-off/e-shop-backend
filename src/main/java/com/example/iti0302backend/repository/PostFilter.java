package com.example.iti0302backend.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostFilter {

    private int page;
    private String header;
    private String orderBy;
    private String order;

    public int getFirstResult() {
        return page * 10;
    }
}
