package cn.ucaner.raspi.service;

/**
* @Package：cn.ucaner.raspi.service   
* @ClassName：AlarmClockService   
* @Description：   <p> 控制树莓派 闹铃的服务 </p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 上午11:44:45   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
 */
public interface AlarmClockService {

	
	/**
	 * 拼接闹钟所需要的所有内容
	 * @return
	 */
	String findAllInfo();
	
	/**
	 * 发声
	 * @param text
	 */
	void playSound(String text);

	/**
	 * 播放文件
	 * @param fileName
	 */
	void play(String fileName);
}
