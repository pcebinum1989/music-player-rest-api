package com.musicplayer.musicplayerrestapi.repositories;

import TestUtils.TestSongs;
import com.musicplayer.musicplayerrestapi.models.Song;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SongRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private SongRepository songRepository;

    @Test
    public void repoSavesInDB() throws Exception{

        //arrange
        Song song = TestSongs.getSongs().get(0);

        //act
        Integer id = testEntityManager.persistAndGetId(song,Integer.class);
        Song foundSong = songRepository.findById(id).orElse(null);

        //assert
        assertThat(foundSong.getTitle()).isEqualTo(song.getTitle());
    }

}