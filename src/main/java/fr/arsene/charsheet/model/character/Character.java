package fr.arsene.charsheet.model.character;

import java.util.List;

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

    // Constructors

    public Character(String name, Gender gender, Race race, Profession profession, int maxHealth, int currentHealth, int maxMana, int currentMana, int experience, int fatePoints, int golds, int silvers, int coppers, int courage, int intelligence, int charisma, int agility, int strength, int attack, int block, List<Ability> abilities, List<Protection> protections, List<Weapon> weapons, List<Item> inventory) {
        this.name = name;
        this.gender = gender;
        this.race = race;
        this.profession = profession;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.maxMana = maxMana;
        this.currentMana = currentMana;
        this.experience = experience;
        this.fatePoints = fatePoints;
        this.golds = golds;
        this.silvers = silvers;
        this.coppers = coppers;
        this.courage = courage;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.agility = agility;
        this.strength = strength;
        this.attack = attack;
        this.block = block;
        this.abilities = abilities;
        this.protections = protections;
        this.weapons = weapons;
        this.inventory = inventory;
    }

    public Character() {


    }


    // Services


    // Getters & Setters


    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getFatePoints() {
        return fatePoints;
    }

    public void setFatePoints(int fatePoints) {
        this.fatePoints = fatePoints;
    }

    public int getGolds() {
        return golds;
    }

    public void setGolds(int golds) {
        this.golds = golds;
    }

    public int getSilvers() {
        return silvers;
    }

    public void setSilvers(int silvers) {
        this.silvers = silvers;
    }

    public int getCoppers() {
        return coppers;
    }

    public void setCoppers(int coppers) {
        this.coppers = coppers;
    }


    public int getCourage() {
        return courage;
    }

    public void setCourage(int courage) {
        this.courage = courage;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public List<Protection> getProtections() {
        return protections;
    }

    public void setProtections(List<Protection> protections) {
        this.protections = protections;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public int getMaxWeightCarried() {
        return maxWeightCarried;
    }

    public void setMaxWeightCarried(int maxWeightCarried) {
        this.maxWeightCarried = maxWeightCarried;
    }
}
