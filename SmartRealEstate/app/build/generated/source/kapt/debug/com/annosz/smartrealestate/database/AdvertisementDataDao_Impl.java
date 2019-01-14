package com.annosz.smartrealestate.database;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.annosz.smartrealestate.model.AdvertisementData;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class AdvertisementDataDao_Impl implements AdvertisementDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAdvertisementData;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public AdvertisementDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAdvertisementData = new EntityInsertionAdapter<AdvertisementData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `advertisementData`(`id`,`image`,`county`,`city`,`postcode`,`propertyType`,`propertySubtype`,`propertyConditionType`,`propertyFloor`,`buildingFloorCount`,`viewType`,`orientation`,`gardenAccess`,`heatingType`,`elevatorType`,`roomCount`,`smallRoomCount`,`propertyArea`,`balconyArea`,`priceCreatedAt`,`creationDate`,`modificationDate`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AdvertisementData value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getImage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindBlob(2, value.getImage());
        }
        if (value.getCounty() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCounty());
        }
        if (value.getCity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCity());
        }
        stmt.bindLong(5, value.getPostcode());
        if (value.getPropertyType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPropertyType());
        }
        if (value.getPropertySubtype() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPropertySubtype());
        }
        if (value.getPropertyConditionType() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPropertyConditionType());
        }
        stmt.bindLong(9, value.getPropertyFloor());
        stmt.bindLong(10, value.getBuildingFloorCount());
        if (value.getViewType() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getViewType());
        }
        if (value.getOrientation() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getOrientation());
        }
        final int _tmp;
        _tmp = value.getGardenAccess() ? 1 : 0;
        stmt.bindLong(13, _tmp);
        if (value.getHeatingType() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getHeatingType());
        }
        final int _tmp_1;
        _tmp_1 = value.getElevatorType() ? 1 : 0;
        stmt.bindLong(15, _tmp_1);
        stmt.bindLong(16, value.getRoomCount());
        stmt.bindLong(17, value.getSmallRoomCount());
        stmt.bindDouble(18, value.getPropertyArea());
        stmt.bindDouble(19, value.getBalconyArea());
        stmt.bindDouble(20, value.getPriceCreatedAt());
        stmt.bindLong(21, value.getCreationDate());
        stmt.bindLong(22, value.getModificationDate());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from advertisementData";
        return _query;
      }
    };
  }

  @Override
  public void insert(AdvertisementData advertisementData) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAdvertisementData.insert(advertisementData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<AdvertisementData> getAll() {
    final String _sql = "SELECT * from advertisementData";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
      final int _cursorIndexOfCounty = _cursor.getColumnIndexOrThrow("county");
      final int _cursorIndexOfCity = _cursor.getColumnIndexOrThrow("city");
      final int _cursorIndexOfPostcode = _cursor.getColumnIndexOrThrow("postcode");
      final int _cursorIndexOfPropertyType = _cursor.getColumnIndexOrThrow("propertyType");
      final int _cursorIndexOfPropertySubtype = _cursor.getColumnIndexOrThrow("propertySubtype");
      final int _cursorIndexOfPropertyConditionType = _cursor.getColumnIndexOrThrow("propertyConditionType");
      final int _cursorIndexOfPropertyFloor = _cursor.getColumnIndexOrThrow("propertyFloor");
      final int _cursorIndexOfBuildingFloorCount = _cursor.getColumnIndexOrThrow("buildingFloorCount");
      final int _cursorIndexOfViewType = _cursor.getColumnIndexOrThrow("viewType");
      final int _cursorIndexOfOrientation = _cursor.getColumnIndexOrThrow("orientation");
      final int _cursorIndexOfGardenAccess = _cursor.getColumnIndexOrThrow("gardenAccess");
      final int _cursorIndexOfHeatingType = _cursor.getColumnIndexOrThrow("heatingType");
      final int _cursorIndexOfElevatorType = _cursor.getColumnIndexOrThrow("elevatorType");
      final int _cursorIndexOfRoomCount = _cursor.getColumnIndexOrThrow("roomCount");
      final int _cursorIndexOfSmallRoomCount = _cursor.getColumnIndexOrThrow("smallRoomCount");
      final int _cursorIndexOfPropertyArea = _cursor.getColumnIndexOrThrow("propertyArea");
      final int _cursorIndexOfBalconyArea = _cursor.getColumnIndexOrThrow("balconyArea");
      final int _cursorIndexOfPriceCreatedAt = _cursor.getColumnIndexOrThrow("priceCreatedAt");
      final int _cursorIndexOfCreationDate = _cursor.getColumnIndexOrThrow("creationDate");
      final int _cursorIndexOfModificationDate = _cursor.getColumnIndexOrThrow("modificationDate");
      final List<AdvertisementData> _result = new ArrayList<AdvertisementData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AdvertisementData _item;
        _item = new AdvertisementData();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final byte[] _tmpImage;
        _tmpImage = _cursor.getBlob(_cursorIndexOfImage);
        _item.setImage(_tmpImage);
        final String _tmpCounty;
        _tmpCounty = _cursor.getString(_cursorIndexOfCounty);
        _item.setCounty(_tmpCounty);
        final String _tmpCity;
        _tmpCity = _cursor.getString(_cursorIndexOfCity);
        _item.setCity(_tmpCity);
        final int _tmpPostcode;
        _tmpPostcode = _cursor.getInt(_cursorIndexOfPostcode);
        _item.setPostcode(_tmpPostcode);
        final String _tmpPropertyType;
        _tmpPropertyType = _cursor.getString(_cursorIndexOfPropertyType);
        _item.setPropertyType(_tmpPropertyType);
        final String _tmpPropertySubtype;
        _tmpPropertySubtype = _cursor.getString(_cursorIndexOfPropertySubtype);
        _item.setPropertySubtype(_tmpPropertySubtype);
        final String _tmpPropertyConditionType;
        _tmpPropertyConditionType = _cursor.getString(_cursorIndexOfPropertyConditionType);
        _item.setPropertyConditionType(_tmpPropertyConditionType);
        final int _tmpPropertyFloor;
        _tmpPropertyFloor = _cursor.getInt(_cursorIndexOfPropertyFloor);
        _item.setPropertyFloor(_tmpPropertyFloor);
        final int _tmpBuildingFloorCount;
        _tmpBuildingFloorCount = _cursor.getInt(_cursorIndexOfBuildingFloorCount);
        _item.setBuildingFloorCount(_tmpBuildingFloorCount);
        final String _tmpViewType;
        _tmpViewType = _cursor.getString(_cursorIndexOfViewType);
        _item.setViewType(_tmpViewType);
        final String _tmpOrientation;
        _tmpOrientation = _cursor.getString(_cursorIndexOfOrientation);
        _item.setOrientation(_tmpOrientation);
        final boolean _tmpGardenAccess;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfGardenAccess);
        _tmpGardenAccess = _tmp != 0;
        _item.setGardenAccess(_tmpGardenAccess);
        final String _tmpHeatingType;
        _tmpHeatingType = _cursor.getString(_cursorIndexOfHeatingType);
        _item.setHeatingType(_tmpHeatingType);
        final boolean _tmpElevatorType;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfElevatorType);
        _tmpElevatorType = _tmp_1 != 0;
        _item.setElevatorType(_tmpElevatorType);
        final int _tmpRoomCount;
        _tmpRoomCount = _cursor.getInt(_cursorIndexOfRoomCount);
        _item.setRoomCount(_tmpRoomCount);
        final int _tmpSmallRoomCount;
        _tmpSmallRoomCount = _cursor.getInt(_cursorIndexOfSmallRoomCount);
        _item.setSmallRoomCount(_tmpSmallRoomCount);
        final double _tmpPropertyArea;
        _tmpPropertyArea = _cursor.getDouble(_cursorIndexOfPropertyArea);
        _item.setPropertyArea(_tmpPropertyArea);
        final double _tmpBalconyArea;
        _tmpBalconyArea = _cursor.getDouble(_cursorIndexOfBalconyArea);
        _item.setBalconyArea(_tmpBalconyArea);
        final double _tmpPriceCreatedAt;
        _tmpPriceCreatedAt = _cursor.getDouble(_cursorIndexOfPriceCreatedAt);
        _item.setPriceCreatedAt(_tmpPriceCreatedAt);
        final long _tmpCreationDate;
        _tmpCreationDate = _cursor.getLong(_cursorIndexOfCreationDate);
        _item.setCreationDate(_tmpCreationDate);
        final long _tmpModificationDate;
        _tmpModificationDate = _cursor.getLong(_cursorIndexOfModificationDate);
        _item.setModificationDate(_tmpModificationDate);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
