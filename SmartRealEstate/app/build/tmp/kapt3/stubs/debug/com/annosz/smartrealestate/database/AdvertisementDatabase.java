package com.annosz.smartrealestate.database;

import java.lang.System;

@android.arch.persistence.room.Database(entities = {com.annosz.smartrealestate.model.AdvertisementData.class}, version = 3)
@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/annosz/smartrealestate/database/AdvertisementDatabase;", "Landroid/arch/persistence/room/RoomDatabase;", "()V", "advertisementDataDao", "Lcom/annosz/smartrealestate/database/AdvertisementDataDao;", "Companion", "app_debug"})
public abstract class AdvertisementDatabase extends android.arch.persistence.room.RoomDatabase {
    private static com.annosz.smartrealestate.database.AdvertisementDatabase INSTANCE;
    public static final com.annosz.smartrealestate.database.AdvertisementDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.annosz.smartrealestate.database.AdvertisementDataDao advertisementDataDao();
    
    public AdvertisementDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/annosz/smartrealestate/database/AdvertisementDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/annosz/smartrealestate/database/AdvertisementDatabase;", "destroyInstance", "", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.annosz.smartrealestate.database.AdvertisementDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        public final void destroyInstance() {
        }
        
        private Companion() {
            super();
        }
    }
}