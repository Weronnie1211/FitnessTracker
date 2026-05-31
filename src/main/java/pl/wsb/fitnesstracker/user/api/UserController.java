package pl.wsb.fitnesstracker.user.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.user.internal.UserRepository;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody UserDto dto) {
        User user = new User(dto.firstName(), dto.lastName(), dto.birthdate(), dto.email());
        User savedUser = userRepository.save(user);
        return new UserDto(savedUser.getId(), savedUser.getFirstName(), savedUser.getLastName(), savedUser.getBirthdate(), savedUser.getEmail());
    }
}