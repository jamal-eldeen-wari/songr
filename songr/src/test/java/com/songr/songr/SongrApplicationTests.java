package com.songr.songr;

import com.songr.songr.model.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class SongrApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Test
	void contextLoads() {
	}

//	@Test void albumConstructor(){
//		Album album = new Album("Long Year","Steve Everett",24,180,"https://f4.bcbits.com/img/0007272500_10.jpg");
//		album.setTitle("Long Year");
//		assertEquals("Long Year",album.getTitle());
//		album.setArtist("Steve Everett");
//		assertEquals("Steve Everett", album.getArtist());
//		assertEquals(24,album.getSongCount());
//		assertEquals(180, album.getLength());
//	}
	@Test
	public void testRequestStatusAndReturn() throws Exception{
		this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Songr")));
	}



}
