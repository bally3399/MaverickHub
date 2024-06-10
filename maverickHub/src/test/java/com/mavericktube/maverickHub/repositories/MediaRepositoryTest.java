package com.mavericktube.maverickHub.repositories;

import com.mavericktube.maverickHub.models.Media;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Sql({"/db/data.sql"})
class MediaRepositoryTest {
    @Autowired
    private MediaRepository mediaRepository;
    @Test
    public void findAllMediaFor() {
        List<Media> media = mediaRepository.findAllMediaFor(200L);
        assertThat(media.size()).isEqualTo(5);
    }

}