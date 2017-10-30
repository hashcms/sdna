/*
 * Copyright © 2015 www.raisecom.com and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package com.hashcms.sdna.impl;

import java.util.concurrent.Future;

import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdna.rev150105.HelloSdnaOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdna.rev150105.HelloSdnaOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdna.rev150105.SdnaService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;

public class SdnaImpl implements SdnaService {

	@Override
	public Future<RpcResult<HelloSdnaOutput>> helloSdna() {
		HelloSdnaOutputBuilder builder = new HelloSdnaOutputBuilder();
		builder.setStatus("ok");
		return RpcResultBuilder.success(builder.build()).buildFuture();
	}

}
