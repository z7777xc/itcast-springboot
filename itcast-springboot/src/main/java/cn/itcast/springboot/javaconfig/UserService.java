package cn.itcast.springboot.javaconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	@Autowired
	//注入spring容器的bean对象
	private UserDao userDao;
	public List<User> queryUserList(){
		return this.userDao.queryUserList();
		}

}
