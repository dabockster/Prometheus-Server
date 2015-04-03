/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.plu.cs.views;

import edu.plu.cs.controllers.ClientConnectionController;

/**
 *
 * @author Timothy Ernst
 */
public class ClientConnectionView extends javax.swing.JFrame {
   
    public ClientConnectionController controller;
    
    
    
    /**
     * CONSTRUCTOR
     * Creates new form ClientView
     */
    public ClientConnectionView(ClientConnectionController controller) {
        this.controller = controller;
        initComponents();
    }
    
    /**
     * RELAY MESSAGE
     * Relays a message from client by appending clientFeedbackTA
     * @param msg the message to be appended
     */
    public void clientFeedback(String msg){
        clientFeedbackTA.append(msg+"\n");
    }
    
    /**
     * COMPONENT OPERATION
     * Enables client-server features once client has connected to server
     */
    public void connected(){
        messageTF.setEditable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientTitleLabel = new javax.swing.JLabel();
        connectLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        addressTF = new javax.swing.JTextField();
        portTF = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientFeedbackTA = new javax.swing.JTextArea();
        terminateConnectionButton = new javax.swing.JButton();
        portLabel1 = new javax.swing.JLabel();
        interactLabel = new javax.swing.JLabel();
        messageTF = new javax.swing.JTextField();
        sendLabel = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setResizable(false);

        clientTitleLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 36)); // NOI18N
        clientTitleLabel.setText("Client Main View -");

        connectLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        connectLabel.setText("Connect to a Server");

        addressLabel.setFont(new java.awt.Font("FangSong", 0, 14)); // NOI18N
        addressLabel.setText("IP Address:");

        portLabel.setFont(new java.awt.Font("FangSong", 0, 14)); // NOI18N
        portLabel.setText("Port Number:");

        addressTF.setColumns(20);
        addressTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTFActionPerformed(evt);
            }
        });

        portTF.setToolTipText("");

        connectButton.setText("Connect to Server");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        clientFeedbackTA.setEditable(false);
        clientFeedbackTA.setColumns(20);
        clientFeedbackTA.setFont(new java.awt.Font("Lucida Console", 0, 10)); // NOI18N
        clientFeedbackTA.setLineWrap(true);
        clientFeedbackTA.setRows(5);
        clientFeedbackTA.setWrapStyleWord(true);
        clientFeedbackTA.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(clientFeedbackTA);
        clientFeedbackTA.getAccessibleContext().setAccessibleName("");

        terminateConnectionButton.setText("Terminate Connection with Server");
        terminateConnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminateConnectionButtonActionPerformed(evt);
            }
        });

        portLabel1.setFont(new java.awt.Font("FangSong", 0, 18)); // NOI18N
        portLabel1.setText("Client Feedback:");

        interactLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        interactLabel.setText("Interact with Server");

        messageTF.setEditable(false);
        messageTF.setColumns(20);
        messageTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageTFActionPerformed(evt);
            }
        });

        sendLabel.setFont(new java.awt.Font("FangSong", 0, 18)); // NOI18N
        sendLabel.setText("Send message to server:");

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(clientTitleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(connectLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(portLabel)
                            .addComponent(addressLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addressTF, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(portTF)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(terminateConnectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(messageTF, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sendLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(interactLabel)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(portLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(clientTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectLabel)
                    .addComponent(interactLabel))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portLabel)
                    .addComponent(portTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(messageTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(connectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(terminateConnectionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(portLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addressTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTFActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        controller.connectToServer(addressTF.getText(), Integer.parseInt(portTF.getText()));
        addressTF.setEditable(false);
        portTF.setEditable(false);
    }//GEN-LAST:event_connectButtonActionPerformed

    private void terminateConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminateConnectionButtonActionPerformed
        addressTF.setText(null);
        addressTF.setEditable(true);
        portTF.setText(null);
        portTF.setEditable(true);
        controller.closeClientConnection();
        clientFeedbackTA.setText("Client terminated. Ready to execute new instructions.");
    }//GEN-LAST:event_terminateConnectionButtonActionPerformed

    private void messageTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageTFActionPerformed

    /**
     * BUTTON ACTION
     *  
     * @param evt 
     */
    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        controller.sendCmnd("msg",messageTF.getText());
        messageTF.setText(null);
    }//GEN-LAST:event_sendButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTF;
    private javax.swing.JTextArea clientFeedbackTA;
    private javax.swing.JLabel clientTitleLabel;
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel connectLabel;
    private javax.swing.JLabel interactLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField messageTF;
    private javax.swing.JLabel portLabel;
    private javax.swing.JLabel portLabel1;
    private javax.swing.JTextField portTF;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel sendLabel;
    private javax.swing.JButton terminateConnectionButton;
    // End of variables declaration//GEN-END:variables
}
