package com.osrs.game.network.packet.client.reader.impl

import com.google.inject.Singleton
import com.osrs.game.network.packet.client.WindowStatusPacket
import com.osrs.game.network.packet.client.reader.PacketReader
import io.ktor.utils.io.ByteReadChannel

@Singleton
class WindowStatusPacketReader : PacketReader<WindowStatusPacket>(
    opcode = 10,
    size = 5
) {
    override suspend fun read(readChannel: ByteReadChannel, size: Int) : WindowStatusPacket = WindowStatusPacket(
        displayMode = readChannel.readByte().toInt(),
        width = readChannel.readShort().toInt(),
        height =  readChannel.readShort().toInt()
    )
}
