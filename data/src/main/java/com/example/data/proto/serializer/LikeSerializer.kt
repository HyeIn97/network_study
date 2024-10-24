package com.example.data.proto.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.data.proto.LikeProto
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object LikeSerializer : Serializer<LikeProto> {
    override val defaultValue: LikeProto = LikeProto.getDefaultInstance()
    override suspend fun readFrom(input: InputStream): LikeProto {
        try {
            return LikeProto.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: LikeProto, output: OutputStream) = t.writeTo(output)
}