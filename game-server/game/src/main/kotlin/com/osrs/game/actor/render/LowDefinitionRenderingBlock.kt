package com.osrs.game.actor.render

import com.osrs.game.actor.Actor
import com.osrs.game.network.packet.builder.impl.sync.RenderingBlock

data class LowDefinitionRenderingBlock<T : Actor, R : RenderType>(
    val renderType: RenderType,
    override val block: RenderingBlock<T, R>,
    val bytes: ByteArray
) : AbstractRenderingBlock<T, R>(block) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LowDefinitionRenderingBlock<*, *>

        if (renderType != other.renderType) return false
        if (block != other.block) return false
        if (!bytes.contentEquals(other.bytes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = renderType.hashCode()
        result = 31 * result + block.hashCode()
        result = 31 * result + bytes.contentHashCode()
        return result
    }
}
