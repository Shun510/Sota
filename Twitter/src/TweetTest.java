import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class TweetTest {
 public static void main(String[] args) throws TwitterException, MalformedURLException, IOException{

  Twitter twitter = new TwitterFactory().getInstance();//Twitterオブジェクト作成

  //twitter.setOAuthConsumer("EarqNFePu9e48G5I1lJnjOU57", //アプリケーションのconsumer key
  //  "jsRoH1JNebqJHA8eMPqwwQzd6MXdqQh8Y58hh31Y4M7IVPmpgZ"); //アプリケーションのconsumer secret

  //AccessToken accessToken = new AccessToken(
  //  "862166599851098112-pQJ3NRL6AUZVQU9Miumruef9yHfsKPW", //自分のAccess token
  //  "ZXTas1jnavSFOZv2EHqNTMN0cepVC0YHtxLMU7DlKRNTs"); //自分のAccess token secret

  //twitter.setOAuthAccessToken(accessToken);//自分のアクセストークンをTwitterオブジェクトに格納

  User user = twitter.verifyCredentials();//Userオブジェクトを作成


  System.out.println(user.getId());//自分のアカウントのIDの取得（数字のID）

  System.out.println(user.getName());//自分のアカウントの名前を取得

  System.out.println(user.getScreenName());//自分のアカウントのUserNameを取得（アルファベットのみの名前）

  System.out.println(user.getLocation());//自分のアカウントのプロフィールの場所を取得

  System.out.println(user.getDescription());//自分のアカウントのプロフィールの説明を取得

  System.out.println(user.getProfileImageURL());//自分のアカウントのプロフィール画像のURLを取得

  System.out.println(user.getURL());//自分のアカウントのプロフィールのURLを取得する

  System.out.println(user.isProtected());//自分のアカウントに鍵がついてるか取得する

  System.out.println(user.getFollowersCount());//自分のアカウントのフォロワー数を取得する

  System.out.println(user.getFriendsCount());//自分のアカウントのフォロー数を取得する

  System.out.println(user.getCreatedAt());//自分のアカウントの登録日を取得する

  System.out.println(user.getFavouritesCount());//自分のアカウントのお気に入り数を取得する

  System.out.println(user.getProfileBannerURL());//自分のアカウントのバナー画像を取得する

  System.out.println(user.getStatusesCount()); //呟きの数を取得

  System.out.println(user.getListedCount());//追加されているリストの数を取得する


  StatusUpdate status = new StatusUpdate("画像付きツイート");
  status.media("310.jpg",new URL("https://nekogazou.com/wp-content/uploads/2013/07/310.jpg").openStream());

  InetAddress addr = InetAddress.getLocalHost();
  InetAddress addr2 = InetAddress.getLocalHost();
  	if (addr.equals(addr2)) System.out.println("addrとaddr2は同じインスタンス");
      System.out.println("Local Host Name: " + addr.getHostName());
      System.out.println("IP Address     : " + addr.getHostAddress());
      twitter.updateStatus(addr.getHostAddress());
 }
}

