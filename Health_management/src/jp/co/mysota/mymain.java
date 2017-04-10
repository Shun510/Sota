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
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,320,32,False,3,@</BlockInfo>
	{
																														//@<OutputChild>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,96,32,96,32,False,2,break@</BlockInfo>
																														//@<EndOfBlock/>
		addFaceuserErrSayInterval=0;																					//@<BlockInfo>jp.vstone.block.variable,160,32,160,32,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void getUser()																								//@<BlockInfo>jp.vstone.block.func,48,672,832,672,False,13,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		for(int i=0;i<(int)50;i++)																						//@<BlockInfo>jp.vstone.block.for,112,672,768,672,False,12,コメント@</BlockInfo>
		{
																														//@<OutputChild>
			GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();										//@<BlockInfo>jp.vstone.block.facedetect.isdetect,176,624,624,624,False,11,コメント@</BlockInfo>

			if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
			else GlobalVariable.detectCount=0;

			if(GlobalVariable.detectCount>(int)1)
			{
																														//@<OutputChild>
				GlobalVariable.faceuser = GlobalVariable.robocam.getUser(GlobalVariable.faceresult);					//@<BlockInfo>jp.vstone.block.facedetect.user.get2,240,576,560,576,False,8,認識した顔の特徴を取得して、グローバル変数FaceUser faceuserに代入します。また、登録済みのユーザの場合、名前をグローバル変数String facenameに代入します。@</BlockInfo>

				if(GlobalVariable.faceuser != null)
				{
					if(GlobalVariable.faceuser.getName() != null) GlobalVariable.facename = GlobalVariable.faceuser.getName();
					else GlobalVariable.facename="";
					
																														//@<OutputChild>
						if(GlobalVariable.faceuser!=null)																	//@<BlockInfo>jp.vstone.block.facedetect.user.add,304,528,496,528,False,6,@</BlockInfo>
						{
							GlobalVariable.faceuser.setName((String)speechRecogResult);
							int faceuserAddReturnCode = GlobalVariable.robocam.addUserwithErrorCode(GlobalVariable.faceuser);
							boolean isfaceuseradd = (faceuserAddReturnCode==1);
						
							String errMessageVoice=null;
							switch(faceuserAddReturnCode)
							{
								case -100: errMessageVoice="ユーザ情報がありません。";
								break;
								case -201: errMessageVoice="顔が上や下を向いているみたい。まっすぐ前を向いてください";
								break;
								case -202: errMessageVoice="首が傾いているみたい。まっすぐにしてください";
								break;
								case -203: errMessageVoice="顔が横を向いているみたい。まっすぐ前を見てください";
								break;
								case -300: errMessageVoice="もっと近くで顔を見せてください。";
								break;
								case -400: errMessageVoice="顔が良く見えませんでした。しっかり顔を見せてください。";
								break;
								case -500: errMessageVoice="顔が見つかりませんでした。";
								break;
							}
							if(errMessageVoice!=null && ++addFaceuserErrSayInterval == 3)
							{
								addFaceuserErrSayInterval=0;
								String file = TextToSpeechSota.getTTSFile(errMessageVoice);
								if(file!=null) CPlayWave.PlayWave(file,true);
							}
						 
							if(isfaceuseradd==true)
							{
																															//@<OutputChild>
							GlobalVariable.sotawish.Say((String)"登録できました",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,368,528,368,528,False,5,@</BlockInfo>
																															//@<EndOfBlock/>
							break;																							//@<BlockInfo>jp.vstone.block.break,432,528,432,528,False,4,break@</BlockInfo>	@<EndOfBlock/>
																															//@</OutputChild>
						
							}else
							{
																															//@<OutputChild>
																															//@</OutputChild>
						
							}
						
						}
																															//@<EndOfBlock/>
																																//@</OutputChild>

				}
				else
				{
					
																														//@<OutputChild>
						GlobalVariable.sotawish.Say((String)"特徴がつかめなかったよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,384,672,384,672,False,7,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>

			}else
			{
																														//@<OutputChild>
				GlobalVariable.sotawish.Say((String)"顔が見えなかったよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,304,720,304,720,False,9,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

			}
																														//@<EndOfBlock/>
			CRobotUtil.wait((int)100);																					//@<BlockInfo>jp.vstone.block.wait,688,672,688,672,False,10,コメント@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
		}																												//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void main()																									//@<BlockInfo>jp.vstone.block.func,416,32,480,32,False,14,コメント@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void getFace()																								//@<BlockInfo>jp.vstone.block.func,16,272,1024,272,False,24,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(false);																//@<BlockInfo>jp.vstone.block.facedetect.traking,80,272,960,272,False,23,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,144,272,896,272,False,22,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,208,224,832,224,False,21,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)1)
				{
																														//@<OutputChild>
					GlobalVariable.faceuser = GlobalVariable.robocam.getUser(GlobalVariable.faceresult);				//@<BlockInfo>jp.vstone.block.facedetect.user.get2,272,176,768,176,False,20,認識した顔の特徴を取得して、グローバル変数FaceUser faceuserに代入します。また、登録済みのユーザの場合、名前をグローバル変数String facenameに代入します。@</BlockInfo>

					if(GlobalVariable.faceuser != null)
					{
						if(GlobalVariable.faceuser.getName() != null) GlobalVariable.facename = GlobalVariable.faceuser.getName();
						else GlobalVariable.facename="";
						
																														//@<OutputChild>
							if(!GlobalVariable.faceuser.isNewUser())														//@<BlockInfo>jp.vstone.block.facedetect.user.isknow,336,128,704,128,False,19,グローバル変数FaceUser faceuserに記録された顔が登録された顔であるか@</BlockInfo>
							{
																															//@<OutputChild>
								String speechText=あなたの名前は;																	//@<BlockInfo>jp.vstone.block.variable,400,128,400,128,False,18,break@</BlockInfo>
																															//@<EndOfBlock/>
								speechText+=GlobalVariable.facename;														//@<BlockInfo>jp.vstone.block.calculater,512,128,512,128,False,17,@</BlockInfo>
																															//@<EndOfBlock/>
								speechText+=先生ですね;																			//@<BlockInfo>jp.vstone.block.calculater,576,128,576,128,False,16,@</BlockInfo>
																															//@<EndOfBlock/>
								GlobalVariable.sotawish.Say((String)speechText,MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,128,640,128,False,15,@</BlockInfo>
																															//@<EndOfBlock/>
																															//@</OutputChild>
							
							}else
							{
																															//@<OutputChild>
								GlobalVariable.sotawish.Say((String)"始めまして、あなたは何先生？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,512,224,512,224,False,34,@</BlockInfo>
																															//@<EndOfBlock/>
								getName();																					//@<BlockInfo>jp.vstone.block.callfunc.base,576,224,576,224,False,33,@</BlockInfo>	@<EndOfBlock/>
								GlobalVariable.sotawish.Say((String)"顔を覚えるので正面向きで僕を見てください",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,640,224,640,224,False,32,@</BlockInfo>
																															//@<EndOfBlock/>
																															//@</OutputChild>
							
							}
																															//@<EndOfBlock/>
																																//@</OutputChild>

					}
					else
					{
						
																														//@<OutputChild>
																														//@</OutputChild>

					}
																														//@<EndOfBlock/>
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
	public void getName()																								//@<BlockInfo>jp.vstone.block.func,160,912,688,912,False,31,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.Say((String)"こんにちは",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);			//@<BlockInfo>jp.vstone.block.talk.say,224,912,224,912,False,30,@</BlockInfo>
																														//@<EndOfBlock/>
		speechRecogResult = GlobalVariable.recog.getNamewithAbort((int)60000 , (int)3);									//@<BlockInfo>jp.vstone.block.talk.getname,304,864,624,864,False,29,音声認識を行い、名前を取得する。取得結果はメンバー変数のspeechRecogResultに格納される。@</BlockInfo>

		if(speechRecogResult != null)
		{
																														//@<OutputChild>
			String speechText=あなたは;																						//@<BlockInfo>jp.vstone.block.variable,368,864,368,864,False,28,break@</BlockInfo>
																														//@<EndOfBlock/>
			speechText+=(String)speechRecogResult;																		//@<BlockInfo>jp.vstone.block.calculater,432,864,432,864,False,27,@</BlockInfo>
																														//@<EndOfBlock/>
			speechText+=先生です;																							//@<BlockInfo>jp.vstone.block.calculater,496,864,496,864,False,26,@</BlockInfo>
																														//@<EndOfBlock/>
			GlobalVariable.sotawish.Say((String)speechText,MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,560,864,560,864,False,25,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

		}else
		{
																														//@<OutputChild>
																														//@</OutputChild>

		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
