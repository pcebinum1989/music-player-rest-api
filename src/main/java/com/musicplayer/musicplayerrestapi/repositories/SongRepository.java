package com.musicplayer.musicplayerrestapi.repositories;

import com.musicplayer.musicplayerrestapi.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Integer> {
}
