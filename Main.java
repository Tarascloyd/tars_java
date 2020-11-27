import java.util.*;

class Main {
  public static void main(String[] args) {
    String[] names=new String[]{"Вася", "Петя", "Рома", "Костя", "Витя", "Алекс", "Стас", "Кот"};
    List<Player> spisok = new ArrayList<>();
    for (int i=0; i<8; i++) {
      Random r=new Random();
      spisok.add(new Player(names[i], r.nextInt(22)+17, r.nextInt(30), r.nextInt(30), r.nextInt(30))); 
    }
    for (int i=0; i<4; i++) {
      Random r=new Random();
      int p1=r.nextInt(spisok.size());
      int p2;
      do {
        p2=r.nextInt(spisok.size());
      } while (p1==p2);
      Compet c1=new Compet(1, spisok.get(p1),spisok.get(p2));
      c1.start();
    }
    Comparator<Player> plEloRatingComparator = (p1, p2) -> p2.getEloRatingInt() - p1.getEloRatingInt();
    for (int i=0; i<12; i++) {
      Collections.sort(spisok, plEloRatingComparator);
      Tournament t1=new Tournament(spisok);
      t1.start();
    }
    
    Collections.sort(spisok, plEloRatingComparator);
    for (Player p : spisok) {
      System.out.println(p.getName()+" has " + p.getTotalw() +" wins, " + p.getTotall()+" loses, " + p.getTotalTitles() + " titles and rating " + Math.round(p.getEloRating())+" max "+ Math.round(p.getMaxElo())+" lvl " + p.getLevel());
    }
  }
}
