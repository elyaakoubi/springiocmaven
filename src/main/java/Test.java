import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.AppConfig;
import ma.ensa.dao.Idao;
import ma.ensa.entities.Client;

public class Test {
	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("config/configContext.xml");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class); 
		Idao dao =(Idao) ctx.getBean("dao");
		Client client1 = new Client("nomclient1","0001000000","m1@gmail.com");
		Client client2 = new Client("nomclient2","0002000000","m2@gmail.com");
		dao.addClient(client1);
		dao.addClient(client2);
		System.out.println(dao.allClients().size());
	}
}
