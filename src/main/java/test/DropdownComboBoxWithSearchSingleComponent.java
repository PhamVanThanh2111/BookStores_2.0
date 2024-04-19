package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class DropdownComboBoxWithSearchSingleComponent extends JFrame {
    private JComboBox<String> comboBox;
    private List<String> items;

    public DropdownComboBoxWithSearchSingleComponent() {
        super("Dropdown ComboBox with Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Orange");
        items.add("Pineapple");
        items.add("Grapes");

        comboBox = new JComboBox<>(items.toArray(new String[0]));
        comboBox.setEditable(true);
        comboBox.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					String searchText = comboBox.getEditor().getItem().toString().toLowerCase();
//					ArrayList<String> filteredItems = new ArrayList<String>();
//					for (String item : items) {
//						if (item.toLowerCase().contains(searchText)) {
//							filteredItems.add(item);
//						}
//					}
//					themArrayListVaoComboBox(filteredItems, comboBox);
					System.out.println("type");
				}
			}
		});

        add(comboBox);
        setSize(300, 200);
        pack();
        setLocationRelativeTo(null);
    }
    
    private void themArrayListVaoComboBox(ArrayList<String> a, JComboBox<String> b) {
		b.removeAllItems();
		for (String item : a) {
			b.addItem(item);
		}
	}

    private void filterItems(String searchText) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (String item : items) {
            if (item.toLowerCase().contains(searchText.toLowerCase())) {
                model.addElement(item);
            }
        }
        comboBox.setModel(model);
//        comboBox.setPopupVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DropdownComboBoxWithSearchSingleComponent frame = new DropdownComboBoxWithSearchSingleComponent();
            frame.setVisible(true);
        });
    }
}
