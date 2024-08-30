package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.af
public enum GameEvent {
    created,
    completeAndActive,
    destroyed,
    killedAnyUnit,
    queuedUnitFinished,
    queueItemAdded,
    queueItemCancelled,
    teleported,
    touchTargetSuccess,
    newWaypointGivenByPlayer,
    teamChanged,
    transportingNewUnit,
    transportUnloadedOrRemovedUnit,
    tookDamage,
    enteredTransport,
    leftTransport,
    newMessage,
    attachmentRemoved;
}
