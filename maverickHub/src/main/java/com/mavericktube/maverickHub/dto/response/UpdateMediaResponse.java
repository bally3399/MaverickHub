package com.mavericktube.maverickHub.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mavericktube.maverickHub.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateMediaResponse {
    @JsonProperty("Media_url")
    private String url;
    private long id;
    @JsonProperty("media_description")
    private String description;
    private Category category;

    private LocalDateTime timeCreated;
    private LocalDateTime timeUpdated;
}
