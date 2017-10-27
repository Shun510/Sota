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
	public void getName()																								//@<BlockInfo>jp.vstone.block.func,256,2064,1584,2064,False,12,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,400,2064,1520,2064,False,11,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,496,2064,1456,2064,False,10,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,560,2016,1392,2016,False,9,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)1)
				{
																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"こんにちは、お名前は",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,624,2016,624,2016,False,8,@</BlockInfo>
																														//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																			//@<BlockInfo>jp.vstone.block.while.endless,688,2016,1184,2016,False,7,Endless@</BlockInfo>
					{

																														//@<OutputChild>
						speechRecogResult = GlobalVariable.recog.getNamewithAbort((int)60000 , (int)3);					//@<BlockInfo>jp.vstone.block.talk.getname,752,1968,1040,1968,False,5,音声認識を行い、名前を取得する。取得結果はメンバー変数のspeechRecogResultに格納される。@</BlockInfo>

						if(speechRecogResult != null)
						{
																														//@<OutputChild>
							String name;																				//@<BlockInfo>jp.vstone.block.freeproc,832,1968,832,1968,False,3,@</BlockInfo>
							name = speechRecogResult;
																														//@<EndOfBlock/>
							GlobalVariable.sotawish.Say((String)name+"さんだね！",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,896,1968,896,1968,False,2,@</BlockInfo>
																														//@<EndOfBlock/>
							break;																						//@<BlockInfo>jp.vstone.block.break,960,1968,960,1968,False,1,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

						}else
						{
																														//@<OutputChild>
							GlobalVariable.sotawish.Say((String)"よく聞き取れなかった",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,816,2064,816,2064,False,4,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

						}
																														//@<EndOfBlock/>
																														//@</OutputChild>
					}
																														//@<EndOfBlock/>
					getTemperature(speechRecogResult);																	//@<BlockInfo>jp.vstone.block.callfunc.base,1264,2016,1264,2016,False,6,@</BlockInfo>	@<EndOfBlock/>
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

	//@<Separate/>
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,352,32,False,17,@</BlockInfo>
	{
																														//@<OutputChild>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,96,32,96,32,False,16,break@</BlockInfo>
																														//@<EndOfBlock/>
		addFaceuserErrSayInterval=0;																					//@<BlockInfo>jp.vstone.block.variable,160,32,160,32,False,15,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*RecogResult recogresult*/;																					//@<BlockInfo>jp.vstone.block.variable,224,32,224,32,False,14,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String time_string*/;																							//@<BlockInfo>jp.vstone.block.variable,288,32,288,32,False,13,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void getTemperature(String gN)																				//@<BlockInfo>jp.vstone.block.func,0,1200,6240,1296,False,228,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		String name;																									//@<BlockInfo>jp.vstone.block.freeproc,64,1216,64,1216,False,227,@</BlockInfo>
		name = gN;

		String dos=null;
		String bu =null;
		String ch =null;
																														//@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)name+"さんの体温は何度？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,128,1200,128,1200,False,226,@</BlockInfo>
																														//@<EndOfBlock/>
		while(GlobalVariable.TRUE)																						//@<BlockInfo>jp.vstone.block.while.endless,176,1296,6096,1296,False,225,Endless@</BlockInfo>
		{

																														//@<OutputChild>
			recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);										//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,240,864,5792,864,False,223,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
			speechRecogResult = recogresult.CheckBest(new String[]{
			 "三十五" ,  "三十六" ,  "三十七" ,  "三十八" ,  "三十九" ,  "四十" ,  "四十一" ,  "四十二" ,  "終わり" ,  "" , 
			},false);
			if(speechRecogResult == null) speechRecogResult = "";

			if(speechRecogResult.contains((String)"三十五"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"３５度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,864,304,864,False,42,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,864,368,864,False,41,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,864,1120,864,False,40,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,624,384,944,384,False,39,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,688,384,688,384,False,19,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,848,384,848,384,False,18,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,688,480,688,480,False,21,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,848,480,848,480,False,20,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,688,576,688,576,False,23,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,848,576,848,576,False,22,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,688,672,688,672,False,25,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,848,672,848,672,False,24,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,688,768,688,768,False,27,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,848,768,848,768,False,26,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,688,864,688,864,False,29,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,848,864,848,864,False,28,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,688,960,688,960,False,31,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,848,960,848,960,False,30,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,688,1056,688,1056,False,33,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,848,1056,848,1056,False,32,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,688,1152,688,1152,False,35,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,848,1152,848,1152,False,34,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,688,1248,688,1248,False,37,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,848,1248,848,1248,False,36,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"聴こえなかったよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,688,1344,688,1344,False,38,@</BlockInfo>
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
					GlobalVariable.sotawish.Say((String)"３６度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,960,304,960,False,67,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,960,368,960,False,66,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,960,1760,960,False,65,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,1344,480,1664,480,False,64,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,1408,480,1408,480,False,44,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1568,480,1568,480,False,43,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,1408,576,1408,576,False,46,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1568,576,1568,576,False,45,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,1408,672,1408,672,False,48,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1568,672,1568,672,False,47,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,1408,768,1408,768,False,50,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1568,768,1568,768,False,49,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,1408,864,1408,864,False,52,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1568,864,1568,864,False,51,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,1408,960,1408,960,False,54,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1568,960,1568,960,False,53,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,1408,1056,1408,1056,False,56,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1568,1056,1568,1056,False,55,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,1408,1152,1408,1152,False,58,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1568,1152,1568,1152,False,57,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,1408,1248,1408,1248,False,60,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1568,1248,1568,1248,False,59,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,1408,1344,1408,1344,False,62,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1568,1344,1568,1344,False,61,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"聴こえなかったよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1408,1440,1408,1440,False,63,@</BlockInfo>
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
					GlobalVariable.sotawish.Say((String)"３７度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1056,304,1056,False,92,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,1056,368,1056,False,91,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,1056,2416,1056,False,90,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,1936,576,2208,576,False,89,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2016,576,2016,576,False,69,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2144,576,2144,576,False,68,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2016,672,2016,672,False,71,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2144,672,2144,672,False,70,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2016,768,2016,768,False,73,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2144,768,2144,768,False,72,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2016,864,2016,864,False,75,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2144,864,2144,864,False,74,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2016,960,2016,960,False,77,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2144,960,2144,960,False,76,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2016,1056,2016,1056,False,79,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2144,1056,2144,1056,False,78,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2016,1152,2016,1152,False,81,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2144,1152,2144,1152,False,80,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2016,1248,2016,1248,False,83,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2144,1248,2144,1248,False,82,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2016,1344,2016,1344,False,85,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2144,1344,2144,1344,False,84,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2016,1440,2016,1440,False,87,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2144,1440,2144,1440,False,86,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"聴こえなかったよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2016,1536,2016,1536,False,88,@</BlockInfo>
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
					GlobalVariable.sotawish.Say((String)"３８度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1152,304,1152,False,117,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,384,1152,384,1152,False,116,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,1152,3040,1152,False,115,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,2624,672,2976,672,False,114,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2704,672,2704,672,False,94,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2912,672,2912,672,False,93,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2688,768,2688,768,False,96,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2912,768,2912,768,False,95,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2704,864,2704,864,False,98,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2912,864,2912,864,False,97,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2704,960,2704,960,False,100,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2912,960,2912,960,False,99,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2704,1056,2704,1056,False,102,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2912,1056,2912,1056,False,101,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2704,1152,2704,1152,False,104,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2912,1152,2912,1152,False,103,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2704,1248,2704,1248,False,106,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2912,1248,2912,1248,False,105,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2704,1344,2704,1344,False,108,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2912,1344,2912,1344,False,107,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2704,1440,2704,1440,False,110,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2912,1440,2912,1440,False,109,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,2704,1536,2704,1536,False,112,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2912,1536,2912,1536,False,111,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"聴こえなかったよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2704,1632,2704,1632,False,113,@</BlockInfo>
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
					GlobalVariable.sotawish.Say((String)"３９度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1248,304,1248,False,142,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,1248,368,1248,False,141,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,1248,3696,1248,False,140,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,3216,768,3568,768,False,139,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3296,768,3296,768,False,119,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3504,768,3504,768,False,118,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3280,864,3280,864,False,121,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3504,864,3504,864,False,120,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3296,960,3296,960,False,123,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3504,960,3504,960,False,122,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3296,1056,3296,1056,False,125,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3504,1056,3504,1056,False,124,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3296,1152,3296,1152,False,127,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3504,1152,3504,1152,False,126,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3296,1248,3296,1248,False,129,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3504,1248,3504,1248,False,128,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3296,1344,3296,1344,False,131,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3504,1344,3504,1344,False,130,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3296,1440,3296,1440,False,133,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3504,1440,3504,1440,False,132,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3296,1536,3296,1536,False,135,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3504,1536,3504,1536,False,134,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3296,1632,3296,1632,False,137,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,3504,1632,3504,1632,False,136,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"聴こえなかったよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3296,1728,3296,1728,False,138,@</BlockInfo>
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
					GlobalVariable.sotawish.Say((String)"四十度何ぶ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1344,304,1344,False,167,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,1344,368,1344,False,166,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,1344,4336,1344,False,165,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,3776,864,4128,864,False,164,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3856,864,3856,864,False,144,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4064,864,4064,864,False,143,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3840,960,3840,960,False,146,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4064,960,4064,960,False,145,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3856,1056,3856,1056,False,148,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4064,1056,4064,1056,False,147,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3856,1152,3856,1152,False,150,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4064,1152,4064,1152,False,149,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3856,1248,3856,1248,False,152,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4064,1248,4064,1248,False,151,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3856,1344,3856,1344,False,154,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4064,1344,4064,1344,False,153,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3856,1440,3856,1440,False,156,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4064,1440,4064,1440,False,155,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3856,1536,3856,1536,False,158,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4064,1536,4064,1536,False,157,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3856,1632,3856,1632,False,160,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4064,1632,4064,1632,False,159,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,3856,1728,3856,1728,False,162,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4064,1728,4064,1728,False,161,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"聴こえなかったよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,3856,1824,3856,1824,False,163,@</BlockInfo>
																																//@<EndOfBlock/>
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
					GlobalVariable.sotawish.Say((String)"四十一度何ぶ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1440,304,1440,False,192,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,1440,368,1440,False,191,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,1440,4960,1440,False,190,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,4480,960,4800,960,False,189,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,4544,960,4544,960,False,169,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4704,960,4704,960,False,168,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,4544,1056,4544,1056,False,171,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4704,1056,4704,1056,False,170,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,4544,1152,4544,1152,False,173,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4704,1152,4704,1152,False,172,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,4544,1248,4544,1248,False,175,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4704,1248,4704,1248,False,174,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,4544,1344,4544,1344,False,177,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4704,1344,4704,1344,False,176,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,4544,1440,4544,1440,False,179,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4704,1440,4704,1440,False,178,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,4544,1536,4544,1536,False,181,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4704,1536,4704,1536,False,180,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,4544,1632,4544,1632,False,183,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4704,1632,4704,1632,False,182,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,4544,1728,4544,1728,False,185,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4704,1728,4704,1728,False,184,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,4544,1824,4544,1824,False,187,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,4704,1824,4704,1824,False,186,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"聴こえなかったよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,4544,1920,4544,1920,False,188,@</BlockInfo>
																																//@<EndOfBlock/>
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
					GlobalVariable.sotawish.Say((String)"四十二度何ぶ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1536,304,1536,False,217,@</BlockInfo>
																															//@<EndOfBlock/>
					ch =speechRecogResult;																					//@<BlockInfo>jp.vstone.block.freeproc,368,1536,368,1536,False,216,@</BlockInfo>
					dos=ch;
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,464,1536,5680,1536,False,215,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,5088,1056,5408,1056,False,214,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "零" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"零"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,5152,1056,5152,1056,False,194,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5312,1056,5312,1056,False,193,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,5152,1152,5152,1152,False,196,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5312,1152,5312,1152,False,195,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,5152,1248,5152,1248,False,198,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5312,1248,5312,1248,False,197,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,5152,1344,5152,1344,False,200,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5312,1344,5312,1344,False,199,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,5152,1440,5152,1440,False,202,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5312,1440,5312,1440,False,201,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,5152,1536,5152,1536,False,204,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5312,1536,5312,1536,False,203,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,5152,1632,5152,1632,False,206,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5312,1632,5312,1632,False,205,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,5152,1728,5152,1728,False,208,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5312,1728,5312,1728,False,207,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,5152,1824,5152,1824,False,210,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5312,1824,5312,1824,False,209,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								ch =speechRecogResult;																			//@<BlockInfo>jp.vstone.block.freeproc,5152,1920,5152,1920,False,212,@</BlockInfo>
								bu=ch;
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,5312,1920,5312,1920,False,211,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"聴こえなかったよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,5152,2016,5152,2016,False,213,@</BlockInfo>
																																//@<EndOfBlock/>
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
					GlobalVariable.sotawish.Say((String)"ばいばい",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1632,304,1632,False,219,@</BlockInfo>
																															//@<EndOfBlock/>
					break;																									//@<BlockInfo>jp.vstone.block.break,384,1632,384,1632,False,218,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

			}
			else
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"聞こえなかった",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1728,304,1728,False,220,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
																														//@<EndOfBlock/>
			System.out.println(name+"さんの体温は，"+dos+"."+bu+"℃ です．");														//@<BlockInfo>jp.vstone.block.freeproc,5872,1296,5872,1296,False,222,@</BlockInfo>
																														//@<EndOfBlock/>
			break;																										//@<BlockInfo>jp.vstone.block.break,5952,1296,5952,1296,False,221,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
		}
																														//@<EndOfBlock/>
		getAll(name,dos,bu);																							//@<BlockInfo>jp.vstone.block.callfunc.base,6160,1296,6160,1296,False,224,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void getAll(String a,String b,String c)																		//@<BlockInfo>jp.vstone.block.func,1760,2032,2272,2032,False,231,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		int numb=0,numc=0;																								//@<BlockInfo>jp.vstone.block.freeproc,1824,2032,1824,2032,False,230,@</BlockInfo>

		switch(b){

		case "三十五":
			numb = 35;
			break;
		case "三十六":
			numb = 36;
			break;
		case "三十七":
			numb = 37;
			break;
		case "三十八":
			numb = 38;
			break;
		case "三十九":
			numb = 39;
			break;
		case "四十":
			numb = 40;
			break;
		case "四十一":
			numb = 41;
			break;
		case "四十二":
			numb = 42;
			break;
		}
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
		try{																											//@<BlockInfo>jp.vstone.block.freeproc,1968,2032,1968,2032,False,232,@</BlockInfo>

		String consumerKey=new String("PeMNePBVCsuEUtww8cuOEx730");
		String consumerSecret=new String("op0T3PmebT8Klhy8T8VW5ActDNno2s9ZAymQPiRW3Dl8SQKboQ");
		String accessToken=new String("862166599851098112-pQJ3NRL6AUZVQU9Miumruef9yHfsKPW");
		String accessTokenSecret=new String("ZXTas1jnavSFOZv2EHqNTMN0cepVC0YHtxLMU7DlKRNTs");
						  
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey(consumerKey)
			.setOAuthConsumerSecret(consumerSecret)
			.setOAuthAccessToken(accessToken)
			.setOAuthAccessTokenSecret(accessTokenSecret);

		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter tw = tf.getInstance();

		tw.updateStatus(a+"さんの体温は，"+numb+"."+numc+"℃ です．");
		}catch(TwitterException e){
			System.out.println(e);
		}
																														//@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)a+"さんの体温は，"+numb+"."+numc+"℃ です．",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2080,2032,2080,2032,False,229,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
