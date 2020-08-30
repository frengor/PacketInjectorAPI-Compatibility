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

package com.fren_gor.packetUtils.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public final class PacketRetriveEvent extends PacketEvent {

	private final com.fren_gor.packetInjectorAPI.api.events.PacketRetriveEvent e;

	public PacketRetriveEvent(com.fren_gor.packetInjectorAPI.api.events.PacketRetriveEvent e) {
		super(true);
		this.e = e;
	}

	public Player getPlayer() {
		return e.getPlayer();
	}

	public Object getPacket() {
		return e.getPacket();
	}

	public String getPacketName() {
		return e.getPacketName();
	}

	public Object setPacket(Object packet) {

		return e.setPacket(packet);

	}

	public void setValue(String field, Object value) {

		e.setValue(field, value);

	}

	public Object getValue(String field) {

		return e.getValue(field);

	}
	
	@Override
	public boolean isCancelled() {
		return e.isCancelled();
	}

	@Override
	public void setCancelled(boolean cancel) {
		e.setCancelled(cancel);
	}

	private static final HandlerList handlers = new HandlerList();

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

}
