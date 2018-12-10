package cn.ucaner.raspi.service.impl;

import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import cn.ucaner.raspi.common.CommonUtils;
import cn.ucaner.raspi.service.PinService;

/***
* @Package：cn.ucaner.raspi.service.impl   
* @ClassName：PinServiceImpl   
* @Description：   <p> PinServiceImpl </p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 下午12:46:17   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
 */
@Service("pinService")
public class PinServiceImpl implements PinService{
	
	
	private static Pin[] pinList = null; 
	
	
	private static GpioPinDigitalOutput[] outputList = null; 

	
	/**
	 * gitPinByNum
	 */
	@Override
	public Pin getPinByNum(int num) {
		if (num < 0 || num > 31) {
			return null;
		}
		if (pinList == null) {
			pinList = RaspiPin.allPins(CommonUtils.boardType);
		}
		return pinList[num];
	}

	@Override
	public GpioPinDigitalOutput provisionGpio(int num, String string, PinState state) {
		if (num < 0 || num > 31) {
			return null;
		}
		if (pinList == null) {
			pinList = RaspiPin.allPins(CommonUtils.boardType);
		}
		if (outputList == null) {
			outputList = new GpioPinDigitalOutput[pinList.length];
		}
		if (outputList[num] == null) {
			GpioController gpio = GpioFactory.getInstance();
			outputList[num] = gpio.provisionDigitalOutputPin(getPinByNum(num), "PIN"+num, state);
		}
		return outputList[num];
	}

	/**
	 * provisionGpio
	 */
	@Override
	public void provisionGpio(Pin pin, String name, PinState state) {
		GpioController gpio = GpioFactory.getInstance();
		gpio.provisionDigitalOutputPin(pin, name, state);
	}
	

}
