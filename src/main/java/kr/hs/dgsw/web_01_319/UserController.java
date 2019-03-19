package kr.hs.dgsw.web_01_319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseBody
    public List<User> list(){
        return this.userService.list();

    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(@PathVariable String id){
        return this.userService.view(id);
    }

    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user){
        return this.userService.add(user);
    }

    @GetMapping("/user/string")
    public String listString(){
        return this.userService.listString();
    }
    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user){
        return this.userService.update(user);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id){
        return this.userService.delete(id);
    }
}
//GET(read) POST(insert) PUT(update) DELETE(delete)
// CRUD Create Read Update Delete
//SQL  insert select update delete
