package com.example.makespace.makespace.HelperPackage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class SuperHelperImplTest {

    @Spy
    SuperHelperImpl superHelperImpl=
            new SuperHelperImpl("vacancy","10:15","12:15","8");

    @Test
    void processInput()
    {
       //given
        List<String> stubReturnedList = new ArrayList<>();
        stubReturnedList.add("G-Mansion1");
        List<String> returnedList ;
        given(superHelperImpl.processInput()).willReturn(stubReturnedList);
        //when
        returnedList = superHelperImpl.processInput();
        //then
        assertEquals(stubReturnedList,returnedList);

    }
}