/*
 * Copyright (C) 2015 Scot P. Floess
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
package org.solenopsis.keraiai.soap.security.enterprise;

import org.solenopsis.keraiai.soap.credentials.Credentials;
import org.solenopsis.keraiai.soap.security.AbstractSecurityMgr;
import org.solenopsis.keraiai.soap.security.LoginContext;
import org.solenopsis.keraiai.soap.security.LoginWebServiceTypeEnum;
import org.solenopsis.keraiai.wsdl.enterprise.Soap;

/**
 * Implementation using the enterprise web service.
 *
 * @author Scot P. Floess
 */
public class EnterpriseSecurityMgr extends AbstractSecurityMgr<Soap> {

    /**
     * This constructor will set credentials.
     *
     * @param credentials our credentials.
     */
    public EnterpriseSecurityMgr(final Credentials credentials) {
        super(credentials);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LoginWebServiceTypeEnum getLoginWebServiceType() {
        return LoginWebServiceTypeEnum.ENTERPRISE_LOGIN_SERVICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LoginContext doLogin(Soap port) throws Exception {
        return new EnterpriseLoginContext(port.login(getCredentials().getUserName(), getCredentials().getSecurityPassword()), getCredentials());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doLogout(Soap port) throws Exception {
        port.logout();
    }
}
