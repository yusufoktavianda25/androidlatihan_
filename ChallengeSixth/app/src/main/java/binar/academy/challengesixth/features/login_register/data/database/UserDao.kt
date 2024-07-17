package binar.academy.challengesixth.features.login_register.data.database

import androidx.room.*
import binar.academy.challengesixth.features.login_register.data.User

@Dao
interface UserDao {
    @Insert
    fun addUser(user: User): Long

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM user WHERE email = :email")
    fun getUsername(email: String?): List<User>

    @Query("UPDATE User SET username = :username ,fullName=:fullname ,born= :birthdate ,address= :address WHERE email= :email")
    fun updateData(
        email: String? = null,
        username: String? = null,
        fullname: String? = null,
        birthdate: String? = null,
        address: String? = null
    ): Int
}