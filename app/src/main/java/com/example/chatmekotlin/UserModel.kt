package com.example.chatmekotlin

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

data class UserModel(
    var name: String = "",
    val status: String = "",
    val image: String = "",
    var number: String = "",
    val uid: String = "",
    val online: String = "offline",
    val typing: String = "false"
) {

    /**write binding adapter to show the image in profile fragment,
    to deal with returned url from firebase and load it to imageView */
    companion object {
        @JvmStatic
        /** using this "imageUrl" instead of "imageSource" in CircleImageView in profile fragment */
        @BindingAdapter("imageUrl")
        fun loadImage(view: CircleImageView, imageUrl: String?) {
            imageUrl?.let {
                Glide.with(view.context).load(imageUrl).into(view)
            }
        }
    }

}

