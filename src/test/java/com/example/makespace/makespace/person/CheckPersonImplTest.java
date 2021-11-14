package com.example.makespace.makespace.person;

import org.hibernate.annotations.Check;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(
        MockitoExtension.class
)
class CheckPersonImplTest {

    @Mock
    CheckPerson checkPerson;

    @Test
    void checkPerson() {
        //given
        int person = 1;
        given(checkPerson.checkPerson(person)).willThrow(RuntimeException.class);
        //when

        //then
        assertThrows(RuntimeException.class,() -> {
            checkPerson.checkPerson(person);
        });
    }
}