package com.spinos.myapp.dao;

import com.spinos.myapp.model.Foo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FooDao {
    List<Foo> selectAllFoos();

    Optional<Foo> selectFooById(UUID id);

    int insertFoo(UUID id, Foo foo);

    default int insertFoo(Foo foo){
        UUID id = UUID.randomUUID();
        return insertFoo(id, foo);
    }

    int saveFoo(Foo foo);

    int updateFoo(UUID id, Foo foo);

    int deleteFoo(UUID id);

    // Optional<Foo> selectFoo(UUID id){}
}
