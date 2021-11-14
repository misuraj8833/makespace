package com.example.makespace.makespace.printResult;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResultPrintImplTest {


    @Test
    void printResult() {
        //given
        String stubInput = "NO_VACANT_ROOM";
        ResultPrint resultPrint = new ResultPrintImpl();
        //when
        resultPrint.setInput("NO_VACANT_ROOM");
        //then
        assertEquals(resultPrint.getInput(),stubInput);
    }
}