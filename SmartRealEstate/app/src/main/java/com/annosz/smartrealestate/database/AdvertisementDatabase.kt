package com.annosz.smartrealestate.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.annosz.smartrealestate.model.AdvertisementData

@Database(entities = arrayOf(AdvertisementData::class), version = 3)
abstract class AdvertisementDatabase : RoomDatabase() {

    abstract fun advertisementDataDao(): AdvertisementDataDao

    companion object {
        private var INSTANCE: AdvertisementDatabase? = null

        fun getInstance(context: Context): AdvertisementDatabase? {
            if (INSTANCE == null) {
                synchronized(AdvertisementDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AdvertisementDatabase::class.java, "advertisement.db")
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}