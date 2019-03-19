package kr.hs.dgsw.web_01_319;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> userList;

    public UserServiceImpl() {
        userList = new ArrayList<>();
        userList.add(new User("dgsw1","user1","user111@dgsw"));
        userList.add(new User("dgsw2", "user2","user222@dgsw"));
        userList.add(new User("dgsw3", "user3","user333@dgsw"));
    }

    @Override
    public String listString() {
        return this.userList.toString();
    }

    @Override
    public List<User> list() {
        return this.userList;
    }

    @Override
    public User view(String id) {
        User found = null;
        for(int i=0;i<this.userList.size();i++){
            found = this.userList.get(i);
            if(found.getId().equals(id))
                return found;
        }
        return null;
    }

    @Override
    public boolean add(User user) {
        if(view(user.getId())!=null) //중복이면
            return false; //false 반환
        return this.userList.add(user);
    }

    @Override
    public User update(User user) {
        User found = this.view(user.getId());
        if(found != null) {
            found.setEmail(user.getEmail());
            found.setName(user.getName());
        }
        return found;
    }

    @Override
    public boolean delete(String id) {
        User found = this.view(id);
        return this.userList.remove(found);
    }

    public User find1(String name){
        Iterator<User> userIterator = this.userList.iterator();
        while(userIterator.hasNext()){
            User user = userIterator.next();
            if(user.getName().equals(name))
                return user;
        }
        return null;
    }
    public User find2(String name){
        for(User user : this.userList){
            if(user.getName().equals(name))
                return user;
        }
        return null;
    }
    public User find3(String name){
        return this.userList.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}
