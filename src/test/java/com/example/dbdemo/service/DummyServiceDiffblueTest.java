package com.example.dbdemo.service;

import com.example.dbdemo.entity.Child;
import com.example.dbdemo.entity.Dummy;
import com.example.dbdemo.repo.ChildRepository;
import com.example.dbdemo.repo.DummyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {DummyService.class})
@ExtendWith(SpringExtension.class)
class DummyServiceDiffblueTest {
    @MockBean
    private ChildRepository childRepository;

    @MockBean
    private DummyRepository dummyRepository;

    @Autowired
    private DummyService dummyService;

    /**
     * Method under test: {@link DummyService#getDummies()}
     */
    @Test
    void testGetDummies() {
        ArrayList<Dummy> dummyList = new ArrayList<>();
        when(dummyRepository.findAll()).thenReturn(dummyList);
        List<Dummy> actualDummies = dummyService.getDummies();
        verify(dummyRepository).findAll();
        assertTrue(actualDummies.isEmpty());
        assertSame(dummyList, actualDummies);
    }

    /**
     * Method under test: {@link DummyService#getChildren(Long)}
     */
    @Test
    void testGetChildren() {
        ArrayList<Child> childList = new ArrayList<>();
        when(childRepository.findByDummyId(Mockito.<Long>any())).thenReturn(childList);
        List<Child> actualChildren = dummyService.getChildren(1L);
        verify(childRepository).findByDummyId(Mockito.<Long>any());
        assertTrue(actualChildren.isEmpty());
        assertSame(childList, actualChildren);
    }

    /**
     * Method under test: {@link DummyService#saveDummy(Dummy)}
     */
    @Test
    void testSaveDummy() {
        when(dummyRepository.save(Mockito.<Dummy>any())).thenReturn(new Dummy());
        dummyService.saveDummy(new Dummy());
        verify(dummyRepository).save(Mockito.<Dummy>any());
    }

    /**
     * Method under test: {@link DummyService#deleteDummy(Long)}
     */
    @Test
    void testDeleteDummy() {
        doNothing().when(dummyRepository).deleteById(Mockito.<Long>any());
        dummyService.deleteDummy(1L);
        verify(dummyRepository).deleteById(Mockito.<Long>any());
    }
}
