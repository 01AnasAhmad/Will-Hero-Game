package WillHero;
//you were changing font outline of text in textfield
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class GameController implements Initializable {

    //System.out.println(locList[count[0]].isHas_platform()); // to get the has platform ...

    Group g = new Group(); // Global
    Image hero = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\hero.jpg");
    ImageView heroImg = new ImageView(hero);
    final int[] count = {1};
    Group g1 = new Group();
    Location[] locList = new Location[123];
    Line line = new Line();
    boolean flagfall=true;
    @FXML
    private Line fallline;

    @FXML
    private Line rescrnline;

    @FXML
    private AnchorPane gameScreenFixed1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Text t = new Text("Location: "+1);
        t.setX(50);
        t.setY(50);
        t.setFont(Font.font ("Arial", FontWeight.BLACK,32));
        t.getStyleClass().add("outline");
        t.setStroke(Color.BLACK);
        t.setStrokeWidth(1.0);
        t.setFill(Color.WHITE);
        g1.getChildren().add(t);

        Button button = new Button("Move Forward");
        button.setLayoutX(385);
        button.setLayoutY(400);
        button.setBorder(new Border(new BorderStroke(Color.LIGHTPINK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,new BorderWidths(4))));



        int [] hasPlatform = new int[123];

        Location heroloc = new Location(0,true);

        Hero willhero = new Hero(heroloc,heroImg);

        Helmet helmet = new Helmet();

        int flag = 0 ; //
        int flagCoin = 0;
        int flagChest = 0;
        int flagChest2 = 0;
        int flagweapon = 0;

        button.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TranslateTransition tt = new TranslateTransition();
                tt.setNode(g);
                tt.setDuration(Duration.millis(250));
                tt.setByX(-200);
                tt.setRate(5);
                count[0]++;
                willhero.setLocation1(locList[count[0]]);
                tt.play();
                //System.out.println(count[0]+" "+(60+heroImg.getTranslateY()));//+" "+heroImg.yProperty());
                t.setText("Location: "+(count[0]));
                //System.out.println(finalFlag); //
                //System.out.println(willhero.getLocation1().getNumber());
//                if(locList[count[0]].isHas_chest()){
//                    System.out.println(1);
//                }
//                willhero.getHelmet().setKnife(knife);
////              willhero.setWeapon_flag(2);
                if(locList[count[0]].isHas_platform()){
                    System.out.println(1);
                }


            }
        });

        // Only for HERO
        g1.getChildren().add(button);
        //Hero image added
        heroImg.setFitHeight(25);
        heroImg.setFitWidth(25);
        heroImg.setX(300);
        heroImg.setY(225);
        heroImg.setPreserveRatio(true);
        heroImg.setSmooth(true);
        heroImg.setCache(true);


        willhero.setHelmet(helmet);
        //willhero.setWeapon_flag(1);
       // if(willhero.getWeapon_flag()==0){//No weapon
            //Hero Translation on Y axis . . .
            TranslateTransition translateTransition = new TranslateTransition();
            translateTransition.setNode(heroImg);
            translateTransition.setAutoReverse(true);
            translateTransition.setDuration(Duration.millis(1500));
            translateTransition.setByY(-60);
            translateTransition.setRate(3);
            translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
            translateTransition.play();
            heroImg.translateYProperty().addListener((obs, old, newValue) -> {
                if(flagfall && !locList[count[0]].isHas_platform() && heroImg.getBoundsInParent().intersects(fallline.getBoundsInParent())){
                    flagfall=false;
                    translateTransition.stop();


                    TranslateTransition fall=new TranslateTransition();
                    fall.setNode(heroImg);
                    fall.setDuration(Duration.millis(800));
                    fall.setByY(250);
                    fall.setCycleCount(1);
                    fall.play();
                    System.out.println("you lost");
                    if(heroImg.getBoundsInParent().intersects(rescrnline.getBoundsInParent())){

                            Stage stage=new Stage();
                            Parent p1 = null;
                            try {
                                System.out.println("h");
                                p1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("page2.fxml")));
                                System.out.println("3");
                            } catch (IOException e) {
                                e.printStackTrace();
                                System.out.println("r");
                            }
                            //((Node) e.getSource()).getScene().getWindow();
                            assert p1 != null;
                            System.out.println("e");
                            stage.setScene(new Scene(p1,900,490));
                            stage.show();

                    }
                    //yahan pe likh
                    //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rough.fxml")));
                    //Parent exitpage = FXMLLoader.load(getClass().getResource("rough.fxml"));

//                    if(heroImg.getTranslateY()<-50){
//                        Stage stage=new Stage();
//                        Parent p1 = null;
//                        try {
//                            System.out.println("h");
//                            p1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("page2.fxml")));
//                            System.out.println("3");
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                            System.out.println("r");
//                        }
//                        //((Node) e.getSource()).getScene().getWindow();
//                        assert p1 != null;
//                        System.out.println("e");
//                        stage.setScene(new Scene(p1,900,490));
//                        stage.show();
//                    }
                }
            });
            g1.getChildren().add(heroImg);
      //  }
      //  else if(willhero.getWeapon_flag()==1){ // Has weapon . . .
            //Hero Translation on Y axis hero. . .
//            TranslateTransition translateTransition = new TranslateTransition();
//            translateTransition.setNode(heroImg);
//            translateTransition.setAutoReverse(true);
//            translateTransition.setDuration(Duration.millis(1500));
//            translateTransition.setByY(-60);
//            translateTransition.setRate(3);
//            translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
//            translateTransition.play();
//            g1.getChildren().add(heroImg);
//
//            ImageView swordImg = willhero.getHelmet().getSword().getImg();
//            swordImg.setFitHeight(10);
//            swordImg.setFitWidth(25);
//            swordImg.setX(320);
//            swordImg.setY(200);
//            swordImg.setPreserveRatio(true);
//            swordImg.setSmooth(true);
//            swordImg.setCache(true);
//            TranslateTransition translateSword = new TranslateTransition();
//            translateSword.setNode(swordImg);
//            translateSword.setAutoReverse(true);
//            translateSword.setDuration(Duration.millis(1500));
//            translateSword.setByY(-60);
//            translateSword.setRate(3);
//            translateSword.setCycleCount(TranslateTransition.INDEFINITE);
//            translateSword.play();
//            g1.getChildren().add(swordImg);
//        }
//        else{
//            //Hero Translation on Y axis . . .
//            TranslateTransition translateTransition = new TranslateTransition();
//            translateTransition.setNode(heroImg);
//            translateTransition.setAutoReverse(true);
//            translateTransition.setDuration(Duration.millis(1500));
//            translateTransition.setByY(-60);
//            translateTransition.setRate(3);
//            translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
//            translateTransition.play();
//            g1.getChildren().add(heroImg);
//
//            ImageView knifeImg = willhero.getHelmet().getKnife().getImg();
//            knifeImg.setFitHeight(5);
//            knifeImg.setFitWidth(25);
//            knifeImg.setX(320);
//            knifeImg.setY(200);
//            knifeImg.setPreserveRatio(true);
//            knifeImg.setSmooth(true);
//            knifeImg.setCache(true);
//            TranslateTransition translateSword = new TranslateTransition();
//            translateSword.setNode(knifeImg);
//            translateSword.setAutoReverse(true);
//            translateSword.setDuration(Duration.millis(1500));
//            translateSword.setByY(-60);
//            translateSword.setRate(3);
//            translateSword.setCycleCount(TranslateTransition.INDEFINITE);
//            translateSword.play();
//            g1.getChildren().add(knifeImg);
//        }

        // Normal with island1 image Platforms
        for (int i = 0; i < 81;) {   // Creating Islands...
            Image island = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg = new ImageView(island);
            islandImg.setFitHeight(100);
            islandImg.setFitWidth(200);
            islandImg.setX((i+1) * 200);
            islandImg.setY(250);
            islandImg.setPreserveRatio(true);
            islandImg.setSmooth(true);
            islandImg.setCache(true);
            g.getChildren().add(islandImg);

            Location islandloc = new Location(i+1,true);
            locList[i+1] = islandloc;
            hasPlatform[i+1] = 1;
            if(flag==1){
                Image orc = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\greenorc.jpg");
                ImageView orcImg1 = new ImageView(orc);
                orcImg1.setFitHeight(25);
                orcImg1.setFitWidth(25);
                orcImg1.setX((i+1) * 200 + 100);
                orcImg1.setY(225);
                orcImg1.setPreserveRatio(true);
                orcImg1.setSmooth(true);
                orcImg1.setCache(true);
                TranslateTransition translateOrc = new TranslateTransition();
                translateOrc.setNode(orcImg1);
                translateOrc.setAutoReverse(true);
                translateOrc.setDuration(Duration.millis(1500));
                translateOrc.setByY(-60);
                translateOrc.setRate(3);
                translateOrc.setCycleCount(TranslateTransition.INDEFINITE);
                translateOrc.play();
                g.getChildren().add(orcImg1);

                Green_Orc greenOrc = new Green_Orc(locList[i+1],orcImg1);
                locList[i+1].setHas_orc(true);
                locList[i+1].setOrc(greenOrc);

            }
            i++;
            Image island1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg1 = new ImageView(island1);
            islandImg1.setFitHeight(100);
            islandImg1.setFitWidth(200);
            islandImg1.setX((i+1) * 200);
            islandImg1.setY(250);
            islandImg1.setPreserveRatio(true);
            islandImg1.setSmooth(true);
            islandImg1.setCache(true);
            g.getChildren().add(islandImg1);
            hasPlatform[i+1] = 1;
            Location islandloc1 = new Location(i+1,true);
            locList[i+1] = islandloc1;
            if(flag==0){
                Image orc = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\RedOrc.jpg");
                ImageView orcImg1 = new ImageView(orc);
                orcImg1.setFitHeight(25);
                orcImg1.setFitWidth(25);
                orcImg1.setX((i+1) * 200 + 100);
                orcImg1.setY(225);
                orcImg1.setPreserveRatio(true);
                orcImg1.setSmooth(true);
                orcImg1.setCache(true);
                TranslateTransition translateOrc = new TranslateTransition();
                translateOrc.setNode(orcImg1);
                translateOrc.setAutoReverse(true);
                translateOrc.setDuration(Duration.millis(1500));
                translateOrc.setByY(-60);
                translateOrc.setRate(3);
                translateOrc.setCycleCount(TranslateTransition.INDEFINITE);
                translateOrc.play();
                g.getChildren().add(orcImg1);

                Red_Orc red_orc = new Red_Orc(locList[i+1],orcImg1);
                locList[i+1].setHas_orc(true);
                locList[i+1].setOrc(red_orc);
            }
            if(flagCoin==1){
                Image coin = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
                Image coin1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
                Image coin2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
                ImageView coinImg = new ImageView(coin);
                coinImg.setFitHeight(15);
                coinImg.setFitWidth(15);
                coinImg.setX((i+1)*200+100);
                coinImg.setY(226);
                ImageView coinImg1 = new ImageView(coin1);
                coinImg1.setFitHeight(15);
                coinImg1.setFitWidth(15);
                coinImg1.setX((i+1)*200+100);
                coinImg1.setY(200);
                ImageView coinImg2 = new ImageView(coin2);
                coinImg2.setFitHeight(15);
                coinImg2.setFitWidth(15);
                coinImg2.setX((i+1)*200+100);
                coinImg2.setY(175);
                g.getChildren().add(coinImg);
                g.getChildren().add(coinImg1);
                g.getChildren().add(coinImg2);
            }
            // Tree1
            Image tree2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\tree1.jpg");
            ImageView Imgtree2 = new ImageView(tree2);
            Imgtree2.setFitWidth(30);
            Imgtree2.setFitHeight(50);
            Imgtree2.setX((i+1) * 200);
            Imgtree2.setY(210);
            Imgtree2.setPreserveRatio(true);
            Imgtree2.setSmooth(true);
            Imgtree2.setCache(true);
            g.getChildren().add(Imgtree2);

            i++;
            Location islandloc2 = new Location(i+1,false);
            locList[i+1] = islandloc2;
            i++;
            Image island2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg2 = new ImageView(island2);
            islandImg2.setFitHeight(100);
            islandImg2.setFitWidth(200);
            islandImg2.setX((i+1) * 200);
            islandImg2.setY(250);
            islandImg2.setPreserveRatio(true);
            islandImg2.setSmooth(true);
            islandImg2.setCache(true);
            g.getChildren().add(islandImg2);
            hasPlatform[i+1] = 1;
            Location islandloc3 = new Location(i+1,true);
            locList[i+1] = islandloc3;
            //Tree2
            Image tree3 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\tree2.jpg");
            ImageView Imgtree3 = new ImageView(tree3);
            Imgtree3.setFitWidth(30);
            Imgtree3.setFitHeight(50);
            Imgtree3.setX((i+1) * 200);
            Imgtree3.setY(205);
            Imgtree3.setPreserveRatio(true);
            Imgtree3.setSmooth(true);
            Imgtree3.setCache(true);
            g.getChildren().add(Imgtree3);
            //Chest

            if(flagChest==2){
                Image chest1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\ChestClosed.jpg");
                ImageView Imgchest1 = new ImageView(chest1);
                Imgchest1.setFitWidth(40);
                Imgchest1.setFitHeight(50);
                Imgchest1.setX((i+1) * 200 + 100);
                Imgchest1.setY(220);
                Imgchest1.setPreserveRatio(true);
                Imgchest1.setSmooth(true);
                Imgchest1.setCache(true);
                g.getChildren().add(Imgchest1);
                if(flagChest2==0){

                    Coin_Chest coin_chest = new Coin_Chest(locList[i+1],Imgchest1);
                    locList[i+1].setHas_chest(true);
                    locList[i+1].setChest(coin_chest);
                    flagChest2 = 1;
                }
                else{
                    if(flagweapon==0){
                        Sword sword = new Sword();
                        Weapon_Chest wc = new Weapon_Chest(locList[i+1],Imgchest1,sword);
                        locList[i+1].setHas_chest(true);
                        locList[i+1].setChest(wc);
                        flagweapon=1;
//                        willhero.getHelmet().setSword(sword);
//                        willhero.setWeapon_flag(1);
                    }
                    else{
                        ThrowingKnife knife = new ThrowingKnife();
                        Weapon_Chest wc = new Weapon_Chest(locList[i+1],Imgchest1,knife);
                        locList[i+1].setHas_chest(true);
                        locList[i+1].setChest(wc);
                        flagweapon=0;
//                        willhero.getHelmet().setKnife(knife);
//                        willhero.setWeapon_flag(2);
                    }
                    flagChest2 = 0;
                }
            }

            i++;
            Location islandloc4 = new Location(i+1,false);
            locList[i+1] = islandloc4;
            i++;
            Image island3 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg3 = new ImageView(island3);
            islandImg3.setFitHeight(100);
            islandImg3.setFitWidth(200);
            islandImg3.setX((i+1) * 200);
            islandImg3.setY(250);
            islandImg3.setPreserveRatio(true);
            islandImg3.setSmooth(true);
            islandImg3.setCache(true);
            g.getChildren().add(islandImg3);
            Location islandloc5 = new Location(i+1,true);
            locList[i+1] = islandloc5;
            hasPlatform[i+1] = 1;
            //Tree1
            Image tree1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\tree1.jpg");
            ImageView Imgtree1 = new ImageView(tree1);
            Imgtree1.setFitWidth(30);
            Imgtree1.setFitHeight(50);
            Imgtree1.setX((i+1) * 200);
            Imgtree1.setY(210);
            Imgtree1.setPreserveRatio(true);
            Imgtree1.setSmooth(true);
            Imgtree1.setCache(true);
            g.getChildren().add(Imgtree1);
            i++;
            Image island4 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg4 = new ImageView(island4);
            islandImg4.setFitHeight(100);
            islandImg4.setFitWidth(200);
            islandImg4.setX((i+1) * 200);
            islandImg4.setY(250);
            islandImg4.setPreserveRatio(true);
            islandImg4.setSmooth(true);
            islandImg4.setCache(true);
            g.getChildren().add(islandImg4);

            hasPlatform[i+1] = 1;
            Image tree4 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\tree2.jpg");
            ImageView Imgtree4 = new ImageView(tree4);
            Imgtree4.setFitWidth(30);
            Imgtree4.setFitHeight(50);
            Imgtree4.setX((i+1) * 200);
            Imgtree4.setY(205);
            Imgtree4.setPreserveRatio(true);
            Imgtree4.setSmooth(true);
            Imgtree4.setCache(true);
            g.getChildren().add(Imgtree4);
            Location islandloc6 = new Location(i+1,true);
            locList[i+1] = islandloc6;
            if(flag==1){
                Image orc = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\RedOrc.jpg");
                ImageView orcImg1 = new ImageView(orc);
                orcImg1.setFitHeight(25);
                orcImg1.setFitWidth(25);
                orcImg1.setX((i+1) * 200 + 100);
                orcImg1.setY(225);
                orcImg1.setPreserveRatio(true);
                orcImg1.setSmooth(true);
                orcImg1.setCache(true);
                TranslateTransition translateOrc = new TranslateTransition();
                translateOrc.setNode(orcImg1);
                translateOrc.setAutoReverse(true);
                translateOrc.setDuration(Duration.millis(1500));
                translateOrc.setByY(-60);
                translateOrc.setRate(3);
                translateOrc.setCycleCount(TranslateTransition.INDEFINITE);
                translateOrc.play();
                g.getChildren().add(orcImg1);
                ///From here
                Red_Orc red_orc = new Red_Orc(locList[i+1],orcImg1);
                locList[i+1].setHas_orc(true);
                locList[i+1].setOrc(red_orc);
            }
            if(flagCoin==0){
                Image coin = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
                Image coin1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
                Image coin2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
                ImageView coinImg = new ImageView(coin);
                coinImg.setFitHeight(15);
                coinImg.setFitWidth(15);
                coinImg.setX((i+1)*200+100);
                coinImg.setY(226);
                ImageView coinImg1 = new ImageView(coin1);
                coinImg1.setFitHeight(15);
                coinImg1.setFitWidth(15);
                coinImg1.setX((i+1)*200+100);
                coinImg1.setY(200);
                ImageView coinImg2 = new ImageView(coin2);
                coinImg2.setFitHeight(15);
                coinImg2.setFitWidth(15);
                coinImg2.setX((i+1)*200+100);
                coinImg2.setY(175);
                g.getChildren().add(coinImg);
                g.getChildren().add(coinImg1);
                g.getChildren().add(coinImg2);
            }

            i++;
            Image island5 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg5 = new ImageView(island5);
            islandImg5.setFitHeight(100);
            islandImg5.setFitWidth(200);
            islandImg5.setX((i+1) * 200);
            islandImg5.setY(250);
            islandImg5.setPreserveRatio(true);
            islandImg5.setSmooth(true);
            islandImg5.setCache(true);
            g.getChildren().add(islandImg5);
            hasPlatform[i+1] = 1;
            Location islandloc7 = new Location(i+1,true);
            locList[i+1] = islandloc7;
            if(flag==0){
                Image orc = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\greenorc.jpg");
                ImageView orcImg1 = new ImageView(orc);
                orcImg1.setFitHeight(25);
                orcImg1.setFitWidth(25);
                orcImg1.setX((i+1) * 200 + 100);
                orcImg1.setY(225);
                orcImg1.setPreserveRatio(true);
                orcImg1.setSmooth(true);
                orcImg1.setCache(true);
                TranslateTransition translateOrc = new TranslateTransition();
                translateOrc.setNode(orcImg1);
                translateOrc.setAutoReverse(true);
                translateOrc.setDuration(Duration.millis(1500));
                translateOrc.setByY(-60);
                translateOrc.setRate(3);
                translateOrc.setCycleCount(TranslateTransition.INDEFINITE);
                translateOrc.play();
                g.getChildren().add(orcImg1);

                Green_Orc greenOrc = new Green_Orc(locList[i+1],orcImg1);
                locList[i+1].setHas_orc(true);
                locList[i+1].setOrc(greenOrc);
            }
            if(flagCoin==1){
                Image coin = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
                Image coin1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
                Image coin2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
                ImageView coinImg = new ImageView(coin);
                coinImg.setFitHeight(15);
                coinImg.setFitWidth(15);
                coinImg.setX((i+1)*200+100);
                coinImg.setY(226);
                ImageView coinImg1 = new ImageView(coin1);
                coinImg1.setFitHeight(15);
                coinImg1.setFitWidth(15);
                coinImg1.setX((i+1)*200+100);
                coinImg1.setY(200);
                ImageView coinImg2 = new ImageView(coin2);
                coinImg2.setFitHeight(15);
                coinImg2.setFitWidth(15);
                coinImg2.setX((i+1)*200+100);
                coinImg2.setY(175);
                g.getChildren().add(coinImg);
                g.getChildren().add(coinImg1);
                g.getChildren().add(coinImg2);
            }
            i++;
            Location islandloc8 = new Location(i+1,false);
            locList[i+1] = islandloc8;
            i++;
            if(flag==0){
                flag=1;
            }
            else{
                flag=0;
            }
            flagCoin=(flagCoin+1)%2;
            flagChest=(flagChest+1)%3;
        }
        for(int i=81;i<88;){//Add falling platforms also!!!!!!!!! and coin chest 3 more
            Image coin2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
            ImageView coinImg2 = new ImageView(coin2);
            coinImg2.setFitHeight(15);
            coinImg2.setFitWidth(15);
            coinImg2.setX((i+1)*200+100);
            coinImg2.setY(175);
            g.getChildren().add(coinImg2);//Add falling platform...

            Location islandloc = new Location(i+1,true);
            locList[i+1] = islandloc;
            i++;
        }
        for(int i=88;i<99;){//Add 2 more chests
            Image island = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg = new ImageView(island);
            islandImg.setFitHeight(100);
            islandImg.setFitWidth(200);
            islandImg.setX((i+1) * 200);
            islandImg.setY(250);
            islandImg.setPreserveRatio(true);
            islandImg.setSmooth(true);
            islandImg.setCache(true);
            g.getChildren().add(islandImg);
            hasPlatform[i+1] = 1;
            if(i==90){
                Image chest = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\ChestClosed.jpg");
                ImageView Imgchest = new ImageView(chest);
                Imgchest.setFitWidth(40);
                Imgchest.setFitHeight(50);
                Imgchest.setX((i+1) * 200 + 100);
                Imgchest.setY(220);
                Imgchest.setPreserveRatio(true);
                Imgchest.setSmooth(true);
                Imgchest.setCache(true);
                g.getChildren().add(Imgchest);
            }
            if(i==95){
                Image chest = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\ChestClosed.jpg");
                ImageView Imgchest = new ImageView(chest);
                Imgchest.setFitWidth(40);
                Imgchest.setFitHeight(50);
                Imgchest.setX((i+1) * 200 + 100);
                Imgchest.setY(220);
                Imgchest.setPreserveRatio(true);
                Imgchest.setSmooth(true);
                Imgchest.setCache(true);
                g.getChildren().add(Imgchest);
            }
            //Confirm it here (i+1) ??
            Location islandloc = new Location(i+1,true);
            locList[i+1] = islandloc;
            hasPlatform[i+1] = 1;
            i++;
        }
        for(int i = 99;i<107;){//Falling platform to be added between this range . . .
            Image coin2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
            ImageView coinImg2 = new ImageView(coin2);
            coinImg2.setFitHeight(15);
            coinImg2.setFitWidth(15);
            coinImg2.setX((i+1)*200+100);
            coinImg2.setY(175);
            g.getChildren().add(coinImg2);
            Location islandloc = new Location(i+1,true);
            locList[i+1] = islandloc;
            i++;
        }

        for(int j=107;j<113;){ // Normal with different image Platforms(island2)
            Image island = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands2.jpg");
            ImageView islandImg = new ImageView(island);
            islandImg.setFitHeight(100);
            islandImg.setFitWidth(200);
            islandImg.setX((j+1) * 200);
            islandImg.setY(250);
            islandImg.setPreserveRatio(true);
            islandImg.setSmooth(true);
            islandImg.setCache(true);
            g.getChildren().add(islandImg);
            Image tree2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\tree1.jpg");
            ImageView Imgtree2 = new ImageView(tree2);
            Imgtree2.setFitWidth(30);
            Imgtree2.setFitHeight(50);
            Imgtree2.setX((j+1) * 200);
            Imgtree2.setY(210);
            Imgtree2.setPreserveRatio(true);
            Imgtree2.setSmooth(true);
            Imgtree2.setCache(true);
            g.getChildren().add(Imgtree2);
            hasPlatform[j+1] = 1;
            Location islandloc = new Location(j+1,true);
            locList[j+1] = islandloc;
            j++;
        }
        for(int k=113;k<122;){ // PLayer has won and meeting the love of her life...
            Image island = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands2.jpg");
            ImageView islandImg = new ImageView(island);
            islandImg.setFitHeight(100);
            islandImg.setFitWidth(200);
            islandImg.setX((k+1) * 200); //
            islandImg.setY(250);
            islandImg.setPreserveRatio(true);
            islandImg.setSmooth(true);
            islandImg.setCache(true);
            g.getChildren().add(islandImg);
            hasPlatform[k+1] = 1;
            Location islandloc = new Location(k+1,true);
            locList[k+1] = islandloc;
            k++;
        }

        //Placing the Boss Orc . . .
        Image orc = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\bossOrc.jpg");
        ImageView orcImg1 = new ImageView(orc);
        orcImg1.setFitHeight(75);
        orcImg1.setFitWidth(75);
        orcImg1.setX(22500);//Notice
        orcImg1.setY(175);
        orcImg1.setPreserveRatio(true);
        orcImg1.setSmooth(true);
        orcImg1.setCache(true);
        TranslateTransition translateOrc = new TranslateTransition();
        translateOrc.setNode(orcImg1);
        translateOrc.setAutoReverse(true);
        translateOrc.setDuration(Duration.millis(1500));
        translateOrc.setByY(-80);
        translateOrc.setRate(3);
        translateOrc.setCycleCount(TranslateTransition.INDEFINITE);
        translateOrc.play();
        g.getChildren().add(orcImg1);
        Boss_Orc bossOrc = new Boss_Orc(locList[112],orcImg1); //hardcoded value
        locList[112].setHas_orc(true);
        locList[112].setOrc(bossOrc);

        //Placing the Queen . . .
        Image queen = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\queen.jpg");
        ImageView queenImg = new ImageView(queen);
        queenImg.setFitHeight(25);
        queenImg.setFitWidth(25);
        queenImg.setX(24300);//Notice
        queenImg.setY(225);
        queenImg.setPreserveRatio(true);
        queenImg.setSmooth(true);
        queenImg.setCache(true);
        g.getChildren().add(queenImg);

        // add one chest on falling platform

        //Clouds ... Of no use...
        int i = 1;
        while(i<122){
            Image island = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\cloud.jpeg");
            ImageView CloudImg = new ImageView(island);
            CloudImg.setFitHeight(100);
            CloudImg.setFitWidth(200);
            CloudImg.setSmooth(true);
            CloudImg.setCache(true);
            CloudImg.setX((i) * 100);
            CloudImg.setY(50);
            g.getChildren().add(CloudImg);
            i+=2;
            Image island1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\cloud.jpeg");
            ImageView CloudImg1 = new ImageView(island1);
            CloudImg1.setFitHeight(100);
            CloudImg1.setFitWidth(200);
            CloudImg1.setSmooth(true);
            CloudImg1.setCache(true);
            CloudImg.setX((i) * 100);
            CloudImg.setY(40);
            i+=3;
        }
        //Image fallPlat0 = new Image("C:\\Users\\ishaan\IdeaProjects\\Group_20\\src\\GameAssets\\fallPlat.jpg");
        gameScreenFixed1.getChildren().add(g);
        gameScreenFixed1.getChildren().add(g1);
    }
}
