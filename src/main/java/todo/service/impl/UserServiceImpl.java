package todo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.dto.UserDTO;
import todo.model.User;
import todo.repository.UserRepository;
import todo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(UserDTO userDTO) {
        User user = User.builder().username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .role("USER")
                .build();

        userRepository.save(user);

    }

    @Override
    public UserDTO findUser(String username, String password) {
        User user = userRepository.findUserByUsernameAndPassword(username,password);
        if (user == null){
            return null;
        }
        return toUserDTO(user);
    }

    private UserDTO toUserDTO(User user){
        return UserDTO.builder().username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }
}

