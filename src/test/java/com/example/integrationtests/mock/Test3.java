package com.example.integrationtests.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

/**
 * @author Gaojx
 */
public class Test3 {

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Mock
    HashMap<String, Integer> mockHashMap;

    @Test
    public void saveTest()
    {
        mockHashMap.put("A", 1);

        Mockito.verify(mockHashMap, times(1)).put("A", 1);
        Mockito.verify(mockHashMap, times(0)).get("A");

        assertEquals(0, mockHashMap.size());

    }

    @Spy
    HashMap<String, Integer> spyHashMap;

    @Test
    public void saveTest2()
    {
        spyHashMap.put("A", 10);

        Mockito.verify(spyHashMap, times(1)).put("A", 10);
        Mockito.verify(spyHashMap, times(0)).get("A");

        assertEquals(1, spyHashMap.size());
        assertEquals(new Integer(10), (Integer) spyHashMap.get("A"));
    }

    @Mock
    HashMap<String, Integer> hashMap;

    @Captor
    ArgumentCaptor<String> keyCaptor;

    @Captor
    ArgumentCaptor<Integer> valueCaptor;

    @Test
    public void saveTest3()
    {
        hashMap.put("A", 10);

        Mockito.verify(hashMap).put(keyCaptor.capture(), valueCaptor.capture());

        assertEquals("A", keyCaptor.getValue());
        assertEquals(new Integer(10), valueCaptor.getValue());
    }
}
