import java.util.*;

public class Player {
  private String name;
  private int age;
  private int power;
  private int speed;
  private int skill;
  private int[] pokrtskill=new int[4];
  private int totalw;
  private int totall;
  private int totaltitles;
  private float elorating;
  private float maxelo;
  public Player(String name,int age,int power,int speed, int skill, int gskill, int hskill, int cskill, int iskill) {
    this.name=name;
    this.age=age;
    this.power=power;
    this.speed=speed;
    this.skill=skill;
    this.pokrtskill[0]=gskill;
    this.pokrtskill[1]=hskill;
    this.pokrtskill[2]=cskill;
    this.pokrtskill[3]=iskill;
    this.totalw=0;
    this.totall=0;
    this.totaltitles=0;
    this.elorating=1000;
    this.maxelo=1000;
  }
  public String getName() {
    return this.name;
  }
  public int getLevel(int pokrt) {
    return this.power+this.speed+this.skill+this.pokrtskill[pokrt];
  }
  public int getLevel() {
    return this.power+this.speed+this.skill+((int)(Arrays.stream(pokrtskill).sum()/this.pokrtskill.length));
  }
  public int getTotalw() {
    return this.totalw;
  }
  public int getTotall() {
    return this.totall;
  }
  public void setTotalw() {
    this.totalw+=1;
  }
  public void setTotall() {
    this.totall+=1;
  }
  public int getTotalTitles() {
    return this.totaltitles;
  }
  public void setTotalTitles() {
    this.totaltitles+=1;
  }
  public float getEloRating() {
    return this.elorating;
  }
  public int getEloRatingInt() {
    return Math.round(this.elorating);
  }
  public void setEloRating(float change) {
    this.elorating+=change;
    if (this.elorating>this.maxelo) {this.maxelo=this.elorating;}
    if (this.elorating<100) {this.elorating=100;}
  }
  public float getMaxElo() {
    return this.maxelo;
  }
}