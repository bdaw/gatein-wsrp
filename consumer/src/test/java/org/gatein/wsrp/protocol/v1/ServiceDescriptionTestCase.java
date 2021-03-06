/******************************************************************************
 * JBoss, a division of Red Hat                                               *
 * Copyright 2006, Red Hat Middleware, LLC, and individual                    *
 * contributors as indicated by the @authors tag. See the                     *
 * copyright.txt in the distribution for a full listing of                    *
 * individual contributors.                                                   *
 *                                                                            *
 * This is free software; you can redistribute it and/or modify it            *
 * under the terms of the GNU Lesser General Public License as                *
 * published by the Free Software Foundation; either version 2.1 of           *
 * the License, or (at your option) any later version.                        *
 *                                                                            *
 * This software is distributed in the hope that it will be useful,           *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of             *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU           *
 * Lesser General Public License for more details.                            *
 *                                                                            *
 * You should have received a copy of the GNU Lesser General Public           *
 * License along with this software; if not, write to the Free                *
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA         *
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.                   *
 ******************************************************************************/
package org.gatein.wsrp.protocol.v1;

import org.gatein.pc.api.Portlet;
import org.gatein.pc.api.PortletContext;
import org.gatein.wsrp.test.ExtendedAssert;
import org.gatein.wsrp.test.protocol.v1.behaviors.BasicMarkupBehavior;
import org.gatein.wsrp.test.protocol.v1.behaviors.SessionMarkupBehavior;

/**
 * @author <a href="mailto:boleslaw.dawidowicz@jboss.org">Boleslaw Dawidowicz</a>
 * @author <a href="mailto:chris.laprun@jboss.com">Chris Laprun</a>
 * @version $Revision: 11320 $
 * @since 2.4
 */
public class ServiceDescriptionTestCase extends InteropServiceDescriptionTestCase
{

   public ServiceDescriptionTestCase() throws Exception
   {
      super();
   }


   @Override
   public void setUp() throws Exception
   {
      super.setUp();

      // use strict mode
      setStrict(true);
   }

   public void testUsesRelaxedMode()
   {
      ExtendedAssert.assertTrue(isStrict());
   }

   public void testGetPortlet() throws Exception
   {
      //obtain one portlet
      Portlet portlet = consumer.getPortlet(PortletContext.createPortletContext(BasicMarkupBehavior.PORTLET_HANDLE, false));
      checkPortlet(portlet, "", BasicMarkupBehavior.PORTLET_HANDLE);

      portlet = consumer.getPortlet(PortletContext.createPortletContext(SessionMarkupBehavior.PORTLET_HANDLE, false));
      checkPortlet(portlet, "2", SessionMarkupBehavior.PORTLET_HANDLE);
   }
}
