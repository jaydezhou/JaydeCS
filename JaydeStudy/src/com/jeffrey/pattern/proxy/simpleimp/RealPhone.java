package com.jeffrey.pattern.proxy.simpleimp;

/**
 * 功能说明：
 *
 * @author weij
 */
public class RealPhone implements Phone {
	@Override
	public void call() {
		System.out.println(getClass().toString());
	}
}
