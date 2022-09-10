package engine.service;

import engine.api.dto.UserDTO;
import engine.api.mapper.UserMapper;
import engine.domain.exceptions.BadRequestException;
import engine.domain.repository.UserRep;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@Service
public class UsersService {

    private UserRep userRep;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    public void saveNewUsers(UserDTO userDTO) {
        if (userRep.findUserByEmail(userDTO.getEmail()).isPresent()) {
            throw new BadRequestException("User is exists");
        }
        userRep.save(userMapper.toUserFromUserDTO(userDTO, passwordEncoder));
    }
}