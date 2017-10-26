//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;
import	jp.vstone.camera.*;
import	jp.vstone.camera.FaceDetectLib.*;
import	twitter4j.*;
import	twitter4j.Status;
import	twitter4j.Twitter;
import	twitter4j.TwitterException;
import	twitter4j.TwitterFactory;
import	twitter4j.User;
import	twitter4j.auth.AccessToken;
import	twitter4j.conf.ConfigurationBuilder;

public class mymain
{

	public String speechRecogResult;
	public int addFaceuserErrSayInterval;
	public RecogResult recogresult;
	public String time_string;
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,352,32,False,5,@</BlockInfo>
	{
																														//@<OutputChild>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,96,32,96,32,False,4,break@</BlockInfo>
																														//@<EndOfBlock/>
		addFaceuserErrSayInterval=0;																					//@<BlockInfo>jp.vstone.block.variable,160,32,160,32,False,3,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*RecogResult recogresult*/;																					//@<BlockInfo>jp.vstone.block.variable,224,32,224,32,False,2,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String time_string*/;																							//@<BlockInfo>jp.vstone.block.variable,288,32,288,32,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void getTemperature(String gN)																				//@<BlockInfo>jp.vstone.block.func,0,1200,6272,1200,False,227,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		String name;																									//@<BlockInfo>jp.vstone.block.freeproc,64,1104,64,1104,False,226,@</BlockInfo>
		name = gN;

		String dos=null;
		String bu=null;
		String ch=null;
																														//@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)name+"さんの体温は何度？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,112,1200,112,1200,False,225,@</BlockInfo>
																														//@<EndOfBlock/>
		while(GlobalVariable.TRUE)																						//@<BlockInfo>jp.vstone.block.while.endless,176,1200,6208,1200,False,224,Endless@</BlockInfo>
		{

																														//@<OutputChild>
			recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);										//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,240,864,5984,960,False,223,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
			speechRecogResult = recogresult.CheckBest(new String[]{
			 "三十五" ,  "三十六" ,  "三十七" ,  "三十八" ,  "三十九" ,  "四十" ,  "四十一" ,  "四十二" ,  "終わり" ,  "" , 
			},false);
			if(speechRecogResult == null) speechRecogResult = "";

			if(speechRecogResult.contains((String)"三十五"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"３５度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,864,304,864,False,30,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,864,368,864,False,29,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,480,864,3744,960,False,28,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,3264,480,3600,480,False,27,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3328,480,3328,480,False,7,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3536,480,3536,480,False,6,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度１ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3328,576,3328,576,False,9,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3536,576,3536,576,False,8,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度２ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3328,672,3328,672,False,11,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3536,672,3536,672,False,10,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度３ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3328,768,3328,768,False,13,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3536,768,3536,768,False,12,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度４だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3328,864,3328,864,False,15,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3536,864,3536,864,False,14,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度５ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3328,960,3328,960,False,17,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3536,960,3536,960,False,16,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度６ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3328,1056,3328,1056,False,19,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3536,1056,3536,1056,False,18,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度７ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3328,1152,3328,1152,False,21,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3536,1152,3536,1152,False,20,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3328,1248,3328,1248,False,23,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3536,1248,3536,1248,False,22,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3328,1344,3328,1344,False,25,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3536,1344,3536,1344,False,24,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3328,1440,3328,1440,False,26,@</BlockInfo>
																																//@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
																															//@<EndOfBlock/>
																															//@</OutputChild>
					}
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"三十六"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"３６度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,960,304,960,False,71,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,960,368,960,False,70,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,960,1168,960,False,69,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,592,480,912,480,False,68,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,656,480,656,480,False,33,@</BlockInfo>
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,480,720,480,False,32,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,816,480,816,480,False,31,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度１ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,656,576,656,576,False,36,@</BlockInfo>
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,576,720,576,False,35,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,816,576,816,576,False,34,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度２ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,656,672,656,672,False,39,@</BlockInfo>
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,672,720,672,False,38,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,816,672,816,672,False,37,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度３ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,656,768,656,768,False,42,@</BlockInfo>
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,768,720,768,False,41,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,816,768,816,768,False,40,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度４だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,656,864,656,864,False,45,@</BlockInfo>
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,864,720,864,False,44,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,816,864,816,864,False,43,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度５ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,656,960,656,960,False,48,@</BlockInfo>
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,960,720,960,False,47,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,816,960,816,960,False,46,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度６ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,656,1056,656,1056,False,52,@</BlockInfo>
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,1056,720,1056,False,51,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,1056,720,1056,False,50,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,816,1056,816,1056,False,49,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度７ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,656,1152,656,1152,False,56,@</BlockInfo>
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,1152,720,1152,False,55,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,1152,720,1152,False,54,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,816,1152,816,1152,False,53,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,656,1248,656,1248,False,62,@</BlockInfo>
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,1248,720,1248,False,60,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,1248,720,1248,False,59,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,816,1248,816,1248,False,58,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,656,1344,656,1344,False,66,@</BlockInfo>
																																//@<EndOfBlock/>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,720,1344,720,1344,False,64,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,816,1344,816,1344,False,63,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"聴こえなかったよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,656,1440,656,1440,False,67,@</BlockInfo>
																																//@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
																															//@<EndOfBlock/>
																															//@</OutputChild>
					}
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"三十七"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"３７度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1056,304,1056,False,96,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,1056,368,1056,False,95,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,1056,1824,1056,False,94,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,1360,576,1696,576,False,93,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1424,576,1424,576,False,73,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1632,576,1632,576,False,72,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度１ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1424,672,1424,672,False,75,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1632,672,1632,672,False,74,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度２ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1424,768,1424,768,False,77,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1632,768,1632,768,False,76,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度３ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1424,864,1424,864,False,79,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1632,864,1632,864,False,78,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度４ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1424,960,1424,960,False,81,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1632,960,1632,960,False,80,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度５ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1424,1056,1424,1056,False,83,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1632,1056,1632,1056,False,82,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度６ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1424,1152,1424,1152,False,85,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1632,1152,1632,1152,False,84,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度７ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1424,1248,1424,1248,False,87,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1632,1248,1632,1248,False,86,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1424,1344,1424,1344,False,89,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1632,1344,1632,1344,False,88,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1424,1440,1424,1440,False,91,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1632,1440,1632,1440,False,90,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"37度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1424,1536,1424,1536,False,92,@</BlockInfo>
																																//@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
																															//@<EndOfBlock/>
																															//@</OutputChild>
					}
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"三十八"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"３８度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1152,304,1152,False,121,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,1152,368,1152,False,120,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,1152,2432,1152,False,119,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,1952,672,2304,672,False,118,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2016,672,2016,672,False,98,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2208,672,2208,672,False,97,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度１ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2016,768,2016,768,False,100,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2208,768,2208,768,False,99,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度２ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2016,864,2016,864,False,102,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2208,864,2208,864,False,101,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度３ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2016,960,2016,960,False,104,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2208,960,2208,960,False,103,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度４だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2016,1056,2016,1056,False,106,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2208,1056,2208,1056,False,105,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度５ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2016,1152,2016,1152,False,108,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2208,1152,2208,1152,False,107,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度６ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2016,1248,2016,1248,False,110,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2208,1248,2208,1248,False,109,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度７ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2016,1344,2016,1344,False,112,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2208,1344,2208,1344,False,111,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2016,1440,2016,1440,False,114,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2208,1440,2208,1440,False,113,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2016,1536,2016,1536,False,116,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2208,1536,2208,1536,False,115,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2016,1632,2016,1632,False,117,@</BlockInfo>
																																//@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
																															//@<EndOfBlock/>
																															//@</OutputChild>
					}
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"三十九"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"３９度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1248,304,1248,False,146,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,1248,368,1248,False,145,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,1248,3104,1248,False,144,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,2608,768,2944,768,False,143,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2672,768,2672,768,False,123,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2880,768,2880,768,False,122,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度１ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2672,864,2672,864,False,125,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2880,864,2880,864,False,124,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度２ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2672,960,2672,960,False,127,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2880,960,2880,960,False,126,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度３ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2672,1056,2672,1056,False,129,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2880,1056,2880,1056,False,128,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度４だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2672,1152,2672,1152,False,131,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2880,1152,2880,1152,False,130,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度５ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2672,1248,2672,1248,False,133,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2880,1248,2880,1248,False,132,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度６ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2672,1344,2672,1344,False,135,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2880,1344,2880,1344,False,134,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度７ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2672,1440,2672,1440,False,137,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2880,1440,2880,1440,False,136,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2672,1536,2672,1536,False,139,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2880,1536,2880,1536,False,138,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2672,1632,2672,1632,False,141,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2880,1632,2880,1632,False,140,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2672,1728,2672,1728,False,142,@</BlockInfo>
																																//@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
																															//@<EndOfBlock/>
																															//@</OutputChild>
					}
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"四十"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"四十度何ぶ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1344,304,1344,False,170,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,1344,368,1344,False,169,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,1344,4336,1344,False,168,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,3824,864,4208,864,False,167,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４０度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3904,864,3904,864,False,148,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4144,864,4144,864,False,147,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４０度１ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3904,960,3904,960,False,150,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4144,960,4144,960,False,149,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４０度２ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3904,1056,3904,1056,False,152,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4144,1056,4144,1056,False,151,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４０度３ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3904,1152,3904,1152,False,154,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4144,1152,4144,1152,False,153,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４０度４ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3904,1248,3904,1248,False,156,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4144,1248,4144,1248,False,155,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４０度５ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3904,1344,3904,1344,False,158,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4144,1344,4144,1344,False,157,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４０度６ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3904,1440,3904,1440,False,160,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4144,1440,4144,1440,False,159,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４０度７ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3904,1536,3904,1536,False,162,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4144,1536,4144,1536,False,161,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４０度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3904,1632,3904,1632,False,164,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4128,1632,4128,1632,False,163,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４０度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3904,1728,3904,1728,False,166,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4128,1728,4128,1728,False,165,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
																															//@</OutputChild>
					
						}
																															//@<EndOfBlock/>
																															//@</OutputChild>
					}
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"四十一"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"四十一度何ぶ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1440,304,1440,False,194,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,1440,368,1440,False,193,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,1440,4960,1440,False,192,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,4432,960,4816,960,False,191,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４１度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,4512,960,4512,960,False,172,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4752,960,4752,960,False,171,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４１度１ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,4512,1056,4512,1056,False,174,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4752,1056,4752,1056,False,173,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４１度２ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,4512,1152,4512,1152,False,176,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4752,1152,4752,1152,False,175,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４１度３ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,4512,1248,4512,1248,False,178,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4752,1248,4752,1248,False,177,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４１度４ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,4512,1344,4512,1344,False,180,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4752,1344,4752,1344,False,179,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４１度５ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,4512,1440,4512,1440,False,182,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4752,1440,4752,1440,False,181,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４１度６ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,4512,1536,4512,1536,False,184,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4752,1536,4752,1536,False,183,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４１度７ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,4512,1632,4512,1632,False,186,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4752,1632,4752,1632,False,185,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４１度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,4512,1728,4512,1728,False,188,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4752,1728,4752,1728,False,187,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４１度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,4512,1824,4512,1824,False,190,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4752,1824,4752,1824,False,189,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
																															//@</OutputChild>
					
						}
																															//@<EndOfBlock/>
																															//@</OutputChild>
					}
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"四十二"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"四十二度何ぶ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1536,304,1536,False,218,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,1536,368,1536,False,217,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,1536,5856,1536,False,216,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,5200,1056,5584,1056,False,215,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４2度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,5296,1056,5296,1056,False,196,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5520,1056,5520,1056,False,195,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４２度１ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,5296,1152,5296,1152,False,198,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5520,1152,5520,1152,False,197,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４２度２ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,5296,1248,5296,1248,False,200,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5520,1248,5520,1248,False,199,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４２度３ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,5296,1344,5296,1344,False,202,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5520,1344,5520,1344,False,201,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４２度４ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,5296,1440,5296,1440,False,204,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5520,1440,5520,1440,False,203,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４２度５ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,5296,1536,5296,1536,False,206,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5520,1536,5520,1536,False,205,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４２度６ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,5296,1632,5296,1632,False,208,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5520,1632,5520,1632,False,207,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４２度７ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,5296,1728,5296,1728,False,210,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5520,1728,5520,1728,False,209,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４２度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,5296,1824,5296,1824,False,212,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5520,1824,5520,1824,False,211,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"４２度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,5296,1920,5296,1920,False,214,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5504,1920,5504,1920,False,213,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
																															//@</OutputChild>
					
						}
																															//@<EndOfBlock/>
																															//@</OutputChild>
					}
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"終わり"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"ばいばい",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,320,1632,320,1632,False,220,@</BlockInfo>
																															//@<EndOfBlock/>
					break;																									//@<BlockInfo>jp.vstone.block.break,400,1632,400,1632,False,219,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

			}
			else
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"聞こえなかった",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,320,1728,320,1728,False,221,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
																														//@<EndOfBlock/>
			getAll(name,dos,bu);																			//@<BlockInfo>jp.vstone.block.callfunc.base,6048,1392,6048,1392,False,222,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void getAll(String a,String b,String c)																		//@<BlockInfo>jp.vstone.block.func,1888,2144,2496,2144,False,229,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		int numb=0,numc=0;																								//@<BlockInfo>jp.vstone.block.freeproc,1952,2144,1952,2144,False,228,@</BlockInfo>

		if(b == "三十五")
			numb = 35;
		if(b == "三十六")
			numb = 36;
		if(b == "三十七")
			numb = 37;
		if(b == "三十八")
			numb = 38;
		if(b == "三十九")
			numb = 39;
		if(b == "四十")
			numb = 40;
		if(b == "四十一")
			numb = 41;
		if(b == "四十二")
			numb = 42;
		switch(c){
			case "零":
				numc = 0;
				break;
			case "一":
				numc = 1;
				break;
			case "二":
				numc = 2;
				break;
			case "三":
				numc = 3;
				break;
			case "四":
				numc = 4;
				break;
			case "五":
				numc = 5;
				break;
			case "六":
				numc = 6;
				break;
			case "七":
				numc = 7;
				break;
			case "八":
				numc = 8;
				break;
			case "九":
				numc = 9;
				break;
			case " ":
				numc = 0;
				break;
			}
			System.out.println(a+"さんの体温は，"+numb+"."+numc+"℃ です．");
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void getName()																								//@<BlockInfo>jp.vstone.block.func,256,2064,1584,2064,False,241,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,400,2064,1520,2064,False,240,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,496,2064,1456,2064,False,239,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,560,2016,1392,2016,False,238,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)1)
				{
																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"こんにちは、お名前は",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,624,2016,624,2016,False,237,@</BlockInfo>
																														//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																			//@<BlockInfo>jp.vstone.block.while.endless,688,2016,1072,2016,False,236,Endless@</BlockInfo>
					{

																														//@<OutputChild>
						speechRecogResult = GlobalVariable.recog.getNamewithAbort((int)60000 , (int)3);					//@<BlockInfo>jp.vstone.block.talk.getname,752,1968,1008,1968,False,234,音声認識を行い、名前を取得する。取得結果はメンバー変数のspeechRecogResultに格納される。@</BlockInfo>

						if(speechRecogResult != null)
						{
																														//@<OutputChild>
							String name;																				//@<BlockInfo>jp.vstone.block.freeproc,816,1968,816,1968,False,232,@</BlockInfo>
							name = speechRecogResult;
																														//@<EndOfBlock/>
							GlobalVariable.sotawish.Say((String)name+"さんだね！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,880,1968,880,1968,False,231,@</BlockInfo>
																														//@<EndOfBlock/>
							break;																						//@<BlockInfo>jp.vstone.block.break,944,1968,944,1968,False,230,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

						}else
						{
																														//@<OutputChild>
							GlobalVariable.sotawish.Say((String)"よく聞き取れなかった",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,816,2064,816,2064,False,233,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

						}
																														//@<EndOfBlock/>
																														//@</OutputChild>
					}
																														//@<EndOfBlock/>
					getTemperature(speechRecogResult);																	//@<BlockInfo>jp.vstone.block.callfunc.base,1152,2016,1152,2016,False,235,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>


		}finally{
			GlobalVariable.robocam.StopFaceTraking();
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
