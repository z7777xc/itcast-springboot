package cn.itcast.springboot.javaconfig;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
//通过该注解表明这是一个相当于xml文件的spring配置

@ComponentScan(basePackages="cn.itcast.springboot.javaconfig")
//配置扫描包

@PropertySource(value= {"classpath:jdbc.properties"},ignoreResourceNotFound=true)
//该注解在视频第四小节加入,可以用来读取指定的配置文件,如需要配置多个配置文件
//可以使用@PropertySource(value= {"classpath:jdbc.properties"."",""})的形式
//ignoreResourceNotFound=true 表示如果找不到配置文件时候忽略

public class SpringConfig {
	@Value("${jdbc.url}")//该注解在视频第四小节加入,可以用来获取指定的值
	private String jdbcUrl;
	//小驼峰命名真tm不习惯
	@Value("${jdbc.driverClassName}")//该注解在视频第5小节加入,可以用来获取指定的值
	private String jdbcDriverClassName;
	
	@Value("${jdbc.userName}")//该注解在视频第5小节加入,可以用来获取指定的值
	private String jdbcUsername;
	@Value("${jdbc.password}")//该注解在视频第5小节加入,可以用来获取指定的值
	private String jdbcPassword;
	
	@Bean//通过注解表明这是一个bean对象相当于xml的<bean>
	public UserDao getUserDao() {
		return new UserDao();//直接new对象演示
	}
	
	@Bean(destroyMethod="close")
/*	public BoneCPDataSource boneCPDataSource() {
	BoneCPDataSource boneCPDataSource= new BoneCPDataSource();
		boneCPDataSource.setDriverClass(driverClassName);
		return boneCPDataSource;*/
		public DataSource dataSource() {
		BoneCPDataSource boneCPDataSource= new BoneCPDataSource();
		//数据库驱动
		boneCPDataSource.setDriverClass(jdbcDriverClassName);
		//数据库驱动的jdbcurl
		
		boneCPDataSource.setUsername(jdbcUsername);
		//数据库用户名
		
		boneCPDataSource.setPassword(jdbcPassword);
		//数据库密码
		
		boneCPDataSource.setIdleMaxAgeInMinutes(30);
		//连接池中未使用的连接的最大存活时间,单位是分,默认60,永远存活设置为0		
		boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
		//检查数据库连接池的空闲连接的检测时间,单位是分,默认是240,如果取消设置为0
		boneCPDataSource.setMaxConnectionsPerPartition(1000);
		//每个分区最大连接数
		boneCPDataSource.setMinConnectionsPerPartition(5);
		//每个分区最小连接数
		return  boneCPDataSource;
		//没有代码demo敲起来真tm的MMP的累,这是java格式的配置= =比起xml没感觉多方便
	}
	}


