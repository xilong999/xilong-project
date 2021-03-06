/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package com.ems.rest;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Device;
import com.ems.entity.JavaBean1;
import com.ems.entity.LastOneDayList;
import com.ems.entity.NowData;
import com.ems.service.QueryBeforeService;
import com.ems.service.TotalConsumptionService;
import com.ems.util.MongoDBUtil;

/**
 * @author Pavel Bucek (pavel.bucek at oracle.com)
 */
@RestController
@Path("/index")
public class TotalConsumptionResource {

	@Autowired
	TotalConsumptionService totalConsumptionService;
    /**
     * 获取电的前23个小时的数据（小时的数据）
     *
     * @return
     */
    @Path("/electricityLastOneDay/{type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public LastOneDayList getElectricity(@PathParam("type") String type){
        return totalConsumptionService.getElectricity(type);
    }

    /**
     * 获取电的当前数据（小时的数据）
     *
     * @return
     */
    @Path("/electricityNowData/{type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public NowData getNowdata(@PathParam("type") String type){
        return totalConsumptionService.getNowdata(type);
    }
}