package com.osrs.game.tick.task.player

import com.osrs.game.actor.player.Player
import com.osrs.game.network.packet.server.builder.impl.sync.syncAndWritePlayers
import com.osrs.game.tick.task.SyncTask
import com.osrs.game.world.World

class PlayerSyncTask(
    val world: World
) : SyncTask {

    override fun sync() {
        val players = world.players.filterNotNull().filter { it.online }
        players.forEach(Player::syncAndWritePlayers)
        players.forEach(Player::reset)
        players.forEach(Player::writeAndFlush)
    }
}
