import java.util.*;

public class Tournament {
  private static int count;
  private int id;
  private int pokrt;
  private int totalplayes;
  private int currentstage;
  List<Player> players;
  
  public Tournament(List<Player> players, int pokrt) {
    count++;
    this.id=count;
    this.pokrt=pokrt;
    this.players=players;
    this.totalplayes=this.players.size();
  }

  public void start() {
    System.out.println("Tournament " + this.id + "(" + this.pokrt + ") is starting");
    for (int i=1; i<this.totalplayes/2; i++) {
      if (this.currentstage==0) {
        stagewithdraw();  
      } else {stagewithoutdraw();}
      this.currentstage++;
    }
    System.out.println("Winner of this tournamet " + this.id + " is " + this.players.get(0).getName());
    this.players.get(0).setTotalTitles();
  }

  private void stagewithdraw() {
    List<Player> stageplayers = new ArrayList<>();
    Random r=new Random();
    List<Integer> draw = new ArrayList<>();
    for (int i=0; i<this.players.size()/2; i++) {
      int p1=r.nextInt(players.size()/2);
      while (draw.indexOf(p1)>=0) {
        p1=r.nextInt(players.size()/2);
      }
      draw.add(p1);
    }
    for (int i=0; i<this.players.size()/2; i++) {
      Compet c1=new Compet(this.pokrt, this.players.get(i),this.players.get(draw.get(i)+this.players.size()/2));
      stageplayers.add(c1.start());
    }
    this.players=stageplayers;
  }

  private void stagewithoutdraw() {
    List<Player> stageplayers = new ArrayList<>();
    for (int i=0; i<this.players.size()/2; i++) {
      Compet c1=new Compet(this.pokrt, this.players.get(i),this.players.get(this.players.size()-i-1));
      stageplayers.add(c1.start());
    }
    this.players=stageplayers;
  }


}