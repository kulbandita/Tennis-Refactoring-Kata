
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String convertScore(int scoreValue) {
        switch (scoreValue) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    public boolean isAll() {
        if (m_score1 == m_score2 && m_score1 < 3) {
            return true;
        }
        return false;
    }

    public boolean isDeuce() {
        if (m_score1 == m_score2 && m_score1 >= 3) {
            return true;
        }
        return false;
    }

    public boolean isWinner() {
        if (m_score1 >= 4 || m_score2 >= 4) {
            return true;
        }
        return false;
    }

    public String getScore() {
        String score = "";
        if (isAll()) {
            score = convertScore(m_score1);
            score = score + "-All";
        } else if (isDeuce()) {
            score = "Deuce";
        } else if (isWinner()) {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1) {
                score = "Advantage " + player1Name;
            } else if (minusResult == -1) {
                score = "Advantage " + player2Name;
            } else if (minusResult >= 2) {
                score = "Win for " + player1Name;
            } else {
                score = "Win for " + player2Name;
            }
        } else {
            score = convertScore(m_score1) + "-" + convertScore(m_score2);
        }
        return score;
    }
}
