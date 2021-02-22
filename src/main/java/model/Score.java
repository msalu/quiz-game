package model;

public class Score {
    private static Score score = null;

    private static int num;

    public static Score getScoreInstance() {
        if (score == null) score = new Score();

        return score;
    }

    public static void increaseScore(int points){
        num += points;
    }

    public int returnNum(){
        return num;
    }

}
