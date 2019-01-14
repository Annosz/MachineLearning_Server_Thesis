package com.annosz.smartrealestate.model

import android.arch.persistence.room.*

@Entity(tableName = "advertisementData")
data class AdvertisementData(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        @ColumnInfo(typeAffinity = ColumnInfo.BLOB) var image: ByteArray?,
        @ColumnInfo(name = "county") var county: String,
        @ColumnInfo(name = "city") var city: String,
        @ColumnInfo(name = "postcode") var postcode: Int,
        @ColumnInfo(name = "propertyType") var propertyType: String,
        @ColumnInfo(name = "propertySubtype") var propertySubtype: String,
        @ColumnInfo(name = "propertyConditionType") var propertyConditionType: String,
        @ColumnInfo(name = "propertyFloor") var propertyFloor: Int,
        @ColumnInfo(name = "buildingFloorCount") var buildingFloorCount: Int,
        @ColumnInfo(name = "viewType") var viewType: String,
        @ColumnInfo(name = "orientation") var orientation: String,
        @ColumnInfo(name = "gardenAccess") var gardenAccess: Boolean,
        @ColumnInfo(name = "heatingType") var heatingType: String,
        @ColumnInfo(name = "elevatorType") var elevatorType: Boolean,
        @ColumnInfo(name = "roomCount") var roomCount: Int,
        @ColumnInfo(name = "smallRoomCount") var smallRoomCount: Int,
        @ColumnInfo(name = "propertyArea") var propertyArea: Double,
        @ColumnInfo(name = "balconyArea") var balconyArea: Double,
        @ColumnInfo(name = "priceCreatedAt") var priceCreatedAt: Double,
        @ColumnInfo(name = "creationDate") var creationDate: Long,
        @ColumnInfo(name = "modificationDate") var modificationDate: Long
){
    constructor():this(null,null, "","",0,"","",
            "",0,0, "", "",
            false, "", false, 0, 0,
            0.0, 0.0, 0.0, 0,0)
}