package com.osrs.game.network.packet.server.builder.impl

import com.google.inject.Inject
import com.google.inject.Singleton
import com.osrs.common.buffer.writeInt
import com.osrs.common.buffer.writeShort
import com.osrs.common.buffer.writeShortLittleEndian
import com.osrs.common.buffer.writeShortLittleEndianAdd
import com.osrs.common.map.MapSquares
import com.osrs.game.network.packet.server.RebuildNormalPacket
import com.osrs.game.network.packet.server.builder.PacketBuilder
import java.nio.ByteBuffer

@Singleton
class RebuildNormalPacketBuilder @Inject constructor(
    private val mapSquares: MapSquares
) : PacketBuilder<RebuildNormalPacket>(
    opcode = 103,
    size = -2
) {
    override fun build(packet: RebuildNormalPacket, buffer: ByteBuffer) {
        if (packet.initialize) packet.viewport.init(buffer)

        val zoneX = packet.location.zoneX
        val zoneZ = packet.location.zoneZ

        buffer.writeShortLittleEndian(zoneX)
        buffer.writeShortLittleEndianAdd(zoneZ)

        val zonesX = ((zoneX - 6) / 8..(zoneX + 6) / 8)
        val zonesZ = ((zoneZ - 6) / 8..(zoneZ + 6) / 8)

        buffer.writeShort(zonesX.count() * zonesZ.count())

        for (x in zonesX) {
            for (z in zonesZ) {
                val id = z + (x shl 8)
                val xteaKeys = mapSquares[id]?.key ?: throw IllegalStateException("Missing data for map square with id: $id")
                for (key in xteaKeys) {
                    buffer.writeInt(key)
                }
            }
        }
    }
}
