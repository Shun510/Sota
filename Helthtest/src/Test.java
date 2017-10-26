
public class Test {

	public static void main(String[] args) {

		 getName();

	}

	public static void getName(){
		String name = null;
		String speechRecogResult = "ゴトウ";
		name = speechRecogResult;
		getTemperature(name);
	}

	public static void getTemperature(String gN){

		int num1 =1,num2 =2;

		String dos = null;
		String bu = null;
		String ch = null;
		String speechRecogResult = null;

		if(num1==1){
			speechRecogResult = "四十";
			ch = speechRecogResult;
			dos=ch;

			speechRecogResult = "五";
			for(int i =0 ;i<10;i++){

				if(i ==4){
					ch = speechRecogResult;


				}bu = ch;
			}

		}
		getAll(gN,dos,bu);
	}

	public static void getAll(String a,String b,String c){
		int numb=0,numc=0;

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
	}

}
