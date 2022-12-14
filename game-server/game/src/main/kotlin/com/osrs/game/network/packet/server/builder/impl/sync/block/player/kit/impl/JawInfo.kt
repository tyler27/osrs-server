package com.osrs.game.network.packet.server.builder.impl.sync.block.player.kit.impl

import com.osrs.game.actor.player.Equipment
import com.osrs.game.actor.render.RenderBlock
import com.osrs.game.network.packet.server.builder.impl.sync.block.player.kit.BodyPartCompanion
import com.osrs.game.network.packet.server.builder.impl.sync.block.player.kit.BodyPartInfo
import io.ktor.utils.io.core.BytePacketBuilder
import io.ktor.utils.io.core.writeShort

class JawInfo : BodyPartInfo(index = 11) {
    override fun equipmentIndex(gender: RenderBlock.Appearance.Gender): Int =
        if (gender === RenderBlock.Appearance.Gender.MALE) Equipment.SLOT_HEAD else Equipment.SLOT_CHEST

    override fun build(builder: BytePacketBuilder, kit: BodyPartCompanion) {
        if (kit.gender === RenderBlock.Appearance.Gender.MALE) {
            builder.writeShort((0x100 + kit.id).toShort())
        } else {
            builder.writeByte(0)
        }
    }
}
