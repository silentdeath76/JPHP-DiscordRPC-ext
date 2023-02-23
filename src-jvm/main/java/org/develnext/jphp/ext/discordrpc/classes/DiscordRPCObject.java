package org.develnext.jphp.ext.discordrpc.classes;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import org.develnext.jphp.ext.discordrpc.DiscordRPCExtension;

import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("DiscordRPC")
@Reflection.Namespace(DiscordRPCExtension.NS)
public class DiscordRPCObject extends BaseObject {

    public static final String EVENT_READY = "ready";
    public static final String EVENT_SPECTATE = "spectate";
    public static final String EVENT_DISCONNECTED = "disconnected";
    public static final String EVENT_ERROR = "error";
    public static final String EVENT_JOIN = "join";


    private String state;
    private String details;
    private String bigImageId;
    private String bigImageHint;
    private String smallImageId;
    private String smallImageHint;
    private long startTimestamp;
    private long endTimestamp;
    private String partyId;
    private int partySize;
    private int partySizeMax;
    private String secretJoin;
    private String secretSpectate;


    private Invoker readyCallback;
    private Invoker spectateCallback;
    private Invoker disconnectedCallback;
    private Invoker errorCallback;
    private Invoker joinCallback;

    public DiscordRPCObject(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(String appId) {

        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder()
                .setReadyEventHandler((user) -> {
                    try {
                        UserObject userObject = new UserObject(__env__, user);

                        if (this.readyCallback != null) {
                            this.readyCallback.callAny(userObject);
                        }
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }).setDisconnectedEventHandler((i, s) -> {
                    try {
                        if (this.disconnectedCallback != null) {
                            this.disconnectedCallback.callAny(i, s);
                        }
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }).setSpectateGameEventHandler(s -> {
                    try {
                        if (this.spectateCallback != null) {
                            this.spectateCallback.callAny(s);
                        }
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }).setJoinGameEventHandler(s -> {
                    try {
                        if (this.joinCallback != null) {
                            this.joinCallback.callAny(s);
                        }
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }).setErroredEventHandler((i, s) -> {
                    try {
                        if (this.errorCallback != null) {
                            this.errorCallback.callAny(i, s);
                        }
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }).build();

        DiscordRPC.discordInitialize(appId, handlers, true);
    }

    @Reflection.Signature
    public void setState(String text) {
        this.state = text;
    }

    @Reflection.Signature
    public void setDetails(String text) {
        this.details = text;
    }

    @Reflection.Signature
    public void setBigImage(String imageId) {
        this.setBigImage(imageId, "");
    }

    @Reflection.Signature
    public void setBigImage(String imageId, String textHint) {
        this.bigImageId = imageId;
        this.bigImageHint = textHint;
    }

    @Reflection.Signature
    public void setSmallImage(String imageId) {
        this.setSmallImage(imageId, "");
    }

    @Reflection.Signature
    public void setSmallImage(String imageId, String textHint) {
        this.smallImageId = imageId;
        this.smallImageHint = textHint;
    }

    @Reflection.Signature
    public void setStartTimestamp(long timestamp) {
        this.startTimestamp = timestamp;
    }

    @Reflection.Signature
    public void setEndTimestamp(long timestamp) {
        this.endTimestamp = timestamp;
    }

    @Reflection.Signature
    public void setParty(String id, int size, int max) {
        this.partyId = id;
        this.partySize = size;
        this.partySizeMax = max;
    }

    @Reflection.Signature
    public void setSecrets(String join, String spectate) {
        this.secretJoin = join;
        this.secretSpectate = spectate;
    }

    @Reflection.Signature
    public void updateState() {
        DiscordRichPresence.Builder rich = new DiscordRichPresence.Builder(this.state);

        if (this.partyId != null) {
            rich.setParty(this.partyId, this.partySize, this.partySizeMax);
        }

        rich.setDetails(this.details);

        if (this.bigImageId != null) {
            rich.setBigImage(this.bigImageId, this.bigImageHint);
        }

        if (this.smallImageId != null) {
            rich.setSmallImage(this.smallImageId, this.smallImageHint);
        }

        if (this.startTimestamp < Long.MAX_VALUE && this.startTimestamp > Long.MIN_VALUE) {
            rich.setStartTimestamps(this.startTimestamp);
        }

        if (this.endTimestamp < Long.MAX_VALUE && this.endTimestamp > Long.MIN_VALUE) {
            rich.setEndTimestamp(this.endTimestamp);
        }

        if (this.secretJoin != null) {
            rich.setSecrets(this.secretJoin, this.secretSpectate);
        }

        DiscordRPC.discordUpdatePresence(rich.build());

        DiscordRPC.discordRunCallbacks();
    }

    @Reflection.Signature
    public void on(String event, Invoker callback) {
        switch (event) {
            case EVENT_READY: {
                this.readyCallback = callback;
            }
            break;

            case EVENT_SPECTATE: {
                this.spectateCallback = callback;
            }
            break;

            case EVENT_DISCONNECTED: {
                this.disconnectedCallback = callback;
            }
            break;

            case EVENT_ERROR: {
                this.errorCallback = callback;
            }
            break;

            case EVENT_JOIN: {
                this.joinCallback = callback;
            }
            break;
        }
    }

    @Reflection.Signature
    public void clear() {
        DiscordRPC.discordClearPresence();
    }

    @Reflection.Signature
    public void __destruct() {
        DiscordRPC.discordShutdown();
    }
}
