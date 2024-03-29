<?php

namespace discord\rpc;


/**
 * Class DiscordRPC
 * @packages discord
 */
class DiscordRPC
{
    const EVENT_READY = "ready";
    const EVENT_SPECTATE = "spectate";
    const EVENT_DISCONNECTED = "disconnected";
    const EVENT_ERROR = "error";
    const EVENT_JOIN = "join";
    const EVENT_JOIN_REQUEST = "joinRequest";

    public function __construct($appId)
    {
    }

    public function setState($text): void
    {
    }

    public function setDetails($text): void
    {
    }

    public function setBigImage($imageId, $textHint = null): void
    {
    }

    public function setSmallImage($imageId, $textHint = null): void
    {
    }

    public function setStartTimestamp($timestamp): void
    {
    }

    public function setEndTimestamp($timestamp): void
    {
    }

    public function setParty($id, $size, $max): void
    {
    }

    public function clear(): void
    {
    }

    public function setSecrets($join, $spectate): void
    {
    }

    public function updateState(): void
    {
    }

    public function updateCallbacks(): void
    {
    }

    public function on($event, callable $callback): void
    {
    }
}