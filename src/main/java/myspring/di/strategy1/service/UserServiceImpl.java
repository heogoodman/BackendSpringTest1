package myspring.di.strategy1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import myspring.di.strategy1.dao.UserDao;
import myspring.user.vo.UserVO;

public class UserServiceImpl implements UserService {

//	@Autowired
	UserDao userdao; //널포인트익셉션오토와일드하기	
	
	public List<UserVO> getUserList() {
		return userdao.readAll();
	}

	@Override
	public UserVO getUser(int index) {
		return userdao.read(index);
	}

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

}