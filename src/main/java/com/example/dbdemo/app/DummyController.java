package com.example.dbdemo.app;

import com.example.dbdemo.entity.Child;
import com.example.dbdemo.entity.Dummy;
import com.example.dbdemo.usecase.DummyUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/dummies")
public class DummyController {
    private final DummyUseCase dummyUseCase;

    public DummyController(DummyUseCase dummyUseCase) {
        this.dummyUseCase = dummyUseCase;
    }

    @GetMapping
    public List<Dummy> list() {
        return dummyUseCase.allDummies();
    }
    @PutMapping
    public Dummy add() {
        return dummyUseCase.newDummy();

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dummyUseCase.deleteDummy(id);
    }

    @GetMapping("/{id}/children")
    public List<Child> children(@PathVariable Long id) {
        return dummyUseCase.findChildren(id);
    }
}
