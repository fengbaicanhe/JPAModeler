/**
 * Copyright [2014] Gaurav Gupta
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
package org.netbeans.orm.converter.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.netbeans.jpa.modeler.spec.EntityListener;
import org.netbeans.orm.converter.compiler.CallbackSnippet;
import org.netbeans.orm.converter.compiler.EntityListenerSnippet;

public class GeneratorUtil {

    private static boolean generateDefaultValue = false;

    public static List<EntityListenerSnippet> processEntityListeners(
            List<EntityListener> parsedEntityListeners,
            String packageName) {

        if (parsedEntityListeners == null || parsedEntityListeners.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        List<EntityListenerSnippet> entityListeners = new ArrayList<EntityListenerSnippet>();

        for (EntityListener entityListener : parsedEntityListeners) {

            List<CallbackSnippet> callbacks = new ArrayList<CallbackSnippet>();

            if (entityListener.getPostLoad() != null) {
                callbacks.add(new CallbackSnippet(
                        CallbackSnippet.CallbackType.PostLoad,
                        entityListener.getPostLoad().getMethodName()));
            }

            if (entityListener.getPostPersist() != null) {
                callbacks.add(new CallbackSnippet(
                        CallbackSnippet.CallbackType.PostPersist,
                        entityListener.getPostPersist().getMethodName()));
            }

            if (entityListener.getPostRemove() != null) {
                callbacks.add(new CallbackSnippet(
                        CallbackSnippet.CallbackType.PostRemove,
                        entityListener.getPostRemove().getMethodName()));
            }

            if (entityListener.getPostUpdate() != null) {
                callbacks.add(new CallbackSnippet(
                        CallbackSnippet.CallbackType.PostUpdate,
                        entityListener.getPostUpdate().getMethodName()));
            }

            if (entityListener.getPrePersist() != null) {
                callbacks.add(
                        new CallbackSnippet(CallbackSnippet.CallbackType.PrePersist,
                                entityListener.getPrePersist().getMethodName()));
            }

            if (entityListener.getPreRemove() != null) {
                callbacks.add(new CallbackSnippet(
                        CallbackSnippet.CallbackType.PreRemove,
                        entityListener.getPreRemove().getMethodName()));
            }

            if (entityListener.getPreUpdate() != null) {
                callbacks.add(new CallbackSnippet(
                        CallbackSnippet.CallbackType.PreUpdate,
                        entityListener.getPreUpdate().getMethodName()));
            }

            EntityListenerSnippet entityListenerSnippet = new EntityListenerSnippet();

            entityListenerSnippet.setClassName(entityListener.getClazz());
            entityListenerSnippet.setPackageName(packageName);
            entityListeners.add(entityListenerSnippet);
            //TODO: Is this check required ?
            if (!callbacks.isEmpty()) {
                entityListenerSnippet.setCallbacks(callbacks);
            }
        }

        return entityListeners;
    }

    /**
     * @return the generateDefaultValue
     */
    public static boolean isGenerateDefaultValue() {
        return generateDefaultValue;
    }

    /**
     * @param aGenerateDefaultValue the generateDefaultValue to set
     */
    public static void setGenerateDefaultValue(boolean aGenerateDefaultValue) {
        generateDefaultValue = aGenerateDefaultValue;
    }
}
