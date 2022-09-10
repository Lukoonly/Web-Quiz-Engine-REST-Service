package engine.api.mapper;

import engine.api.dto.UserDTO;
import engine.domain.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUserFromUserDTO(UserDTO userDTO, PasswordEncoder passwordEncoder) {
        return User.builder()
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .build();
    }
}
