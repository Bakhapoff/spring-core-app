package kg.spring.core.repository;

import kg.spring.core.mapper.UserRowMapper;
import kg.spring.core.model.User;
import kg.spring.core.model.payload.request.UserRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM users",
                new UserRowMapper()
        );
    }

    public User findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM users WHERE id = ?",
                new UserRowMapper(),
                id
        );
    }

    public void save(UserRequest request) {
        jdbcTemplate.update(
                "INSERT INTO users (first_name, last_name, profession, age) VALUES (?, ?, ?, ?)",
                request.getFirstName(),
                request.getLastName(),
                request.getProfession(),
                request.getAge()
        );
    }

    public void update(Long id, UserRequest request) {
        jdbcTemplate.update(
                "UPDATE users SET first_name = ?, last_name = ?, profession = ?, age = ? WHERE id = ?",
                request.getFirstName(),
                request.getLastName(),
                request.getProfession(),
                request.getAge(),
                id
        );
    }

    public void delete(Long id) {
        jdbcTemplate.update(
                "DELETE FROM users WHERE id = ?",
                id
        );
    }
}