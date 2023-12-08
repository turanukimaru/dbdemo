package com.example.dbdemo.app;

import com.example.dbdemo.entity.Dummy;
import com.example.dbdemo.usecase.DummyUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {DummyController.class})
@ExtendWith(SpringExtension.class)
class DummyControllerDiffblueTest {
    @Autowired
    private DummyController dummyController;

    @MockBean
    private DummyUseCase dummyUseCase;

    /**
     * Method under test: {@link DummyController#add()}
     */
    @Test
    void testAdd() throws Exception {
        when(dummyUseCase.allDummies()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummies");
        MockMvcBuilders.standaloneSetup(dummyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link DummyController#add()}
     */
    @Test
    void testAdd2() throws Exception {
        ArrayList<Dummy> dummyList = new ArrayList<>();
        dummyList.add(new Dummy());
        when(dummyUseCase.allDummies()).thenReturn(dummyList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummies");
        MockMvcBuilders.standaloneSetup(dummyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("[{\"name\":null,\"text\":null,\"comment\":null,\"childList\":null,\"dummyId\":null}]"));
    }

    /**
     * Method under test: {@link DummyController#delete(Long)}
     */
    @Test
    void testDelete() throws Exception {
        doNothing().when(dummyUseCase).deleteDummy(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/dummies/{id}", 1L);
        MockMvcBuilders.standaloneSetup(dummyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link DummyController#delete(Long)}
     */
    @Test
    void testDelete2() throws Exception {
        doNothing().when(dummyUseCase).deleteDummy(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/dummies/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(dummyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link DummyController#children(Long)}
     */
    @Test
    void testChildren() throws Exception {
        when(dummyUseCase.findChildren(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummies/{id}/children", 1L);
        MockMvcBuilders.standaloneSetup(dummyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}
