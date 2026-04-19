package kg.spring.core.service.impl;

import kg.spring.core.model.User;
import kg.spring.core.model.payload.request.UserRequest;
import kg.spring.core.model.payload.response.UserResponse;
import kg.spring.core.repository.UserRepository;
import kg.spring.core.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getProfession(),
                        user.getAge()))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(Long id) {
        User user =  userRepository.findById(id);
        return new UserResponse(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getProfession(),
                user.getAge());
    }

    @Override
    public void save(UserRequest request) {
        userRepository.save(request);
    }

    @Override
    public void update(Long id, UserRequest request) {
        userRepository.update(id, request);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}