package com.example.dbdemo.app;

import com.example.dbdemo.entity.Child;
import com.example.dbdemo.entity.Dummy;
import com.example.dbdemo.usecase.DummyUseCase;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(value = "/dummies")
public class DummyController {
    private final DummyUseCase dummyUseCase;

    public DummyController(DummyUseCase dummyUseCase) {
        this.dummyUseCase = dummyUseCase;
    }

    @GetMapping
    public List<Dummy> list() {
        return dummyUseCase.allDummies();
    }

    @PostMapping
    public Dummy add(@RequestBody @Validated DummyAddRequest request) {
        return dummyUseCase.addDummy(request.toDummy());

    }
    @PutMapping("/{id}")
    public Dummy add(@PathVariable Long id,@RequestBody @Validated DummyAddRequest request) {
        return dummyUseCase.editDummy(request.toDummy(),id);

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
