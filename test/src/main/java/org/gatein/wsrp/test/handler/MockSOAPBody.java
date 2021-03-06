/*
* JBoss, a division of Red Hat
* Copyright 2008, Red Hat Middleware, LLC, and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
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

package org.gatein.wsrp.test.handler;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPBody;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author <a href="mailto:chris.laprun@jboss.com">Chris Laprun</a>
 * @version $Revision$
 */
public class MockSOAPBody implements InvocationHandler
{
   Element body;
   private static DocumentBuilder BUILDER;

   static
   {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setValidating(false);
      factory.setNamespaceAware(true);
      try
      {
         BUILDER = factory.newDocumentBuilder();
      }
      catch (ParserConfigurationException e)
      {
         BUILDER = null;
      }
   }

   public MockSOAPBody(Element body)
   {
      this.body = body;
   }

   public static SOAPBody newInstance(String body) throws IOException
   {
      return (SOAPBody)Proxy.newProxyInstance(MockSOAPBody.class.getClassLoader(), new Class[]{SOAPBody.class},
         new MockSOAPBody(parse(body)));
   }

   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
   {
      return method.invoke(body, args);
   }

   private static Element parse(String elementAsString) throws IOException
   {
      try
      {
         Document doc = BUILDER.parse(new ByteArrayInputStream(elementAsString.getBytes("UTF-8")));
         return doc.getDocumentElement();
      }
      catch (SAXException e)
      {
         throw new IOException(e.toString());
      }
   }
}
