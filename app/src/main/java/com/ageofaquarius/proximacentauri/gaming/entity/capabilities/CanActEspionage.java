package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.actions.Action;
import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.utils.EspionageActionType;

/**
 * Created by Mars on 2016-12-19.
 */

public class CanActEspionage extends Capability {
    private EspionageActionType[] availableActions;
    private EspionageActionType currentAction;
    private boolean isConcealing;
    private EspionageActionType autoAction;
    private Action wakeUpBy;
}
