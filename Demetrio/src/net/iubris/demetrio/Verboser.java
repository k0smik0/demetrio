/*******************************************************************************
 * Copyleft 2011 Massimiliano Leone - k0smik0@logorroici.org .
 * 
 * Verboser.java is part of Demetrio.
 * 
 * Demetrio is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Demetrio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Demetrio ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.demetrio;

import java.lang.reflect.Field;
/*
 * Utility class for debug output
 */
public class Verboser {
	
	/**
	Simple reflective toString
	*/
	public static <T> String reflectiveToString(T t) {
		StringBuilder output = new StringBuilder();
		for (Field field: t.getClass().getDeclaredFields()) {			
			try {
				field.setAccessible(true);
				output.append( field.getName() ).append(": ").append( field.get(t) ).append("\n");
				field.setAccessible(false);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return output.toString();
	}

	/*
    public static void println(String msg ) {
    	final StackTraceElement trace = Thread.currentThread().getStackTrace()[5];
    	System.out.println(trace.getFileName()+ ":" + trace.getLineNumber() + " "+msg);            
    }
    */
}
