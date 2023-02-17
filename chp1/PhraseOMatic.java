package chp1;

public class PhraseOMatic {
    public static void main(String[] args) {
        String[] wordListOne = {"24/7","B-to-B","front-end","web-based","smart"
        ,"six-sigma","critical-path","dynamic","agile","TDD"};
        String[] wordListTwo = {"empowered","sticky","clustered","cooperative"
        ,"outside-the-box","oriented","distributed","networked","leveraged"};
        String[] wordListThree = {"process","tipping-point","solution"
        ,"architecture","core competency","strategy","mindshare"};

        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        int rand1 = (int) (Math.random()*oneLength);
        int rand2 = (int) (Math.random()*twoLength);
        int rand3 = (int) (Math.random()*threeLength);

        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] +
            " " + wordListThree[rand3];
        System.out.println("What we need is a "+phrase);

    }
}
