package com.example.dbdemo.usecase;

import com.example.dbdemo.entity.Child;
import com.example.dbdemo.entity.Dummy;
import com.example.dbdemo.service.DummyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DummyUseCase {
    private final DummyService dummyService;

    public DummyUseCase(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @Transactional
    public List<Dummy> allDummies(){
        return dummyService.getDummies();
    }

    @Transactional
    public List<Child> findChildren(Long dummyId) {
        return dummyService.getChildren(dummyId);
    }
    @Transactional
    public Dummy addDummy(Dummy dummy) {
        dummyService.saveDummy(dummy);
        return dummy;
    }
    @Transactional
    public Dummy editDummy(Dummy dummy,Long id) {
        Dummy old = dummyService.getDummy(id);
        old.setName(dummy.getName());
        dummyService.saveDummy(dummy);
        return dummy;
    }
    @Transactional
    public void deleteDummy(Long dummyId) {
        dummyService.deleteDummy(dummyId);
    }
}
