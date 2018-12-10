package cn.ucaner.raspi.service;

/**
* @Package：cn.ucaner.raspi.service   
* @ClassName：GpioService   
* @Description：   <p> 控制树莓派GPIO的服务 </p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 上午11:44:27   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
 */
public interface GpioService {

	/**
	 * 置一个端口为正或负
	 * @param portNum
	 * @param status
	 * @return
	 */
	boolean dealPort(int portNum , boolean status);
	
	/**
	 * 处理一个延时端口
	 * @param portNum
	 * @param status
	 * @param time
	 * @return
	 */
	boolean dealPortWithTime(int portNum , boolean status , long time);
	
	/**
	 * 取反一个端口
	 * @param portNum
	 * @return
	 */
	boolean reversePort(int portNum);
	
	/**
	 * 处理树莓派所有端口的正负性
	 * 输入一串包含0和1的字符串
	 * @param allPortStatus
	 * @return
	 */
	boolean dealAllPort(String allPortStatus);
}
