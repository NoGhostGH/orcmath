package myStuff;

public class MoveAndrew implements MoveInterfaceSunny {
	
	ButtonInterfaceSunny a;
	
	public MoveAndrew(ButtonInterfaceSunny b) {
		// TODO Auto-generated constructor stub
		a = b;
	}

	@Override
	public void lightOn(int buttonInt) {
		// TODO Auto-generated method stub
	}

	@Override
	public void lightOff() {
		// TODO Auto-generated method stub
	}

	@Override
	public ButtonInterfaceSunny getButton() {
		// TODO Auto-generated method stub
		return a;
	}

}
