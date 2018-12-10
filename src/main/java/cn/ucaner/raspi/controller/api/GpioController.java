/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年12月10日 下午12:38:47</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.raspi.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import cn.ucaner.raspi.service.PinService;
import cn.ucaner.raspi.vo.RespBody;

/**     
* @Package：cn.ucaner.raspi.controller.api   
* @ClassName：GpioController   
* @Description：   <p> GpioController </p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 下午12:38:47   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
*/
@RestController
@RequestMapping(value = "/gpio/v1")
public class GpioController {
	
	private static final Logger logger = LoggerFactory.getLogger(GpioController.class);
	
	@Autowired
	private PinService pinService;
	
	@RequestMapping("/test")
    public RespBody gpioTest() throws InterruptedException {
		RespBody respBody = new RespBody();
		int num = 1;
		Pin pinByNum = pinService.getPinByNum(num);
		String raspiData = JSON.toJSONString(pinByNum);
		if (raspiData!=null) {
			respBody.addOK(JSON.toJSONString(raspiData));
		}else {
			respBody.addFail("调用错误");
		}
		
		for (int i = 0; i < 10; i++) {
			if (i%2 == 0) {
				pinService.provisionGpio(RaspiPin.GPIO_05, "LED", PinState.HIGH);
				logger.info("LED亮起来!");
				Thread.sleep(1000);
//				gpio.shutdown();
//				gpio.unProvisionPin(pin);
			}else {
				//RaspiPin.GPIO_00
				pinService.provisionGpio(RaspiPin.GPIO_05, "LED", PinState.LOW);
				logger.info("LED关掉!");
				Thread.sleep(1000);
			}
		}
		return respBody;
    }
	
	
	@RequestMapping("/demo")
    public RespBody gpioDemo() throws InterruptedException {
		RespBody respBody = new RespBody();
		int num = 1;
		Pin pinByNum = pinService.getPinByNum(num);
		String raspiData = JSON.toJSONString(pinByNum);
		if (raspiData!=null) {
			respBody.addOK(JSON.toJSONString(raspiData));
		}else {
			respBody.addFail("调用错误");
		}
		return respBody;
    }
	
	
	/**
	 * @Description: gpioGood 
	 * @return  RespBody
	 * @throws InterruptedException 
	 * @Autor: Jason
	 */
	@RequestMapping("/good")
    public void gpioGood() throws InterruptedException {
		final com.pi4j.io.gpio.GpioController gpio = GpioFactory.getInstance();
		final GpioPinPwmOutput pin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26, "MyLED", 100);
		pin.setShutdownOptions(true, PinState.LOW);
		int sleep_time = 10;
	    int sleep_time2 = 7;
	    while(true) {
          // lighting....
          for (int i=0; i<=100; i++) {
              pin.setPwm(i);           
              Thread.sleep(sleep_time);
              System.out.println("第"+i+"次");
          }
          // darking...
          for (int i=100; i>0; i--) {
              pin.setPwm(i);     
              Thread.sleep(sleep_time2);
              System.out.println("第"+i+"次");
          }
          Thread.sleep(1000); // break 1 second
      }
    }
	
  

}
