package com.example.flickerphotossearexample.model
import com.google.gson.annotations.SerializedName


data class SearchImagesApiModel(
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("stat")
    val stat: String // ok
) {
    data class Photos(
        @SerializedName("page")
        val page: Int, // 1
        @SerializedName("pages")
        val pages: Int, // 25189
        @SerializedName("perpage")
        val perpage: Int, // 5
        @SerializedName("photo")
        val photo: List<Photo>,
        @SerializedName("total")
        val total: String // 125943
    ) {
        data class Photo(
                @SerializedName("farm")
                val farm: Int, // 66
                @SerializedName("height_l")
                val heightL: Int, // 683
                @SerializedName("id")
                val id: String, // 50975449806
                @SerializedName("isfamily")
                val isfamily: Int, // 0
                @SerializedName("isfriend")
                val isfriend: Int, // 0
                @SerializedName("ispublic")
                val ispublic: Int, // 1
                @SerializedName("owner")
                val owner: String, // 133876835@N08
                @SerializedName("secret")
                val secret: String, // da9d5de99c
                @SerializedName("server")
                val server: String, // 65535
                @SerializedName("title")
                val title: String, // Austria / Vorarlberg - Kleinwalsertal
                @SerializedName("url_l")
                val urlL: String? = null, // https://live.staticflickr.com/65535/50975449806_da9d5de99c_b.jpg
                @SerializedName("width_l")
                val widthL: Int // 1024
        )
    }
}