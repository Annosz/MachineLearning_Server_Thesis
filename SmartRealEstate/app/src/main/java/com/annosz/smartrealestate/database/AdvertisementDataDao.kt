package com.annosz.smartrealestate.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.annosz.smartrealestate.model.AdvertisementData

@Dao
interface AdvertisementDataDao {
    @Query("SELECT * from advertisementData")
    fun getAll(): List<AdvertisementData>

    @Insert(onConflict = REPLACE)
    fun insert(advertisementData: AdvertisementData)

    @Query("DELETE from advertisementData")
    fun deleteAll()
}