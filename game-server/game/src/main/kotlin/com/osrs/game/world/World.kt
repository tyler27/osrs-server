package com.osrs.game.world

import com.osrs.cache.Cache
import com.osrs.cache.entry.map.MapSquareTypeProvider
import com.osrs.common.map.location.Location
import com.osrs.common.map.location.ZoneLocation
import com.osrs.game.actor.PlayerList
import com.osrs.game.actor.player.Player
import com.osrs.game.network.Session
import com.osrs.game.world.map.CollisionMap
import com.osrs.game.world.map.zone.Zone
import com.osrs.game.world.map.zone.ZoneManager
import com.osrs.game.world.service.LoginService
import org.rsmod.pathfinder.StepValidator
import java.util.concurrent.ConcurrentHashMap

data class World(
    val worldId: Int,
    val cache: Cache,
    val loginService: LoginService,
    val maps: MapSquareTypeProvider,
    val collisionMap: CollisionMap,
    val stepValidator: StepValidator,
    val zoneManager: ZoneManager
) {
    val players: PlayerList = PlayerList(MAX_PLAYERS)

    private val loginRequests = ConcurrentHashMap<Player, Session>()
    private val logoutRequest = ConcurrentHashMap<Player, Session>()

    var isOnline = false

    fun start() {
        maps.forEach(collisionMap::applyCollision)
    }

    fun processLoginRequest() {
        if (!isOnline) return

        loginRequests.entries.take(50).onEach {
            players.add(it.key)
            loginService.login(it.key)
        }.also(loginRequests.entries::removeAll)
    }

    fun processLogoutRequest() {
        if (!isOnline) return

        logoutRequest.entries.onEach {
            players.remove(it.key)
            it.key.logout()
        }

        logoutRequest.clear()
    }

    fun requestLogin(player: Player) {
        this.loginRequests[player] = player.session
    }

    fun requestLogout(player: Player) {
        this.logoutRequest[player] = player.session
    }

    fun zone(location: ZoneLocation): Zone {
        return zoneManager[location]
    }

    fun zone(location: Location): Zone {
        return zoneManager[location.zoneLocation]
    }

    @Suppress("UNCHECKED_CAST")
    fun players(): List<Player> = players.filter { it != null && it.online } as List<Player>

    @Suppress("UNCHECKED_CAST")
    fun zones(predicate: (Zone) -> Boolean): List<Zone> = zoneManager.zones.filter { it != null && predicate.invoke(it) } as List<Zone>

    companion object {
        const val MAX_PLAYERS = 2048
    }
}
