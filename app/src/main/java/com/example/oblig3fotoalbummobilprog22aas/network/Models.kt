package com.example.oblig3fotoalbummobilprog22aas.network
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//class Users : ArrayList<UsersItem>()
//class Albums : ArrayList<AlbumsItem>()
//class Photos : ArrayList<PhotosItem>()

@Parcelize
data class Users(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
) : Parcelable

@Parcelize
data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
) : Parcelable

@Parcelize
data class Geo(
    val lat: String,
    val lng: String
) : Parcelable

@Parcelize
data class Company(
    val bs: String,
    val catchPhrase: String,
    val name: String
) : Parcelable

@Parcelize
data class AlbumsItem(
    val id: Int,
    val title: String,
    val userId: Int
) : Parcelable

@Parcelize
data class PhotosItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
) : Parcelable