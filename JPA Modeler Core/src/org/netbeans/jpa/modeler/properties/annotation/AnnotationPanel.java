/**
 * Copyright [2016] Gaurav Gupta
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
package org.netbeans.jpa.modeler.properties.annotation;

import javax.swing.JOptionPane;
import static org.apache.commons.lang.StringUtils.EMPTY;
import org.netbeans.jpa.modeler.internal.jpqleditor.ModelerPanel;
import org.netbeans.jpa.modeler.spec.extend.annotation.Annotation;
import org.netbeans.modeler.core.ModelerFile;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.Entity;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.RowValue;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.internal.EntityComponent;

public class AnnotationPanel extends EntityComponent<Annotation> implements ModelerPanel {

    private Annotation annotation;
    private final ModelerFile modelerFile;
    
    public AnnotationPanel(ModelerFile modelerFile) {
        this.modelerFile=modelerFile;
    }
    
    @Override
    public void postConstruct() {
        initComponents();
    }

    @Override
    public void init() {
    }

    @Override
    public void createEntity(Class<? extends Entity> entityWrapperType) {
        this.setTitle("Add new Annotation");
        if (entityWrapperType == RowValue.class) {
            this.setEntity(new RowValue(new Object[5]));
        }
        annotation = null;
        annotation_EditorPane.setText(EMPTY);
    }

    @Override
    public void updateEntity(Entity<Annotation> entityValue) {
        this.setTitle("Update Annotation");
        if (entityValue.getClass() == RowValue.class) {
            this.setEntity(entityValue);
            Object[] row = ((RowValue) entityValue).getRow();
            annotation = (Annotation) row[0];
            annotation_EditorPane.setText(annotation.getName());
        }

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root_jLayeredPane = new javax.swing.JLayeredPane();
        action_jLayeredPane = new javax.swing.JLayeredPane();
        save_Button = new javax.swing.JButton();
        cancel_Button = new javax.swing.JButton();
        annotation_ScrollPane = new javax.swing.JScrollPane();
        annotation_EditorPane = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.openide.awt.Mnemonics.setLocalizedText(save_Button, org.openide.util.NbBundle.getMessage(AnnotationPanel.class, "AnnotationPanel.save_Button.text")); // NOI18N
        save_Button.setToolTipText(org.openide.util.NbBundle.getMessage(AnnotationPanel.class, "AnnotationPanel.save_Button.toolTipText")); // NOI18N
        save_Button.setSelected(true);
        save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_ButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancel_Button, org.openide.util.NbBundle.getMessage(AnnotationPanel.class, "AnnotationPanel.cancel_Button.text")); // NOI18N
        cancel_Button.setToolTipText(org.openide.util.NbBundle.getMessage(AnnotationPanel.class, "AnnotationPanel.cancel_Button.toolTipText")); // NOI18N
        cancel_Button.setPreferredSize(new java.awt.Dimension(60, 23));
        cancel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_ButtonActionPerformed(evt);
            }
        });

        action_jLayeredPane.setLayer(save_Button, javax.swing.JLayeredPane.DEFAULT_LAYER);
        action_jLayeredPane.setLayer(cancel_Button, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout action_jLayeredPaneLayout = new javax.swing.GroupLayout(action_jLayeredPane);
        action_jLayeredPane.setLayout(action_jLayeredPaneLayout);
        action_jLayeredPaneLayout.setHorizontalGroup(
            action_jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(action_jLayeredPaneLayout.createSequentialGroup()
                .addComponent(save_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        action_jLayeredPaneLayout.setVerticalGroup(
            action_jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(action_jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(save_Button)
                .addComponent(cancel_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        annotation_ScrollPane.setPreferredSize(new java.awt.Dimension(400, 100));

        annotation_EditorPane.setContentType("text/x-java"); // NOI18N
        annotation_EditorPane.setAutoscrolls(false);
        annotation_EditorPane.setPreferredSize(new java.awt.Dimension(210, 23));
        annotation_ScrollPane.setViewportView(annotation_EditorPane);

        root_jLayeredPane.setLayer(action_jLayeredPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        root_jLayeredPane.setLayer(annotation_ScrollPane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout root_jLayeredPaneLayout = new javax.swing.GroupLayout(root_jLayeredPane);
        root_jLayeredPane.setLayout(root_jLayeredPaneLayout);
        root_jLayeredPaneLayout.setHorizontalGroup(
            root_jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(root_jLayeredPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(root_jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(annotation_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, root_jLayeredPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(action_jLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        root_jLayeredPaneLayout.setVerticalGroup(
            root_jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(root_jLayeredPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(annotation_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(action_jLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(root_jLayeredPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(root_jLayeredPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean validateField() {
        if (this.annotation_EditorPane.getText().trim().length() <= 0 /*|| Pattern.compile("[^\\w-]").matcher(this.id_TextField.getText().trim()).find()*/) {
            JOptionPane.showMessageDialog(this, "Annotation can't be empty", "Invalid Value", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        } else if(this.annotation_EditorPane.getText().trim().charAt(0) != '@'){
            JOptionPane.showMessageDialog(this, "Invalid Annotation type (missing @)", "Invalid Value", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }

    private void save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_ButtonActionPerformed
        if (!validateField()) {
            return;
        }
        if (this.getEntity().getClass() == RowValue.class) {
            Object[] row = ((RowValue) this.getEntity()).getRow();
            if (row[0] == null) {
                annotation = new Annotation();
            } else {
                annotation = (Annotation) row[0];
            }
        }

        annotation.setName(annotation_EditorPane.getText());

        if (this.getEntity().getClass() == RowValue.class) {
            Object[] row = ((RowValue) this.getEntity()).getRow();
            row[0] = annotation;
            row[1] = annotation.isEnable();
            row[2] = annotation.getName();
        }
        saveActionPerformed(evt);
    }//GEN-LAST:event_save_ButtonActionPerformed

    private void cancel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_ButtonActionPerformed
        cancelActionPerformed(evt);
    }//GEN-LAST:event_cancel_ButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane action_jLayeredPane;
    private javax.swing.JEditorPane annotation_EditorPane;
    private javax.swing.JScrollPane annotation_ScrollPane;
    private javax.swing.JButton cancel_Button;
    private javax.swing.JLayeredPane root_jLayeredPane;
    private javax.swing.JButton save_Button;
    // End of variables declaration//GEN-END:variables

    @Override
    public ModelerFile getModelerFile() {
        return modelerFile;
    }
}
