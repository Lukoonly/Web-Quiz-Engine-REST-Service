package engine.api.controller;

import engine.api.dto.UserDTO;
import engine.api.mapper.UserMapper;
import engine.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@RestController
public class UserController {

    private UsersService usersService;

    @PostMapping("/api/register")
    public boolean registerUser(@Valid @RequestBody UserDTO userDTO) {
        usersService.saveNewUsers(userDTO);
        return true;
    }
}
