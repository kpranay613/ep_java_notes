package test.suites;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.calsi.Calculator;

public class AdditionTest {

	@Tag("dev")
	@Test
	void addTest() {

			Calculator cal = new Calculator();
			
			assertEquals(10, cal.add(5, 5));
		
		
	}

}
