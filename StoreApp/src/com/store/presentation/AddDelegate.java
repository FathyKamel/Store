

package com.store.presentation;

import java.awt.ComponentOrientation;
import java.util.List;

import com.store.database.exception.PersistanceOperationException;
import com.store.models.basic.BasicStoreEntity;

import com.store.models.impl.Delegate;
import com.store.service.basic.BasicServiceManager;

import com.store.service.impl.DelegateService;
import com.store.ws.service.exception.OperationFailureException;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDelegate extends javax.swing.JFrame {

	private BasicServiceManager basicServiceManager;
	   private Delegate  Delegate ;
	   
	   private List<BasicStoreEntity>  allDelegators ;
	   
	   private DefaultTableModel tableModel ;
	   
	   JScrollPane scrollPane;
	   
    public AddDelegate() throws PersistanceOperationException {
        initComponents();
        SelectDelegateMode();
        
        AllDelegatesTable.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	    
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void SelectDelegateMode() {
    	
    	DelegateAddress.setVisible(false);
    	DelegatePhone.setVisible(false);
    	DelegateName.setVisible(false);
  	 
  	  
    	DelegatePhoneLabel.setVisible(false);
    	DelegateNameLabel.setVisible(false);
    	DelegateAddressLabel.setVisible(false);
  	   
		
		
	}
    
   private void AddDelegateMode() {
	   DelegateAddress.setVisible(true);
	   DelegatePhone.setVisible(true);
	   DelegateName.setVisible(true);
 	  
 	  
	   DelegatePhoneLabel.setVisible(true);
	   DelegateNameLabel.setVisible(true);
	   DelegateAddressLabel.setVisible(true);
 	   
// 	    AllCustomersTable.addAncestorListener(this);
 	  scrollPane.setVisible(false);
		
		
	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
	 * @throws PersistanceOperationException 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws PersistanceOperationException {

        jPanel1 = new javax.swing.JPanel();
        DelegateName = new javax.swing.JTextField();
        DelegateAddress = new javax.swing.JTextField();
        DelegatePhone = new javax.swing.JTextField();
        SaveDelegate = new javax.swing.JButton();
        DelegatePhoneLabel = new javax.swing.JLabel();
        DelegateNameLabel = new javax.swing.JLabel();
        DelegateAddressLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DelegateName.setName("DelegateName"); // NOI18N
        DelegateName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelegateNameActionPerformed(evt);
            }
        });

        DelegateAddress.setName("SupplierName"); // NOI18N
        DelegateAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelegateAddressActionPerformed(evt);
            }
        });

        DelegatePhone.setName("SupplierName"); // NOI18N
        DelegatePhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelegatePhoneActionPerformed(evt);
            }
        });

        SaveDelegate.setText("حفظ");
        SaveDelegate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDelegateActionPerformed(evt);
            }
        });

        DelegatePhoneLabel.setText("الهاتف");

        DelegateNameLabel.setText("المندوب");

        DelegateAddressLabel.setText("العنوان");
        
         scrollPane = new JScrollPane();
        
        JButton AddDelegate = new JButton("اضافة مندوب");
        AddDelegate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		AddDelegateMode();
        	}
        });
        AddDelegate.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent arg0) {
        		AddDelegateMode();
        	}
        });
        
        String col[] = {"كود العميل ","اسم العميل ","العنوان", "التليفون", "ملاحظات"};

	     tableModel = new DefaultTableModel(col, 0);
	
	    
	
	     basicServiceManager = new DelegateService();
	    	
	allDelegators = ((DelegateService) basicServiceManager).allDelegates();
	for (int i =0 ; i< allDelegators.size(); i++ ){
		Delegate del = (Delegate) allDelegators.get(i);
		Object [] obj = {del.getId(),del.getDelegateName(),del.getDelegateAddress(),del.getDelegatePhone()};

		tableModel.addRow( obj);
	}

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        					.addGap(36)
        					.addComponent(SaveDelegate, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap(23, Short.MAX_VALUE)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(DelegateAddress, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(AddDelegate)
        							.addGap(18)
        							.addComponent(DelegateName, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
        						.addComponent(DelegatePhone, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(DelegateNameLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        				.addComponent(DelegateAddressLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        				.addComponent(DelegatePhoneLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
        			.addGap(18))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(41)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(DelegateName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(DelegateNameLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        				.addComponent(AddDelegate))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(35)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(DelegateAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(DelegateAddressLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
        					.addGap(28)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(DelegatePhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(DelegatePhoneLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(156)
        					.addComponent(SaveDelegate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        			.addContainerGap(29, Short.MAX_VALUE))
        );
        
        AllDelegatesTable = new JTable();
        AllDelegatesTable.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		int row = AllDelegatesTable.getSelectedRow();
        		System.out.println("value  "+AllDelegatesTable.getModel().getValueAt(row, 0).toString());
        		SalesInvoice.getDelegateNumber().setText( AllDelegatesTable.getModel().getValueAt(row, 0).toString());
        		SalesInvoice.getDelegateName().setText(AllDelegatesTable.getModel().getValueAt(row, 1).toString());
//        		customerID = "123";
//        		customerName = "456";
        		//SalesInvoice.putCustomerInfo(customerID , customerName);
        		
        		//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        		dispose();
        		
        	}
        });
        
        scrollPane.setViewportView(AllDelegatesTable);
        AllDelegatesTable.setModel(tableModel);
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void DelegateNameActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    	
    	
    	
    }                                            

    private void DelegateAddressActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void DelegatePhoneActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void AddDelegateActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	basicServiceManager = new DelegateService();
    	Delegate = new Delegate();
    	Delegate.setDelegateName(DelegateName.getText());
    	Delegate.setDelegateAddress(DelegateAddress.getText());
    	Delegate.setDelegatePhone(DelegatePhone.getText());
    	
    	try {
			basicServiceManager.insertNewItem(Delegate);
			DelegateName.setText(""); 
			DelegateAddress.setText("");
			DelegatePhone.setText("");
			
			tableModel.setRowCount(0);
			
			Object [] obj = {Delegate.getId(),Delegate.getDelegateName(),Delegate.getDelegateAddress(),Delegate.getDelegatePhone()};

			tableModel.addRow( obj);
			
			
			SelectDelegateMode();
	    	    
	    	    scrollPane.setVisible(true);

		} catch (OperationFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	DelegateName.setText(""); 
    	DelegateAddress.setText("");
    	DelegatePhone.setText("");
    }                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddDelegate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDelegate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDelegate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDelegate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new AddDelegate().setVisible(true);
				} catch (PersistanceOperationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton SaveDelegate;
    private javax.swing.JTextField DelegateAddress;
    private javax.swing.JTextField DelegateName;
    private javax.swing.JTextField DelegatePhone;
    private javax.swing.JLabel DelegatePhoneLabel;
    private javax.swing.JLabel DelegateNameLabel;
    private javax.swing.JLabel DelegateAddressLabel;
    private javax.swing.JPanel jPanel1;
    private JTable AllDelegatesTable;
}
