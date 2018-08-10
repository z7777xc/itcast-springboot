package cn.itcast.springboot.javaconfig;

import java.util.ArrayList;
import java.util.List;
import cn.itcast.springboot.javaconfig.User;

public class UserDao {
public List<User> queryUserList(){
	List<User> result= new ArrayList<User>();
	for (int i = 0; i < 10; i++) {
		User user=new User();
		user.setAge(i+1);
		user.setPassword("password_"+ i);
		user.setUsername("username_"+ i);
		result.add(user);
	}
	return result;
}
}
