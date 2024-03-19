package dev.danvega.hellovaadin.post;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record Post(
        String title,
        String summary,
        String url,
        @JsonProperty("date_published")
        LocalDate datePublished,
        Author author
) {

}