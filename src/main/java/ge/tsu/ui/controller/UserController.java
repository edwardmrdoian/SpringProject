package ge.tsu.ui.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import ge.tsu.service.UserService;
import ge.tsu.shared.dto.UserDto;
import ge.tsu.ui.model.request.UserDetailsRequestModel;
import ge.tsu.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String GetUser(){
        return "get user";
    }

    @PostMapping
    public UserRest CreateUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser,returnValue);

        return returnValue;
    }

    @PutMapping
    public String UpdateUser(){
        return "update user";
    }

    @DeleteMapping
    public String DeleteUser(){
        return "delete user";
    }
}
