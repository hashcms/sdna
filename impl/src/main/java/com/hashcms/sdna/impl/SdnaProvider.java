/*
 * Copyright © 2015 www.raisecom.com and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package com.hashcms.sdna.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdna.rev150105.SdnaService;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SdnaProvider implements BindingAwareProvider, AutoCloseable {

	private static final Logger LOG = LoggerFactory.getLogger(SdnaProvider.class);
	private RpcRegistration<SdnaService> service;
	private DataBroker dataBroker;

	@Override
	public void onSessionInitiated(ProviderContext session) {
		service = session.addRpcImplementation(SdnaService.class, new SdnaImpl());
		dataBroker = session.getSALService(DataBroker.class);
		LOG.info("SdnaProvider Session Initiated");
	}

	@Override
	public void close() throws Exception {
		LOG.info("SdnaProvider Closed");
	}

}
