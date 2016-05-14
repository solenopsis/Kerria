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

import javax.xml.ws.Service;
import org.flossware.jcore.utils.soap.ServiceUtils;
import org.solenopsis.keraiai.soap.WebServiceTypeEnum;
import org.solenopsis.keraiai.soap.security.SecurityMgr;

/**
 * Utility class for port names. A port name is the API version for all non custom web services or the WebEndpoint annotation for
 * the service class.
 *
 * @author Scot P. Floess
 */
public class PortNameUtil {

    static String computePortName(final WebServiceTypeEnum webServiceType, final Service service, final SecurityMgr securityMgr) {
        return webServiceType == WebServiceTypeEnum.CUSTOM_TYPE ? ServiceUtils.getPortName(service.getClass()) : securityMgr.getCredentials().getApiVersion();
    }
}
