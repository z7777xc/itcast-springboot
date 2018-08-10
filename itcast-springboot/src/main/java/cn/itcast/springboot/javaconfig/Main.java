package cn.itcast.springboot.javaconfig;

import java.util.Iterator;
import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[]args ) {

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);

////	方法说明:独立应用程序上下文，接受带注释的类作为输入 - 特别是@Configuration-annotated类，
//		还有使用javax.inject注释的普通@Component类型和JSR-330兼容类。允许使用寄存器（Class）逐个注册类，
//		以及使用scan（String）进行类路径扫描。在多个@Configuration类的情况下，后面的类中定义的@Bean方法将
//		覆盖在早期类中定义的方法。这可以用来通过额外的@Configuration类故意覆盖某些bean定义。
		//个人理解为类的扫描和加载器复合体,而加载的springconfig文件是已经注释好的java型xml文件


		UserService service =context.getBean(UserService.class);
		//在spring容器中获取bean对象
		
		List<User>list =service.queryUserList();
		for (User user:list) {
			System.out.println(user.getUsername()+","+user.getPassword()+","+user.getAge());
			
		}
		//调用对象中的方法
		context.destroy();//销毁容器
	}

}
