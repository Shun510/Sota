//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;
import	jp.vstone.camera.*;

public class Health
{

	public String speechRecogResult;
	public RecogResult recogresult;
	public int faceDetectResultAge;
	public Health()																										//@<BlockInfo>jp.vstone.block.func.constructor,16,16,272,16,False,4,@</BlockInfo>
	{
																														//@<OutputChild>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,80,16,80,16,False,3,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*RecogResult recogresult*/;																					//@<BlockInfo>jp.vstone.block.variable,144,16,144,16,False,2,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*int faceDetectResultAge*/;																					//@<BlockInfo>jp.vstone.block.variable,208,16,208,16,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void talkman()																								//@<BlockInfo>jp.vstone.block.func,0,144,720,144,False,11,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		if(!GlobalVariable.sotawish.isPlayIdling()) GlobalVariable.sotawish.StartIdling();								//@<BlockInfo>jp.vstone.block.talk.idling2,64,144,656,144,False,10,Idling開始@</BlockInfo>
		try{


																														//@<OutputChild>
			GlobalVariable.robocam.setEnableFaceSearch(false);															//@<BlockInfo>jp.vstone.block.facedetect.traking,128,144,592,144,False,9,顔追従@</BlockInfo>
			GlobalVariable.robocam.setEnableSmileDetect(true);
			GlobalVariable.robocam.setEnableAgeSexDetect(true);

			GlobalVariable.robocam.StartFaceTraking();
			try{
				GlobalVariable.detectCount=0;


																														//@<OutputChild>
				while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,192,144,528,144,False,8,Endless@</BlockInfo>
				{

																														//@<OutputChild>
					GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();								//@<BlockInfo>jp.vstone.block.facedetect.isdetect,256,96,464,96,False,7,コメント@</BlockInfo>

					if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
					else GlobalVariable.detectCount=0;

					if(GlobalVariable.detectCount>(int)1)
					{
																														//@<OutputChild>
						GlobalVariable.sotawish.Say((String)"こんにちは",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,320,96,320,96,False,6,@</BlockInfo>
																														//@<EndOfBlock/>
						Health_check();																					//@<BlockInfo>jp.vstone.block.callfunc.base,384,96,384,96,False,5,@</BlockInfo>	@<EndOfBlock/>
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


		}
		finally
		{
			GlobalVariable.sotawish.StopIdling();
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void Health_check()																							//@<BlockInfo>jp.vstone.block.func,0,736,1472,736,False,18,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		speechRecogResult = GlobalVariable.recog.getNamewithAbort((int)60000 , (int)3);									//@<BlockInfo>jp.vstone.block.talk.getname,64,688,848,704,False,17,音声認識を行い、名前を取得する。取得結果はメンバー変数のspeechRecogResultに格納される。@</BlockInfo>

		if(speechRecogResult != null)
		{
																														//@<OutputChild>
			String enjiname=0;																							//@<BlockInfo>jp.vstone.block.variable,144,688,144,688,False,15,break@</BlockInfo>
																														//@<EndOfBlock/>
			enjiname=(String)speechRecogResult;																			//@<BlockInfo>jp.vstone.block.calculater,208,688,208,688,False,14,@</BlockInfo>
																														//@<EndOfBlock/>
			GlobalVariable.sotawish.Say((String)enjiname+"くんの体温は？,MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,288,688,288,688,False,13,@</BlockInfo>
																														//@<EndOfBlock/>
			recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);										//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,384,640,704,640,False,12,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
			speechRecogResult = recogresult.CheckBest(new String[]{
			 36.0 ,  36.1 ,  36.2 ,  36.3 ,  36.4 ,  36.5 ,  36.6 ,  "" , 
			},false);
			if(speechRecogResult == null) speechRecogResult = "";

			if(speechRecogResult.contains((String)36.0))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)enjiname+"くんの体温は"+speechRecogResultです。,MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,448,640,448,640,False,22,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)36.1))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
																														//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)36.2))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
																														//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)36.3))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
																														//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)36.4))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
																														//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)36.5))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
																														//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)36.6))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
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

		}else
		{
																														//@<OutputChild>
			GlobalVariable.sotawish.Say((String)"名前がわからなかったよ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,128,784,128,784,False,16,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void speechRecog()																							//@<BlockInfo>jp.vstone.block.func,128,416,1184,400,False,20,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);											//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,192,368,1120,352,False,19,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
		speechRecogResult = recogresult.CheckBest(new String[]{
		 "こんにちは" ,  "" , 
		},false);
		if(speechRecogResult == null) speechRecogResult = "";

		if(speechRecogResult.contains((String)"こんにちは"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
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

	}																													//@<EndOfBlock/>

	//@<Separate/>
	/*
	GlobalVariable.sotawish.Say((String)"こんにちは",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);				//@<BlockInfo>jp.vstone.block.talk.say,64,560,64,560,False,21,@</BlockInfo>
																														//@<EndOfBlock/>

	*/

}
