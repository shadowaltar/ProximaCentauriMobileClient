package com.ageofaquarius.proximacentauri.gaming.faction;

import com.ageofaquarius.proximacentauri.gaming.entity.City;
import com.ageofaquarius.proximacentauri.gaming.entity.Structure;
import com.ageofaquarius.proximacentauri.gaming.entity.Unit;
import com.ageofaquarius.proximacentauri.gaming.governing.Diplomacy;
import com.ageofaquarius.proximacentauri.gaming.governing.SocietyPolicy;
import com.ageofaquarius.proximacentauri.gaming.tech.Research;
import com.ageofaquarius.proximacentauri.gaming.tech.ResearchConstraint;

import java.util.List;

/**
 * Created by Mars on 2016-11-17.
 */

public interface Faction {

    Leader getLeader();

    List<Unit> getAllUnits();

    List<City> getAllCities();

    List<Structure> getAllStructures();

    List<Structure> getAllControllables();

    City getCapital();

    List<Research> getAcquiredResearchItems();

    List<Research> getCurrentResearchItems();

    List<String> getCurrentResearchDirection();

    List<Research> getResearchItems();

    List<Research> getInnateResearchItems();

    List<SocietyModifier> getCurrentSocietyModifier();

    List<SocietyModifier> getInnateSocietyModifier();

    List<SocietyPolicy> getCurrentSocietyPolicy();

    int getPopulation();

    int getFactionStartYear();

    int getFactionEndYear();

    Faction fromFaction();

    Faction destroyByFaction();

    List<Diplomacy> getDiplomacies();

    List<Trading> getTradings();

    List<ResearchConstraint> getLiftedResearchConstraints();

    List<ResearchConstraint> getCurrentResearchConstraints();

    double getBureaucracyLevel();

    boolean isInTerritory(Unit unit);

    boolean isOwned(Unit unit);

    boolean isPlayer();

    boolean isComputer();
}