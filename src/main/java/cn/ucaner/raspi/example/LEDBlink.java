/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年12月10日 下午12:31:04</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.raspi.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import cn.ucaner.raspi.listener.ApplicationContextListener;

/**     
* @Package：cn.ucaner.raspi.example   
* @ClassName：LEDBlink   
* @Description：   <p> LEDBlink </p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 下午12:31:04   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
*/
public class LEDBlink {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationContextListener.class);

	
	/**
	 * 获取全局GPIO 引脚控制器对象
	 */
    public static final GpioController gpio = GpioFactory.getInstance();

    
    public static void main(String[] args) throws InterruptedException {
    	
    	/**
    	 * 定义编号为0的引脚为数字输出引脚,初始化为低电平
    	 */
        GpioPinDigitalOutput ledBlink = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "01" ,PinState.LOW);
        
        while(true){
        	ledBlink.high();
        	logger.info("LED亮起来!");
            Thread.sleep(500);
            ledBlink.low();
            logger.info("LED被灭掉!");
            Thread.sleep(500);
            
        }
	}
}
