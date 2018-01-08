package myStuff;

public class MoveAndrew implements MoveInterfaceSunny {
	
	ButtonInterfaceSunny a;
	
	public MoveAndrew(ButtonInterfaceSunny b) {
		// TODO Auto-generated constructor stub
		a = b;
	}

	@Override
	public ButtonInterfaceSunny getButton() {
		// TODO Auto-generated method stub
		return a;
	}

}
