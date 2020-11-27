import java.util.*;

public class Tournament {
  private static int count;
  private int id;
  private int pokrt;
  private int totalplayes;
  private int currentstage;
  List<Player> players;
  
  public Tournament(List<Player> players) {
    count++;
    this.id=count;
    this.players=players;
    this.totalplayes=this.players.size();
  }

  public void start() {
    System.out.println("Tournament is" + this.id + " starting");
    for (int i=1; i<this.totalplayes/2; i++) {
      stage();
      this.currentstage++;
    }
    System.out.println("Winner of this tournamet " + this.id + " is " + this.players.get(0).getName());
    this.players.get(0).setTotalTitles();
  }

  private void stage() {
    List<Player> stageplayers = new ArrayList<>();
    for (int i=0; i<this.players.size()/2; i++) {
      Compet c1=new Compet(1, this.players.get(i),this.players.get(this.players.size()-i-1));
      stageplayers.add(c1.start());
    }
    this.players=stageplayers;
  }


}