package com.example.wallpaper.common

sealed class Resource<T>(val data: T? = null, val error: Exception? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(error: Exception, data: T? = null) : Resource<T>(data, error)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}