# JPHP-DiscordRPC-ext

Библиотека на основе которой собрано [Vatuu/discord-rpc](https://github.com/Vatuu/discord-rpc)

##### Как пользоваться:

1. Чтобы использовать пакет вам надо создать приложение в [discord](https://discord.com/developers/applications).
2. Название `игры \ приложения` - это название вашего приложения, вы его можете в любой момент поменять в настройках по ссылку в п. 1.
3. Чтобы ваше приложение отображало иконку, надо загрузить изображения в "Rich Presence" (см. ссылку в п. 1), загружаете и даете ID вашей картинке (может не сразу работать, у меня только через пару минут начало подгружать ее)

```php
$discord->setBigImage("ID картинки что вы указали");
```

##### Простой пример использования
```php
$discord = new DiscordRPC($appId);

// заголовок если исопльзуется метод setParty 
$discord->setState("Игроков на сервере");

// hint - не обязательно указывать
$discord->setBigImage("BImage", "hint");
$discord->setSmallImage("SImageDefault", "hint");

// Подзагловок
$discord->setDetails("...");

// я не до конца разобрался для чего первый аргумент (вообще не разбирался, понятно что это ID но как с ним работать без понятия)
// по этому можно указать все что угодно
$discord->setParty("ID", 15, 60);

// нужен чтобы отображалось сколько времени вы провели в вашем приложении
$discord->setStartTimestamp((Time::now())->getTime());

$discord->updateState();
```

<br><br>
##### События
Callback события в основном бесполезные тут (имхо конечно, не видел я что-то чтобы хоть кто-то делал игры на DN), единственное для которого есть применение это `DiscordRPC::EVENT_READY` т.к. там возвращается объект User с данными (ну может кому-то захочется статистику делать, или там бан по ID сделать)
```php
$discord->on(DiscordRPC::EVENT_READY, function (User $user) {
    // пример формирования ссылки для получения аватара
    // $avatar = "https://cdn.discordapp.com/avatars/" . $user->getId() . "/" . $user->getAvatar() . ".png";
    var_dump($user->getName());
});
```

Событие - Аргументы в callback функции
```php
DiscordRPC::EVENT_READY - User $user
DiscordRPC::EVENT_JOIN_REQUES - User $user
DiscordRPC::EVENT_JOIN - string $secret
DiscordRPC::EVENT_SPECTATE - stromg $spectateSecret
DiscordRPC::EVENT_ERROR - int $code, string $message
DiscordRPC::EVENT_DISCONNECTED - int $code, string $message
```

Чтобы события работали надо постоянно вызывать метод `updateCallbacks`

<br><br>
Теперь по методам которые вряд ли кто-то будет использовать
<br>
```setEndTimestamp``` - принимает значение будущего, для обратного отсчета (время до закрытия лобби и прочие моменты когда нужно вывести информацию об каком то ограниченном событии)
<br>
```setSecrets``` - для создания кнопки в профиле "присоединиться". Вот тут, конечно, события будут нам нужны 


##### Подключение пакета через jphp
```
 jppm add jphp-discord-rpc-ext@git+https://github.com/silentdeath76/JPHP-DiscordRPC-ext
```