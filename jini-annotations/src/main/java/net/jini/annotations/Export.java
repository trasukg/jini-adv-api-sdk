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

package net.jini.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Specifies that the class named should be instantiated and exported in the
 * application scope.
 * 
 * When the exporter runs, it will establish a bean with the same attributes,
 * but annotated with the @Proxy annotation, making it available for injection.
 */
@Target(ElementType.TYPE)
public @interface Export {
    /**
     * The name of the exporter that should be used for export.
     * @return 
     */
    String exporter();
}
