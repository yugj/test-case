package test.javabasic.proxy;

public class TankTimeProxy implements Moveable{
	
	Moveable tank;
	
	public TankTimeProxy(Moveable tank) {
		this.tank = tank;
	}
	
	@Override
	public void move() {
		System.out.println("time proxy start");
		tank.move();
		System.out.println("time proxy stop");
	}

}
