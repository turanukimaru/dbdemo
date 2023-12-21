package com.example.dbdemo.usecase;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.dbdemo.entity.Child;
import com.example.dbdemo.entity.Dummy;
import com.example.dbdemo.service.DummyService;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DummyUseCase.class})
@ExtendWith(SpringExtension.class)
class DummyUseCaseDiffblueTest {
    @MockBean
    private DummyService dummyService;

    @Autowired
    private DummyUseCase dummyUseCase;

    /**
     * Method under test: {@link DummyUseCase#allDummies()}
     */
    @Test
    void testAllDummies() {
        ArrayList<Dummy> dummyList = new ArrayList<>();
        when(dummyService.getDummies()).thenReturn(dummyList);
        List<Dummy> actualAllDummiesResult = dummyUseCase.allDummies();
        verify(dummyService).getDummies();
        assertTrue(actualAllDummiesResult.isEmpty());
        assertSame(dummyList, actualAllDummiesResult);
    }

    /**
     * Method under test: {@link DummyUseCase#findChildren(Long)}
     */
    @Test
    void testFindChildren() {
        ArrayList<Child> childList = new ArrayList<>();
        when(dummyService.getChildren(Mockito.<Long>any())).thenReturn(childList);
        List<Child> actualFindChildrenResult = dummyUseCase.findChildren(1L);
        verify(dummyService).getChildren(Mockito.<Long>any());
        assertTrue(actualFindChildrenResult.isEmpty());
        assertSame(childList, actualFindChildrenResult);
    }

    /**
     * Method under test: {@link DummyUseCase#addDummy(Dummy)}
     */
    @Test
    void testAddDummy() {
        doNothing().when(dummyService).saveDummy(Mockito.<Dummy>any());
        Dummy dummy = new Dummy();
        Dummy actualAddDummyResult = dummyUseCase.addDummy(dummy);
        verify(dummyService).saveDummy(Mockito.<Dummy>any());
        assertSame(dummy, actualAddDummyResult);
    }

    /**
     * Method under test: {@link DummyUseCase#editDummy(Dummy, Long)}
     */
    @Test
    void testEditDummy() {
        doNothing().when(dummyService).saveDummy(Mockito.<Dummy>any());
        when(dummyService.getDummy(Mockito.<Long>any())).thenReturn(new Dummy());
        Dummy dummy = new Dummy();
        Dummy actualEditDummyResult = dummyUseCase.editDummy(dummy, 1L);
        verify(dummyService).getDummy(Mockito.<Long>any());
        verify(dummyService).saveDummy(Mockito.<Dummy>any());
        assertSame(dummy, actualEditDummyResult);
    }

    /**
     * Method under test: {@link DummyUseCase#editDummy(Dummy, Long)}
     */
    @Test
    void testEditDummy2() {
        doNothing().when(dummyService).saveDummy(Mockito.<Dummy>any());
        when(dummyService.getDummy(Mockito.<Long>any())).thenReturn(new Dummy("name", "name", "name"));
        Dummy dummy = new Dummy();
        Dummy actualEditDummyResult = dummyUseCase.editDummy(dummy, 1L);
        verify(dummyService).getDummy(Mockito.<Long>any());
        verify(dummyService).saveDummy(Mockito.<Dummy>any());
        assertSame(dummy, actualEditDummyResult);
    }

    /**
     * Method under test: {@link DummyUseCase#editDummy(Dummy, Long)}
     */
    @Test
    void testEditDummy3() {
        doNothing().when(dummyService).saveDummy(Mockito.<Dummy>any());
        when(dummyService.getDummy(Mockito.<Long>any())).thenReturn(new Dummy());
        Dummy dummy = new Dummy("name", "name", "name");

        Dummy actualEditDummyResult = dummyUseCase.editDummy(dummy, 1L);
        verify(dummyService).getDummy(Mockito.<Long>any());
        verify(dummyService).saveDummy(Mockito.<Dummy>any());
        assertSame(dummy, actualEditDummyResult);
    }

    /**
     * Method under test: {@link DummyUseCase#deleteDummy(Long)}
     */
    @Test
    void testDeleteDummy() {
        doNothing().when(dummyService).deleteDummy(Mockito.<Long>any());
        dummyUseCase.deleteDummy(1L);
        verify(dummyService).deleteDummy(Mockito.<Long>any());
    }
}
