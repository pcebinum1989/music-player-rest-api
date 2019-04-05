package com.musicplayer.musicplayerrestapi.IntegrationTests;


import TestUtils.TestSongs;
import com.musicplayer.musicplayerrestapi.repositories.SongRepository;
import com.musicplayer.musicplayerrestapi.services.SongService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SongIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void postingSong_savesTheSong(){

        ResponseEntity<String> response = testRestTemplate.postForEntity(
                "/song", TestSongs.getSongs().get(1), String.class
        );

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("saved");
    }

}




