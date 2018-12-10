/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年8月28日 下午1:48:43</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.raspi.common;

import com.pi4j.system.SystemInfo;
import com.pi4j.system.SystemInfo.BoardType;

/**
* @Package：cn.ucaner.raspi.common   
* @ClassName：CommonUtils   
* @Description：   <p> CommonUtils </p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 上午11:42:46   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
 */
public class CommonUtils {
	
	/**
	 * 树莓派板子类型设为2B
	 */
	public static final BoardType boardType = SystemInfo.BoardType.RaspberryPi_2B;
}
