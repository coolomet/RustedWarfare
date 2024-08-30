package com.corrodinggames.rts.game.units.custom.logicBooleans;

public strictfp class LogicBooleanGameFunctions {
    static void addBooleanType(LogicBoolean var0, String... var1) {
        LogicBoolean.addBooleanType(var0, var1);
    }

    static void loadTypes() {
        addBooleanType((new LogicBooleanGameFunctions$HeightBoolean()).with("underwater=true"), "self.underwater", "self.isUnderwater");
        addBooleanType((new LogicBooleanGameFunctions$HeightBoolean()).with("ground=true"), "self.gound", "self.ground", "self.isAtGroundHeight");
        addBooleanType(new LogicBooleanGameFunctions$HeightValueBoolean(), "self.height", "self.z");
        addBooleanType((new LogicBooleanGameFunctions$HeightBoolean()).with("flying=true"), "self.flying", "self.isFlying");
        addBooleanType(new LogicBooleanGameFunctions$MovingBoolean(), "self.isMoving");
        addBooleanType(new LogicBooleanGameFunctions$HasActiveWaypoint(), "self.hasActiveWaypoint");
        addBooleanType(new LogicBooleanGameFunctions$NumberOfQueuedWaypoints(), "self.numberOfQueuedWaypoints");
        addBooleanType(new LogicBooleanGameFunctions$SpeedValueBoolean(), "self.speed");
        addBooleanType((new LogicBooleanGameFunctions$SpeedBoolean()).with("atTopSpeed=true"), "self.maxspeed", "self.isAtTopSpeed");
        addBooleanType(new LogicBooleanGameFunctions$InMapBoolean(), "self.isInMap");
        addBooleanType(new LogicBooleanGameFunctions$TouchWaterBoolean(), "self.inwater", "self.isInWater");
        addBooleanType(new LogicBooleanGameFunctions$OverWaterBoolean(), "self.overwater", "self.isOverwater");
        addBooleanType(new LogicBooleanGameFunctions$OverLiquidBoolean(), "self.isOverLiquid");
        addBooleanType(new LogicBooleanGameFunctions$OverCliftBoolean(), "self.isOverClift", "self.isOverCliff");
        addBooleanType(new LogicBooleanGameFunctions$OverPassableTileBoolean(), "self.isOverPassableTile");
        addBooleanType((new LogicBooleanGameFunctions$OverPassableTileBoolean()).with("type='LAND'").createLocked(), "self.isOverOpenLand");
        addBooleanType(new LogicBooleanGameFunctions$TagsBoolean(), "self.tags", "self.hasTags");
        addBooleanType(new LogicBooleanGameFunctions$TeamTagBoolean(), "self.globalTeamTags", "self.hasGlobalTeamTags");
        addBooleanType(new LogicBooleanGameFunctions$HasFlagDynamicBoolean(), "self.hasFlag");
        addBooleanType(new LogicBooleanGameFunctions$EnergyBoolean(), "self.energy");
        addBooleanType(new LogicBooleanGameFunctions$EnergyIncludingQueuedBoolean(), "self.energyIncludingQueued");
        addBooleanType((new LogicBooleanGameFunctions$EnergyBoolean()).with("full=true"), "self.isEnergyFull");
        addBooleanType((new LogicBooleanGameFunctions$EnergyBoolean()).with("empty=true"), "self.isEnergyEmpty");
        addBooleanType(new LogicBooleanGameFunctions$TransportingCountBoolean(), "self.transportingCount");
        addBooleanType(new LogicBooleanGameFunctions$TransportingUnitWithTagsBoolean(), "self.transportingUnitWithTags");
        addBooleanType(new LogicBooleanGameFunctions$isTransportUnloading(), "self.isTransportUnloading");
        addBooleanType(new LogicBooleanGameFunctions$PriceCreditsBoolean(), "self.priceCredits");
        addBooleanType(new LogicBooleanGameFunctions$HpBoolean(), "self.hp");
        addBooleanType(new LogicBooleanGameFunctions$MaxHpBoolean(), "self.maxHp");
        addBooleanType(new LogicBooleanGameFunctions$MaxShieldBoolean(), "self.maxShield");
        addBooleanType(new LogicBooleanGameFunctions$MaxEnergyBoolean(), "self.maxEnergy");
        addBooleanType(new LogicBooleanGameFunctions$UnitIdBoolean(), "self.id");
        addBooleanType(new LogicBooleanGameFunctions$TeamIdBoolean(), "self.teamId");
        addBooleanType(new LogicBooleanGameFunctions$TeamDefeatedTechBoolean(), "self.teamDefeatedTech");
        addBooleanType(new LogicBooleanGameFunctions$TeamWipedOutBoolean(), "self.teamWipedOut");
        addBooleanType(new LogicBooleanGameFunctions$TeamVictoryBoolean(), "self.teamVictory");
        addBooleanType(new LogicBooleanGameFunctions$isEnergyRechargingBoolean(), "self.isEnergyRecharging");
        addBooleanType(new LogicBooleanGameFunctions$PositionXBoolean(), "self.x");
        addBooleanType(new LogicBooleanGameFunctions$PositionYBoolean(), "self.y");
        addBooleanType(new LogicBooleanGameFunctions$RotationBoolean(), "self.dir");
        addBooleanType(new LogicBooleanGameFunctions$MaxMoveSpeedBoolean(), "self.maxMoveSpeed");
        addBooleanType(new LogicBooleanGameFunctions$BuiltAmountBoolean(), "self.builtAmount");
        addBooleanType(new LogicBooleanGameFunctions$CompletedBoolean(), "self.completed");
        addBooleanType(new LogicBooleanGameFunctions$ShieldBoolean(), "self.shield");
        addBooleanType(new LogicBooleanGameFunctions$AmmoBoolean(), "self.ammo");
        addBooleanType((new LogicBooleanGameFunctions$AmmoBoolean()).with("empty=true"), "self.isAmmoEmpty");
        addBooleanType(new LogicBooleanGameFunctions$AmmoIncludingQueuedBoolean(), "self.ammoIncludingQueued");
        addBooleanType(new LogicBooleanGameFunctions$ResourceCountBoolean(), "self.resource");
        addBooleanType(new LogicBooleanGameFunctions$QueueSize(), "self.queueSize");
        addBooleanType(new LogicBooleanGameFunctions$NumberOfConnectionsBoolean(), "self.numberOfConnections");
        addBooleanType(new LogicBooleanGameFunctions$NumberOfAttachedUnitsBoolean(), "self.numberOfAttachedUnits");
        addBooleanType(new LogicBooleanGameFunctions$HasParent(), "self.hasParent");
        addBooleanType(new LogicBooleanGameFunctions$HasResourcesBoolean(), "self.hasResources");
        addBooleanType(new LogicBooleanGameFunctions$IsResourceLargerThan(), "self.isResourceLargerThan");
        addBooleanType(new LogicBooleanGameFunctions$KillsBoolean(), "self.kills");
        addBooleanType(new LogicBooleanGameFunctions$TimeAliveBoolean(), "self.timeAlive");
        addBooleanType(new LogicBooleanGameFunctions$LastConvertedBoolean(), "self.lastConverted");
        addBooleanType(new LogicBooleanGameFunctions$CustomTimerBoolean(), "self.customTimer");
        addBooleanType(new LogicBooleanGameFunctions$HasTakenDamage(), "self.hasTakenDamage");
        addBooleanType(new LogicBooleanGameFunctions$IsAttackingBoolean(), "self.isAttacking");
        addBooleanType(new LogicBooleanGameFunctions$IsReversingBoolean(), "self.isReversing");
        addBooleanType((new LogicBooleanGameFunctions$IsOnTeam()).with("team=-1").createLocked(), "self.isOnNeutralTeam");
        addBooleanType(new LogicBooleanGameFunctions$IsControlledByAI(), "self.isControlledByAI");
        addBooleanType(new LogicBooleanGameFunctions$NumberOfUnitsInTeam(), "numberOfUnitsInTeam", "self.numberOfUnitsInTeam");
        addBooleanType((new LogicBooleanGameFunctions$NumberOfUnitsInTeam()).with("greaterThan=0, lessThan=-1"), "hasUnitInTeam", "self.hasUnitInTeam");
        addBooleanType((new LogicBooleanGameFunctions$NumberOfUnitsInTeam()).with("greaterThan=-1, lessThan=1"), "noUnitInTeam", "self.noUnitInTeam");
        addBooleanType((new LogicBooleanGameFunctions$NumberOfUnitsInTeam()).with("neutralTeam=true"), "numberOfUnitsInNeutralTeam", "self.numberOfUnitsInNeutralTeam");
        addBooleanType((new LogicBooleanGameFunctions$NumberOfUnitsInTeam()).with("aggressiveTeam=true"), "numberOfUnitsInAggressiveTeam", "self.numberOfUnitsInAggressiveTeam");
        addBooleanType((new LogicBooleanGameFunctions$NumberOfUnitsInTeam()).with("allTeams=true"), "numberOfUnitsInAllTeams", "self.numberOfUnitsInAllTeams");
        addBooleanType((new LogicBooleanGameFunctions$NumberOfUnitsInEnemyOrAllyTeam()).with("ally=false"), "numberOfUnitsInEnemyTeam", "self.numberOfUnitsInEnemyTeam");
        addBooleanType((new LogicBooleanGameFunctions$NumberOfUnitsInEnemyOrAllyTeam()).with("ally=true"), "numberOfUnitsInAllyTeam", "self.numberOfUnitsInAllyTeam", "numberOfUnitsInAllyNotOwnTeam", "self.numberOfUnitsInAllyNotOwnTeam");
        addBooleanType((new LogicBooleanGameFunctions$GameModeBoolean()).with("nukesEnabled=true").createLocked(), "game.nukesEnabled");
        addBooleanType(new LogicBooleanGameFunctions$GameMapWidthBoolean(), "game.mapWidth");
        addBooleanType(new LogicBooleanGameFunctions$GameMapHeightBoolean(), "game.mapHeight");
        addBooleanType(new LogicBooleanGameFunctions$ThisActionRepeatedCount(), "thisActionIndex", "index");
    }
}
