package kr.hs.dgsw.web_01_319;

import java.util.List;

public interface UserService {
    String listString();
    List<User> list();
    User view(String name);
    boolean add(User user);
    User update(User user);
    boolean delete(String name);
}
