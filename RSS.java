import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class RSS_Test {

 private static final String RSS_URL= "https://queryfeed.net/twitter?q=from%3Aeew_jp&title-type=user-name-both&geocode=";

 public static String HtmlTagRemover(String str) {
		// 文字列のすべてのタグを取り除く
		return str.replaceAll("<.+?>", "");
	}

 public static void main(String[] args) {

  try {

   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

   DocumentBuilder builder = factory.newDocumentBuilder();

   Document document = builder.parse(RSS_URL);

   // ドキュメントのルートを取得
   Element root = document.getDocumentElement();

   // ルート直下の"channel"に含まれるノードリストを取得
   NodeList channel = root.getElementsByTagName("channel");

   // "channel"直下の"title"に含まれるノードリストを取得
   NodeList title = ((Element)channel.item(0)).getElementsByTagName("title");

   // とりあえず出力する
   //System.out.println("タイトル：" + title.item(0).getFirstChild().getNodeValue());

   // 各"item"とその中の"title"と"description"を取得する。
   NodeList item_list = root.getElementsByTagName("item");

   // item分ループする
   for(int i = 0; i < 1; i++) {

    Element element = (Element)item_list.item(i);

    // title を取得する
                NodeList item_title = element.getElementsByTagName("title");
                // description を取得する
                NodeList item_description = element.getElementsByTagName("description");
                String des = item_description.item(0).getFirstChild().getNodeValue();
                System.out.println(des);
                des = des.replaceAll("<a.+?>", "");
                des = des.replaceAll("</a.*?>", "");
                des = des.replaceAll("twiple.*", "");
                des = des.replaceAll("#earthquake", "");
                // 出力する
                //System.out.println(item_title.item(0).getFirstChild().getNodeValue());
                System.out.println(des);


   }

  } catch (ParserConfigurationException e) {
   e.printStackTrace();
  } catch (SAXException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }

 }

}
