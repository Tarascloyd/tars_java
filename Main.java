import java.util.*;

class Main {
  public static void main(String[] args) {
    String[] names=new String[]{"Вася", "Петя", "Рома", "Костя", "Витя", "Алекс", "Стас", "Кот"};
    List<Player> spisok = new ArrayList<>();
    for (int i=0; i<8; i++) {
      Random r=new Random();
      spisok.add(new Player(names[i], r.nextInt(22)+17, r.nextInt(30), r.nextInt(30), r.nextInt(30), r.nextInt(60), r.nextInt(60), r.nextInt(60), r.nextInt(60))); 
    }
    for (int i=0; i<4; i++) {
      Random r=new Random();
      int p1=r.nextInt(spisok.size());
      int p2;
      do {
        p2=r.nextInt(spisok.size());
      } while (p1==p2);
      Compet c1=new Compet(r.nextInt(4), spisok.get(p1),spisok.get(p2));
      c1.start();
    }
    Comparator<Player> plEloRatingComparator = (p1, p2) -> p2.getEloRatingInt() - p1.getEloRatingInt();
    for (int i=0; i<24; i++) {
      Random r=new Random();
      Collections.sort(spisok, plEloRatingComparator);
      Tournament t1=new Tournament(spisok, r.nextInt(4));
      t1.start();
    }
    
    Collections.sort(spisok, plEloRatingComparator);
    for (Player p : spisok) {
      System.out.println(p.getName()+" has " + p.getTotalw() +" wins, " + p.getTotall()+" loses, " + p.getTotalTitles() + " tit and rat " + Math.round(p.getEloRating())+" max "+ Math.round(p.getMaxElo())+" lvl " + p.getLevel() + "(" + p.getLevel(0) + ", " + p.getLevel(1) + ", " + p.getLevel(2) + ", "+ p.getLevel(3) + ")");
    }
  }
}
