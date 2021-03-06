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
package org.netbeans.jpa.modeler.core.widget;

import java.util.ArrayList;
import java.util.List;
import org.netbeans.jpa.modeler.core.widget.attribute.AttributeWidget;
import org.netbeans.jpa.modeler.spec.IdentifiableClass;
import org.netbeans.jpa.modeler.specification.model.scene.JPAModelerScene;
import org.netbeans.modeler.widget.node.info.NodeWidgetInfo;

public abstract class PrimaryKeyContainerWidget<E extends IdentifiableClass> extends PersistenceClassWidget<E> {

    public PrimaryKeyContainerWidget(JPAModelerScene scene, NodeWidgetInfo nodeWidgetInfo) {
        super(scene, nodeWidgetInfo);
    }

    @Override
    public List<AttributeWidget> getAttributeOverrideWidgets() {
        List<AttributeWidget> attributeWidgets = new ArrayList<>();
        JavaClassWidget classWidget = this.getSuperclassWidget(); //super class will get other attribute from its own super class
        if (classWidget instanceof PrimaryKeyContainerWidget) {
            attributeWidgets.addAll(((PrimaryKeyContainerWidget) classWidget).getAttributeOverrideWidgetsImpl());
        }
        return attributeWidgets;
    }

    private List<AttributeWidget> getAttributeOverrideWidgetsImpl() {//include self
        List<AttributeWidget> attributeWidgets = new ArrayList<>();
        JavaClassWidget classWidget = this.getSuperclassWidget(); //super class will get other attribute from its own super class
        if (classWidget instanceof PrimaryKeyContainerWidget) {
            attributeWidgets.addAll(((PrimaryKeyContainerWidget) classWidget).getAttributeOverrideWidgetsImpl());
        }
        attributeWidgets.addAll(this.getIdAttributeWidgets());
//        if (embeddedIdAttributeWidget != null) {
//            attributeWidgets.add(embeddedIdAttributeWidget);
//        }
        attributeWidgets.addAll(getBasicAttributeWidgets());
        attributeWidgets.addAll(getBasicCollectionAttributeWidgets());
        return attributeWidgets;
    }

    public List<AttributeWidget> getAssociationOverrideWidgets() {
        List<AttributeWidget> attributeWidgets = new ArrayList<>();
        JavaClassWidget classWidget = this.getSuperclassWidget(); //super class will get other attribute from its own super class
        if (classWidget instanceof PrimaryKeyContainerWidget) {
            attributeWidgets.addAll(((PrimaryKeyContainerWidget) classWidget).getAssociationOverrideWidgetsImpl());
        }
        return attributeWidgets;
    }

    private List<AttributeWidget> getAssociationOverrideWidgetsImpl() {//include self
        List<AttributeWidget> attributeWidgets = new ArrayList<>();
        JavaClassWidget classWidget = this.getSuperclassWidget(); //super class will get other attribute from its own super class
        if (classWidget instanceof PrimaryKeyContainerWidget) {
            attributeWidgets.addAll(((PrimaryKeyContainerWidget) classWidget).getAssociationOverrideWidgetsImpl());
        }
        attributeWidgets.addAll(this.getOneToOneRelationAttributeWidgets());
        attributeWidgets.addAll(this.getOneToManyRelationAttributeWidgets());
        attributeWidgets.addAll(this.getManyToOneRelationAttributeWidgets());
        attributeWidgets.addAll(this.getManyToManyRelationAttributeWidgets());
        return attributeWidgets;
    }

    public List<AttributeWidget> getEmbeddedOverrideWidgets() {
        List<AttributeWidget> attributeWidgets = new ArrayList<>();
        JavaClassWidget classWidget = this.getSuperclassWidget(); //super class will get other attribute from its own super class
        if (classWidget instanceof PrimaryKeyContainerWidget) {
            attributeWidgets.addAll(((PrimaryKeyContainerWidget) classWidget).getEmbeddedOverrideWidgetsImpl());
        }
        attributeWidgets.addAll(this.getSingleValueEmbeddedAttributeWidgets());
        attributeWidgets.addAll(this.getMultiValueEmbeddedAttributeWidgets());
        return attributeWidgets;
    }

    private List<AttributeWidget> getEmbeddedOverrideWidgetsImpl() {//include self
        List<AttributeWidget> attributeWidgets = new ArrayList<>();
        JavaClassWidget classWidget = this.getSuperclassWidget(); //super class will get other attribute from its own super class
        if (classWidget instanceof PrimaryKeyContainerWidget) {
            attributeWidgets.addAll(((PrimaryKeyContainerWidget) classWidget).getEmbeddedOverrideWidgetsImpl());
        }
        attributeWidgets.addAll(this.getSingleValueEmbeddedAttributeWidgets());
        attributeWidgets.addAll(this.getMultiValueEmbeddedAttributeWidgets());
        return attributeWidgets;
    }

}
