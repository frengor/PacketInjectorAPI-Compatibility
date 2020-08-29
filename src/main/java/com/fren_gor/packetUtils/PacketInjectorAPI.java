package com.fren_gor.packetUtils;

import org.bukkit.entity.Player;

/**
 * Util class by fren_gor Give me credits if you use it in one of your plugin
 * 
 * @author fren_gor
 *
 */
public final class PacketInjectorAPI {

	/**
	 * Send packet to a player
	 * 
	 * @param player
	 *            The packet will be sent to this player
	 * @param packet
	 *            The NMS packet
	 */
	public static void sendPacketToClient(Player player, Object packet) {

		com.fren_gor.packetInjectorAPI.api.PacketInjectorAPI.sendPacketToClient(player, packet);

	}

	/**
	 * Send packet to a player
	 * 
	 * @param player
	 *            The packet will be sent to this player
	 * @param packet
	 *            The NMS packet
	 * @deprecated Use {@link PacketInjectorAPI#sendPacketToClient(Player, Object)} instead
	 */
	@Deprecated
	public static void sendPacket(Player player, Object packet) {

		com.fren_gor.packetInjectorAPI.api.PacketInjectorAPI.sendPacketToClient(player, packet);

	}

	/**
	 * Send packet to the server
	 * 
	 * @param player
	 *            The player that will send the packet
	 * @param packet
	 *            The NMS packet
	 */
	public static void sendPacketToServer(Player player, Object packet) {

		com.fren_gor.packetInjectorAPI.api.PacketInjectorAPI.sendPacketToServer(player, packet);
	}

}
