/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.river.container.examples.advapi.hello.impl;

import java.io.IOException;
import javax.inject.Inject;
import net.jini.core.lookup.ServiceID;
import net.jini.annotations.Export;
import net.jini.annotations.Service;
import net.jini.annotations.Proxy;
import net.jini.annotations.ServiceName;
import org.apache.river.examples.hello.api.Greeter;

/**
 * This class is an example of what I'd like to have for a simple service-implementation
 * pattern.
 * 
 * '@Export' indicates that this service should be exported.
 '@Service' indicates that the service should be registered with the service registrar.
 Since there is also an @Export on the class, the exported proxy is registered.
 * @author trasukg
 */
@Export(exporter="default")
@Service(attributes="greeterAttributes")
@ServiceName("hello-service")
public class AdvApiGreeterService implements Greeter {
    public String sayHello(String name) throws IOException {
        return "Hi there " + name + " from service id '" + sid + "'";
        
    }

    /* Trying to indicate that the service id assigned for this service should be
    injected.  I'm not sure if that's within the spec range of CDI - is there a 
    "this-object" scope?  I suppose we could have a custom scope.
    */
    @Inject
    ServiceID sid=null;
    
    @Inject
    @Proxy
    Greeter myProxy;
    
}
