package com.example.data.proto

data class ProtoLikeEntity(
    val protoLike: ArrayList<ProtoLikeLikeEntity>
) {
    data class ProtoLikeLikeEntity(
        val link: String,
        val name: String
    )
}