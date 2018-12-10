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
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

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
    public RespBody jwtToken() throws InterruptedException {
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
				pinService.provisionGpio(num, "LED", PinState.HIGH);
				logger.info("LED亮起来!");
				Thread.sleep(1000);
			}else {
				//RaspiPin.GPIO_00
				pinService.provisionGpio(num, "LED", PinState.LOW);
				logger.info("LED关掉!");
				Thread.sleep(1000);
			}
		}
		return respBody;
    }

}
