package com.ageofaquarius.proximacentauri.gaming.behavior;

import com.ageofaquarius.proximacentauri.gaming.Action;
import com.ageofaquarius.proximacentauri.gaming.entity.MapObject;
import com.ageofaquarius.proximacentauri.gaming.entity.Unit;
import com.ageofaquarius.proximacentauri.gaming.entity.Zone;
import com.ageofaquarius.proximacentauri.gaming.entity.ability.PatrolRoute;
import com.ageofaquarius.proximacentauri.gaming.environment.Coordinate;

import java.util.List;

/**
 * Created by Mars on 2016-11-28.
 */

public interface UnitBehaviors {
    List<Action> getOnInitialized();

    List<Action> getOnCreating();
    List<Action> getOnCreated();

    List<Action> getOnBuilding();
    List<Action> getOnBuilt();

    List<Action> getOnDamaging();
    List<Action> getOnDamaged();
    List<Action> getOnDestroying();
    List<Action> getOnDestroyed();

    List<Action> getOnMoving(Coordinate destination);
    List<Action> getOnMoved(Coordinate destination);
    List<Action> getOnPatrolStarted(PatrolRoute route);
    List<Action> getOnPatrolStopped(PatrolRoute route);

    List<Action> getOnEncountering(MapObject target);
    List<Action> getOnEncountered(MapObject target);

    List<Action> getOnProducing(List<MapObject> products);
    List<Action> getOnProduced(List<MapObject> products);
    List<Action> getOnRazing(List<MapObject> targets);
    List<Action> getOnRazed(List<MapObject> targets);

    List<Action> getOnAttacking(MapObject target);
    List<Action> getOnAttacked(MapObject target);
    List<Action> getOnDefending(MapObject attacker);
    List<Action> getOnDefended(MapObject attacker);

    List<Action> getOnSelfHealing();
    List<Action> getOnSelfHealed();
    List<Action> getOnHealing(MapObject target);
    List<Action> getOnHealed(MapObject target);

    List<Action> getOnObjectSighting(MapObject object);
    List<Action> getOnObjectSighted(MapObject object);
    List<Action> getOnObjectUnsighting(MapObject object);
    List<Action> getOnObjectUnsighted(MapObject object);

    List<Action> getOnUpgradeAvailable(MapObject target);
    List<Action> getOnUpgraded(MapObject target);
    List<Action> getOnLevelUp();

    List<Action> getOnEnterZOC(MapObject zocOwner);
    List<Action> getOnExitZOC(MapObject zocOwner);
    List<Action> getOnBeingEnteredZOC(MapObject enterer);
    List<Action> getOnBeingExitedZOC(MapObject exiter);

    List<Action> getOnStepInside(Zone zone);
    List<Action> getOnStepOutOf(Zone zone);

    List<Action> getOnLoading(Unit unit);
    List<Action> getOnLoaded(Unit unit);
    List<Action> getOnUnloading(Unit unit);
    List<Action> getOnUnloaded(Unit unit);
    List<Action> getOnBoarding(Unit transporter);
    List<Action> getOnBoarded(Unit transporter);
    List<Action> getOnDebarking(Unit transporter);
    List<Action> getOnDebarked(Unit transporter);

    List<Action> getOnLifting();
    List<Action> getOnLifted();
    List<Action> getOnLeavingAtmosphere();
    List<Action> getOnLeftAtmosphere();
    List<Action> getOnPlanetfalling();
    List<Action> getOnPlanetfalled();
    List<Action> getOnEnteringAtmosphere();
    List<Action> getOnEnteredAtmosphere();

    List<Action> getOnEnteringSupportRange();
    List<Action> getOnEnteredSupportRange();
    List<Action> getOnExitingSupportRange();
    List<Action> getOnExitedSupportRange();
    List<Action> getOnExtendedSupportRange();
    List<Action> getOnContractedSupportRange();
    List<Action> getOnAddUnitToSupportList(Unit supportee);
    List<Action> getOnRemoveUnitToSupportList(Unit supportee);

    List<Action> getOnResourceGatheringStart();
    List<Action> getOnResourceGatheringEnd();
    List<Action> getOnResourceReturningStart();
    List<Action> getOnResourceReturningEnd();
    List<Action> getOnResourceBackToGatheringStart();
    List<Action> getOnResourceBackToGatheringEnd();

}
