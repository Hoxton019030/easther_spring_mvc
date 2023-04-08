package ch01.ioc._01_xml.model.impl;

public class Mouse extends Pet {

	public Mouse(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("我是小老鼠" + getName());
	}

}
