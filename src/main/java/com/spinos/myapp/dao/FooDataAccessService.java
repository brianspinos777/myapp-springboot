package com.spinos.myapp.dao;

import com.spinos.myapp.model.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Component is same as @Repository
@Repository("postgres") // for dependency injection
public class FooDataAccessService implements FooDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FooDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Foo> selectAllFoos() {
        final String sql = "SELECT id, name FROM foo";
        List<Foo> queryResult = jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Foo(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name"),
                    "default-description");
        });
        return queryResult;
    }

    @Override
    public Optional<Foo> selectFooById(UUID id) {
        final String sql = "SELECT id, name FROM foo WHERE id = ?";
        Foo foo = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            return new Foo(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name"),
                    "default-description");
        });
        return Optional.ofNullable(foo);
    }

    @Override
    public int insertFoo(UUID id, Foo foo) {
        return 0;
    }

    @Override
    public int insertFoo(Foo foo) {
        return FooDao.super.insertFoo(foo);
    }

    @Override
    public int saveFoo(Foo foo) {
        final String sql = "INSERT INTO foo (id, name) VALUES (uuid_generate_v4(), ?)";
        int savedRecordCount = jdbcTemplate.update(sql, foo.getName());
        return savedRecordCount;
    }

    @Override
    public int updateFoo(UUID id, Foo foo) {
        final String sql = "UPDATE foo SET name = ? WHERE id = ?";
        int updatedRecordCount = jdbcTemplate.update(sql, foo.getName(), id);
        return updatedRecordCount;
    }

    @Override
    public int deleteFoo(UUID id) {
        final String sql = "DELETE FROM foo WHERE id = ?";
        int deletedRecordCount = jdbcTemplate.update(sql, id);
        return deletedRecordCount;
    }
}
