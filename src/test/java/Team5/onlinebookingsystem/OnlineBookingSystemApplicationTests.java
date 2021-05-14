package Team5.onlinebookingsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OnlineBookingSystemApplicationTests {

	@Test
	// The main method should run without any exceptions
	void mainTest() {
		assertDoesNotThrow(() -> OnlineBookingSystemApplication.main(new String[]{}));
	}
}



