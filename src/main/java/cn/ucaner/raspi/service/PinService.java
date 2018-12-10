package cn.ucaner.raspi.service;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

/**
* @Package：cn.ucaner.raspi.service   
* @ClassName：PinService   
* @Description：   <p> PinService </p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 下午12:21:13   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
 */
public interface PinService {

	/**
	 * 获得pin
	 * @param num
	 * @return
	 */
	Pin getPinByNum(int num);
	
	/**
	 * 定义为GPIO口（数字参数）
	 * @param num
	 * @param name
	 * @param state
	 * @return
	 */
	GpioPinDigitalOutput provisionGpio(int num, String name, PinState state);
}
