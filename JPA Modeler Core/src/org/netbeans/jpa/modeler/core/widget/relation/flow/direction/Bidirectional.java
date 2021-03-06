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
package org.netbeans.jpa.modeler.core.widget.relation.flow.direction;

import org.netbeans.jpa.modeler.core.widget.attribute.relation.RelationAttributeWidget;
import org.netbeans.jpa.modeler.spec.extend.RelationAttribute;

/**
 *
 * @author Gaurav Gupta
 */
public interface Bidirectional extends Direction {

    /**
     * @return the targetRelationAttributeWidget
     */
    public RelationAttributeWidget<RelationAttribute> getTargetRelationAttributeWidget();

    /**
     * @param targetRelationAttributeWidget the targetRelationAttributeWidget to
     * set
     */
    public void setTargetRelationAttributeWidget(RelationAttributeWidget<RelationAttribute> targetRelationAttributeWidget);
}
