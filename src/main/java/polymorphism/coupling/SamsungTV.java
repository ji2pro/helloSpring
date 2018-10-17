package polymorphism.coupling;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV {
	/*@Autowired  //클래스 타입
	@Qualifier("apple")  //이름*/	
	@Resource(name="apple")
	
	private Speaker speaker;  //필드(멤버 변수) = 속성(property)
	private int price;
	private List<String> program;

	public List<String> getProgram() {
		return program;
	}
	public void setProgram(List<String> program) {
		this.program = program;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//생성자
	public SamsungTV() {}  //default 생성자
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("SamsungTV 생성자 호출");
		this.speaker = speaker;
	}

	public SamsungTV(SonySpeaker speaker, int price) {
		System.out.println("SamsungTV 생성자 호출 - 인수 2");
		this.speaker = speaker;
		this.price = price;
	}
	public void initMethod() {
		System.out.println("초기화 메서드 호출");
	}
	public void destroyMethod() {
		System.out.println("종료 메서드 호출");
	}
	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}	
}
