package com.musicplayer.musicplayerrestapi.servicestests;


import com.musicplayer.musicplayerrestapi.models.Song;
import com.musicplayer.musicplayerrestapi.repositories.SongRepository;
import com.musicplayer.musicplayerrestapi.services.SongService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Duration;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SongServiceTest {

    @Mock
    private SongRepository songRepository;

    private SongService songService;


    @Before
    public void setUp(){
        this.songService = new SongService(songRepository);
    }

    @Test
    public void saveSong_invokesRepoSave(){
        //arrange
        Song song = new Song("FKJ and msego","Tadow", Duration.ofSeconds(274));

        //act
        songService.saveSong(song);

        //assert
        verify(songRepository, times(1)).save(song);
    }
}