//  MIT License
//  
//  Copyright (c) 2020 fren_gor
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

package com.fren_gor.packetUtils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.fren_gor.packetInjectorAPI.PacketInjectorPlugin;
import com.fren_gor.packetInjectorAPI.ReflectionUtil;
import com.fren_gor.packetInjectorAPI.api.PacketEventManager;
import com.fren_gor.packetInjectorAPI.api.events.PacketRetriveEvent;
import com.fren_gor.packetInjectorAPI.api.events.PacketSendEvent;
import com.fren_gor.packetInjectorAPI.api.listeners.PacketListener;

import lombok.Getter;

public final class Main extends JavaPlugin {

	@Getter
	private static Main instance;

	public Object getPacketInjector() {
		return PacketInjectorPlugin.getInstance().getPacketInjector();
	}

	@Override
	public void onEnable() {
		instance = this;

		if (ReflectionUtil.getVersion() < 14)
			PacketEventManager.registerPacketListener(this, new PacketListener() {
				@Override
				public void onSend(PacketSendEvent e) {
					Bukkit.getPluginManager().callEvent(new com.fren_gor.packetUtils.events.PacketSendEvent(e));
				}

				@Override
				public void onRetrive(PacketRetriveEvent e) {
					Bukkit.getPluginManager().callEvent(new com.fren_gor.packetUtils.events.PacketRetriveEvent(e));
				}
			});
	}

}
