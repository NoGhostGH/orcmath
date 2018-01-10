package myStuff1;

public class MoveSunny implements MoveInterfaceSunny {

	ButtonInterfaceSunny button;
	public MoveSunny(ButtonInterfaceSunny button) {
		this.button = button;
	}

	@Override
	public ButtonInterfaceSunny getButton() {
		return button;
	}

}