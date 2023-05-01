package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import pizzas.Ingredients;
import pizzas.Neapolitan;
import pizzas.Poolish;
import pizzas.Sheet;

public class Controller implements Initializable {

	@FXML
	private Pane root;
	@FXML
	private Scene scene;
	@FXML
	private Stage stage;
	@FXML
	private Label napolyi = new Label();
	@FXML
	private Label romai = new Label();
	@FXML
	private Label segitseg = new Label();
	@FXML
	private Label fooldal = new Label();
	@FXML
	private javafx.scene.control.TextField weight = new javafx.scene.control.TextField();
	@FXML
	private javafx.scene.control.TextField hydration = new javafx.scene.control.TextField();
	@FXML
	private javafx.scene.control.TextField db = new javafx.scene.control.TextField();
	@FXML
	private javafx.scene.control.TextField a_side = new javafx.scene.control.TextField();
	@FXML
	private javafx.scene.control.TextField b_side = new javafx.scene.control.TextField();
	@FXML
	private javafx.scene.control.TextField thickness = new javafx.scene.control.TextField();
	@FXML
	private Text fooldal_szoveg1 = new Text();
	@FXML
	private Text fooldal_szoveg2 = new Text();
	@FXML
	private Text fooldal_szoveg3 = new Text();
	@FXML
	private Label vito = new Label();
	@FXML
	private Label malati = new Label();
	@FXML
	private Button ButtonX = new Button();
	@FXML
	private Line line = new Line(0, 0, 2000, 0);

	// A window mozgatasara valo értekek
	private double xOffset = 0;
	private double yOffset = 0;

	long pressTime = 0;
	boolean dragDetected = false;

	// Rgb_line previous scene színével + a rgb_line_second meghívása a megfelelő
	// animáció végett
	public void rgb_line_first(Color previousLineColor) {
		line.setStrokeWidth(4);
		line.setRotate(90);
		line.setTranslateX(-725);

		Timeline colorTimeline = new Timeline();
		colorTimeline.setCycleCount(Timeline.INDEFINITE);

		KeyValue kv0 = new KeyValue(line.strokeProperty(), previousLineColor);
		KeyValue kv1 = new KeyValue(line.strokeProperty(), Color.RED);
		KeyValue kv2 = new KeyValue(line.strokeProperty(), Color.MAGENTA);
		KeyValue kv3 = new KeyValue(line.strokeProperty(), Color.PURPLE);
		KeyValue kv4 = new KeyValue(line.strokeProperty(), Color.AQUA);
		KeyValue kv5 = new KeyValue(line.strokeProperty(), Color.LIGHTSEAGREEN);
		KeyValue kv6 = new KeyValue(line.strokeProperty(), Color.GREEN);
		KeyValue kv7 = new KeyValue(line.strokeProperty(), Color.YELLOWGREEN);
		KeyValue kv8 = new KeyValue(line.strokeProperty(), Color.YELLOW);
		KeyValue kv9 = new KeyValue(line.strokeProperty(), Color.ORANGE);
		KeyValue kv10 = new KeyValue(line.strokeProperty(), Color.RED);

		KeyFrame kf0 = new KeyFrame(Duration.ZERO, kv0);
		KeyFrame kf1 = new KeyFrame(Duration.seconds(0.7), kv1);
		KeyFrame kf2 = new KeyFrame(Duration.seconds(1.4), kv2);
		KeyFrame kf3 = new KeyFrame(Duration.seconds(2.1), kv3);
		KeyFrame kf4 = new KeyFrame(Duration.seconds(2.8), kv4);
		KeyFrame kf5 = new KeyFrame(Duration.seconds(3.5), kv5);
		KeyFrame kf6 = new KeyFrame(Duration.seconds(4.2), kv6);
		KeyFrame kf7 = new KeyFrame(Duration.seconds(4.9), kv7);
		KeyFrame kf8 = new KeyFrame(Duration.seconds(5.6), kv8);
		KeyFrame kf9 = new KeyFrame(Duration.seconds(6.3), kv9);
		KeyFrame kf10 = new KeyFrame(Duration.seconds(7.0), kv10);

		colorTimeline.getKeyFrames().addAll(kf0, kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9, kf10);

		colorTimeline.play();

		((Pane) scene.getRoot()).getChildren().add(line);

		Duration duration = Duration.millis(6990);
		PauseTransition pause = new PauseTransition(duration);
		pause.setOnFinished(e -> {
			rgb_line_second();
		});

		pause.play();
	}

	// Rgb_line újrahívása már a previous scene színe nélkül
	public void rgb_line_second() {
		line.setStrokeWidth(4);
		line.setRotate(90);
		line.setTranslateX(-725);

		Timeline colorTimeline = new Timeline();
		colorTimeline.setCycleCount(Timeline.INDEFINITE);

		KeyValue kv1 = new KeyValue(line.strokeProperty(), Color.RED);
		KeyValue kv2 = new KeyValue(line.strokeProperty(), Color.MAGENTA);
		KeyValue kv3 = new KeyValue(line.strokeProperty(), Color.PURPLE);
		KeyValue kv4 = new KeyValue(line.strokeProperty(), Color.AQUA);
		KeyValue kv5 = new KeyValue(line.strokeProperty(), Color.LIGHTSEAGREEN);
		KeyValue kv6 = new KeyValue(line.strokeProperty(), Color.GREEN);
		KeyValue kv7 = new KeyValue(line.strokeProperty(), Color.YELLOWGREEN);
		KeyValue kv8 = new KeyValue(line.strokeProperty(), Color.YELLOW);
		KeyValue kv9 = new KeyValue(line.strokeProperty(), Color.ORANGE);

		KeyFrame kf0 = new KeyFrame(Duration.ZERO, kv1);
		KeyFrame kf1 = new KeyFrame(Duration.seconds(0.7), kv2);
		KeyFrame kf2 = new KeyFrame(Duration.seconds(1.4), kv3);
		KeyFrame kf3 = new KeyFrame(Duration.seconds(2.1), kv4);
		KeyFrame kf4 = new KeyFrame(Duration.seconds(2.8), kv5);
		KeyFrame kf5 = new KeyFrame(Duration.seconds(3.5), kv6);
		KeyFrame kf6 = new KeyFrame(Duration.seconds(4.2), kv7);
		KeyFrame kf7 = new KeyFrame(Duration.seconds(4.9), kv8);
		KeyFrame kf8 = new KeyFrame(Duration.seconds(5.6), kv9);
		KeyFrame kf9 = new KeyFrame(Duration.seconds(6.3), kv1);

		colorTimeline.getKeyFrames().addAll(kf0, kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9);

		colorTimeline.play();
	}

	// Nápolyi oldara váltás
	public void switchToScene1(MouseEvent event) throws IOException {
		Color previousLineColor = (Color) line.getStroke();
		root = FXMLLoader.load(getClass().getResource("Napolyi.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
		rgb_line_first(previousLineColor);
	}

	// Római oldalra váltás
	public void switchToScene2(MouseEvent event) throws IOException {
		Color previousLineColor = (Color) line.getStroke();
		root = FXMLLoader.load(getClass().getResource("Romai.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
		rgb_line_first(previousLineColor);
	}

	// ÚTMUTATÓNAK ÁTNEVEZÉSE !!!!
	// Segitseg oldalra valtas plusz ScrollPane + TextArea
	public void switchToScene3(MouseEvent event) throws IOException {
		Color previousLineColor = (Color) line.getStroke();
		root = FXMLLoader.load(getClass().getResource("Segitseg.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		String css = this.getClass().getResource("application.css").toExternalForm();
		TextArea text_area = new TextArea();
		ScrollPane segitseg_scroll = new ScrollPane();
		text_area.setWrapText(true);
		text_area.setEditable(false);
		text_area.setPrefSize(400, 530);
		segitseg_scroll.setFitToWidth(true);
		segitseg_scroll.setFitToHeight(true);
		segitseg_scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		text_area.setText(
				"Számítsuk ki a kívánt pizza hozzávalóit, ügyeljünk a helyes értékek megadására!\n\n"
				+ "Súly: egy buci súlyát fogjuk meghatározni! Figyeljünk oda, hogyha nem hagyjuk elég ideig a bucit kelni, akkor sokkal kisebb lesz a végeredmény, mint amit itt meghatározok a következőkben:\n"
				+ "- Kicsi: 340g alatt adjunk értéket, ha 28 centinél kisebb pizzát késztenél!\n"
				+ "- Normál: 330g felett és 380g alatt legyen az érték 32cm-s pizza esetén!\n"
				+ "- Nagy: 380g-tól nagyobb értéket adj meg!\n\n"
				+ "Vastagság: ez egy osztószám, ami az oldalak szorzatát osztja el önmagával!\n"
				+ "- Vékony: 250 ~ 2cm vastag\n"
				+ "- Normál: 200 ~ 3cm vastag\n"
				+ "- Vastag: 150 ~ 4/5cm vastag\n"
				+ "Ha nagyobb szélű pizzát szeretnél, akkor ajánlom a 390g-400g bucit, ezt kelesztés után ki tudod nyújtani úgy 32cm-re, hogy maradjon szép nagy széle!\n\n"
				+ "Természetesen a tapasztalatunk szab határt egy pizza készítésében és formázásában.\n\n"
				+ "Hidratáció: itt a bucinak a víztartalmát adjuk meg, pl 70%-nál és 100g liszttel számolva 70ml vizet kellene hozzáadni.\n"
				+ "Az intervallum 60-70 között van beállítva, kevesebbet nem érdemes, mert nagyon száraz lesz a tészta és sok nedvet felszív a gyomorból! (ezért IS érezzük, hogy 'puffadunk' tőle)\nKezdőknek a 60%-t ajánlom, majd pedig fokozatosan lehet haladni felfele a tökéletes 70%-hoz! Az intervallum között szabadon adhatsz meg értéket pl: 63%. Magasabb, mint 70% hidratációval lehet próbálkozni plusz hozzáadott vízzel konyhai robotképpel való dagasztásnál, ettől még puhább lesz a tészta, ezért nehezebb bucizni és nyújtani!\n"
				+ "Az előtésztának nagyon fontos szerepe van a pizza életében, mivel itt kezdődik el a glutén kiépítése, mert ettől lesz finom, feszes és tökéletes ízű a tészta. (ez is szerepet játszik abban, hogy pizza evés után nem fogunk puffadni)\n\n\n"
				+ "Gratulálok, megtetted az első mérföldkövet a tökéletes pizza elkészítésében!\nA továbbiaknak a lépéseket és tanácsokat olvashatsz saját tapasztalat alapján!\n\n\n"
				+ "1. lépés:\nA finom pizza készítéséhez kell egy előtészta, aminek a hozzávalóit megkapod a számítás után!\nFontos! A bal oldali hozzávalók az egész, a jobb oldaliak az előtésztához kellenek, a kézi/gépi dagasztásnál kell hozzáadni a maradék lisztet, ami a kettő különbsége! (Egész liszt 1000g, előtészta liszt 600g... tehát csak 400g-t kell hozzáadni dagasztásnál)\nÖntsük össze egy megfelelően nagy tálba, amit alaposan elkavarunk, majd teljesen lezárva berakjuk a hűtőbe 12-24 órára.\n\n"
				+ "2. lépés:\nAz előtészta pihentetése utáni napon ajnálatos konyhai robotgépet használni!\nFigyelem! - Egyszerre 4-5db bucinyi pizzát ajánlok a géppel készíteni, mert ettől több esetén nagyobb terhelés fogja érni az eszközt!\nPersze lehet kézzel is, de sokkal több időbe fog telni a tészta tökéletes megdolgozása.\n"
				+ "Az előtésztát mindig frissen és hidegen a hűtőből kell használni, a hideg miatt gyorsabban összeáll a tészta.\n"
				+ "Ha robotggéppel dolgozol, akkor önts a robotgép táljába a maradék lisztet, majd az előtésztát és az oliva olajat. Ezután legkisebb fokozaton indítsd el és figyelj oda, mert a liszt hajlamos ilyenkor elhagyni a tálat... Amikor nagyjából eldolgozódott, akkor kezdheted emelni a gép sebességét. Amikor egy gombóc kezd formálódni a karon és a tészta teljesen elválik a táltól, akkor fokozatosan hozzá lehet önteni a sót. A só hatására újra szétfolyhat, ekkor még magasabbra rakhatjuk a fokozatot és hagyjuk, hogy újra felszedjen minden tésztát a tálról és kialakuljon a tészta gombócunk. "
				+ "Akkor leszünk kész, hogyha leállítod a gépet és nem folyik tükörsimára a tészta 1 perc alatt sem.\n\n"
				+ "3.lépés:\nTakarítsuk le az asztalt vagy a konyhapultot, locsoljunk ki pici oliva olajat a pultra, illetve a kezünkre és szedjük ki az edényből a tésztát, fedjük le egy edénnyel és hagyjuk pihenni 15-20 percet! Ezután hajtogató műveletet fogunk alkalmazni 1 vagy lehet 2 alkalommal, amit Vito bácsi is csinál a videóban 10:20-tól. (Fent találod meg a videó linkjét, kattints rá!) \n"
				+ "Ennél figyelni kell, hogy a tésztának mindig a teteje legyen felfele és ha túl sokszor ismételjük, akkor az eddig kiépül kicsi glutén a tésztában el fog szakadni és szétnyílik! A feladatunk az, hogy ezeket elkerüljük.\n"
				+ "Amikor szép, feszes, sima lesz a tésztának a teteje és úgy néz ki, mint egy puha párna, akkor eljutottunk a 3. lépés végére. Ezután bekenjük vékonyan oliva olajjal, újra takarjuk le egy edénnyel és hagyjuk pihenni fél órát!\n\n"
				+ "4. lépés:\nEljött a bucizás ideje. Levesszük az edényt róla és kettévágjuk a tésztánkat éles késsel/műanyag spatulával! Ezután a tészta csík végét elkezdjük saját magába forgatni, ezzel egy gombócot formázva majd pedig levágjuk a végét és gondosan bezárjuk a kisebb gombócunk alját. Malati di Pizza videóját nézdd meg a műveletet! (Persze ezt méregetés közben, mivel a megadott méretűre kell csinálni a gombócokat, majd pedig a maradék tésztát szétosztjuk a bucik között.)"
				+ "Az elkészült gombócokat egy műanyag fedeles tárolóba vagy akár egy tepsibe is el lehet helyezni, amit légmentesen le kell zárni, hogy ne száradjon ki a tészta! Ha mégis kiszáradna, akkor egy sprével elég meglocsolni és kb fél óra alatt a régi lesz. Vito Iacopelli videójában látható ez bucizási művelet, érdemes több videóját megnézni további tanulás céljából"
				+ "\n\nItt kettéválnak a tészták, mivel ugyan így kell a nápolyit és a rómait előkészíteni.\n\n"
				+ "5. lépés - nápolyi:\nLehet kapni áruházakban és webshopokban pizzakövet, lehet használni kemencében és sütőben egyaránt. Első használat előtt érdemes üres járatban kiégetni, ami 3-4 órát vesz igénybe. A sütő melegítése előtt kell berakni a követ, berakjuk a pizzakövet a középső foglalatra, kapcsoljuk grill módba a sütőt és melegítsük 1,5 órán át, ezután rendes alul-felül sütési módben kell folytatni 250 fokon a sütést.\n"
				+ "A bucik akkor lesznek használhatóak, amikor durván kétszeresére nőnek meg. A nyújtási folyamat során az ujjainkat fogjuk használni, mert vigyázni kell a tészta szélében lévő levegőre, hogy szép buborékos legyen! Vito Iacopelli-nek van erről is videója. A lényege az, hogy lisztbe forgatjuk a bucit, majd az ujjbegyeinkkel elkezdjük a levegőt a tészta külseje felé nyomkodni, ezután egy határozott mozdulattal le kell zárni a tésztát a szélénél."
				+ "\nMinnél nagyobb hőfokra képes a sütőnk, annál könyebb dolgunk van a sütésnél, mivel 250foknál és alatta félig elő kell sütni a tésztát csak az alap szósszal! Utána kivesszük, felrakjuk a feltéteket, visszarakjuk a sütőbe, hogy barnuljon a széle és megolvadjon a sajt.\n"
				+ "Fontosak a megfelelően előkészített hozzávalók, ilyen pl a kukorica: egy szűrőbe a csap alatt ki kell önteni, picit meg kell fröcskölni vízzel majd hagyni, hogy lecsorogjon. Miért kell ez ? Mert a kukorica sütés közben rengeteg felszívot vizet kiereszt magából, így eláztatja a pizzát."
				+ "\n\nGratulálok, elkészült az első igazi autentikus nápolyi pizzád!\n\n"
				+ "5. lépés - római:\n"
				+ "Bucizást ennél a pizzánál nem kell csinálni, mivel egyszerre 1db pizzát lehet kigenerálni, így elég csak hajtogatni!\nMiután durván a kétszeresére kelt a tészta fogjuk meg a lemért tepsit, oliva olajjal kenjük ki és rakjuk bele a pizzát fejjel lefelé, hogy a tészta teteje legyen a tepsi alján, majd az ujjbegyeinkkel kezdjük el kinyújtani.\n"
				+ "Fontos, mert elsőre nem fogod tudni teljesen kinyújtani a tepsi méretére, ezért majd le kell fedned félúton légmentesen a tepsit és hagyni kell 12-15 percet pihenni. Ezalatt tovább kell és könyebben tudod nyújtani, majd újra le kell takarni és hagyni megint 15-30 percet kelni.\n\n"
				+ "6. lépés - római:\n"
				+ "Eljött a sütés ideje. A sütőben a középső foglalatba kell helyezni alul-felül sütési módban 200-220fokon. Érdemes elősütni a tésztát natúr, majd amikor látod, hogy jön fel és éppenhogy barnul ki kell venni, felrakni rá a szószt és a feltéteket, majd pedig visszarakni sütni. Figyelni és szagolgatni szükséges, mert hirtelen meg tud égni az alja."
				+ "\n\nGratulálok, elkészült az első igazi autentikus római pizzád!\n"
				+ "Elértünk az útmutató végére, remélem tisztábban látod a dolgokat, nagyon sokat segít Vito Iacopelli és Malati di Pizza videói, ezért nyomatékosan ajánlom megtekintésüket!");
		text_area.setStyle("-fx-font-size: 22;");
		segitseg_scroll.setStyle("-fx-background-color: #2a2f3b; -fx-control-inner-background: #2a2f3b; -fx-boder-color: #2a2f3b");
		segitseg_scroll.setContent(text_area);
		segitseg_scroll.setLayoutX(300);
		segitseg_scroll.setLayoutY(100);
		segitseg_scroll.setPrefSize(786, 520);
		segitseg_scroll.setContent(text_area);
		root.getChildren().add(segitseg_scroll);
		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
		rgb_line_first(previousLineColor);
	}

	// Kezdő oldalra váltás
	public void switchToScene4(MouseEvent event) throws IOException {
		Color previousLineColor = (Color) line.getStroke();
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		String css = this.getClass().getResource("application.css").toExternalForm();

		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
		rgb_line_first(previousLineColor);
	}

	// WD logo kattinthato
	public void clickableLogo(MouseEvent event) throws IOException {
		try {
			Desktop.getDesktop().browse(new URI("https://users.iit.uni-miskolc.hu/~buha/"));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	// Initialize
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Első elindulásnál lévő rgb_line
		line.setStrokeWidth(4);
		line.setRotate(90);
		line.setTranslateX(-725);

		Timeline colorTimeline = new Timeline();
		colorTimeline.setCycleCount(Timeline.INDEFINITE);

		KeyValue kv0 = new KeyValue(line.strokeProperty(), Color.ORANGE);
		KeyValue kv1 = new KeyValue(line.strokeProperty(), Color.RED);
		KeyValue kv2 = new KeyValue(line.strokeProperty(), Color.MAGENTA);
		KeyValue kv3 = new KeyValue(line.strokeProperty(), Color.PURPLE);
		KeyValue kv4 = new KeyValue(line.strokeProperty(), Color.AQUA);
		KeyValue kv5 = new KeyValue(line.strokeProperty(), Color.LIGHTSEAGREEN);
		KeyValue kv6 = new KeyValue(line.strokeProperty(), Color.GREEN);
		KeyValue kv7 = new KeyValue(line.strokeProperty(), Color.YELLOWGREEN);
		KeyValue kv8 = new KeyValue(line.strokeProperty(), Color.YELLOW);
		KeyValue kv9 = new KeyValue(line.strokeProperty(), Color.ORANGE);

		KeyFrame kf0 = new KeyFrame(Duration.ZERO, kv0);
		KeyFrame kf1 = new KeyFrame(Duration.seconds(0.7), kv1);
		KeyFrame kf2 = new KeyFrame(Duration.seconds(1.4), kv2);
		KeyFrame kf3 = new KeyFrame(Duration.seconds(2.1), kv3);
		KeyFrame kf4 = new KeyFrame(Duration.seconds(2.8), kv4);
		KeyFrame kf5 = new KeyFrame(Duration.seconds(3.5), kv5);
		KeyFrame kf6 = new KeyFrame(Duration.seconds(4.2), kv6);
		KeyFrame kf7 = new KeyFrame(Duration.seconds(4.9), kv7);
		KeyFrame kf8 = new KeyFrame(Duration.seconds(5.6), kv8);
		KeyFrame kf9 = new KeyFrame(Duration.seconds(6.3), kv9);

		colorTimeline.getKeyFrames().addAll(kf0, kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9);
		colorTimeline.play();
		root.getChildren().add(line);

		// Betű szín feherre allitas
		napolyi.setTextFill(Color.WHITE);
		romai.setTextFill(Color.WHITE);
		segitseg.setTextFill(Color.WHITE);
		fooldal.setTextFill(Color.WHITE);
		fooldal_szoveg1.setFill(Color.WHITE);
		fooldal_szoveg2.setFill(Color.WHITE);
		fooldal_szoveg3.setFill(Color.WHITE);
		vito.setTextFill(Color.WHITE);
		malati.setTextFill(Color.WHITE);

		// Hover események kezelése a labeleknel
		napolyi.setOnMouseEntered(event -> {
			animateTextColor(napolyi, Color.RED);
		});
		napolyi.setOnMouseExited(event -> {
			animateTextColor(napolyi, Color.WHITE);
		});
		romai.setOnMouseEntered(event -> {
			animateTextColor(romai, Color.RED);
		});
		romai.setOnMouseExited(event -> {
			animateTextColor(romai, Color.WHITE);
		});
		segitseg.setOnMouseEntered(event -> {
			animateTextColor(segitseg, Color.RED);
		});
		segitseg.setOnMouseExited(event -> {
			animateTextColor(segitseg, Color.WHITE);
		});
		fooldal.setOnMouseEntered(event -> {
			animateTextColor(fooldal, Color.RED);
		});
		fooldal.setOnMouseExited(event -> {
			animateTextColor(fooldal, Color.WHITE);
		});
		vito.setOnMouseEntered(event -> {
			animateTextColor(vito, Color.RED);
		});
		vito.setOnMouseExited(event -> {
			animateTextColor(vito, Color.WHITE);
		});
		vito.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try {
					Desktop.getDesktop().browse(new URI("https://youtu.be/4nZ3xXBmHEI?t=792"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});
		malati.setOnMouseEntered(event -> {
			animateTextColor(malati, Color.RED);
		});
		malati.setOnMouseExited(event -> {
			animateTextColor(malati, Color.WHITE);
		});
		malati.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try {
					Desktop.getDesktop().browse(new URI("https://youtu.be/hR9oNB-tQYA?t=150"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});

		// Jobb klikk a textfieldre és kitörli az adatot, majd alaphelyzetbe állíja
		weight.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
		weight.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			if (!weight.getText().isEmpty()) {
				setTextFieldBorderColor(false, "weight");
				weight.clear();
			}
			event.consume();
		});
		hydration.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
		hydration.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			if (!hydration.getText().isEmpty()) {
				setTextFieldBorderColor(false, "hydration");
				hydration.clear();
			}
			event.consume();
		});
		db.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
		db.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			if (!db.getText().isEmpty()) {
				setTextFieldBorderColor(false, "db");
				db.clear();
			}
			event.consume();
		});
		a_side.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
		a_side.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			if (!a_side.getText().isEmpty()) {
				setTextFieldBorderColorRomai(false, "a_side");
				a_side.clear();
			}
			event.consume();
		});
		b_side.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
		b_side.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			if (!b_side.getText().isEmpty()) {
				setTextFieldBorderColorRomai(false, "b_side");
				b_side.clear();
			}
			event.consume();
		});
		thickness.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
		thickness.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
			if (!thickness.getText().isEmpty()) {
				setTextFieldBorderColorRomai(false, "thickness");
				thickness.clear();
			}
			event.consume();
		});

		// Kép hozzáadása + kattinthatóság es weboldalam
		Image image = new Image("wd_logo.png", 200, 140, true, true);
		ImageView imageView = new ImageView(image);
		imageView.setCursor(Cursor.HAND);
		Rectangle2D viewportRect = new Rectangle2D(0, 0, 400, 300);
		imageView.setViewport(viewportRect);
		Group group = new Group(imageView);
		group.setLayoutY(525);
		group.setLayoutX(35);
		group.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try {
					Desktop.getDesktop().browse(new URI("https://users.iit.uni-miskolc.hu/~buha/"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});

		root.getChildren().add(group);

		// Mivel felül definialom css-ben a buttont, ezert itt ujra kell hivni, nelkule
		// zöld lenne és 2x kell kattintani, maybe egyszer kijavitom
		EscapeButton();

		// Mozgatjuk a panet, szerencsere az alert boxok megfeleloen működnek
		// + új implementáció, amikor kattintottam labelre, akkor mindig megrantotta a
		// window-t, mert dragnak erzekelte
		root.setOnMousePressed(event -> {
			pressTime = System.currentTimeMillis();
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
		});

		root.setOnMouseDragged(event -> {
			if (System.currentTimeMillis() - pressTime >= 100) {
				Stage stage = (Stage) root.getScene().getWindow();
				stage.setX(event.getScreenX() - xOffset);
				stage.setY(event.getScreenY() - yOffset);
				dragDetected = true;
			}
		});

	}

	// Escape button - X (407. SOR)
	public void EscapeButton() {
		ButtonX.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff;");
		ButtonX.setOnAction(e -> {
			Stage stage = (Stage) ButtonX.getScene().getWindow();
			stage.close();
		});
	}

	// Nápolyi számítas gomb
	public void CalculatingButton() {
		if (getTextFieldInputWeight() == 0 || getTextFieldInputHydration() == 0 || getTextFieldInputDB() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initStyle(StageStyle.TRANSPARENT);
			alert.setTitle("Hibás adatok!");
			alert.setHeaderText(" Sajnos rossz értékeket adtál meg!\t\t");
			alert.setContentText("Ha az érték helyes, akkor zöld lesz a mezője!");

			Stage primaryStage = (Stage) root.getScene().getWindow();
			alert.setX(primaryStage.getX() + primaryStage.getWidth() - alert.getDialogPane().getWidth() - 290);
			alert.setY(primaryStage.getY() + primaryStage.getHeight() - alert.getDialogPane().getHeight() - 510);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
					.add(new Image("PizzaCalculator_image.png"));

			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("myDialogs.css").toExternalForm());
			dialogPane.setStyle("-fx-border-color: #ff0000; -fx-border-width: 1.5;");
			dialogPane.getStyleClass().add("myDialog");

			Button okBtn = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
			okBtn.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #2a2f3b;");

			alert.showAndWait();
		} else {
			Ingredients ingredients = new Ingredients(getTextFieldInputWeight(), getTextFieldInputHydration(),
					getTextFieldInputDB());
			Poolish poolish = new Poolish(ingredients.flour(ingredients.getWeight(), ingredients.getHydration()),
					ingredients.water(ingredients.getWeight(), ingredients.getHydration()),
					ingredients.yeast(ingredients.getWeight()), ingredients.getDb());
			Neapolitan neapolitan = new Neapolitan(poolish.getFlour(), poolish.getWater(), poolish.getYeast(),
					ingredients.olive_oil(ingredients.getDb()),
					ingredients.salt(ingredients.getWeight(), ingredients.getHydration()), ingredients.getDb());

			Alert alert = new Alert(AlertType.INFORMATION);
			Stage primaryStage = (Stage) root.getScene().getWindow();
			alert.setX(primaryStage.getX() + primaryStage.getWidth() - alert.getDialogPane().getWidth() - 293);
			alert.setY(primaryStage.getY() + primaryStage.getHeight() - alert.getDialogPane().getHeight() - 610);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
					.add(new Image("PizzaCalculator_image.png"));

			alert.initStyle(StageStyle.TRANSPARENT);
			alert.setTitle("Kiszámítás kész");
			alert.setHeaderText(" Az értékek kiszámolásra kerültek!           ");
			alert.setContentText("Összes hozzávaló:      " + "     Ebből előtésztához:\n" + "Liszt: "
					+ (int) Math.round(neapolitan.getFlour()) + "g  \t\t        Liszt: "
					+ (int) Math.round(neapolitan.getWater()) + "g" + "\nVíz: "
					+ (int) Math.round(neapolitan.getWater()) + "ml  \t\t        Víz: "
					+ (int) Math.round(neapolitan.getWater()) + "ml" + "\nSó: " + (int) Math.round(neapolitan.getSalt())
					+ "g  \t\t\t        Élesztő: " + (int) Math.round(neapolitan.getYeast()) + "g\nÉlesztő: "
					+ (int) Math.round(neapolitan.getYeast()) + "g  \t\t        Kiskanálnyi méz" + "\nOliva olaj: "
					+ (int) Math.round(neapolitan.getOlive_oil()) + " löttyintés");

			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("myDialogs.css").toExternalForm());
			dialogPane.setStyle("-fx-border-color: #00ff7b; -fx-border-width: 1.5;");
			dialogPane.getStyleClass().add("myDialog");

			Button okBtn = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
			okBtn.setStyle("-fx-background-color: #00ff7b; -fx-text-fill: #2a2f3b;");

			alert.showAndWait();

		}
	}

	// Római szamítás gomb
	public void CalculatingButtonRomai() {
		if (getTextFieldInputASide() == 0 || getTextFieldInputBSide() == 0 || getTextFieldInputThickness() == 0
				|| getTextFieldInputHydration() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initStyle(StageStyle.TRANSPARENT);
			alert.setTitle("Hibás adatok!");
			alert.setHeaderText(" Sajnos rossz értékeket adtál meg!\t\t");
			alert.setContentText("Ha az érték helyes, akkor zöld lesz a mezője!");

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
					.add(new Image("PizzaCalculator_image.png"));

			Stage primaryStage = (Stage) root.getScene().getWindow();
			alert.setX(primaryStage.getX() + primaryStage.getWidth() - alert.getDialogPane().getWidth() - 290);
			alert.setY(primaryStage.getY() + primaryStage.getHeight() - alert.getDialogPane().getHeight() - 510);

			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("myDialogs.css").toExternalForm());
			dialogPane.setStyle("-fx-border-color: #ff0000; -fx-border-width: 1.5;");
			dialogPane.getStyleClass().add("myDialog");

			Button okBtn = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
			okBtn.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #2a2f3b;");

			alert.showAndWait();
		} else {
			Ingredients ingredients = new Ingredients(
					(getTextFieldInputASide() * getTextFieldInputBSide()) / getTextFieldInputThickness(),
					getTextFieldInputHydration(), 1);
			Poolish poolish = new Poolish(ingredients.flour(ingredients.getWeight(), ingredients.getHydration()),
					ingredients.water(ingredients.getWeight(), ingredients.getHydration()),
					ingredients.yeast(ingredients.getWeight()), ingredients.getDb());
			Sheet sheet = new Sheet(poolish.getFlour(), poolish.getWater(), poolish.getYeast(),
					ingredients.olive_oil(ingredients.getDb()),
					ingredients.salt(ingredients.getWeight(), ingredients.getHydration()));

			Alert alert = new Alert(AlertType.INFORMATION);
			Stage primaryStage = (Stage) root.getScene().getWindow();
			alert.setX(primaryStage.getX() + primaryStage.getWidth() - alert.getDialogPane().getWidth() - 293);
			alert.setY(primaryStage.getY() + primaryStage.getHeight() - alert.getDialogPane().getHeight() - 610);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
					.add(new Image("PizzaCalculator_image.png"));

			alert.initStyle(StageStyle.TRANSPARENT);
			alert.setTitle("Kiszámítás kész");
			alert.setHeaderText(" Az értékek kiszámolásra kerültek!            ");
			alert.setContentText("Összes hozzávaló:      " + "       Ebből előtésztához:\n" + "Liszt: "
					+ (int) Math.round(sheet.getFlour()) + "g  \t\t          Liszt: "
					+ (int) Math.round(sheet.getWater()) + "g" + "\nVíz: " + (int) Math.round(sheet.getWater())
					+ "ml  \t\t          Víz: " + (int) Math.round(sheet.getWater()) + "ml" + "\nSó: "
					+ (int) Math.round(sheet.getSalt()) + "g  \t\t\t          Élesztő: "
					+ (int) Math.round(sheet.getYeast()) + "g\nÉlesztő: " + (int) Math.round(sheet.getYeast())
					+ "g  \t\t          Kiskanálnyi méz" + "\nOliva olaj: " + (int) Math.round(sheet.getOlive_oil())
					+ " löttyintés");

			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("myDialogs.css").toExternalForm());
			dialogPane.setStyle("-fx-border-color: #00ff7b; -fx-border-width: 1.5;");
			dialogPane.getStyleClass().add("myDialog");

			Button okBtn = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
			okBtn.setStyle("-fx-background-color: #00ff7b; -fx-text-fill: #2a2f3b;");

			alert.showAndWait();

		}
	}

	// Hover animacio a labeleknek
	private void animateTextColor(Label label, Color targetColor) {
		Duration duration = Duration.seconds(0.2);
		Timeline timeline = new Timeline(
				new KeyFrame(Duration.ZERO, new KeyValue(label.textFillProperty(), label.getTextFill())),
				new KeyFrame(duration, new KeyValue(label.textFillProperty(), targetColor)));
		timeline.play();
	}

	// A nápolyi textfieldek színének állítása
	public void setTextFieldBorderColor(boolean valid, String name) {
		if (name.equalsIgnoreCase("weight")) {
			if (valid) {
				weight.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				weight.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		} else if (name.equalsIgnoreCase("hydration")) {
			if (valid) {
				hydration.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				hydration.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		} else {
			if (valid) {
				db.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				db.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		}
	}

	// A római textfieldek állítása
	public void setTextFieldBorderColorRomai(boolean valid, String name) {
		if (name.equalsIgnoreCase("a_side")) {
			if (valid) {
				a_side.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				a_side.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		} else if (name.equalsIgnoreCase("b_side")) {
			if (valid) {
				b_side.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				b_side.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		} else if (name.equalsIgnoreCase("thickness")) {
			if (valid) {
				thickness.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				thickness.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		} else {
			if (valid) {
				hydration.setStyle(
						"-fx-focus-color: #00ff7b; -fx-control-inner-background: #2a2f3b; -fx-border-color: #00ff7b; -fx-border-radius: 3;");
			} else {
				hydration.setStyle(
						"-fx-focus-color: #ff0000; -fx-control-inner-background: #2a2f3b; -fx-border-color: #ff0000; -fx-border-radius: 3;");
			}
		}
	}

	public int getTextFieldInputWeight() {
		if (!weight.getText().isEmpty()) {
			try {
				String input = weight.getText();
				int real_weight;
				if (input.length() == 3 && input.matches("\\d+")) {
					real_weight = Integer.parseInt(input);
					if (real_weight >= 280 && real_weight <= 450) {
						setTextFieldBorderColor(true, "weight");
						return (int) Math.round(real_weight);
					}
					setTextFieldBorderColor(false, "weight");
					return 0;
				} else {
					setTextFieldBorderColor(false, "weight");
					return 0;
				}
			} catch (NumberFormatException e) {
				setTextFieldBorderColor(false, "weight");
				return 0;
			}
		} else {
			setTextFieldBorderColor(false, "weight");
			return 0;
		}
	}

	public int getTextFieldInputHydration() {
		if (!hydration.getText().isEmpty()) {
			try {
				String input = hydration.getText();
				int hydration;
				if (input.length() == 2 && input.matches("\\d+")) {
					hydration = Integer.parseInt(input);
					if (hydration >= 60 && hydration <= 70) {
						setTextFieldBorderColorRomai(true, "hydration");
						setTextFieldBorderColor(true, "hydration");
						return hydration;
					}
					setTextFieldBorderColorRomai(false, "hydration");
					setTextFieldBorderColor(false, "hydration");
					return 0;
				} else {
					setTextFieldBorderColorRomai(false, "hydration");
					setTextFieldBorderColor(false, "hydration");
					return 0;
				}
			} catch (NumberFormatException e) {
				setTextFieldBorderColorRomai(false, "hydration");
				setTextFieldBorderColor(false, "hydration");
				return 0;
			}
		} else {
			setTextFieldBorderColorRomai(false, "hydration");
			setTextFieldBorderColor(false, "hydration");
			return 0;
		}
	}

	public int getTextFieldInputDB() {
		if (!db.getText().isEmpty()) {
			try {
				String input = db.getText();
				int db;
				if ((input.length() == 1 || input.length() == 2 || input.length() == 3) && input.matches("\\d+")) {
					db = Integer.parseInt(input);
					if (db > 0) {
						setTextFieldBorderColor(true, "db");
						return db;
					}
					setTextFieldBorderColor(false, "db");
					return 0;
				} else {
					setTextFieldBorderColor(false, "db");
					return 0;
				}
			} catch (NumberFormatException e) {
				setTextFieldBorderColor(false, "db");
				return 0;
			}
		} else {
			setTextFieldBorderColor(false, "db");
			return 0;
		}
	}

	public int getTextFieldInputASide() {
		if (!a_side.getText().isEmpty()) {
			try {
				String input = a_side.getText();
				int a_side;
				if ((input.length() == 1 || input.length() == 2 || input.length() == 3) && input.matches("\\d+")) {
					a_side = Integer.parseInt(input);
					if (a_side > 0) {
						setTextFieldBorderColorRomai(true, "a_side");
						return a_side;
					}
					setTextFieldBorderColorRomai(false, "a_side");
					return 0;
				} else {
					setTextFieldBorderColorRomai(false, "a_side");
					return 0;
				}
			} catch (NumberFormatException e) {
				setTextFieldBorderColorRomai(false, "a_side");
				return 0;
			}
		} else {
			setTextFieldBorderColorRomai(false, "a_side");
			return 0;
		}
	}

	public int getTextFieldInputBSide() {
		if (!b_side.getText().isEmpty()) {
			try {
				String input = b_side.getText();
				int b_side;
				if ((input.length() == 1 || input.length() == 2) && input.matches("\\d+")) {
					b_side = Integer.parseInt(input);
					if (b_side > 0) {
						setTextFieldBorderColorRomai(true, "b_side");
						return b_side;
					}
					setTextFieldBorderColorRomai(false, "b_side");
					return 0;
				} else {
					setTextFieldBorderColorRomai(false, "b_side");
					return 0;
				}
			} catch (NumberFormatException e) {
				setTextFieldBorderColorRomai(false, "b_side");
				return 0;
			}
		} else {
			setTextFieldBorderColorRomai(false, "b_side");
			return 0;
		}
	}

	public double getTextFieldInputThickness() {
		if (!thickness.getText().isEmpty()) {
			try {
				String input = thickness.getText();
				double thickness = 0;
				thickness = Integer.parseInt(input);
				if ((input.length() == 3) && input.matches("\\d+") && (thickness >= 150 && thickness <= 250)) {
					thickness = thickness / 100;
					if (thickness > 0) {
						setTextFieldBorderColorRomai(true, "thickness");
						return thickness;
					}
					setTextFieldBorderColorRomai(false, "thickness");
					return 0;
				} else {
					setTextFieldBorderColorRomai(false, "thickness");
					return 0;
				}
			} catch (NumberFormatException e) {
				setTextFieldBorderColorRomai(false, "thickness");
				return 0;
			}
		} else {
			setTextFieldBorderColorRomai(false, "thickness");
			return 0;
		}
	}
}
