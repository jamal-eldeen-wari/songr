package com.songr.songr;

import com.songr.songr.model.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test void albumConstructor(){
		Album album = new Album("Long Year","Steve Everett",24,180,"https://f4.bcbits.com/img/0007272500_10.jpg");
		album.setTitle("Long Year");
		assertEquals("Long Year",album.getTitle());
		album.setArtist("Steve Everett");
		assertEquals("Steve Everett", album.getArtist());
		assertEquals(24,album.getSongCount());
		assertEquals(180, album.getLength());
	}

	

}
