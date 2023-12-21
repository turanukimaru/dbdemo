package com.example.dbdemo.app;

import com.example.dbdemo.entity.Dummy;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DummyAddRequest {
    @Size(min = 1, max = 100)
    private String name;
    @Size(min = 1, max = 1000)
    private String text;
    @Size(min = 1, max = 1000)
    private String comment;

    public Dummy toDummy() {
        return new Dummy(name, text, comment);
    }
}
