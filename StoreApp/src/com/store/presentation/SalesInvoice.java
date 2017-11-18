package com.store.presentation;

import java.awt.ComponentOrientation;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

import javassist.compiler.Parser;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.store.database.exception.PersistanceOperationException;
import com.store.models.impl.Customer;
import com.store.models.impl.SaleInvoicDetail;
import com.store.models.impl.SaleInvoice;
import com.store.service.basic.BasicServiceManager;
import com.store.service.impl.CustomerService;
import com.store.service.impl.SalesInvoiceService;
import com.store.ws.service.exception.OperationFailureException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SalesInvoice extends javax.swing.JFrame {

	private BasicServiceManager basicServiceManager;
	private SaleInvoice saleInvoice;
	public static SalesInvoice salesInvoicePresentation;
	private SaleInvoicDetail saleInvoiceDetail;
	private List<SaleInvoicDetail> SaleInvoiceDetailList;
	AddCustomer addCustomer = null;
	AddDelegate addDelegate = null;
	AddProduct  addProduct = null;

	private static DefaultTableModel tableModel;
    
	public static DefaultTableModel getTableModel() {
		return tableModel;
	}
	
	
	public static javax.swing.JTextField getDelegateName() {
		return DelegateName;
	}

	public static javax.swing.JTextField getDelegateNumber() {
		return DelegateNumber;
	}

	public static javax.swing.JTextField getCustomerName() {
		return CustomerName;
	}

	public static javax.swing.JTextField getCustomerNumber() {
		return CustomerNumber;
	}

	public SalesInvoice() {
		initComponents();

		// CustomerNumber.addActionListener(this);
	}

	public static void putCustomerInfo(String id, String name) {
		CustomerNumber.setText(id);
		CustomerName.setText(name);

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		InvoiceNumber = new javax.swing.JTextField();
		DelegateName = new javax.swing.JTextField();
		CustomerName = new javax.swing.JTextField();
		CustomerNumber = new javax.swing.JTextField();
		CustomerNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == e.VK_F9) {

					try {
						addCustomer = new AddCustomer();
					} catch (PersistanceOperationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					addCustomer.setVisible(true);
					System.out.println("success");
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				try {
					AddCustomer addCustomer = new AddCustomer();
				} catch (PersistanceOperationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("success");
			}
		});
		DelegateNumber = new javax.swing.JTextField();
		DelegateNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == e.VK_F9) {

					try {
						addDelegate = new AddDelegate();
					} catch (PersistanceOperationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					addDelegate.setVisible(true);
					System.out.println("success");
				}
			}
		});
		jScrollPane1 = new javax.swing.JScrollPane();
		InvoiceDetail = new javax.swing.JTable();
		InvoiceDetail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == arg0.VK_ENTER) {
					tableModel.addRow(new Object[] { null, null, null, null,
							null, null });
				}
				

        		int col = InvoiceDetail.getSelectedColumn();
        		if (arg0.getKeyCode() == arg0.VK_F9 && col ==0 ) {
        			try {
						addProduct = new AddProduct();
					} catch (PersistanceOperationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			addProduct.setVisible(true);
				}
        		
        		
        		
        		
//        		System.out.println("value  "+AllCustomersTable.getModel().getValueAt(row, 0).toString());
//        		SalesInvoice.getCustomerNumber().setText( AllCustomersTable.getModel().getValueAt(row, 0).toString());
//        		SalesInvoice.getCustomerName().setText(AllCustomersTable.getModel().getValueAt(row, 1).toString());
//				
				
				
				
				
				
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}
		});
		TotalInvoice = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		DescountPercint = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		NetTotal = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		Notes = new javax.swing.JTextField();
		Date = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		TypeDate = new javax.swing.JButton();
		Save = new javax.swing.JButton();
		Delete = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel3.setText("رقم الفاتورة");

		jLabel4.setText("رقم العميل");

		jLabel5.setText("رقم المندوب");

		DelegateNumber.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DelegateNumberActionPerformed(evt);
			}
		});
		InvoiceDetail
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		tableModel = new javax.swing.table.DefaultTableModel(new Object[][] { {
				null, null, null, null, null, null } },

		new String[] { "رقم الصنف", "اسم الصنف", "الكمية", "الوحده",
				"سعر الوحده", "الاجمالي" });

		InvoiceDetail.setCellSelectionEnabled(true);
		// ListSelectionModel select= jTable1.getSelectionModel();
		// select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		InvoiceDetail.setModel(tableModel);
		jScrollPane1.setViewportView(InvoiceDetail);

		jLabel7.setText("اجمالي الفاتورة");

		jLabel8.setText("صافي الاجمالي");

		jLabel9.setText("نسبة الخصم");

		jLabel10.setText("ملاحظات");

		jLabel11.setText("التاريخ");

		TypeDate.setText("م");
		TypeDate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TypeDateActionPerformed(evt);
			}
		});

		Save.setText("حفظ");
		Save.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					SaveActionPerformed(evt);
				} catch (OperationFailureException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Delete.setText("حذف");
		Delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeleteActionPerformed(evt);
			}
		});

		JButton choseCustomer = new JButton("f9");
		choseCustomer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_F9) {
					try {
						AddCustomer addCustomer = new AddCustomer();
					} catch (PersistanceOperationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				CustomerNumber.setText(addCustomer.getCustomerID());
				CustomerName.setText(addCustomer.getCustomerName());
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(0, 685, Short.MAX_VALUE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																jLabel3,
																GroupLayout.PREFERRED_SIZE,
																62,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				Delete)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				Save)))
										.addGap(28))
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				TypeDate)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				Date,
																				GroupLayout.PREFERRED_SIZE,
																				150,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				jLabel11,
																				GroupLayout.PREFERRED_SIZE,
																				38,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				choseCustomer,
																				GroupLayout.PREFERRED_SIZE,
																				44,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)))
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												CustomerName,
																												GroupLayout.PREFERRED_SIZE,
																												181,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												CustomerNumber,
																												GroupLayout.PREFERRED_SIZE,
																												49,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								InvoiceNumber,
																								GroupLayout.PREFERRED_SIZE,
																								84,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				jLabel4,
																				GroupLayout.PREFERRED_SIZE,
																				62,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(30))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				DelegateName,
																				GroupLayout.PREFERRED_SIZE,
																				181,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				DelegateNumber,
																				GroupLayout.PREFERRED_SIZE,
																				51,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				jLabel5,
																				GroupLayout.PREFERRED_SIZE,
																				62,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())))
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(0, 37, Short.MAX_VALUE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				Notes,
																				GroupLayout.PREFERRED_SIZE,
																				251,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				316,
																				Short.MAX_VALUE)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												DescountPercint,
																												GroupLayout.PREFERRED_SIZE,
																												87,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												jLabel9,
																												GroupLayout.PREFERRED_SIZE,
																												85,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												NetTotal,
																												GroupLayout.PREFERRED_SIZE,
																												87,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												jLabel8,
																												GroupLayout.PREFERRED_SIZE,
																												85,
																												GroupLayout.PREFERRED_SIZE))))
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				Alignment.TRAILING,
																				false)
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addGap(209)
																						.addComponent(
																								jLabel10,
																								GroupLayout.PREFERRED_SIZE,
																								51,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								TotalInvoice,
																								GroupLayout.PREFERRED_SIZE,
																								87,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.UNRELATED)
																						.addComponent(
																								jLabel7,
																								GroupLayout.PREFERRED_SIZE,
																								85,
																								GroupLayout.PREFERRED_SIZE))
																		.addComponent(
																				jScrollPane1,
																				GroupLayout.PREFERRED_SIZE,
																				712,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(45)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																Save,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																Delete,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(
																jLabel3,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				InvoiceNumber,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				Date,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jLabel11,
																				GroupLayout.PREFERRED_SIZE,
																				26,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				TypeDate)))
										.addPreferredGap(
												ComponentPlacement.RELATED,
												122, Short.MAX_VALUE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jLabel4,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																CustomerNumber,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																CustomerName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																choseCustomer,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jLabel5,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																DelegateNumber,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																DelegateName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addComponent(jScrollPane1,
												GroupLayout.PREFERRED_SIZE,
												279, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																Alignment.BASELINE,
																false)
														.addComponent(
																jLabel7,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																TotalInvoice,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabel10,
																GroupLayout.PREFERRED_SIZE,
																28,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								DescountPercint,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel9,
																								GroupLayout.PREFERRED_SIZE,
																								28,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								jLabel8,
																								GroupLayout.PREFERRED_SIZE,
																								28,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								NetTotal,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																Notes,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(71)));
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void DelegateNumberActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_DelegateNumberActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_DelegateNumberActionPerformed

	private void TypeDateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TypeDateActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_TypeDateActionPerformed

	private void SaveActionPerformed(java.awt.event.ActionEvent evt)
			throws OperationFailureException {// GEN-FIRST:event_SaveActionPerformed

		basicServiceManager = new SalesInvoiceService();
		saleInvoice = new SaleInvoice();
		saleInvoice.setCustomerID(CustomerNumber.getText());
		saleInvoice.setDelegatID(DelegateNumber.getText());
		saleInvoice.setInvoiceSaleDate(Long.parseLong(Date.getText()));

		SaleInvoiceDetailList = new ArrayList<SaleInvoicDetail>();
		for (int i = 0; i < InvoiceDetail.getRowCount(); i++) {
			saleInvoiceDetail = new SaleInvoicDetail();

			// saleInvoiceDetail.setInvoiceSaleDetailDiscount(Integer.parseInt((jTable1.getModel().getValueAt(i,
			// 5)).toString()));
			saleInvoiceDetail.setInvoiceSaleDetailPrice(Double
					.parseDouble((InvoiceDetail.getModel().getValueAt(i, 4))
							.toString()));
			saleInvoiceDetail.setInvoiceSaleDetailQuantity(Integer
					.parseInt((InvoiceDetail.getModel().getValueAt(i, 2))
							.toString()));
			saleInvoiceDetail.setProductID(Integer.parseInt((InvoiceDetail
					.getModel().getValueAt(i, 0)).toString()));

			saleInvoiceDetail.setSaleInvoice(saleInvoice);
			saleInvoice.setSaleInvoiceDetailList(SaleInvoiceDetailList);

			// SaleInvoiceDetailList.set(i, saleInvoiceDetail);
			SaleInvoiceDetailList.add(saleInvoiceDetail);

		}

		saleInvoice.setSaleInvoiceDetailList(SaleInvoiceDetailList);

		basicServiceManager.insertNewItem(saleInvoice);

	}// GEN-LAST:event_SaveActionPerformed

	private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_DeleteActionPerformed
	// tableModel.addRow(new Object[]{null,null,null,null,null,null});

	}// GEN-LAST:event_DeleteActionPerformed

	void test() throws OperationFailureException {
		basicServiceManager = new SalesInvoiceService();
		saleInvoice = new SaleInvoice();
		saleInvoice.setCustomerID("123");
		saleInvoice.setDelegatID("123");
		saleInvoice.setInvoiceSaleDate(23102017L);

		SaleInvoiceDetailList = new ArrayList<SaleInvoicDetail>();
		for (int i = 0; i < 4; i++) {
			saleInvoiceDetail = new SaleInvoicDetail();

			saleInvoiceDetail.setInvoiceSaleDetailDiscount(22);
			saleInvoiceDetail.setInvoiceSaleDetailPrice(33D);
			saleInvoiceDetail.setInvoiceSaleDetailQuantity(55);
			saleInvoiceDetail.setProductID(11);

			saleInvoiceDetail.setSaleInvoice(saleInvoice);
			saleInvoice.setSaleInvoiceDetailList(SaleInvoiceDetailList);

			// SaleInvoiceDetailList.set(i, saleInvoiceDetail);
			SaleInvoiceDetailList.add(saleInvoiceDetail);

		}

		saleInvoice.setSaleInvoiceDetailList(SaleInvoiceDetailList);

		basicServiceManager.insertNewItem(saleInvoice);

		// SaleInvoiceDetailList. get(0).setInvoiceSaleDetailPrice(20.5);
		// SaleInvoiceDetailList.get(0).setInvoiceSaleDetailQuantity(3);
		// SaleInvoiceDetailList.get(0).setInvoiceSaleDetailDiscount(10);
		// SaleInvoiceDetailList.get(0).setProductID(2);
		//
		// SaleInvoiceDetailList.get(1).setInvoiceSaleDetailPrice(22.5);
		// SaleInvoiceDetailList.get(1).setInvoiceSaleDetailQuantity(32);
		// SaleInvoiceDetailList.get(1).setInvoiceSaleDetailDiscount(12);
		// SaleInvoiceDetailList.get(1).setProductID(22);

	}

	// public static void main(String args[]) throws OperationFailureException {
	// SalesInvoice ss = new SalesInvoice();
	//
	// ss.test();
	//
	// }

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(SalesInvoice.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SalesInvoice.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SalesInvoice.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SalesInvoice.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				salesInvoicePresentation = new SalesInvoice();

				salesInvoicePresentation
						.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				salesInvoicePresentation.pack();
				salesInvoicePresentation.setLocationRelativeTo(null);

				salesInvoicePresentation.setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private static javax.swing.JTextField CustomerName;
	private static javax.swing.JTextField CustomerNumber;
	private javax.swing.JTextField Date;
	private static javax.swing.JTextField DelegateName;
	private static javax.swing.JTextField DelegateNumber;
	private javax.swing.JButton Delete;
	private javax.swing.JTextField DescountPercint;
	private javax.swing.JTextField InvoiceNumber;
	private javax.swing.JTextField NetTotal;
	private javax.swing.JTextField Notes;
	private javax.swing.JButton Save;
	private javax.swing.JTextField TotalInvoice;
	private javax.swing.JButton TypeDate;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable InvoiceDetail;

	// @Override
	// public void actionPerformed(ActionEvent e) {
	// try {
	// AddCustomer addCustomer = new AddCustomer();
	// } catch (PersistanceOperationException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// }
	// }
}
