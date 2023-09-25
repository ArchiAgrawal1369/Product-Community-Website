package com.nagaro.ExitTest.repo;
import com.nagaro.ExitTest.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String>{
	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String emailId, String password);
}
