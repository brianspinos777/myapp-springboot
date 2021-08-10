package com.spinos.myapp.dao;

import com.spinos.myapp.model.Foo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Component is same as @Repository
@Repository("fakeDao") // for dependency injection
public class FakeFooDataAccessService implements FooDao {
    private static final List<Foo> DB = new ArrayList<>();

    @Override
    public List<Foo> selectAllFoos() {
        return null;
    }

    @Override
    public Optional<Foo> selectFooById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int insertFoo(UUID id, Foo foo) {
        DB.add(new Foo(id, foo.getName(), foo.getDescription()));
        return 0;
    }

    @Override
    public int saveFoo(Foo foo) {
        return 0;
    }

    @Override
    public int updateFoo(UUID id, Foo foo) {
        return 0;
    }

    @Override
    public int deleteFoo(UUID id) {
        return 0;
    }
}
