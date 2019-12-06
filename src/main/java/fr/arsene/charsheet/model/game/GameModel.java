package fr.arsene.charsheet.model.game;

import fr.arsene.charsheet.model.character.Profession;
import fr.arsene.charsheet.model.character.Race;

import java.util.List;

public final class GameModel {

    private List<Race> races;
    private List<Profession> professions;

    public GameModel() {
    }

    public GameModel(List<Race> races, List<Profession> professions) {
        this.races = races;
        this.professions = professions;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<Profession> professions) {
        this.professions = professions;
    }
}
