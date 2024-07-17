package binar.academy.mycatalogmovies.data.local

import androidx.room.*

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Query("SELECT * FROM user WHERE email LIKE :email AND password LIKE :password")
    suspend fun checkUser(email: String, password: String): User

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUser(id: Int): User
}