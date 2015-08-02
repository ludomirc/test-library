package resources;

import loans.Loan;

/**
 * Created by Benek on 2015-08-02.
 */
public class GameResource extends AbstractResource {

    private String gameType;

    public GameResource() {
    }

    public GameResource(String title, String type, String gameType) {
        super(title, type);
        this.gameType = gameType;
    }

    public GameResource(String id, String title, String type, Loan loan, String gameType) {
        super(id, title, type, loan);
        this.gameType = gameType;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    @Override
    public String getFormattedString() {
        return "Game - " + getTitle() + " for the " + getGameType();
    }

    @Override
    public int getMaxLoanPeriod() {
        if (gameType.equals("X-Box")) {
            return 7;
        } else if (gameType.equals("PS2")) {
            return 7;
        } else if (gameType.equals("Amstrad")) {
            return 14;
        } else {
            return super.getMaxLoanPeriod();
        }
    }

    @Override
    public double getSurcharge() {
        if (gameType.equals("X-Box")) {
            return 1.0;
        } else if (gameType.equals("PS2")) {
            return 1.5;
        } else if (gameType.equals("Amstrad")) {
            return .5;
        } else {
            return super.getSurcharge();
        }
    }
}
