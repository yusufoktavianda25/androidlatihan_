package binar.academy.mycatalogmovies.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserRoomDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
}