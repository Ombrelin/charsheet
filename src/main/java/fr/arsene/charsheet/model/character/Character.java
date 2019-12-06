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

    private Characteristic courage;
    private Characteristic intelligence;
    private Characteristic charisma;
    private Characteristic agility;
    private Characteristic strength;

    private Characteristic attack;
    private Characteristic block;

    // Belongings

    private List<Protection> protections;
    private List<Weapon> weapons;

    private List<Item> inventory;

    // Constructeurs

    public Character(String name, Gender gender, Race race, Profession profession, int maxHealth, int currentHealth, int maxMana, int currentMana, int experience, int fatePoints, int golds, int silvers, int coppers, Characteristic courage, Characteristic intelligence, Characteristic charisma, Characteristic agility, Characteristic strength, Characteristic attack, Characteristic block, List<Protection> protections, List<Weapon> weapons, List<Item> inventory) {
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
        this.protections = protections;
        this.weapons = weapons;
        this.inventory = inventory;
    }

    // Services




    // Getters & Setters

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

    public Characteristic getCourage() {
        return courage;
    }

    public void setCourage(Characteristic courage) {
        this.courage = courage;
    }

    public Characteristic getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Characteristic intelligence) {
        this.intelligence = intelligence;
    }

    public Characteristic getCharisma() {
        return charisma;
    }

    public void setCharisma(Characteristic charisma) {
        this.charisma = charisma;
    }

    public Characteristic getAgility() {
        return agility;
    }

    public void setAgility(Characteristic agility) {
        this.agility = agility;
    }

    public Characteristic getStrength() {
        return strength;
    }

    public void setStrength(Characteristic strength) {
        this.strength = strength;
    }

    public Characteristic getAttack() {
        return attack;
    }

    public void setAttack(Characteristic attack) {
        this.attack = attack;
    }

    public Characteristic getBlock() {
        return block;
    }

    public void setBlock(Characteristic block) {
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
}
