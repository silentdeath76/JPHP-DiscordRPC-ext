package org.develnext.jphp.ext.discordrpc;

import net.arikia.dev.drpc.DiscordUser;
import org.develnext.jphp.ext.discordrpc.classes.DiscordRPCObject;
import org.develnext.jphp.ext.discordrpc.classes.UserObject;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;

public class DiscordRPCExtension extends Extension {
    public static final String NS = "discord\\rpc";

    @Override
    public Status getStatus() {
        return Status.EXPERIMENTAL;
    }

    @Override
    public void onRegister(CompileScope compileScope) {
        registerClass(compileScope, DiscordRPCObject.class);
        registerWrapperClass(compileScope, DiscordUser.class, UserObject.class);
    }
}