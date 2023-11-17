package com.example.travelpal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TravelpalApplicationTests {

	@Test
	void itShould() {
		assertThat(2).isEqualTo(2);
	}

}
