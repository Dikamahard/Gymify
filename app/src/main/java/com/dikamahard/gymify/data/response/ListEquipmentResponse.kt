package com.dikamahard.gymify.data.response

import com.google.gson.annotations.SerializedName

data class ListEquipmentResponse (

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("equipment")
    val equipment: ArrayList<EquipmentItem>
)

data class EquipmentItem(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("ref1Url")
    val ref1Url: String,

    @field:SerializedName("ref2Url")
    val ref2Url: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("photoUrl")
    val photoUrl: String,
)