//  MIT License
//  
//  Copyright (c) 2019 fren_gor
//  
//  Permission is hereby granted, free of charge, to any person obtaining a copy
//  of this software and associated documentation files (the "Software"), to deal
//  in the Software without restriction, including without limitation the rights
//  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//  copies of the Software, and to permit persons to whom the Software is
//  furnished to do so, subject to the following conditions:
//  
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//  
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//  SOFTWARE.

package com.fren_gor.packetUtils.v1_14;

import java.util.Map;

import org.apache.commons.lang.Validate;

import com.fren_gor.packetInjectorAPI.ReflectionUtil;
import com.fren_gor.packetInjectorAPI.api.events.PacketRetriveEvent;
import com.fren_gor.packetInjectorAPI.api.events.PacketSendEvent;
import com.fren_gor.packetUtils.Main;

import it.unimi.dsi.fastutil.objects.Reference2ReferenceLinkedOpenHashMap;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class PacketEventManager {

	private static Map<PacketSendListener, com.fren_gor.packetInjectorAPI.api.listeners.PacketSendListener> SEND_LISTENERS = new Reference2ReferenceLinkedOpenHashMap<>();
	private static Map<PacketRetriveListener, com.fren_gor.packetInjectorAPI.api.listeners.PacketRetriveListener> RETRIVE_LISTENERS = new Reference2ReferenceLinkedOpenHashMap<>();

	/**
	 * Register a packet send listener
	 * 
	 * @param listener
	 *            The listener instance
	 */
	public static void registerSendListener(PacketSendListener listener) {
		Validate.notNull(listener, "PacketSendListener cannot be null");
		if (ReflectionUtil.getVersion() < 14 || SEND_LISTENERS.containsKey(listener))
			return;
		com.fren_gor.packetInjectorAPI.api.listeners.PacketSendListener list;
		com.fren_gor.packetInjectorAPI.api.PacketEventManager.registerPacketListener(Main.getInstance(),
				list = new com.fren_gor.packetInjectorAPI.api.listeners.PacketSendListener() {
					@Override
					public void onSend(PacketSendEvent event) {
						listener.onSend(new com.fren_gor.packetUtils.events.PacketSendEvent(event));
					}
				});
		SEND_LISTENERS.put(listener, list);
	}

	/**
	 * Register a packet retrive listener
	 * 
	 * @param listener
	 *            The listener instance
	 */
	public static void registerRetriveListener(PacketRetriveListener listener) {
		Validate.notNull(listener, "PacketRetriveListener cannot be null");
		if (ReflectionUtil.getVersion() < 14 || RETRIVE_LISTENERS.containsKey(listener))
			return;
		com.fren_gor.packetInjectorAPI.api.listeners.PacketRetriveListener list;
		com.fren_gor.packetInjectorAPI.api.PacketEventManager.registerPacketListener(Main.getInstance(),
				list = new com.fren_gor.packetInjectorAPI.api.listeners.PacketRetriveListener() {
					@Override
					public void onRetrive(PacketRetriveEvent event) {
						listener.onRetrive(new com.fren_gor.packetUtils.events.PacketRetriveEvent(event));
					}
				});
		RETRIVE_LISTENERS.put(listener, list);
	}

	/**
	 * Unregister a packet send listener
	 * 
	 * @param listener
	 *            The listener instance
	 */
	public static void unregisterSendListener(PacketSendListener listener) {
		Validate.notNull(listener, "PacketSendListener cannot be null");
		if (ReflectionUtil.getVersion() < 14) {
			return;
		}
		com.fren_gor.packetInjectorAPI.api.listeners.PacketSendListener list = SEND_LISTENERS.remove(listener);
		if (list != null) {
			com.fren_gor.packetInjectorAPI.api.PacketEventManager.unregisterPacketListener(list);
		}
	}

	/**
	 * Unregister a packet retrive listener
	 * 
	 * @param listener
	 *            The listener instance
	 */
	public static void unregisterRetriveListener(PacketRetriveListener listener) {
		Validate.notNull(listener, "PacketRetriveListener cannot be null");
		if (ReflectionUtil.getVersion() < 14) {
			return;
		}
		com.fren_gor.packetInjectorAPI.api.listeners.PacketRetriveListener list = RETRIVE_LISTENERS.remove(listener);
		if (list != null) {
			com.fren_gor.packetInjectorAPI.api.PacketEventManager.unregisterPacketListener(list);
		}
	}

}
