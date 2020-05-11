package fr.arsene.charsheet.model.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Character {
    private String name;
    private Gender gender;
    private Race race;
    private Profession profession;

    private int maxHealth;
    private int currentHealth;

    private int maxMana;
    private int currentMana;

    private int experience;

    private int fatePoints;

    // Currencies

    private int golds;
    private int silvers;
    private int coppers;

    // Characteristics

    private int courage;
    private int intelligence;
    private int charisma;
    private int agility;
    private int strength;
    private int attack;
    private int block;

    // Abilities

    private List<Ability> abilities;

    // Belongings

    private List<Protection> protections;
    private List<Weapon> weapons;

    private List<Item> inventory;

    private int maxWeightCarried;
}
