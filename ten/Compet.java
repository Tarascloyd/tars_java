import java.util.*;

public class Compet {
 private int pokrt;
 Player play1;
 Player play2;
 private int p1;
 private int p2; 
 public Compet(int pokrt, Player play1, Player play2){
   this.pokrt=pokrt;
   this.play1=play1;
   this.play2=play2;
   System.out.println(play1.getName()+" vs "+play2.getName());
 }
 
 public static float Probability(float rating1, float rating2) { 
  return 1.0f * 1.0f / (1 + 1.0f * (float)(Math.pow(10, 1.0f * (rating1 - rating2) / 400))); 
 } 

 public Player start() {
  match();
  
  float rat1 = play1.getEloRating();
  float rat2 = play2.getEloRating();
  if (this.p1>this.p2) { 
    float prob = Probability(rat1,rat2);
    play1.setTotalw();
    play2.setTotall();
    play1.setEloRating(prob*40);
    play2.setEloRating(prob*-40);
    System.out.println(play1.getName()+" is winner. R:" + Math.round(play1.getEloRating()) + "| " + Math.round(prob*40));
    return this.play1;
  } else {
    float prob = Probability(rat2,rat1);
    play2.setTotalw();
    play1.setTotall();
    play2.setEloRating(prob*40);
    play1.setEloRating(prob*-40);
    System.out.println(play2.getName()+" is winner. R:" + Math.round(play2.getEloRating()) + "| " + Math.round(prob*40));
    return this.play2;
  }
 }

 private void match() {
  int lvl1=play1.getLevel(this.pokrt);
  int lvl2=play2.getLevel(this.pokrt);
  double ver;
  String score="(";
  if (lvl1>lvl2) {
    ver=100-Math.round((0.5-(lvl1-lvl2)*0.005-(lvl1-lvl2)*0.00875)*100);
  } else {
    ver=Math.round((0.5-(lvl2-lvl1)*0.005-(lvl2-lvl1)*0.00875)*100);
  }
  if (ver<1) {ver=1;}
  if (ver>99) {ver=99;}
  do {
  score = score + set(ver);
  } while (this.p1<2 && this.p2<2);
  System.out.println(this.p1+" - "+this.p2+score.substring(0, score.length()-2)+")");
 }

 private String set(double ver) {
   int g1=0;
   int g2=0;
   double verg;
   Random r=new Random();
   do {
    if ((g1+g2)%2==0) {
      verg=ver+20;
    } else verg=ver-20;
    if (verg<1) {verg=1;}
    if (verg>99) {verg=99;}
    int kubik=r.nextInt(100);
    if (kubik<verg) {
      g1+=1;
    } else {g2+=1;}
  } while ((g1<6 && g2<6) || (g1-g2==1 || g1-g2==-1 || g1-g2==0) && (g1!=7 && g2!=7));
  if (g1>g2) {
    this.p1+=1; 
  } else {this.p2+=1;}
  return Integer.toString(g1) + " - " + Integer.toString(g2) + ", ";
 }
}