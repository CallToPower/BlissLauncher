package org.indin.blisslaunchero.features.launcher;

import com.jakewharton.rxrelay2.BehaviorRelay;

import org.indin.blisslaunchero.core.database.model.LauncherItem;

import java.util.List;

public class AppsRepository {

    private static final String TAG = "AppsRepository";
    private BehaviorRelay<List<LauncherItem>> appsRelay;

    private static AppsRepository sAppsRepository;

    private AppsRepository() {
        appsRelay = BehaviorRelay.create();
    }

    public static AppsRepository getAppsRepository() {
        if (sAppsRepository == null) {
            sAppsRepository = new AppsRepository();
        }
        return sAppsRepository;
    }

    public void updateAppsRelay(List<LauncherItem> launcherItems) {
        this.appsRelay.accept(launcherItems);
    }

    public BehaviorRelay<List<LauncherItem>> getAppsRelay() {
        return appsRelay;
    }
}
