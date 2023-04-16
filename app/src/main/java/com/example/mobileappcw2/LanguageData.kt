package com.example.mobileappcw2

data class LanguageData(val title : String , val picture : Int,  var isLiked: Boolean = false) {
    fun toggleLike() {
        isLiked = !isLiked
    }
}
