package com.spinos.myapp.controller;

import com.spinos.myapp.exception.RecordNotFoundException;
import com.spinos.myapp.model.Foo;
import com.spinos.myapp.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/myapp") // URI prefix
@RestController
public class FooController {

    private final FooService fooService;

    @Autowired
    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    // GET http://localhost:8080/api/v1/myapp/foo
    @GetMapping("/foo")
    public List<Foo> getAllFoos() {
        return fooService.getAllFoos();
    }

    // GET http://localhost:8080/api/v1/myapp/foo/ec96bf33-bccf-407e-b54a-58fe36141088
    @GetMapping("/foo/{id}")
    public Optional<Foo> getFooById(@PathVariable("id") UUID id) {
        return fooService.selectFooById(id);
    }

    /**
     * POST http://localhost:8080/api/v1/myapp/foo
     * {
     * "name": "brian",
     * "description": "description-1",
     * }
     */
    @PostMapping("/foo")
    public void addFoo(@RequestBody Foo foo) {
        fooService.saveFoo(foo);
    }

    /**
     * PUT http://localhost:8080/api/v1/myapp/foo/fc985165-06eb-4236-9a2d-82afa3404487
     * {
     * "name": "name2",
     * "description": "description2",
     * }
     */
    @PutMapping("/foo/{id}")
    public void updateFoo(@PathVariable("id") UUID id, /* @Valid */ @RequestBody Foo foo) {
        fooService.updateFoo(id, foo);
    }

    /**
     * DELETE http://localhost:8080/api/v1/myapp/foo/fc985165-06eb-4236-9a2d-82afa3404487
     */
    @DeleteMapping("/foo/{id}")
    public void deleteFoo(@PathVariable("id") UUID id) {
        fooService.deleteFoo(id);
    }

//    @GetMapping("users/{id}")
//    public ResponseEntity<Foo> getById(@
//    PathVariable long id) throws RecordNotFoundException {
//        Optional<Foo> user = Optional.of(new Foo(1L,"foo-name", "foo-desc"));
//        if (user.isPresent()) {
//            return new ResponseEntity<>(user.get(), HttpStatus.OK);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }


//    @PostMapping(path = "users",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> create(@RequestBody User newUser) {
//        User user = userService.save(newUser);
//        if (user == null) {
//            throw new ServerException();
//        } else {
//            return new ResponseEntity<>(user, HttpStatus.CREATED);
//        }
//    }

    // GET http://localhost:8080/api/v1/myapp/hello?name=brian
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
