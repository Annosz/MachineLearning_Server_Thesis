package com.annosz.smartrealestate.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class AdvertisementDatabase_Impl extends AdvertisementDatabase {
  private volatile AdvertisementDataDao _advertisementDataDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `advertisementData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `image` BLOB, `county` TEXT NOT NULL, `city` TEXT NOT NULL, `postcode` INTEGER NOT NULL, `propertyType` TEXT NOT NULL, `propertySubtype` TEXT NOT NULL, `propertyConditionType` TEXT NOT NULL, `propertyFloor` INTEGER NOT NULL, `buildingFloorCount` INTEGER NOT NULL, `viewType` TEXT NOT NULL, `orientation` TEXT NOT NULL, `gardenAccess` INTEGER NOT NULL, `heatingType` TEXT NOT NULL, `elevatorType` INTEGER NOT NULL, `roomCount` INTEGER NOT NULL, `smallRoomCount` INTEGER NOT NULL, `propertyArea` REAL NOT NULL, `balconyArea` REAL NOT NULL, `priceCreatedAt` REAL NOT NULL, `creationDate` INTEGER NOT NULL, `modificationDate` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"d38e03c1eacb72ed729bf5d3632e5c31\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `advertisementData`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAdvertisementData = new HashMap<String, TableInfo.Column>(22);
        _columnsAdvertisementData.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsAdvertisementData.put("image", new TableInfo.Column("image", "BLOB", false, 0));
        _columnsAdvertisementData.put("county", new TableInfo.Column("county", "TEXT", true, 0));
        _columnsAdvertisementData.put("city", new TableInfo.Column("city", "TEXT", true, 0));
        _columnsAdvertisementData.put("postcode", new TableInfo.Column("postcode", "INTEGER", true, 0));
        _columnsAdvertisementData.put("propertyType", new TableInfo.Column("propertyType", "TEXT", true, 0));
        _columnsAdvertisementData.put("propertySubtype", new TableInfo.Column("propertySubtype", "TEXT", true, 0));
        _columnsAdvertisementData.put("propertyConditionType", new TableInfo.Column("propertyConditionType", "TEXT", true, 0));
        _columnsAdvertisementData.put("propertyFloor", new TableInfo.Column("propertyFloor", "INTEGER", true, 0));
        _columnsAdvertisementData.put("buildingFloorCount", new TableInfo.Column("buildingFloorCount", "INTEGER", true, 0));
        _columnsAdvertisementData.put("viewType", new TableInfo.Column("viewType", "TEXT", true, 0));
        _columnsAdvertisementData.put("orientation", new TableInfo.Column("orientation", "TEXT", true, 0));
        _columnsAdvertisementData.put("gardenAccess", new TableInfo.Column("gardenAccess", "INTEGER", true, 0));
        _columnsAdvertisementData.put("heatingType", new TableInfo.Column("heatingType", "TEXT", true, 0));
        _columnsAdvertisementData.put("elevatorType", new TableInfo.Column("elevatorType", "INTEGER", true, 0));
        _columnsAdvertisementData.put("roomCount", new TableInfo.Column("roomCount", "INTEGER", true, 0));
        _columnsAdvertisementData.put("smallRoomCount", new TableInfo.Column("smallRoomCount", "INTEGER", true, 0));
        _columnsAdvertisementData.put("propertyArea", new TableInfo.Column("propertyArea", "REAL", true, 0));
        _columnsAdvertisementData.put("balconyArea", new TableInfo.Column("balconyArea", "REAL", true, 0));
        _columnsAdvertisementData.put("priceCreatedAt", new TableInfo.Column("priceCreatedAt", "REAL", true, 0));
        _columnsAdvertisementData.put("creationDate", new TableInfo.Column("creationDate", "INTEGER", true, 0));
        _columnsAdvertisementData.put("modificationDate", new TableInfo.Column("modificationDate", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAdvertisementData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAdvertisementData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAdvertisementData = new TableInfo("advertisementData", _columnsAdvertisementData, _foreignKeysAdvertisementData, _indicesAdvertisementData);
        final TableInfo _existingAdvertisementData = TableInfo.read(_db, "advertisementData");
        if (! _infoAdvertisementData.equals(_existingAdvertisementData)) {
          throw new IllegalStateException("Migration didn't properly handle advertisementData(com.annosz.smartrealestate.model.AdvertisementData).\n"
                  + " Expected:\n" + _infoAdvertisementData + "\n"
                  + " Found:\n" + _existingAdvertisementData);
        }
      }
    }, "d38e03c1eacb72ed729bf5d3632e5c31", "d543252f173a2341a21a96b331b6a5fe");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "advertisementData");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `advertisementData`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public AdvertisementDataDao advertisementDataDao() {
    if (_advertisementDataDao != null) {
      return _advertisementDataDao;
    } else {
      synchronized(this) {
        if(_advertisementDataDao == null) {
          _advertisementDataDao = new AdvertisementDataDao_Impl(this);
        }
        return _advertisementDataDao;
      }
    }
  }
}
