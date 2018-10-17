package polymorphism.coupling;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {

		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		TV tv = (TV)factory.getBean("samsungTV");
		tv.powerOn();
		tv.volumeUp();
		System.out.println(((SamsungTV)tv).getProgram());
	}
}
