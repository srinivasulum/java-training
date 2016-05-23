package helloworld;

public class SpringGreetings implements Greetings {

	public String message = null;

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String pleaseGreet() {
		return message;
	}
}
