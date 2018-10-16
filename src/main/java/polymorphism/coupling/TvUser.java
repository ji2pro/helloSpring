package polymorphism.coupling;

public class TvUser {

	public static void main(String[] args) {
		//TV tv = new SamsungTV();
		TV tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}
