public class Player {
  private String name;
  private int age;
  private int power;
  private int speed;
  private int skill;
  private int totalw;
  private int totall;
  private int totaltitles;
  private float elorating;
  private float maxelo;
  public Player(String name,int age,int power,int speed, int skill) {
    this.name=name;
    this.age=age;
    this.power=power;
    this.speed=speed;
    this.skill=skill;
    this.totalw=0;
    this.totall=0;
    this.totaltitles=0;
    this.elorating=1000;
    this.maxelo=1000;
  }
  public String getName() {
    return this.name;
  }
  public int getLevel() {
    return this.power+this.speed+this.skill;
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