package com.osrs.game.network.packet.server

import com.osrs.game.network.packet.Packet

data class IfOpenSubPacket(
    val interfaceId: Int,
    val toInterface: Int,
    val clickThrough: Boolean
) : Packet