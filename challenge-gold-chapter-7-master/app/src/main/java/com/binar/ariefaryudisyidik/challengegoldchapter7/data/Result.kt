package com.binar.ariefaryudisyidik.challengegoldchapter7.data


sealed class Result<out R> private constructor() {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: String) : Result<Nothing>()
    object loading : Result<Nothing>()
}