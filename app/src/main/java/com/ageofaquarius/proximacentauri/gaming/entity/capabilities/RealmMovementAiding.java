package com.ageofaquarius.proximacentauri.gaming.entity.capabilities;

import com.ageofaquarius.proximacentauri.gaming.environment.Realm;

import java.util.HashSet;

/**
 * Created by Mars on 2016-12-27.
 */

public class RealmMovementAiding extends Capability {
    private HashSet<RealmPairAiding> aidingRealmPairs;

    public class RealmPairAiding {
        private Realm fromRealm;
        private Realm toRealm;
        private boolean isAdditionalRoundNeeded;
        private boolean isEnabled;
    }
}
