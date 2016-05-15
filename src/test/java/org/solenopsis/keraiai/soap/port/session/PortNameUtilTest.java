/*
 * Copyright (C) 2016 Scot P. Floess
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.solenopsis.keraiai.soap.port.session;

import org.flossware.jcore.utils.TestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.solenopsis.keraiai.soap.WebServiceTypeEnum;
import org.solenopsis.keraiai.soap.credentials.Credentials;
import org.solenopsis.keraiai.soap.security.SecurityMgr;
import org.solenopsis.keraiai.wsdl.enterprise.SforceService;

/**
 * Tests the PortNameUtils utility class.
 *
 * @author Scot P. Floess
 */
@RunWith(MockitoJUnitRunner.class)
public class PortNameUtilTest {
    
    @Mock
    SecurityMgr securityMgr;
    
    @Mock
    Credentials credentials;
    
    String apiVersion;
    
    @Before
    public void setup() {
        Mockito.when(securityMgr.getCredentials()).thenReturn(credentials);
        
        apiVersion = TestUtils.generateUniqueStr("api");
        Mockito.when(credentials.getApiVersion()).thenReturn(apiVersion);
        
    }

    /**
     * Tests logging the computed port name.
     */
    @Test
    public void test_logAndReturnComputedPortName() {
        final String portName = TestUtils.generateUniqueStr("MyPort");
        
        Assert.assertSame("Should be the same port name", portName, PortNameUtils.logAndReturnComputedPortName(portName));
    }

    /**
     * Test computing port names.
     */
    @Test
    public void test_computePortName() {
        final SforceService service = new SforceService(getClass().getClassLoader().getResource("wsdl/Keraiai-enterprise.wsdl"));
        Assert.assertEquals("Should be the correct port name", "Soap", PortNameUtils.computePortName(WebServiceTypeEnum.CUSTOM_TYPE, service, securityMgr));
        Assert.assertEquals("Should be the correct port name", apiVersion, PortNameUtils.computePortName(WebServiceTypeEnum.ENTERPRISE_TYPE, service, securityMgr));
    }
}
