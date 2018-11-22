package todo.service;

import todo.dto.UserDTO;

public interface UserService {

    void saveUser(UserDTO userDTO);

    UserDTO findUser(String username, String password);

}
