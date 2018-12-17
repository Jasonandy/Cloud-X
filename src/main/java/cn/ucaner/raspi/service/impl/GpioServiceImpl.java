package cn.ucaner.raspi.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

import cn.ucaner.raspi.service.GpioService;
import cn.ucaner.raspi.service.PinService;

/**
* @Package：cn.ucaner.raspi.service.impl   
* @ClassName：GpioServiceImpl   
* @Description：   <p> gpio模块</p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 下午12:27:01   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
 */
@Service("gpioService")
public class GpioServiceImpl implements GpioService{


	/**
	 * pin服务
	 */
	@Autowired
	private PinService pinService;
	
	/**
	 * 日志记录器
	 */
	private static Logger logger = Logger.getLogger(GpioServiceImpl.class);  
	
	/**
	 * 对指定的端口 进行操作
	 */
	@Override
	public boolean dealPort(int portNum, boolean status) {
		logger.debug("Set Port "+ portNum + "to status "+ status);
		GpioPinDigitalOutput output = pinService.provisionGpio(portNum, "PIN"+portNum, PinState.LOW);
		if (output == null) {
			return false;
		}
        if (status) {
			output.high();
		}
        else {
			output.low();
		}
		return true;
	}

	/**
	 * 处理一个演示的端口
	 */
	@Override
	public boolean dealPortWithTime(int portNum, boolean status, long time) {
		logger.debug("Set Port "+ portNum + " to status "+ status +" with time " + time);
		GpioPinDigitalOutput output = pinService.provisionGpio(portNum, "PIN"+portNum, PinState.LOW);
		if (output == null) {
			return false;
		}
        output.pulse(time, PinState.getState(status));
		return true;
	}

	/**
	 * 对端口进行反转操作 
	 */
	@Override
	public boolean reversePort(int portNum) {
		logger.debug("reverse Port "+ portNum);
		GpioPinDigitalOutput output = pinService.provisionGpio(portNum, "PIN"+portNum, PinState.LOW);
		if (output == null) {
			return false;
		}
        output.toggle();
		return true;
	}

	/**
	 * 按照 一串字符串来对字符数据进行处理 
	 * 
	 * 比如 “10010101010101 ”
	 * 
	 * 电信号 脉冲为 高低...
	 */
	@Override
	public boolean dealAllPort(String allPortStatus) {
		if (allPortStatus == null) {
			return false;
		}
		for (int i = 0; i < allPortStatus.length(); i++) {
			boolean status = (allPortStatus.charAt(i) == '1')?true:false;
			dealPort(i, status);
		}
		return true;
	}

}
