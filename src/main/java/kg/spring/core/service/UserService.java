package kg.spring.core.service;

import kg.spring.core.model.payload.request.UserRequest;
import kg.spring.core.model.payload.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> findAll();
    UserResponse findById(Long id);
    void save(UserRequest request);
    void update(Long id, UserRequest request);
    void delete(Long id);
}