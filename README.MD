# JPHP-DiscordRPC-ext

Библиотека на основе которой собрано [Vatuu/discord-rpc](https://github.com/Vatuu/discord-rpc)

##### Как скачать для DevelNext?
Жми **[сюда](https://github.com/silentdeath76/JPHP-DiscordRPC-ext/releases)**
<br>

##### Как пользоваться:
1. Чтобы использовать пакет вам надо создать приложение в [discord](https://discord.com/developers/applications).
2. Название `игры \ приложения` - это название вашего приложения, вы его можете в любой момент поменять в настройках по ссылке в п. 1.
3. Чтобы ваше приложение отображало иконку, надо загрузить изображения в "Rich Presence" (см. ссылку в п. 1), загружаете и даете ID вашей картинке (может не сразу работать, у меня только через пару минут начало подгружать ее)

##### Простой пример использования
```php
$appId = ""; // ID приложения что вы создали до этого
$discord = new DiscordRPC($appId);

// заголовок если исопльзуется метод setParty 
$discord->setState("Игроков на сервере");

$discord->setBigImage("ID картинки");

// Подзагловок
$discord->setDetails("...");

// нужен чтобы отображалось сколько времени вы провели в приложении
$discord->setStartTimestamp((Time::now())->getTime());

$discord->updateState();
```
После любого изменения заголовка, подзаголовка и т.д. **НУЖНО** вызвать метод `updateState` чтобы эти изменения применились
<br>

##### События
Callback события в основном бесполезные тут (имхо конечно, не видел я что-то чтобы хоть кто-то делал игры на DN), единственное для которого есть применение это `DiscordRPC::EVENT_READY` т.к. там возвращается объект User с данными (ну может кому-то захочется статистику делать, или там бан по ID сделать)
```php
$discord->on(DiscordRPC::EVENT_READY, function (User $user) {
    // пример формирования ссылки для получения аватара
    // $avatar = "https://cdn.discordapp.com/avatars/" . $user->getId() . "/" . $user->getAvatar() . ".png";
    var_dump($user->getName());
});
```

Событие — Аргументы в callback функции
```php
DiscordRPC::EVENT_READY - User $user
DiscordRPC::EVENT_JOIN_REQUES - User $user
DiscordRPC::EVENT_JOIN - string $secret
DiscordRPC::EVENT_SPECTATE - string $spectateSecret
DiscordRPC::EVENT_ERROR - int $code, string $message
DiscordRPC::EVENT_DISCONNECTED - int $code, string $message
```

Чтобы события работали надо постоянно вызывать метод `updateCallbacks`

<br><br>
```setParty``` - принимает 3 значения: ID, текущее количество игроков, максимальное количество игроков
<br>
```setEndTimestamp``` - принимает значение будущего, для обратного отсчета (время до закрытия лобби и прочие моменты когда нужно вывести информацию об каком то ограниченном событии)
<br>
```setSecrets``` - для создания кнопки в профиле "присоединиться". Вот тут, конечно, события будут нам нужны 


##### Подключение пакета через JPHP
```
 jppm add jphp-discord-rpc-ext@git+https://github.com/silentdeath76/JPHP-DiscordRPC-ext
```