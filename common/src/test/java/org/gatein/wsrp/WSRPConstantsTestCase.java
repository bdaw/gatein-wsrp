/*
 * JBoss, a division of Red Hat
 * Copyright 2010, Red Hat Middleware, LLC, and individual
 * contributors as indicated by the @authors tag. See the
 * copyright.txt in the distribution for a full listing of
 * individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.gatein.wsrp;

import junit.framework.TestCase;

/**
 * @author <a href="mailto:chris.laprun@jboss.com">Chris Laprun</a>
 * @version $Revision$
 */
public class WSRPConstantsTestCase extends TestCase
{
   public void testServiceVersion()
   {
      // should be equals to the interpolated ${project.version} value, "1.1.0-CR02-SNAPSHOT" when written 
      // assertEquals("1.1.0-CR02-SNAPSHOT", WSRPConstants.WSRP_SERVICE_VERSION);
//      System.out.println("WSRPConstants.WSRP_SERVICE_VERSION = " + WSRPConstants.WSRP_SERVICE_VERSION);
//      assertFalse(WSRPConstants.WSRP_SERVICE_VERSION.equals("${project.version}"));
   }
}
