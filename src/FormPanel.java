import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JLabel taxLabel;
	private JLabel ageLabel;
	private JLabel genderLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JTextField taxField;
	private JList<String> ageList;
	private JComboBox<String> empCombo;
	private JCheckBox citizenCheck;
	private ButtonGroup genderGroup;
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private JButton okBtn;
	
	private FormListener formListener;

	FormPanel() {

		setUpComponents();
		setUpVisuals();
	}

	private void disableTaxId() {
		
		taxLabel.setEnabled(false);
		taxField.setEnabled(false);
	}

	private void instantiateComponents() {
		
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		taxLabel = new JLabel("Tax ID: ");
		ageLabel = new JLabel("Age category: ");
		genderLabel = new JLabel("Age category: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		ageList = new JList<>();
		empCombo = new JComboBox<>();
		citizenCheck = new JCheckBox();
		taxField = new JTextField(10);
		maleRadio = new JRadioButton("Male");
		femaleRadio = new JRadioButton("Female");
		genderGroup = new ButtonGroup();
		okBtn = new JButton("OK");
	}

	private void refreshTaxIdVisibility() {
		
		citizenCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isTicked = citizenCheck.isSelected();
				taxLabel.setEnabled(isTicked);
				taxField.setEnabled(isTicked);
			}
		});
	}

	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}

	private void setUpAgeListBox() {
		
		DefaultListModel<String> ageModel = new DefaultListModel<>();
		ageModel.addElement("Under 18");
		ageModel.addElement("18 to 65");
		ageModel.addElement("65 or over");

		ageList.setModel(ageModel);
		ageList.setSelectedIndex(1);
		ageList.setPreferredSize(new Dimension(114, 68));
		ageList.setBorder(BorderFactory.createEtchedBorder());
	}

	private void setUpComponents() {

		instantiateComponents();

		setUpGenderRadios();
		setUpTaxIdTextField();
		setUpAgeListBox();
		setUpEmploymentComboBox();
		setUpOkButton();

		setUpMnemonics();
	}

	private void setUpDimensions() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
	}

	private void setUpEmploymentComboBox() {
		
		DefaultComboBoxModel<String> empModel = new DefaultComboBoxModel<>();
		empModel.addElement("Employed");
		empModel.addElement("Selfemployed");
		empModel.addElement("Unemployed");

		empCombo.setModel(empModel);
	}

	private void setUpFormBorder() {
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	}

	private void setUpGenderRadios() {
		
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);
		maleRadio.setSelected(true);
		maleRadio.setActionCommand("male");
		femaleRadio.setActionCommand("female");
	}

	private void setUpLayout() {
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// First row
		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nameField, gc);

		// Next row
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(occupationLabel, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(occupationField, gc);

		// Next row
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(ageLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(ageList, gc);

		// Next row
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(4, 0, 0, 5);
		add(new JLabel("Employment: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(empCombo, gc);

		// Next row
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(1, 0, 0, 5);
		add(new JLabel("US Citizen: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(citizenCheck, gc);

		// Next row
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(1, 0, 0, 5);
		add(taxLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(taxField, gc);

		// Next row
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.01;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(2, 0, 0, 5);
		add(genderLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(maleRadio, gc);

		// Next row
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.01;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(femaleRadio, gc);

		// Next row
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(okBtn, gc);
	}

	private void setUpMnemonics() {
		
		okBtn.setMnemonic(KeyEvent.VK_O);
		nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		nameLabel.setLabelFor(nameField);
	}

	private void setUpOkButton() {
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = nameField.getText();
				String occupation = occupationField.getText();
				int ageCat = (int) ageList.getSelectedIndex();
				String empCat = (String) empCombo.getSelectedItem();
				String taxId = taxField.getText();
				boolean usCitizen = citizenCheck.isSelected();
				String genderCommand = genderGroup.getSelection().getActionCommand();

				FormDataObject formData = new FormDataObject(name, occupation, ageCat, empCat, taxId, usCitizen,
						genderCommand);

				FormEvent formEvent = new FormEvent(this, formData);
				if (formListener != null) {
					formListener.formEventOccured(formEvent);
				}
			}
		});
	}

	private void setUpTaxIdTextField() {
		disableTaxId();
		refreshTaxIdVisibility();
	}

	private void setUpVisuals() {

		setUpDimensions();
		setUpFormBorder();
		setUpLayout();
	}
}
