package dev.brian.playground.service;

import dev.brian.playground.entity.User;
import dev.brian.playground.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow();
	}

	public User create(User user) {
		return userRepository.save(user);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public User update(Long id, User updatedUser) {
		User existing = userRepository.findById(id).orElseThrow();
		existing.setName(updatedUser.getName());
		existing.setEmail(updatedUser.getEmail());
		return userRepository.save(existing);
	}
}
