package com.example.makespace.makespace.time;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CheckTimeImplTest 
{
	@Mock
	CheckTimeImpl checkTime;

	@Test
	void testCheckTime()
	{
		//given
		String startTime="15:01";
		String endTime ="18:45";
		given(checkTime.checkTime(startTime,endTime)).willReturn(false);
		//when
		boolean result = checkTime.checkTime(startTime,endTime);
		//then
		assertFalse(result);
//		assertThrows(RuntimeException.class,() -> {
//			checkTime.checkTime(startTime,endTime);
//		});
	}
		
}


