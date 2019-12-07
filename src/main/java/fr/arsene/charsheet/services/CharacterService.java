package fr.arsene.charsheet.services;

import fr.arsene.charsheet.model.character.Character;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CharacterService {

    List<Character> characters;

    public CharacterService() {
        this.characters = new LinkedList<>();
    }

    public void save(Character character) {
        characters.add(character);
    }

    public List<Character> findAll(){
        return this.characters;
    }

}
