package views;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import domain.MusicVO;


public class Melon {
	
	public List<MusicVO> getTop50(){
		String url = "https://www.genie.co.kr/chart/top200";
		List<MusicVO> mList = new ArrayList<>();
		
		try {
			Document doc = Jsoup.connect(url).get();

			Elements musicList = doc.select(".list-wrap > tbody > tr");
			
			
			
			for (Element music : musicList) {
				String rank = music.selectFirst(".number").ownText();
				String name = music.selectFirst(".info > a").ownText();
				
				MusicVO temp = new MusicVO();
				temp.setName(name);
				temp.setRank(rank);
				
				mList.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mList;
	}

	public static void main(String[] args) {

	}

}
