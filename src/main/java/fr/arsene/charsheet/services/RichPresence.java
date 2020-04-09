package fr.arsene.charsheet.services;


import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class RichPresence  {

    private static RichPresence INSTANCE;

    static {
        INSTANCE = new RichPresence();
    }

    public static RichPresence getINSTANCE() {
        return INSTANCE;
    }

    private static final String token = "697912259590225950";
    DiscordRichPresence presence = new DiscordRichPresence();
    DiscordRPC lib = DiscordRPC.INSTANCE;

    public void start(){

        String steamId = "";
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> System.out.println("Ready!");
        lib.Discord_Initialize(token, handlers, true, steamId);

        presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
        presence.details = "Pas de personnage";
        presence.largeImageKey = "icon";
        lib.Discord_UpdatePresence(presence);
    }

    public void updateMessage(String character, String name){
        presence.details = name;
        presence.state = character;
        lib.Discord_UpdatePresence(presence);
    }



}
