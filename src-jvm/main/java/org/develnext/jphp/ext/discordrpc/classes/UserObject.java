package org.develnext.jphp.ext.discordrpc.classes;

import net.arikia.dev.drpc.DiscordUser;
import org.develnext.jphp.ext.discordrpc.DiscordRPCExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;

@Reflection.Abstract
@Reflection.Name("User")
@Reflection.Namespace(DiscordRPCExtension.NS)
public class UserObject extends BaseWrapper<DiscordUser> {

    private DiscordUser user;

    public UserObject(Environment env, DiscordUser wrappedObject) {
        super(env, wrappedObject);
        user = wrappedObject;
    }

    @Reflection.Signature
    public String getName() {
        return user.username;
    }

    @Reflection.Signature
    public String getId() {
        return user.userId;
    }

    @Reflection.Signature
    public String getAvatar() {
        return user.avatar;
    }

    @Reflection.Signature
    public String getDiscriminator() {
        return user.discriminator;
    }
}
