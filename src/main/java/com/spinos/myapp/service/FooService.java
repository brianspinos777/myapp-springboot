package com.spinos.myapp.service;

import com.spinos.myapp.dao.FooDao;
import com.spinos.myapp.model.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FooService {
    private FooDao fooDao;

    @Autowired // dependency injection!
    public FooService(@Qualifier("postgres") FooDao fooDao) {
        this.fooDao = fooDao;
    }

    public Foo getFoo() {
        return new Foo(UUID.randomUUID(), "foo-name", "foo-desc");
    }

    public int addFoo(Foo foo) {
        return fooDao.insertFoo(foo);
    }

    public List<Foo> getAllFoos() {
        return fooDao.selectAllFoos();
    }

    public Optional<Foo> selectFooById(UUID id) {
        return fooDao.selectFooById(id);
    }

    public int saveFoo(Foo foo) {
        return fooDao.saveFoo(foo);
    }

    public int updateFoo(UUID id, Foo foo) {
        return fooDao.updateFoo(id, foo);
    }

    public int deleteFoo(UUID id) {
        return fooDao.deleteFoo(id);
    }
}
