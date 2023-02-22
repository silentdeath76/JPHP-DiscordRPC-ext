# JPHP-DiscordRPC-ext

##### Как пользоваться:

1. Чтобы использовать пакет вам надо создать приложение в [discord](https://discord.com/developers/applications).
2. Название `игры \ приложения` - это название вашего приложения, вы его можете в любой момент поменять в настройках по ссылку в 1 пункте.
3. Чтобы ваше приложение отображало иконку, надо загрузить изображения в "Rich Presence" нажимаете "Add Image", загружаете и даете ID вашей картинке (может не сразу работать, у меня только через пару минут началао подгружать ее)
```php
$discord->setBigImage("ID картинки что вы указали");
```

```php
$discord = new DiscordRPC($appId);
$discord->setState("Игроков на сервере"); // заголовок если исопльзуется метод setParty 
$discord->setBigImage("cover");
$discord->setSmallImage("cover");
$discord->setDetails("..."); // Подзагловок
$discord->setParty("ID", 15, 60); // я не до конца разобрался для чего первый аргумент (вообще не разбирался) по этому, можно все что угодно указать
$discord->setStartTimestamp((Time::now())->getTime()); // нужен чтобы отображалось сколько времени вы провели в вашем приложении
$discord->on(DiscordRPC::EVENT_READY, function (User $user) {
    // $avatar = "https://cdn.discordapp.com/avatars/" . $user->getId() . "/" . $user->getAvatar() . ".png";
    var_dump($user->getName());
});
```

Теперь по методам которые вряд ли ктото будет использовать
<br>
```setEndTimestamp``` - принимает значение будущего, для обратного отсчета (время до закрытия лобби и прочие момоенты когда нужно вывести информацию об каком то ограниченном событии)
<br>
```setSecrets``` - без понятия для чего оно, думал может чтото в стиле создания ID для метода ```setParty``` но хз, может и не для этого ¯\_(ツ)_/¯


### Подключение пакета через jphp
```
 jppm add jphp-discord-rpc-ext@git+https://github.com/silentdeath76/JPHP-DiscordRPC-ext
```