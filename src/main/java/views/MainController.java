package views;

import java.awt.Desktop;
import java.net.URI;
import java.util.List;

import domain.MusicVO;
import domain.UserVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import main.MainApp;

public class MainController extends MasterController {
	@FXML
	private TextField txtMsg;
	@FXML
	private Button btnAlert;
	@FXML
	private TextField ms;
	@FXML
	private Button btn2;
	@FXML
	private ScrollPane sp;
	@FXML
	private Label lbl;
	@FXML
	private TextField ms2;
	@FXML
	private Button btn3;
	
	@FXML
	private Button help;

	private Melon m;
	private List<MusicVO> musicList;
	private UserVO user;
	@FXML
	private StackPane mainPage;

	@FXML
	private void initialize() {
		m = new Melon();
		musicList = m.getTop50();
		setMusicList();
	}

	public void setMusicList() {
		for (MusicVO music : musicList) {
			
			lbl.setText(lbl.getText() + music.getRank() + " 위  - " + music.getName() + "\n");
		}

	}

	public void clickHandler() {
		String msg = txtMsg.getText();
		try {
			Desktop.getDesktop().browse(new URI("https://www.youtube.com/results?search_query=" + msg));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("브라우저 오픈중 오류 발생");
		}
	}

	public void clickHandler2() {
		String site = ms.getText();
		try {
			Desktop.getDesktop().browse(new URI("https://www." + "aaa" + "youtube.com/watch?v=" + site));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("브라우저 오픈중 오류 발생");
		}

	}

	public void clickHandler3() {

		try {
			Desktop.getDesktop().browse(new URI("https://youtu.be/Mg8qVW3LHNM"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("브라우저 오픈중 오류 발생");
		}

	}
	public void clickHandler4() {
String ms = ms2.getText();
		try {
			Desktop.getDesktop().browse(new URI("https://www.melon.com/search/total/index.htm?q=" + ms + "&section=&searchGnbYn=Y&kkoSpl=Y&kkoDpType=&linkOrText=T&ipath=srch_form"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("브라우저 오픈중 오류 발생");
		}

	}

	public void setLoginInfo(UserVO user) {
		this.user = user;
	}

	public void logout() {
		this.user = null;
		MainApp.app.loadPane("login");
	}

	@Override
	public void reset() {
	}

}
