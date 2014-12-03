package test.javabasic.proxy;

public class TankLogProxy implements Moveable{
	
	Moveable tank;
	
	public TankLogProxy(Moveable tank) {
		this.tank = tank;
	}
	
	@Override
	public void move() {
		System.out.println("Log start");
		tank.move();
		System.out.println("log stop");
	}

}
