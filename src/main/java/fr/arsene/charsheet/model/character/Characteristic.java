package fr.arsene.charsheet.model.character;

import java.util.List;

public class Characteristic {

    private String name;
    private int baseScore;
    private List<Integer> bonuses;
    private List<Integer> maluses;


    public Characteristic(String name, int baseScore, List<Integer> bonuses, List<Integer> maluses) {
        this.name = name;
        this.baseScore = baseScore;
        this.bonuses = bonuses;
        this.maluses = maluses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(int baseScore) {
        this.baseScore = baseScore;
    }

    public List<Integer> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<Integer> bonuses) {
        this.bonuses = bonuses;
    }

    public List<Integer> getMaluses() {
        return maluses;
    }

    public void setMaluses(List<Integer> maluses) {
        this.maluses = maluses;
    }
}
