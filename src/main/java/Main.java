import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;


import java.util.Date;

public class Main {
    private static Long starttime;

    public static void main(String[] args) {
        String appId = "817484458025418764";
        starttime = new Date().getTime();

        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
        }).build();

        DiscordRPC.discordInitialize(appId, handlers, true);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // createNewPresence();
                    DiscordRPC.discordRunCallbacks();

                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        th.start();
    }

    public static void createNewPresence() {
        DiscordRichPresence rich = new DiscordRichPresence
                .Builder("Игроков на сервере")
                .setParty("id???", 15, 60)
                .setDetails("https://.../")
                .setBigImage("cover", null)
                // .setSecrets("id???", "2")
                .setStartTimestamps(starttime)
                .build();

        DiscordRPC.discordUpdatePresence(rich);
    }
}
