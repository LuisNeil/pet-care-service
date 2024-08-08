package com.dailycodework.universalpetcare.controller;

import com.dailycodework.universalpetcare.dto.EntityConverter;
import com.dailycodework.universalpetcare.dto.UserDto;
import com.dailycodework.universalpetcare.exception.ResourceNotFoundException;
import com.dailycodework.universalpetcare.exception.UserAlreadyExistsException;
import com.dailycodework.universalpetcare.model.User;
import com.dailycodework.universalpetcare.requests.RegistrationRequest;
import com.dailycodework.universalpetcare.requests.UserUpdateRequest;
import com.dailycodework.universalpetcare.response.ApiResponse;
import com.dailycodework.universalpetcare.service.user.IUserService;
import com.dailycodework.universalpetcare.utils.FeedBackMessage;
import com.dailycodework.universalpetcare.utils.UrlMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RequestMapping(UrlMapping.USERS)
@RestController
public class UserController {

    private final IUserService userService;
    private final EntityConverter<User, UserDto> entityConverter;

    @PostMapping(UrlMapping.REGISTER_USER)
    public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequest request){
       try {
           User theUser = userService.register(request);
           UserDto registeredUser = entityConverter.mapEntityToDto(theUser, UserDto.class);
           return ResponseEntity.ok(new ApiResponse(FeedBackMessage.SUCCESS, registeredUser));
       }catch (UserAlreadyExistsException e){
           return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
       } catch (Exception e){
           return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
       }
    }

    @PutMapping(UrlMapping.UPDATE_USER)
    public ResponseEntity<ApiResponse> update(@PathVariable Long userId, @RequestBody UserUpdateRequest request){
        try{
            User theUser = userService.update(userId, request);
            UserDto updatedUser = entityConverter.mapEntityToDto(theUser, UserDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.UPDATE_SUCCESS, updatedUser));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
        catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping(UrlMapping.GET_USER_BY_ID)
    public ResponseEntity<ApiResponse> findById(@PathVariable Long userId){
        try{
            User user = userService.findById(userId);
            UserDto theUser = entityConverter.mapEntityToDto(user, UserDto.class);
            return ResponseEntity.status(FOUND).body(new ApiResponse(FeedBackMessage.FOUND, theUser));
        } catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping(UrlMapping.DELETE_USER_BY_ID)
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Long userId){
        try{
            userService.delete(userId);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DELETE_SUCCESS, null));
        } catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping(UrlMapping.GET_ALL_USERS)
    public ResponseEntity<ApiResponse> getAllUsers(){
        List<UserDto> theUsers = userService.getAllUsers();
        return ResponseEntity.status(FOUND).body(new ApiResponse(FeedBackMessage.FOUND, theUsers));
    }
}
