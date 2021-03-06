/*
 * Copyright 2000-2014 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.customweb.sass.internal.parser.function;

import com.customweb.sass.internal.parser.LexicalUnitImpl;

public class AbsFunctionGenerator extends
        AbstractSingleParameterFunctionGenerator {

    private static String[] argumentNames = { "value" };

    public AbsFunctionGenerator() {
        super(createArgumentList(argumentNames, false), "abs");
    }

    @Override
    protected LexicalUnitImpl computeForParam(String functionName,
            LexicalUnitImpl param) {
        return param.copyWithValue(Math.abs(param.getFloatValue()));
    }

}
