/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年12月10日 上午10:19:47</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.raspi.controller.api;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ucaner.raspi.vo.RespBody;
import cn.ucaner.raspi.vo.RespBody.Status;

/**     
* @Package：cn.ucaner.raspi.controller.api   
* @ClassName：ApiController   
* @Description：   <p> ApiController api接口测试类 </p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 上午10:19:47   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
*/
@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {
	
	@RequestMapping("/test")
    public RespBody jwtToken() {
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("name", "jwt");
		hashMap.put("value", "pass");
		return new RespBody(Status.OK,hashMap);
    }

}
