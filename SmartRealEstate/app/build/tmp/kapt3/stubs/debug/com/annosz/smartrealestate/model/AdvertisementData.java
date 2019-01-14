package com.annosz.smartrealestate.model;

import java.lang.System;

@android.arch.persistence.room.Entity(tableName = "advertisementData")
@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b]\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u00b9\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010[\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010;J\t\u0010\\\u001a\u00020\u000bH\u00c6\u0003J\t\u0010]\u001a\u00020\bH\u00c6\u0003J\t\u0010^\u001a\u00020\bH\u00c6\u0003J\t\u0010_\u001a\u00020\u0014H\u00c6\u0003J\t\u0010`\u001a\u00020\bH\u00c6\u0003J\t\u0010a\u001a\u00020\u0014H\u00c6\u0003J\t\u0010b\u001a\u00020\u000bH\u00c6\u0003J\t\u0010c\u001a\u00020\u000bH\u00c6\u0003J\t\u0010d\u001a\u00020\u001aH\u00c6\u0003J\t\u0010e\u001a\u00020\u001aH\u00c6\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010g\u001a\u00020\u001aH\u00c6\u0003J\t\u0010h\u001a\u00020\u0004H\u00c6\u0003J\t\u0010i\u001a\u00020\u0004H\u00c6\u0003J\t\u0010j\u001a\u00020\bH\u00c6\u0003J\t\u0010k\u001a\u00020\bH\u00c6\u0003J\t\u0010l\u001a\u00020\u000bH\u00c6\u0003J\t\u0010m\u001a\u00020\bH\u00c6\u0003J\t\u0010n\u001a\u00020\bH\u00c6\u0003J\t\u0010o\u001a\u00020\bH\u00c6\u0003J\t\u0010p\u001a\u00020\u000bH\u00c6\u0003J\u00ee\u0001\u0010q\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0004H\u00c6\u0001\u00a2\u0006\u0002\u0010rJ\u0013\u0010s\u001a\u00020\u00142\b\u0010t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010u\u001a\u00020\u000bH\u00d6\u0001J\t\u0010v\u001a\u00020\bH\u00d6\u0001R\u001e\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001e\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001e\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\u0016\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00103\"\u0004\b7\u00105R\u001e\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010+R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010/\"\u0004\bD\u00101R\u001e\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010)\"\u0004\bF\u0010+R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010%\"\u0004\bH\u0010\'R\u001e\u0010\u001c\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010!\"\u0004\bJ\u0010#R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010!\"\u0004\bL\u0010#R\u001e\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010)\"\u0004\bN\u0010+R\u001e\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010%\"\u0004\bP\u0010\'R\u001e\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010)\"\u0004\bR\u0010+R\u001e\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010)\"\u0004\bT\u0010+R\u001e\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010%\"\u0004\bV\u0010\'R\u001e\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010%\"\u0004\bX\u0010\'R\u001e\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010)\"\u0004\bZ\u0010+\u00a8\u0006w"}, d2 = {"Lcom/annosz/smartrealestate/model/AdvertisementData;", "", "()V", "id", "", "image", "", "county", "", "city", "postcode", "", "propertyType", "propertySubtype", "propertyConditionType", "propertyFloor", "buildingFloorCount", "viewType", "orientation", "gardenAccess", "", "heatingType", "elevatorType", "roomCount", "smallRoomCount", "propertyArea", "", "balconyArea", "priceCreatedAt", "creationDate", "modificationDate", "(Ljava/lang/Long;[BLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZIIDDDJJ)V", "getBalconyArea", "()D", "setBalconyArea", "(D)V", "getBuildingFloorCount", "()I", "setBuildingFloorCount", "(I)V", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "getCounty", "setCounty", "getCreationDate", "()J", "setCreationDate", "(J)V", "getElevatorType", "()Z", "setElevatorType", "(Z)V", "getGardenAccess", "setGardenAccess", "getHeatingType", "setHeatingType", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getImage", "()[B", "setImage", "([B)V", "getModificationDate", "setModificationDate", "getOrientation", "setOrientation", "getPostcode", "setPostcode", "getPriceCreatedAt", "setPriceCreatedAt", "getPropertyArea", "setPropertyArea", "getPropertyConditionType", "setPropertyConditionType", "getPropertyFloor", "setPropertyFloor", "getPropertySubtype", "setPropertySubtype", "getPropertyType", "setPropertyType", "getRoomCount", "setRoomCount", "getSmallRoomCount", "setSmallRoomCount", "getViewType", "setViewType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;[BLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZIIDDDJJ)Lcom/annosz/smartrealestate/model/AdvertisementData;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class AdvertisementData {
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.PrimaryKey(autoGenerate = true)
    private java.lang.Long id;
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.ColumnInfo(typeAffinity = android.arch.persistence.room.ColumnInfo.BLOB)
    private byte[] image;
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.ColumnInfo(name = "county")
    private java.lang.String county;
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.ColumnInfo(name = "city")
    private java.lang.String city;
    @android.arch.persistence.room.ColumnInfo(name = "postcode")
    private int postcode;
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.ColumnInfo(name = "propertyType")
    private java.lang.String propertyType;
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.ColumnInfo(name = "propertySubtype")
    private java.lang.String propertySubtype;
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.ColumnInfo(name = "propertyConditionType")
    private java.lang.String propertyConditionType;
    @android.arch.persistence.room.ColumnInfo(name = "propertyFloor")
    private int propertyFloor;
    @android.arch.persistence.room.ColumnInfo(name = "buildingFloorCount")
    private int buildingFloorCount;
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.ColumnInfo(name = "viewType")
    private java.lang.String viewType;
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.ColumnInfo(name = "orientation")
    private java.lang.String orientation;
    @android.arch.persistence.room.ColumnInfo(name = "gardenAccess")
    private boolean gardenAccess;
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.ColumnInfo(name = "heatingType")
    private java.lang.String heatingType;
    @android.arch.persistence.room.ColumnInfo(name = "elevatorType")
    private boolean elevatorType;
    @android.arch.persistence.room.ColumnInfo(name = "roomCount")
    private int roomCount;
    @android.arch.persistence.room.ColumnInfo(name = "smallRoomCount")
    private int smallRoomCount;
    @android.arch.persistence.room.ColumnInfo(name = "propertyArea")
    private double propertyArea;
    @android.arch.persistence.room.ColumnInfo(name = "balconyArea")
    private double balconyArea;
    @android.arch.persistence.room.ColumnInfo(name = "priceCreatedAt")
    private double priceCreatedAt;
    @android.arch.persistence.room.ColumnInfo(name = "creationDate")
    private long creationDate;
    @android.arch.persistence.room.ColumnInfo(name = "modificationDate")
    private long modificationDate;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final byte[] getImage() {
        return null;
    }
    
    public final void setImage(@org.jetbrains.annotations.Nullable()
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCounty() {
        return null;
    }
    
    public final void setCounty(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCity() {
        return null;
    }
    
    public final void setCity(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getPostcode() {
        return 0;
    }
    
    public final void setPostcode(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPropertyType() {
        return null;
    }
    
    public final void setPropertyType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPropertySubtype() {
        return null;
    }
    
    public final void setPropertySubtype(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPropertyConditionType() {
        return null;
    }
    
    public final void setPropertyConditionType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getPropertyFloor() {
        return 0;
    }
    
    public final void setPropertyFloor(int p0) {
    }
    
    public final int getBuildingFloorCount() {
        return 0;
    }
    
    public final void setBuildingFloorCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getViewType() {
        return null;
    }
    
    public final void setViewType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrientation() {
        return null;
    }
    
    public final void setOrientation(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getGardenAccess() {
        return false;
    }
    
    public final void setGardenAccess(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHeatingType() {
        return null;
    }
    
    public final void setHeatingType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getElevatorType() {
        return false;
    }
    
    public final void setElevatorType(boolean p0) {
    }
    
    public final int getRoomCount() {
        return 0;
    }
    
    public final void setRoomCount(int p0) {
    }
    
    public final int getSmallRoomCount() {
        return 0;
    }
    
    public final void setSmallRoomCount(int p0) {
    }
    
    public final double getPropertyArea() {
        return 0.0;
    }
    
    public final void setPropertyArea(double p0) {
    }
    
    public final double getBalconyArea() {
        return 0.0;
    }
    
    public final void setBalconyArea(double p0) {
    }
    
    public final double getPriceCreatedAt() {
        return 0.0;
    }
    
    public final void setPriceCreatedAt(double p0) {
    }
    
    public final long getCreationDate() {
        return 0L;
    }
    
    public final void setCreationDate(long p0) {
    }
    
    public final long getModificationDate() {
        return 0L;
    }
    
    public final void setModificationDate(long p0) {
    }
    
    public AdvertisementData(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.Nullable()
    byte[] image, @org.jetbrains.annotations.NotNull()
    java.lang.String county, @org.jetbrains.annotations.NotNull()
    java.lang.String city, int postcode, @org.jetbrains.annotations.NotNull()
    java.lang.String propertyType, @org.jetbrains.annotations.NotNull()
    java.lang.String propertySubtype, @org.jetbrains.annotations.NotNull()
    java.lang.String propertyConditionType, int propertyFloor, int buildingFloorCount, @org.jetbrains.annotations.NotNull()
    java.lang.String viewType, @org.jetbrains.annotations.NotNull()
    java.lang.String orientation, boolean gardenAccess, @org.jetbrains.annotations.NotNull()
    java.lang.String heatingType, boolean elevatorType, int roomCount, int smallRoomCount, double propertyArea, double balconyArea, double priceCreatedAt, long creationDate, long modificationDate) {
        super();
    }
    
    public AdvertisementData() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final byte[] component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int component10() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    public final boolean component13() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final int component16() {
        return 0;
    }
    
    public final int component17() {
        return 0;
    }
    
    public final double component18() {
        return 0.0;
    }
    
    public final double component19() {
        return 0.0;
    }
    
    public final double component20() {
        return 0.0;
    }
    
    public final long component21() {
        return 0L;
    }
    
    public final long component22() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.annosz.smartrealestate.model.AdvertisementData copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.Nullable()
    byte[] image, @org.jetbrains.annotations.NotNull()
    java.lang.String county, @org.jetbrains.annotations.NotNull()
    java.lang.String city, int postcode, @org.jetbrains.annotations.NotNull()
    java.lang.String propertyType, @org.jetbrains.annotations.NotNull()
    java.lang.String propertySubtype, @org.jetbrains.annotations.NotNull()
    java.lang.String propertyConditionType, int propertyFloor, int buildingFloorCount, @org.jetbrains.annotations.NotNull()
    java.lang.String viewType, @org.jetbrains.annotations.NotNull()
    java.lang.String orientation, boolean gardenAccess, @org.jetbrains.annotations.NotNull()
    java.lang.String heatingType, boolean elevatorType, int roomCount, int smallRoomCount, double propertyArea, double balconyArea, double priceCreatedAt, long creationDate, long modificationDate) {
        return null;
    }
    
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(java.lang.Object p0) {
        return false;
    }
}