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

import org.jetbrains.annotations.Nullable;

import lombok.Getter;

/**
 * Reflection class by fren_gor Give me credits if you use it in one of your plugin
 * 
 * @author fren_gor
 *
 */
public final class ReflectionUtil {

	/**
	 * Build a new class getting the proper constructor from parameters
	 * 
	 * @param clazz
	 *            The class of the object of witch you want the instance
	 * @param parameters
	 *            The contructors parameters
	 * @return The new instance
	 */
	public static Object newInstance(Class<?> clazz, Object... parameters) {

		return com.fren_gor.packetInjectorAPI.ReflectionUtil.newInstance(clazz, parameters);

	}

	/**
	 * Invoke method in c class
	 * 
	 * @param object
	 *            The object where the method is invoked
	 * @param method
	 *            The name of the method
	 * @param parameters
	 *            The object uses as parameters
	 * @return What the method return. If the method is void, return null
	 */
	@Nullable
	public static Object invoke(Object object, String method, Object... parameters) {

		return com.fren_gor.packetInjectorAPI.ReflectionUtil.invoke(object, method, parameters);

	}

	/**
	 * Set a field
	 * 
	 * @param object
	 *            The object where the field is set
	 * @param field
	 *            The name of the field
	 * @param newValue
	 *            The new value of the field
	 * @return If the execution was successful
	 */
	@Nullable
	public static boolean setField(Object object, String field, Object newValue) {

		return com.fren_gor.packetInjectorAPI.ReflectionUtil.setField(object, field, newValue);

	}

	/**
	 * Get a field value
	 * 
	 * @param object
	 *            The object from which the represented field's value is to be extracted
	 * @param field
	 *            The field name
	 * @return The field value, null if the field doesn't exists.
	 */
	@Nullable
	public static Object getField(Object object, String field) {

		return com.fren_gor.packetInjectorAPI.ReflectionUtil.getField(object, field);

	}

	/**
	 * Cast a object to a class
	 * 
	 * @param object
	 *            The object to cast
	 * @param clazz
	 *            The class
	 * @return The casted object
	 */
	@Nullable
	public static Object cast(Object object, Class<?> clazz) {
		return com.fren_gor.packetInjectorAPI.ReflectionUtil.cast(object, clazz);
	}

	/**
	 * @param name
	 *            The class name
	 * @return The NMS class
	 */
	public static Class<?> getNMSClass(String name) {
		return com.fren_gor.packetInjectorAPI.ReflectionUtil.getNMSClass(name);
	}

	/**
	 * @param name
	 *            The class name
	 * @return The CraftBukkit class
	 */
	public static Class<?> getCBClass(String name) {
		return com.fren_gor.packetInjectorAPI.ReflectionUtil.getCBClass(name);
	}

	/**
	 * Get the server version
	 * 
	 * @return The server version
	 */
	public static String getCompleteVersion() {
		return com.fren_gor.packetInjectorAPI.ReflectionUtil.getCompleteVersion();
	}

	@Getter
	private static int version = com.fren_gor.packetInjectorAPI.ReflectionUtil.getVersion();
	@Getter
	private static int release = com.fren_gor.packetInjectorAPI.ReflectionUtil.getRelease();

}
