package com.cikyra.hometeam.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cikyra.hometeam.data.datasource.local.dao.AnnouncementDao
import com.cikyra.hometeam.data.datasource.local.dao.SchoolDao
import com.cikyra.hometeam.data.model.local.AnnouncementEntity
import com.cikyra.hometeam.data.model.local.SchoolEntity

@TypeConverters(RoomTypeConverters::class)
@Database(version = 1, entities = [
    AnnouncementEntity::class,
    SchoolEntity::class
], exportSchema = false)
abstract class HomeTeamDatabase: RoomDatabase() {
    abstract fun getSchoolDao(): SchoolDao
    abstract fun getAnnouncementDao(): AnnouncementDao
}