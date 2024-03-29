# DiscordRPC

- **class** `DiscordRPC` (`discord\rpc\DiscordRPC`)
- **source** `discord/rpc/DiscordRPC.php`

---

#### Methods

- `->`[`__construct()`](#method-__construct)
- `->`[`setState()`](#method-setstate)
- `->`[`setDetails()`](#method-setdetails)
- `->`[`setBigImage()`](#method-setbigimage)
- `->`[`setSmallImage()`](#method-setsmallimage)
- `->`[`setStartTimestamp()`](#method-setstarttimestamp)
- `->`[`setEndTimestamp()`](#method-setendtimestamp)
- `->`[`setParty()`](#method-setparty)
- `->`[`clear()`](#method-clear)
- `->`[`setSecrets()`](#method-setsecrets)
- `->`[`updateState()`](#method-updatestate)
- `->`[`updateCallbacks()`](#method-updatecallbacks)
- `->`[`on()`](#method-on)

---
# Methods

<a name="method-__construct"></a>

### __construct()
```php
__construct(mixed $appId): void
```

---

<a name="method-setstate"></a>

### setState()
```php
setState(mixed $text): void
```

---

<a name="method-setdetails"></a>

### setDetails()
```php
setDetails(mixed $text): void
```

---

<a name="method-setbigimage"></a>

### setBigImage()
```php
setBigImage(mixed $imageId, mixed $textHint): void
```

---

<a name="method-setsmallimage"></a>

### setSmallImage()
```php
setSmallImage(mixed $imageId, mixed $textHint): void
```

---

<a name="method-setstarttimestamp"></a>

### setStartTimestamp()
```php
setStartTimestamp(mixed $timestamp): void
```

---

<a name="method-setendtimestamp"></a>

### setEndTimestamp()
```php
setEndTimestamp(mixed $timestamp): void
```

---

<a name="method-setparty"></a>

### setParty()
```php
setParty(mixed $id, mixed $size, mixed $max): void
```

---

<a name="method-clear"></a>

### clear()
```php
clear(): void
```

---

<a name="method-setsecrets"></a>

### setSecrets()
```php
setSecrets(mixed $join, mixed $spectate): void
```

---

<a name="method-updatestate"></a>

### updateState()
```php
updateState(): void
```

---

<a name="method-updatecallbacks"></a>

### updateCallbacks()
```php
updateCallbacks(): void
```

---

<a name="method-on"></a>

### on()
```php
on(mixed $event, callable $callback): void
```