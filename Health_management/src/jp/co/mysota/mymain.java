//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;
import	jp.vstone.camera.*;
import	jp.vstone.camera.FaceDetectLib.*;

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
	public void getName()																								//@<BlockInfo>jp.vstone.block.func,240,4080,1984,4144,False,17,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,384,4080,1872,4144,False,16,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,480,4080,1760,4144,False,15,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,544,4032,1632,4032,False,14,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)1)
				{
																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"こんにちは、お名前は",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,608,4032,608,4032,False,13,@</BlockInfo>
																														//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																			//@<BlockInfo>jp.vstone.block.while.endless,672,4032,992,4032,False,12,Endless@</BlockInfo>
					{

																														//@<OutputChild>
						speechRecogResult = GlobalVariable.recog.getNamewithAbort((int)60000 , (int)3);					//@<BlockInfo>jp.vstone.block.talk.getname,736,3984,928,3984,False,9,音声認識を行い、名前を取得する。取得結果はメンバー変数のspeechRecogResultに格納される。@</BlockInfo>

						if(speechRecogResult != null)
						{
																														//@<OutputChild>
							GlobalVariable.sotawish.Say((String)speechRecogResult+"君だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,800,3984,800,3984,False,7,@</BlockInfo>
																														//@<EndOfBlock/>
							break;																						//@<BlockInfo>jp.vstone.block.break,864,3984,864,3984,False,6,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

						}else
						{
																														//@<OutputChild>
							GlobalVariable.sotawish.Say((String)"よく聞き取れなかった",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,800,4080,800,4080,False,8,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

						}
																														//@<EndOfBlock/>
																														//@</OutputChild>
					}
																														//@<EndOfBlock/>
					GlobalVariable.sotawish.Say((String)speechRecogResult+"君の体温は？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1168,4032,1168,4032,False,11,@</BlockInfo>
																														//@<EndOfBlock/>
					getTemperature();																					//@<BlockInfo>jp.vstone.block.callfunc.base,1488,4032,1488,4032,False,10,@</BlockInfo>	@<EndOfBlock/>
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
	public void getTemperature()																						//@<BlockInfo>jp.vstone.block.func,16,1200,2624,1120,False,150,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		while(GlobalVariable.TRUE)																						//@<BlockInfo>jp.vstone.block.while.endless,160,1200,2560,1120,False,149,Endless@</BlockInfo>
		{

																														//@<OutputChild>
			recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);										//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,240,864,2416,864,False,148,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
			speechRecogResult = recogresult.CheckBest(new String[]{
			 "三十六" ,  "三十五" ,  "三十七" ,  "三十八" ,  "三十九" ,  "四十" ,  "終わり" ,  "" , 
			},false);
			if(speechRecogResult == null) speechRecogResult = "";

			if(speechRecogResult.contains((String)"三十六"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"３６度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,864,304,864,False,42,@</BlockInfo>
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,432,864,992,864,False,41,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,576,384,768,384,False,40,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "ゼロ" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"ゼロ"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,384,640,384,False,19,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,704,384,704,384,False,18,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度１ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,480,640,480,False,21,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,704,480,704,480,False,20,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度２ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,576,640,576,False,23,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,704,576,704,576,False,22,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度３ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,672,640,672,False,25,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,704,672,704,672,False,24,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度４だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,768,640,768,False,27,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,704,768,704,768,False,26,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度５ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,864,640,864,False,29,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,704,864,704,864,False,28,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度６ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,960,640,960,False,31,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,704,960,704,960,False,30,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度７ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,1056,640,1056,False,33,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,704,1056,704,1056,False,32,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,1152,640,1152,False,35,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,704,1152,704,1152,False,34,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３６度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,1248,640,1248,False,37,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,704,1248,704,1248,False,36,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,1344,640,1344,False,38,@</BlockInfo>
																																//@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
																															//@<EndOfBlock/>
						break;																								//@<BlockInfo>jp.vstone.block.break,896,864,896,864,False,39,break@</BlockInfo>	@<EndOfBlock/>
																															//@</OutputChild>
					}
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"三十五"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"３５度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,960,304,960,False,67,@</BlockInfo>
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,368,960,2208,2320,False,66,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,1872,2736,2064,2736,False,65,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "ゼロ" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"ゼロ"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1936,2736,1936,2736,False,44,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2000,2736,2000,2736,False,43,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度１ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1936,2832,1936,2832,False,46,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2000,2832,2000,2832,False,45,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度２ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1936,2928,1936,2928,False,48,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2000,2928,2000,2928,False,47,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度３ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1936,3024,1936,3024,False,50,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2000,3024,2000,3024,False,49,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度４だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1936,3120,1936,3120,False,52,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2000,3120,2000,3120,False,51,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度５ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1936,3216,1936,3216,False,54,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2000,3216,2000,3216,False,53,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度６ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1936,3312,1936,3312,False,56,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2000,3312,2000,3312,False,55,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度７ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1936,3408,1936,3408,False,58,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2000,3408,2000,3408,False,57,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1936,3504,1936,3504,False,60,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2000,3504,2000,3504,False,59,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３５度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1936,3600,1936,3600,False,62,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2000,3600,2000,3600,False,61,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1936,3696,1936,3696,False,63,@</BlockInfo>
																																//@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
																															//@<EndOfBlock/>
						break;																								//@<BlockInfo>jp.vstone.block.break,2128,3216,2128,3216,False,64,break@</BlockInfo>	@<EndOfBlock/>
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
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,432,1056,1840,816,False,91,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,1344,336,1648,336,False,90,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "ゼロ" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"ゼロ"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1488,336,1488,336,False,69,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1552,336,1552,336,False,68,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度１ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1488,432,1488,432,False,71,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1552,432,1552,432,False,70,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度２ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1488,528,1488,528,False,73,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1552,528,1552,528,False,72,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度３ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1488,624,1488,624,False,75,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1552,624,1552,624,False,74,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度４ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1488,720,1488,720,False,77,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1552,720,1552,720,False,76,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度５ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1488,816,1488,816,False,79,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1552,816,1552,816,False,78,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度６ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1488,912,1488,912,False,81,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1552,912,1552,912,False,80,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度７ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1488,1008,1488,1008,False,83,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1552,1008,1552,1008,False,82,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1488,1104,1488,1104,False,85,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1552,1104,1552,1104,False,84,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３７度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1488,1200,1488,1200,False,87,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1552,1200,1552,1200,False,86,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1488,1296,1488,1296,False,88,@</BlockInfo>
																																//@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
																															//@<EndOfBlock/>
						break;																								//@<BlockInfo>jp.vstone.block.break,1712,816,1712,816,False,89,break@</BlockInfo>	@<EndOfBlock/>
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
					GlobalVariable.sotawish.Say((String)"３８度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1152,304,1152,False,116,@</BlockInfo>
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,432,1152,2272,1024,False,115,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,2000,544,2192,544,False,114,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "ゼロ" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"ゼロ"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2064,544,2064,544,False,94,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2128,544,2128,544,False,93,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度１ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2064,640,2064,640,False,96,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2128,640,2128,640,False,95,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度２ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2064,736,2064,736,False,98,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2128,736,2128,736,False,97,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度３ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2064,832,2064,832,False,100,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2128,832,2128,832,False,99,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度４だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2064,928,2064,928,False,102,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2128,928,2128,928,False,101,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度５ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2064,1024,2064,1024,False,104,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2128,1024,2128,1024,False,103,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度６ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2064,1120,2064,1120,False,106,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2128,1120,2128,1120,False,105,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度７ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2064,1216,2064,1216,False,108,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2128,1216,2128,1216,False,107,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2064,1312,2064,1312,False,110,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2128,1312,2128,1312,False,109,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３８度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2064,1408,2064,1408,False,112,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,2128,1408,2128,1408,False,111,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,2064,1504,2064,1504,False,113,@</BlockInfo>
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
					GlobalVariable.sotawish.Say((String)"３９度ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1248,304,1248,False,141,@</BlockInfo>
																															//@<EndOfBlock/>
					while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,432,1248,1264,2448,False,140,Endless@</BlockInfo>
					{
					
																															//@<OutputChild>
						recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);								//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,944,1968,1136,1968,False,139,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
						speechRecogResult = recogresult.CheckBest(new String[]{
						 "ゼロ" ,  "一" ,  "二" ,  "三" ,  "四" ,  "五" ,  "六" ,  "七" ,  "八" ,  "九" ,  "" , 
						},false);
						if(speechRecogResult == null) speechRecogResult = "";
					
						if(speechRecogResult.contains((String)"ゼロ"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1008,1968,1008,1968,False,118,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1072,1968,1072,1968,False,117,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"一"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度１ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1008,2064,1008,2064,False,120,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1072,2064,1072,2064,False,119,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"二"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度２ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1008,2160,1008,2160,False,122,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1072,2160,1072,2160,False,121,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"三"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度３ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1008,2256,1008,2256,False,124,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1072,2256,1072,2256,False,123,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"四"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度４だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1008,2352,1008,2352,False,126,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1072,2352,1072,2352,False,125,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"五"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度５ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1008,2448,1008,2448,False,128,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1072,2448,1072,2448,False,127,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"六"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度６ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1008,2544,1008,2544,False,130,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1072,2544,1072,2544,False,129,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"七"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度７ブだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1008,2640,1008,2640,False,132,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1072,2640,1072,2640,False,131,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"八"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度８ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1008,2736,1008,2736,False,134,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1072,2736,1072,2736,False,133,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else if(speechRecogResult.contains((String)"九"))
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"３９度９ぶだね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1008,2832,1008,2832,False,136,@</BlockInfo>
																																//@<EndOfBlock/>
								break;																							//@<BlockInfo>jp.vstone.block.break,1072,2832,1072,2832,False,135,break@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
						else
						{
							speechRecogResult = recogresult.getBasicResult();
							if(speechRecogResult == null) speechRecogResult = "";
					
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"ナンブ？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,1008,2928,1008,2928,False,137,@</BlockInfo>
																																//@<EndOfBlock/>
																																	//@</OutputChild>
					
						}
																															//@<EndOfBlock/>
						break;																								//@<BlockInfo>jp.vstone.block.break,1200,2448,1200,2448,False,138,break@</BlockInfo>	@<EndOfBlock/>
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
					GlobalVariable.sotawish.Say((String)"四十度以上だね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1344,304,1344,False,143,@</BlockInfo>
																															//@<EndOfBlock/>
					break;																									//@<BlockInfo>jp.vstone.block.break,432,1344,432,1344,False,142,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"終わり"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"ばいばい",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1440,304,1440,False,145,@</BlockInfo>
																															//@<EndOfBlock/>
					break;																									//@<BlockInfo>jp.vstone.block.break,432,1440,432,1440,False,144,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

			}
			else
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"聞こえなかった",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,1536,304,1536,False,146,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
																														//@<EndOfBlock/>
			break;																										//@<BlockInfo>jp.vstone.block.break,2496,1120,2496,1120,False,147,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
