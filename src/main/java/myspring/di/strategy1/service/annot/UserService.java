package myspring.di.strategy1.service.annot;

import java.util.List;

import org.springframework.stereotype.Component;

import myspring.user.vo.UserVO;

public interface UserService {
	
	public List<UserVO> getUserList();

	public UserVO getUser(int index);
	
}
