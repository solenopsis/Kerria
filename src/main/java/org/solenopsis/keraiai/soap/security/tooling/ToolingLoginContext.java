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
package org.solenopsis.keraiai.soap.security.tooling;

import org.solenopsis.keraiai.soap.credentials.Credentials;
import org.solenopsis.keraiai.soap.security.AbstractLoginContext;
import org.solenopsis.keraiai.wsdl.tooling.LoginResult;

/**
 * Tooling web service login result.
 *
 * @author Scot P. Floess
 */
class ToolingLoginContext extends AbstractLoginContext {

    /**
     * Our login result.
     */
    private final LoginResult loginResult;

    /**
     * Return our login result.
     *
     * @return our login result.
     */
    LoginResult getLoginResult() {
        return loginResult;
    }

    /**
     * Constructor sets the login result and security manager who constructed self.
     *
     * @param loginContext result of login.
     * @param credentials the used for login.
     *
     * @throws IllegalArgumentException if loginContext or credentials are null.
     */
    ToolingLoginContext(final LoginResult loginResult, final Credentials credentials) {
        super(credentials);

        if (null == loginResult) {
            throw new IllegalArgumentException("LoginResult must not be null");
        }

        this.loginResult = loginResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMetadataServerUrl() {
        return getLoginResult().getMetadataServerUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPasswordExpired() {
        return getLoginResult().isPasswordExpired();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSandbox() {
        return getLoginResult().isSandbox();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSessionId() {
        return getLoginResult().getSessionId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUserId() {
        return getLoginResult().getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getServerUrl() {
        return getLoginResult().getServerUrl();
    }
}
