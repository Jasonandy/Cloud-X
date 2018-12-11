/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年12月11日 上午8:33:23</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.raspi.listener;

import java.util.Scanner;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**     
* @Package：cn.ucaner.raspi.listener   
* @ClassName：GpioListener   
* @Description：   <p> GpioListener </p>
* @Author： - Jason   
* @CreatTime：2018年12月11日 上午8:33:23   
* @Modify By：   
* @ModifyTime：  2018年12月11日
* @Modify marker：   
* @version    V1.0
*/
public class GpioListener  implements GpioPinListenerDigital{

	/**
	 * GpioController 
	 */
	private static final GpioController CONTROLLER = GpioFactory.getInstance();
	
	/**
	 * input 输入
	 */
	private static final GpioPinDigitalInput BUTTON = CONTROLLER.provisionDigitalInputPin(RaspiPin.GPIO_16);
	
	/**
	 * output 输出
	 */
	private static final GpioPinDigitalOutput LED = CONTROLLER.provisionDigitalOutputPin(RaspiPin.GPIO_15);
	private Scanner scanner;
	
	/**
	 * @Description: GpioListener RUN
	 * @Autor: Jason
	 */
	public static void main(String[] args) {
        new GpioListener().run();
    }
	
	
	/**
	 * @Description: 启动 - 监听器
	 * @Autor: Jason
	 */
	public static void startUp() {
		new GpioListener().run();
	}
	
	
	/**
	 * @Description:run
	 * @Autor: Jason
	 */
	public void run() {
        BUTTON.addListener(this);//时间加入进去
        scanner = new Scanner(System.in);
        scanner.nextLine();
    }
	
	
	/**
	 * handleGpioPinDigitalStateChangeEvent 
	 */
	@Override
	public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
		boolean state = event.getState().isHigh();
		System.out.println("--->pin:" + event.getPin() + "|state:" + state);
		if (state) {
			LED.high();
		}else {
			LED.low();
		}
	}
	

}
