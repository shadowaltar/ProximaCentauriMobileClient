package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.utils.CrossRealmType;
import com.ageofaquarius.proximacentauri.gaming.environment.Realm;

/**
 * Created by Mars on 2016-12-19.
 */

public class CanCrossRealm extends Capability {
    private Realm fromRealm;
    private Realm toRealm;
    private CrossRealmType type;
}
