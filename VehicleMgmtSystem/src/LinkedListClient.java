

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class LinkedListClient {

	public JFrame frame;
	private final JPanel navigationPanel = new JPanel();
	JPanel homePanel = new JPanel();
	JPanel insertPanel = new JPanel();
	JPanel modifyPanel = new JPanel();

	JLabel home = new JLabel("");
	JLabel InsertVehicle = new JLabel("INSERT VEHICLE");
	JLabel ModifyVehicle = new JLabel("MODIFY VEHICLE");
	JLabel SearchVehicle = new JLabel("SEARCH VEHICLE");
	JLabel DeleteVehicle = new JLabel("DELETE VEHICLE");
	private final JLabel lblVehicleManagementSystem = new JLabel("Vehicle Management System");
	private final JLabel lblNewLabel = new JLabel("Insert New Vehicles");
	private final JLabel lblModifyVehicle = new JLabel("Modify Existing Vehicles");
	private final JLabel lblMake = new JLabel("Make");
	private final JLabel lblModel = new JLabel("Model");
	private final JLabel lblEngine = new JLabel("Engine");
	private final JLabel lblYear = new JLabel("Year");
	private final JLabel lblDoors = new JLabel("Doors");
	private final JLabel lblSeats = new JLabel("Seats");
	private final JLabel lblWeight = new JLabel("Weight");
	private final JLabel lblFuelCapacity = new JLabel("Fuel Capacity");
	private final JLabel lblFuelAverage = new JLabel("Fuel Average");
	private final JLabel lblPrice = new JLabel("Price");

	private JTextField modelTF = new JTextField();
	private JTextField engineTF = new JTextField();
	private JTextField yearTF = new JTextField();
	private JTextField doorsTF = new JTextField();
	private JTextField seatsTF = new JTextField();
	private JTextField weightTF = new JTextField();
	private JTextField fuelCapacityTF = new JTextField();
	private JTextField fuelAverageTF = new JTextField();
	private JTextField priceTF = new JTextField();
	JLabel vehicleIDLbl = new JLabel("0");
	int newVehicleID = 0;

	JComboBox<String> makeCB = new JComboBox<String>();
	JComboBox<Integer> vehicleIDCB = new JComboBox<Integer>();

	private final JPanel searchPanel = new JPanel();
	private final JLabel lblSearchVehicle = new JLabel("Search Existing Vehicles");
	private final JPanel deletePanel = new JPanel();
	private final JLabel lblDeleteVehicle = new JLabel("Delete Existing Vehicles");
	public static LinkedListInterface linkedlistInt;
	private JButton btnClose;
	private JTextField minPriceSearchTF;
	private JTextField maxPriceSearchTF;

	JComboBox<Integer> deleteVehicleIDCB = new JComboBox<Integer>();
	JButton btnDeleteVehicle = new JButton("DELETE");
	private JTextField modelUpdateTF;
	private JTextField yearUpdateTF;
	private JTextField engineUpdateTF;
	private JTextField doorsUpdateTF;
	private JTextField seatsUpdateTF;
	private JTextField weightUpdateTF;
	private JTextField fuelCapacityUpdateTF;
	private JTextField fuelAverageUpdateTF;
	private JTextField priceUpdateTF;

	public int currentVehicleIndex = 0;
	JComboBox<Integer> vehicleSearchIDCB = new JComboBox<Integer>();
	JLabel vehicle_id = new JLabel("New label");
	JLabel vehicle_make = new JLabel("New label");
	JLabel vehicle_price = new JLabel("New label");
	JButton btnPrev = new JButton("<");
	JButton btnNext = new JButton(">");
	JRadioButton searchByIDRadioBtn = new JRadioButton("ID");
	JRadioButton searchByMakeRadioBtn = new JRadioButton("Make");
	JRadioButton searchByPriceRadioBtn = new JRadioButton("Price");
	private final ButtonGroup buttonGroup = new ButtonGroup();

	JComboBox<String> makeSearchCB = new JComboBox<String>();
	List<Integer> vehicleIDArray = new ArrayList<Integer>();
	private final JLabel lblDoors_2 = new JLabel("Doors : ");
	private final JLabel lblSeats_2 = new JLabel("Seats : ");
	private final JLabel lblWeight_2 = new JLabel("Weight : ");
	private final JLabel vehicle_doors = new JLabel("0");
	private final JLabel vehicle_seats = new JLabel("0");
	private final JLabel vehicle_weight = new JLabel("0");
	private final JLabel lblFuelCapactiy = new JLabel("Fuel Capactiy : ");
	private final JLabel lblFuelAverage_2 = new JLabel("Fuel Average : ");
	private final JLabel vehicle_fuelCapacity = new JLabel("0");
	private final JLabel vehicle_fuelAverage = new JLabel("0");
	private final JLabel vehicle_model = new JLabel("0");
	private final JLabel lblEngine_2 = new JLabel("Model : ");
	private final JLabel lblPrevious = new JLabel("Previous");
	private final JLabel lblNext = new JLabel("Next");
	private final JLabel label = new JLabel("Engine : ");
	private final JLabel vehicle_engine = new JLabel("0");
	private final JLabel lblYear_2 = new JLabel("Year : ");
	private final JLabel vehicle_year = new JLabel("0.0");
	private final JLabel label_1 = new JLabel("<-- Click on the Links ");
	private final JLabel lblEuro = new JLabel("EURO");
	private final JLabel lblLkm = new JLabel("L/100Km");
	private final JLabel lblLitres = new JLabel("Litres");
	private final JLabel label_2 = new JLabel("L/100Km");
	private final JLabel label_3 = new JLabel("Litres");
	private final JLabel label_4 = new JLabel("EURO");
	private final JLabel label_5 = new JLabel("L/100Km");
	private final JLabel label_6 = new JLabel("Litres");
	private final JLabel label_7 = new JLabel("EURO");
	private final JLabel lblKg = new JLabel("Kg");
	private final JLabel lblKg_1 = new JLabel("Kg");
	private final JLabel lblKg_2 = new JLabel("Kg");
	private final JLabel lblKg_3 = new JLabel("Kg");
	private final JLabel label_8 = new JLabel("Litres");
	private final JLabel lblLkm_1 = new JLabel("L/100Km");
	private final JLabel lblEuro_1 = new JLabel("EURO");

	public static void connectRMIServer() throws MalformedURLException, RemoteException, NotBoundException {
		String url = "rmi://172.19.96.60/";
		linkedlistInt = (LinkedListInterface) Naming.lookup(url + "list");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinkedListClient window = new LinkedListClient();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LinkedListClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			connectRMIServer();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Server is not running!!");
			System.out.print(e2);
//			System.exit(0);

		}
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				setVehicleID();
				getAllVehicleIDs();
			}

		});
		frame.setBounds(100, 100, 827, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		deletePanel.setBounds(283, 0, 543, 594);
		frame.getContentPane().add(deletePanel);
		deletePanel.setLayout(null);
		lblDeleteVehicle.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblDeleteVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteVehicle.setBounds(60, 40, 420, 35);

		deletePanel.add(lblDeleteVehicle);

		JLabel lblVehicleId_2 = new JLabel("Vehicle ID: ");
		lblVehicleId_2.setBounds(171, 101, 78, 16);
		deletePanel.add(lblVehicleId_2);

		deleteVehicleIDCB.setBounds(261, 97, 120, 27);
		deletePanel.add(deleteVehicleIDCB);
		btnDeleteVehicle.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));

		btnDeleteVehicle.setBounds(205, 530, 140, 35);
		deletePanel.add(btnDeleteVehicle);

		JLabel lblMake_2 = new JLabel("Make : ");
		lblMake_2.setBounds(60, 160, 61, 16);
		deletePanel.add(lblMake_2);

		JLabel lblEngine_1 = new JLabel("Engine : ");
		lblEngine_1.setBounds(60, 210, 61, 16);
		deletePanel.add(lblEngine_1);

		JLabel lblDoors_1 = new JLabel("Doors : ");
		lblDoors_1.setBounds(60, 260, 61, 16);
		deletePanel.add(lblDoors_1);

		JLabel lblModel_1 = new JLabel("Model : ");
		lblModel_1.setBounds(311, 160, 61, 16);
		deletePanel.add(lblModel_1);

		JLabel lblYear_1 = new JLabel("Year : ");
		lblYear_1.setBounds(311, 210, 61, 16);
		deletePanel.add(lblYear_1);

		JLabel lblSeats_1 = new JLabel("Seats : ");
		lblSeats_1.setBounds(311, 260, 61, 16);
		deletePanel.add(lblSeats_1);

		JLabel lblWeight_1 = new JLabel("Weight : ");
		lblWeight_1.setBounds(60, 310, 61, 16);
		deletePanel.add(lblWeight_1);

		JLabel lblFuelCapacity_1 = new JLabel("Fuel Capacity : ");
		lblFuelCapacity_1.setBounds(60, 360, 105, 16);
		deletePanel.add(lblFuelCapacity_1);

		JLabel lblFuelAverage_1 = new JLabel("Fuel Average : ");
		lblFuelAverage_1.setBounds(60, 410, 92, 16);
		deletePanel.add(lblFuelAverage_1);

		JLabel lblPrice_1 = new JLabel("Price : ");
		lblPrice_1.setBounds(188, 460, 61, 16);
		deletePanel.add(lblPrice_1);

		JLabel lblFuelCapacityInfo = new JLabel("fuelCapacityInfo");
		lblFuelCapacityInfo.setBounds(164, 360, 66, 16);
		deletePanel.add(lblFuelCapacityInfo);

		JLabel lblFuelAverageInfo = new JLabel("fuelAverageInfo");
		lblFuelAverageInfo.setBounds(164, 410, 66, 16);
		deletePanel.add(lblFuelAverageInfo);

		JLabel lblPriceInfo = new JLabel("0");
		lblPriceInfo.setBounds(233, 460, 61, 16);
		deletePanel.add(lblPriceInfo);

		JLabel lblWeightInfo = new JLabel("weightInfo");
		lblWeightInfo.setBounds(164, 310, 117, 16);
		deletePanel.add(lblWeightInfo);

		JLabel lblDoorsInfo = new JLabel("doorsInfo");
		lblDoorsInfo.setBounds(164, 260, 117, 16);
		deletePanel.add(lblDoorsInfo);

		JLabel lblEngineInfo = new JLabel("engineInfo");
		lblEngineInfo.setBounds(164, 210, 117, 16);
		deletePanel.add(lblEngineInfo);

		JLabel lblMakeInfo = new JLabel("makeInfo");
		lblMakeInfo.setBounds(164, 160, 117, 16);
		deletePanel.add(lblMakeInfo);

		JLabel lblModelInfo = new JLabel("modelInfo");
		lblModelInfo.setBounds(386, 160, 94, 16);
		deletePanel.add(lblModelInfo);

		JLabel lblYearInfo = new JLabel("yearInfo");
		lblYearInfo.setBounds(386, 210, 94, 16);
		deletePanel.add(lblYearInfo);

		JLabel lblSeatsInfo = new JLabel("seatsInfo");
		lblSeatsInfo.setBounds(386, 260, 94, 16);
		deletePanel.add(lblSeatsInfo);
		label_5.setBounds(233, 410, 61, 16);

		deletePanel.add(label_5);
		label_6.setBounds(233, 360, 61, 16);

		deletePanel.add(label_6);
		label_7.setBounds(306, 460, 61, 16);

		deletePanel.add(label_7);
		lblKg.setBounds(233, 310, 61, 16);

		deletePanel.add(lblKg);
		deletePanel.setVisible(false);

		btnDeleteVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int vehicleID = (int) deleteVehicleIDCB.getSelectedItem();
				try {
					linkedlistInt.deleteVehicle(vehicleID);
					JOptionPane.showMessageDialog(null, "Vehicle has been Deleted!!");
					getAllVehicleIDs();
				} catch (RemoteException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});

		deleteVehicleIDCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					try {
						int idprovider = Integer.parseInt(deleteVehicleIDCB.getSelectedItem().toString());
						LinkNode selectedVehicle = linkedlistInt.getVehicleInfo(idprovider);

						lblMakeInfo.setText(selectedVehicle.getMake());
						lblModelInfo.setText(selectedVehicle.getModel());
						lblEngineInfo.setText(selectedVehicle.getEngine());
						lblYearInfo.setText(String.valueOf(selectedVehicle.getYear()));
						lblDoorsInfo.setText(String.valueOf(selectedVehicle.getDoors()));
						lblSeatsInfo.setText(String.valueOf(selectedVehicle.getSeats()));
						lblPriceInfo.setText(String.valueOf(selectedVehicle.getPrice()));
						lblWeightInfo.setText(String.valueOf(selectedVehicle.getWeight()));
						lblFuelCapacityInfo.setText(String.valueOf(selectedVehicle.getFuelCapacity()));
						lblFuelAverageInfo.setText(String.valueOf(selectedVehicle.getFuelAverage()));

					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		searchPanel.setBounds(284, 0, 542, 594);
		frame.getContentPane().add(searchPanel);
		searchPanel.setLayout(null);
		lblSearchVehicle.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblSearchVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchVehicle.setBounds(60, 40, 420, 35);

		searchPanel.add(lblSearchVehicle);

		JLabel lblId = new JLabel("Jump to ID");
		lblId.setBounds(60, 148, 88, 16);
		searchPanel.add(lblId);

		JLabel lblMinPrice = new JLabel("Min Price");
		lblMinPrice.setBounds(60, 204, 71, 16);
		searchPanel.add(lblMinPrice);

		minPriceSearchTF = new JTextField();
		minPriceSearchTF.setBorder(new LineBorder(new Color(0, 0, 0)));
		minPriceSearchTF.setEnabled(false);
		minPriceSearchTF.setColumns(10);
		minPriceSearchTF.setBounds(60, 222, 130, 30);
		searchPanel.add(minPriceSearchTF);

		JLabel lblMaxPrice = new JLabel("Max Price");
		lblMaxPrice.setBounds(202, 204, 61, 16);
		searchPanel.add(lblMaxPrice);

		maxPriceSearchTF = new JTextField();
		maxPriceSearchTF.setBorder(new LineBorder(new Color(0, 0, 0)));
		maxPriceSearchTF.setEnabled(false);
		maxPriceSearchTF.setColumns(10);
		maxPriceSearchTF.setBounds(202, 222, 130, 30);
		searchPanel.add(maxPriceSearchTF);

		JLabel lblMake_1 = new JLabel("Make");
		lblMake_1.setBounds(202, 146, 61, 16);
		searchPanel.add(lblMake_1);
		makeSearchCB.setBorder(null);

		makeSearchCB.setModel(new DefaultComboBoxModel<String>(new String[] { "SELECT", "AUDI", "BENTLEY", "BMW",
				"CHEVROLET", "FERRARI", "FIAT", "FORD", "HONDA", "HYUNDAI", "ISUZU", "JAGUAR", "JEEP", "KIA",
				"LAND ROVER", "LEXUS", "MASERATI", "MERCEDES-BENZ", "MITSUBISHI", "NISSAN", "PORSCHE", "RENAULT",
				"ROLLS-ROYCE", "SEAT", "SKODA", "SUZUKI", "TESLA", "TOYOTA", "VOLKSWAGEN", "VOLVO" }));
		makeSearchCB.setEnabled(false);
		makeSearchCB.setBounds(202, 165, 130, 30);
		searchPanel.add(makeSearchCB);

		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (minPriceSearchTF.getText().equals("") || maxPriceSearchTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Min or Max price cannot be Empty!!");
				} else {
					setSearchValues("vehiclePrice");
				}
			}
		});
		btnSearch.setBounds(344, 220, 140, 35);
		searchPanel.add(btnSearch);

		JPanel searchVehiclePanel = new JPanel();
		searchVehiclePanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		searchVehiclePanel.setBounds(60, 270, 420, 306);
		searchPanel.add(searchVehiclePanel);
		searchVehiclePanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Vehicle ID :");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1.setBounds(18, 21, 85, 16);
		searchVehiclePanel.add(lblNewLabel_1);

		JLabel lblMake_3 = new JLabel("Make :  ");
		lblMake_3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMake_3.setBounds(18, 59, 61, 16);
		searchVehiclePanel.add(lblMake_3);

		JLabel lblPrice_2 = new JLabel("Price : ");
		lblPrice_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPrice_2.setBounds(119, 264, 61, 16);
		searchVehiclePanel.add(lblPrice_2);

		vehicle_id.setBounds(108, 21, 61, 16);
		searchVehiclePanel.add(vehicle_id);

		vehicle_make.setBounds(108, 59, 112, 16);
		searchVehiclePanel.add(vehicle_make);

		vehicle_price.setBounds(175, 264, 80, 16);
		searchVehiclePanel.add(vehicle_price);
		lblDoors_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDoors_2.setBounds(270, 21, 61, 16);

		searchVehiclePanel.add(lblDoors_2);
		lblSeats_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblSeats_2.setBounds(270, 59, 61, 16);

		searchVehiclePanel.add(lblSeats_2);
		lblWeight_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblWeight_2.setBounds(270, 97, 61, 16);

		searchVehiclePanel.add(lblWeight_2);
		vehicle_doors.setBounds(343, 21, 61, 16);

		searchVehiclePanel.add(vehicle_doors);
		vehicle_seats.setBounds(343, 59, 61, 16);

		searchVehiclePanel.add(vehicle_seats);
		vehicle_weight.setBounds(343, 97, 61, 16);

		searchVehiclePanel.add(vehicle_weight);
		lblFuelCapactiy.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblFuelCapactiy.setBounds(91, 197, 106, 16);

		searchVehiclePanel.add(lblFuelCapactiy);
		lblFuelAverage_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblFuelAverage_2.setBounds(91, 236, 106, 16);

		searchVehiclePanel.add(lblFuelAverage_2);
		vehicle_fuelCapacity.setBounds(203, 197, 61, 16);

		searchVehiclePanel.add(vehicle_fuelCapacity);
		vehicle_fuelAverage.setBounds(203, 236, 61, 16);

		searchVehiclePanel.add(vehicle_fuelAverage);
		vehicle_model.setBounds(108, 97, 61, 16);

		searchVehiclePanel.add(vehicle_model);
		lblEngine_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblEngine_2.setBounds(18, 97, 85, 16);

		searchVehiclePanel.add(lblEngine_2);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		label.setBounds(18, 138, 85, 16);

		searchVehiclePanel.add(label);
		vehicle_engine.setBounds(108, 138, 61, 16);

		searchVehiclePanel.add(vehicle_engine);
		lblYear_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblYear_2.setBounds(270, 138, 61, 16);

		searchVehiclePanel.add(lblYear_2);
		vehicle_year.setBounds(343, 138, 61, 16);

		searchVehiclePanel.add(vehicle_year);
		lblKg_3.setBounds(392, 97, 22, 16);

		searchVehiclePanel.add(lblKg_3);
		label_8.setBounds(270, 197, 61, 16);

		searchVehiclePanel.add(label_8);
		lblLkm_1.setBounds(270, 236, 61, 16);

		searchVehiclePanel.add(lblLkm_1);
		lblEuro_1.setBounds(260, 264, 61, 16);

		searchVehiclePanel.add(lblEuro_1);
		vehicleSearchIDCB.setBorder(null);
		vehicleSearchIDCB.setEnabled(false);

		vehicleSearchIDCB.setBounds(60, 165, 130, 30);
		searchPanel.add(vehicleSearchIDCB);

		buttonGroup.add(searchByIDRadioBtn);

		searchByIDRadioBtn.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				vehicleSearchIDCB.setEnabled(true);
				makeSearchCB.setEnabled(false);

				maxPriceSearchTF.setEnabled(false);
				minPriceSearchTF.setEnabled(false);
			}
		});
		searchByMakeRadioBtn.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				makeSearchCB.setEnabled(true);
				vehicleSearchIDCB.setEnabled(false);

				maxPriceSearchTF.setEnabled(false);
				minPriceSearchTF.setEnabled(false);
			}
		});
		buttonGroup.add(searchByPriceRadioBtn);

		searchByPriceRadioBtn.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				maxPriceSearchTF.setEnabled(true);
				minPriceSearchTF.setEnabled(true);

				makeSearchCB.setEnabled(false);
				vehicleSearchIDCB.setEnabled(false);

			}
		});

		searchByIDRadioBtn.setBounds(155, 100, 80, 23);
		searchPanel.add(searchByIDRadioBtn);

		buttonGroup.add(searchByMakeRadioBtn);
		searchByMakeRadioBtn.setBounds(230, 100, 80, 23);
		searchPanel.add(searchByMakeRadioBtn);

		searchByPriceRadioBtn.setBounds(320, 100, 71, 23);

		searchPanel.add(searchByPriceRadioBtn);
		btnPrev.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnPrev.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnPrev.setBounds(12, 402, 40, 40);
		searchPanel.add(btnPrev);
		btnNext.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnNext.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnNext.setBounds(490, 402, 40, 40);
		searchPanel.add(btnNext);
		lblPrevious.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblPrevious.setBounds(8, 443, 61, 16);

		searchPanel.add(lblPrevious);
		lblNext.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNext.setBounds(495, 443, 40, 16);

		searchPanel.add(lblNext);

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentVehicleIndex != vehicleIDArray.size() - 1) {
					currentVehicleIndex = currentVehicleIndex + 1;

					LinkNode currentVehicleInfo;
					try {
						currentVehicleInfo = linkedlistInt.searchByID(vehicleIDArray.get(currentVehicleIndex));
						vehicle_id.setText("" + currentVehicleInfo.getId());
						vehicle_make.setText("" + currentVehicleInfo.getMake());
						vehicle_model.setText("" + currentVehicleInfo.getModel());
						vehicle_year.setText("" + currentVehicleInfo.getYear());
						vehicle_engine.setText("" + currentVehicleInfo.getEngine());
						vehicle_price.setText("" + currentVehicleInfo.getPrice());
						vehicle_doors.setText("" + currentVehicleInfo.getDoors());
						vehicle_seats.setText("" + currentVehicleInfo.getSeats());
						vehicle_weight.setText("" + currentVehicleInfo.getWeight());
						vehicle_fuelCapacity.setText("" + currentVehicleInfo.getFuelCapacity());
						vehicle_fuelAverage.setText("" + currentVehicleInfo.getFuelAverage());
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}

				if (currentVehicleIndex == vehicleIDArray.size() - 1) {
					btnNext.setEnabled(false);
					btnPrev.setEnabled(true);
				} else {
					btnPrev.setEnabled(true);
					btnNext.setEnabled(true);
				}

			}
		});

		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentVehicleIndex != 0) {
					currentVehicleIndex = currentVehicleIndex - 1;

					LinkNode currentVehicleInfo;
					try {
						currentVehicleInfo = linkedlistInt.searchByID(vehicleIDArray.get(currentVehicleIndex));
						vehicle_id.setText("" + currentVehicleInfo.getId());
						vehicle_make.setText("" + currentVehicleInfo.getMake());
						vehicle_model.setText("" + currentVehicleInfo.getModel());
						vehicle_year.setText("" + currentVehicleInfo.getYear());
						vehicle_engine.setText("" + currentVehicleInfo.getEngine());
						vehicle_price.setText("" + currentVehicleInfo.getPrice());
						vehicle_doors.setText("" + currentVehicleInfo.getDoors());
						vehicle_seats.setText("" + currentVehicleInfo.getSeats());
						vehicle_weight.setText("" + currentVehicleInfo.getWeight());
						vehicle_fuelCapacity.setText("" + currentVehicleInfo.getFuelCapacity());
						vehicle_fuelAverage.setText("" + currentVehicleInfo.getFuelAverage());
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}

				}
				if (currentVehicleIndex == 0) {
					btnNext.setEnabled(true);
					btnPrev.setEnabled(false);
				} else {
					btnPrev.setEnabled(true);
					btnNext.setEnabled(true);
				}
			}
		});
		searchPanel.setVisible(false);

		btnPrev.setEnabled(false);
		btnNext.setEnabled(false);

		vehicleSearchIDCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {

					setSearchValues("vehicleID");
					currentVehicleIndex = vehicleSearchIDCB.getSelectedIndex();
					LinkNode currentVehicleInfo;
					try {
						currentVehicleInfo = linkedlistInt.searchByID(vehicleIDArray.get(currentVehicleIndex));
						vehicle_id.setText("" + currentVehicleInfo.getId());
						vehicle_make.setText("" + currentVehicleInfo.getMake());
						vehicle_model.setText("" + currentVehicleInfo.getModel());
						vehicle_year.setText("" + currentVehicleInfo.getYear());
						vehicle_engine.setText("" + currentVehicleInfo.getEngine());
						vehicle_price.setText("" + currentVehicleInfo.getPrice());
						vehicle_doors.setText("" + currentVehicleInfo.getDoors());
						vehicle_seats.setText("" + currentVehicleInfo.getSeats());
						vehicle_weight.setText("" + currentVehicleInfo.getWeight());
						vehicle_fuelCapacity.setText("" + currentVehicleInfo.getFuelCapacity());
						vehicle_fuelAverage.setText("" + currentVehicleInfo.getFuelAverage());
					} catch (RemoteException e1) {
					}
				}
			}
		});

		makeSearchCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (makeSearchCB.getSelectedIndex() != 0) {
						try {
							setSearchValues("vehicleMake");
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Vehicle Make Info not Found!!");
						}

					}

				}
			}
		});

		insertPanel.setBounds(283, 0, 544, 594);
		frame.getContentPane().add(insertPanel);
		insertPanel.setLayout(null);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 40, 420, 35);
		insertPanel.add(lblNewLabel);
		lblMake.setBounds(60, 148, 61, 16);

		insertPanel.add(lblMake);
		insertPanel.add(lblModel);
		insertPanel.add(lblEngine);
		insertPanel.add(lblYear);
		insertPanel.add(lblDoors);
		insertPanel.add(lblSeats);
		insertPanel.add(lblWeight);
		insertPanel.add(lblFuelCapacity);
		insertPanel.add(lblFuelAverage);
		insertPanel.add(lblPrice);

		insertPanel.add(makeCB);
		insertPanel.add(modelTF);
		insertPanel.add(engineTF);
		insertPanel.add(yearTF);
		insertPanel.add(doorsTF);
		insertPanel.add(seatsTF);
		insertPanel.add(weightTF);
		insertPanel.add(fuelCapacityTF);
		insertPanel.add(fuelAverageTF);
		insertPanel.add(priceTF);

		lblModel.setBounds(295, 148, 61, 16);
		lblEngine.setBounds(60, 205, 61, 16);
		lblYear.setBounds(295, 205, 61, 16);
		lblDoors.setBounds(60, 262, 61, 16);
		lblSeats.setBounds(295, 262, 61, 16);
		lblWeight.setBounds(168, 320, 61, 16);
		lblFuelCapacity.setBounds(60, 365, 96, 16);
		lblFuelAverage.setBounds(60, 408, 96, 16);
		lblPrice.setBounds(168, 470, 61, 16);

		makeCB.setModel(new DefaultComboBoxModel<String>(new String[] { "AUDI", "BENTLEY", "BMW", "CHEVROLET",
				"FERRARI", "FIAT", "FORD", "HONDA", "HYUNDAI", "ISUZU", "JAGUAR", "JEEP", "KIA", "LAND ROVER", "LEXUS",
				"MASERATI", "MERCEDES-BENZ", "MITSUBISHI", "NISSAN", "PORSCHE", "RENAULT", "ROLLS-ROYCE", "SEAT",
				"SKODA", "SUZUKI", "TESLA", "TOYOTA", "VOLKSWAGEN", "VOLVO" }));

		makeCB.setBounds(124, 142, 135, 30);
		modelTF.setBounds(360, 144, 135, 30);

		modelTF.setColumns(10);
		engineTF.setColumns(10);
		yearTF.setColumns(10);
		doorsTF.setColumns(10);
		seatsTF.setColumns(10);
		weightTF.setColumns(10);
		fuelCapacityTF.setColumns(10);
		fuelAverageTF.setColumns(10);
		priceTF.setColumns(10);

		engineTF.setBounds(124, 198, 135, 30);
		yearTF.setBounds(360, 200, 135, 30);
		doorsTF.setBounds(124, 255, 135, 30);
		seatsTF.setBounds(360, 257, 135, 30);
		weightTF.setBounds(245, 313, 135, 30);
		fuelCapacityTF.setBounds(168, 360, 135, 30);
		fuelAverageTF.setBounds(168, 403, 135, 30);
		priceTF.setBounds(245, 463, 135, 30);

		JButton btnInsertVehicle = new JButton("INSERT");
		btnInsertVehicle.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnInsertVehicle.setBounds(215, 530, 140, 35);
		insertPanel.add(btnInsertVehicle);

		JLabel lblVehicleId = new JLabel("Vehicle ID: ");
		lblVehicleId.setBounds(235, 100, 71, 16);
		insertPanel.add(lblVehicleId);

		vehicleIDLbl.setBounds(307, 100, 61, 16);
		insertPanel.add(vehicleIDLbl);

		insertPanel.setVisible(false);

		// Setting borders to fields
		modelTF.setBorder(new LineBorder(Color.BLACK));
		engineTF.setBorder(new LineBorder(Color.BLACK));
		yearTF.setBorder(new LineBorder(Color.BLACK));
		doorsTF.setBorder(new LineBorder(Color.BLACK));
		seatsTF.setBorder(new LineBorder(Color.BLACK));
		weightTF.setBorder(new LineBorder(Color.BLACK));
		fuelCapacityTF.setBorder(new LineBorder(Color.BLACK));
		fuelAverageTF.setBorder(new LineBorder(Color.BLACK));
		priceTF.setBorder(new LineBorder(Color.BLACK));
		lblEuro.setBounds(392, 470, 61, 16);

		insertPanel.add(lblEuro);
		lblLkm.setBounds(315, 408, 61, 16);

		insertPanel.add(lblLkm);
		lblLitres.setBounds(315, 365, 61, 16);

		insertPanel.add(lblLitres);
		lblKg_2.setBounds(392, 320, 61, 16);

		insertPanel.add(lblKg_2);

		btnInsertVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int vehicleID = Integer.parseInt(vehicleIDLbl.getText());
				String make = makeCB.getSelectedItem().toString();
				String model = modelTF.getText();
				String engine = engineTF.getText();
				int year = Integer.parseInt(yearTF.getText());
				int doors = Integer.parseInt(doorsTF.getText());
				int seats = Integer.parseInt(seatsTF.getText());
				float weight = Float.parseFloat(weightTF.getText());
				int price = Integer.parseInt(priceTF.getText());
				int fuelCapacity = Integer.parseInt(fuelCapacityTF.getText());
				float fuelAverage = Float.parseFloat(fuelAverageTF.getText());
				try {
					linkedlistInt.insert(vehicleID, make, model, engine, year, doors, seats, weight, price,
							fuelCapacity, fuelAverage);
					JOptionPane.showMessageDialog(null, "Vehicle has been Inserted!!");
					setVehicleID();
					getAllVehicleIDs();

					modelTF.setText("");
					engineTF.setText("");
					yearTF.setText("");
					doorsTF.setText("");
					seatsTF.setText("");
					weightTF.setText("");
					priceTF.setText("");
					fuelCapacityTF.setText("");
					fuelAverageTF.setText("");

				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});

		modifyPanel.setBounds(283, 0, 544, 594);
		frame.getContentPane().add(modifyPanel);
		modifyPanel.setLayout(null);
		lblModifyVehicle.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblModifyVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyVehicle.setBounds(60, 40, 420, 35);

		modifyPanel.add(lblModifyVehicle);
		vehicleIDCB.setBounds(280, 96, 100, 27);

		modifyPanel.add(vehicleIDCB);

		JLabel lblVehicleId_1 = new JLabel("Vehicle ID : ");
		lblVehicleId_1.setBounds(202, 100, 75, 16);
		modifyPanel.add(lblVehicleId_1);
		modifyPanel.setVisible(false);
		modifyPanel.setVisible(false);

		JLabel label_10 = new JLabel("Make");
		label_10.setBounds(60, 148, 61, 16);
		modifyPanel.add(label_10);

		JComboBox<String> makeUpdateCB = new JComboBox<String>();
		makeUpdateCB.setModel(new DefaultComboBoxModel<String>(new String[] { "AUDI", "BENTLEY", "BMW", "CHEVROLET",
				"FERRARI", "FIAT", "FORD", "HONDA", "HYUNDAI", "ISUZU", "JAGUAR", "JEEP", "KIA", "LAND ROVER", "LEXUS",
				"MASERATI", "MERCEDES-BENZ", "MITSUBISHI", "NISSAN", "PORSCHE", "RENAULT", "ROLLS-ROYCE", "SEAT",
				"SKODA", "SUZUKI", "TESLA", "TOYOTA", "VOLKSWAGEN", "VOLVO" }));
		makeUpdateCB.setBounds(124, 142, 135, 30);
		modifyPanel.add(makeUpdateCB);

		modelUpdateTF = new JTextField();
		modelUpdateTF.setColumns(10);
		modelUpdateTF.setBorder(new LineBorder(Color.BLACK));
		modelUpdateTF.setBounds(360, 144, 135, 30);
		modifyPanel.add(modelUpdateTF);

		yearUpdateTF = new JTextField();
		yearUpdateTF.setColumns(10);
		yearUpdateTF.setBorder(new LineBorder(Color.BLACK));
		yearUpdateTF.setBounds(360, 200, 135, 30);
		modifyPanel.add(yearUpdateTF);

		JLabel label_11 = new JLabel("Model");
		label_11.setBounds(295, 148, 61, 16);
		modifyPanel.add(label_11);

		JLabel label_12 = new JLabel("Year");
		label_12.setBounds(295, 205, 61, 16);
		modifyPanel.add(label_12);

		engineUpdateTF = new JTextField();
		engineUpdateTF.setColumns(10);
		engineUpdateTF.setBorder(new LineBorder(Color.BLACK));
		engineUpdateTF.setBounds(124, 198, 135, 30);
		modifyPanel.add(engineUpdateTF);

		JLabel label_13 = new JLabel("Engine");
		label_13.setBounds(60, 205, 61, 16);
		modifyPanel.add(label_13);

		JLabel label_14 = new JLabel("Doors");
		label_14.setBounds(60, 262, 61, 16);
		modifyPanel.add(label_14);

		doorsUpdateTF = new JTextField();
		doorsUpdateTF.setColumns(10);
		doorsUpdateTF.setBorder(new LineBorder(Color.BLACK));
		doorsUpdateTF.setBounds(124, 255, 135, 30);
		modifyPanel.add(doorsUpdateTF);

		JLabel label_15 = new JLabel("Seats");
		label_15.setBounds(295, 262, 61, 16);
		modifyPanel.add(label_15);

		seatsUpdateTF = new JTextField();
		seatsUpdateTF.setColumns(10);
		seatsUpdateTF.setBorder(new LineBorder(Color.BLACK));
		seatsUpdateTF.setBounds(360, 257, 135, 30);
		modifyPanel.add(seatsUpdateTF);

		weightUpdateTF = new JTextField();
		weightUpdateTF.setColumns(10);
		weightUpdateTF.setBorder(new LineBorder(Color.BLACK));
		weightUpdateTF.setBounds(245, 313, 135, 30);
		modifyPanel.add(weightUpdateTF);

		JLabel label_16 = new JLabel("Weight");
		label_16.setBounds(168, 320, 61, 16);
		modifyPanel.add(label_16);

		fuelCapacityUpdateTF = new JTextField();
		fuelCapacityUpdateTF.setColumns(10);
		fuelCapacityUpdateTF.setBorder(new LineBorder(Color.BLACK));
		fuelCapacityUpdateTF.setBounds(168, 360, 135, 30);
		modifyPanel.add(fuelCapacityUpdateTF);

		JLabel label_17 = new JLabel("Fuel Capacity");
		label_17.setBounds(60, 365, 96, 16);
		modifyPanel.add(label_17);

		JLabel label_18 = new JLabel("Fuel Average");
		label_18.setBounds(60, 408, 96, 16);
		modifyPanel.add(label_18);

		fuelAverageUpdateTF = new JTextField();
		fuelAverageUpdateTF.setColumns(10);
		fuelAverageUpdateTF.setBorder(new LineBorder(Color.BLACK));
		fuelAverageUpdateTF.setBounds(168, 403, 135, 30);
		modifyPanel.add(fuelAverageUpdateTF);

		priceUpdateTF = new JTextField();
		priceUpdateTF.setColumns(10);
		priceUpdateTF.setBorder(new LineBorder(Color.BLACK));
		priceUpdateTF.setBounds(245, 463, 135, 30);
		modifyPanel.add(priceUpdateTF);

		JLabel label_19 = new JLabel("Price");
		label_19.setBounds(168, 470, 61, 16);
		modifyPanel.add(label_19);

		JButton btnModifyVehicle = new JButton("MODIFY");
		btnModifyVehicle.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnModifyVehicle.setBounds(215, 530, 140, 35);
		modifyPanel.add(btnModifyVehicle);
		label_2.setBounds(315, 408, 61, 16);

		modifyPanel.add(label_2);
		label_3.setBounds(315, 367, 61, 16);

		modifyPanel.add(label_3);
		label_4.setBounds(392, 470, 61, 16);

		modifyPanel.add(label_4);
		lblKg_1.setBounds(392, 320, 61, 16);

		modifyPanel.add(lblKg_1);

		btnModifyVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int vehicleID = (int) vehicleIDCB.getSelectedItem();
				String make = makeUpdateCB.getSelectedItem().toString();
				String model = modelUpdateTF.getText();
				String engine = engineUpdateTF.getText();
				int year = Integer.parseInt(yearUpdateTF.getText());
				int doors = Integer.parseInt(doorsUpdateTF.getText());
				int seats = Integer.parseInt(seatsUpdateTF.getText());
				float weight = Float.parseFloat(weightUpdateTF.getText());
				int price = Integer.parseInt(priceUpdateTF.getText());
				int fuelCapacity = Integer.parseInt(fuelCapacityUpdateTF.getText());
				float fuelAverage = Float.parseFloat(fuelAverageUpdateTF.getText());

				try {
					LinkNode updateVehicleInfo = new LinkNode(vehicleID, make, model, engine, year, doors, seats,
							weight, price, fuelCapacity, fuelAverage);
					linkedlistInt.updateVehicle(updateVehicleInfo);
					JOptionPane.showMessageDialog(null, "Vehicle has been Modified!!");

				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});

		vehicleIDCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					try {
						int idprovider = Integer.parseInt(vehicleIDCB.getSelectedItem().toString());
						LinkNode selectedVehicle = linkedlistInt.getVehicleInfo(idprovider);

						makeUpdateCB.setSelectedItem(selectedVehicle.getMake());
						modelUpdateTF.setText(selectedVehicle.getModel());
						engineUpdateTF.setText(selectedVehicle.getEngine());
						yearUpdateTF.setText(String.valueOf(selectedVehicle.getYear()));
						doorsUpdateTF.setText(String.valueOf(selectedVehicle.getDoors()));
						seatsUpdateTF.setText(String.valueOf(selectedVehicle.getSeats()));
						priceUpdateTF.setText(String.valueOf(selectedVehicle.getPrice()));
						weightUpdateTF.setText(String.valueOf(selectedVehicle.getWeight()));
						fuelCapacityUpdateTF.setText(String.valueOf(selectedVehicle.getFuelCapacity()));
						fuelAverageUpdateTF.setText(String.valueOf(selectedVehicle.getFuelAverage()));

					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		homePanel.setBounds(283, 0, 544, 594);
		frame.getContentPane().add(homePanel);
		homePanel.setLayout(null);
		lblVehicleManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehicleManagementSystem.setBounds(65, 35, 420, 39);

		homePanel.add(lblVehicleManagementSystem);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(65, 275, 420, 39);

		homePanel.add(label_1);

		homePanel.setVisible(true);
		navigationPanel.setBackground(new Color(66, 37, 203));
		navigationPanel.setBounds(0, 0, 283, 594);
		frame.getContentPane().add(navigationPanel);
		navigationPanel.setLayout(null);
		home.setIcon(
				new ImageIcon("/Users/burhanmullamitha/CollegeStuff/Git Projects/VehicleManagementSystem/VehicleMgmtSystem/images/logo.gif"));
		home.setHorizontalAlignment(SwingConstants.CENTER);

		home.setForeground(Color.WHITE);
		home.setBounds(29, 71, 85, 58);
		navigationPanel.add(home);

		InsertVehicle.setForeground(Color.WHITE);
		InsertVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		InsertVehicle.setBounds(0, 204, 283, 48);
		navigationPanel.add(InsertVehicle);

		ModifyVehicle.setForeground(Color.WHITE);
		ModifyVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		ModifyVehicle.setBounds(0, 253, 283, 48);
		navigationPanel.add(ModifyVehicle);

		SearchVehicle.setForeground(Color.WHITE);
		SearchVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		SearchVehicle.setBounds(0, 303, 283, 48);
		navigationPanel.add(SearchVehicle);

		DeleteVehicle.setForeground(Color.WHITE);
		DeleteVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		DeleteVehicle.setBounds(0, 353, 283, 48);
		navigationPanel.add(DeleteVehicle);

		InsertVehicle.setOpaque(true);
		ModifyVehicle.setOpaque(true);
		SearchVehicle.setOpaque(true);
		DeleteVehicle.setOpaque(true);

		InsertVehicle.setBackground(new Color(66, 37, 203));
		ModifyVehicle.setBackground(new Color(66, 37, 203));
		SearchVehicle.setBackground(new Color(66, 37, 203));
		DeleteVehicle.setBackground(new Color(66, 37, 203));

		btnClose = new JButton("X");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		btnClose.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnClose.setBounds(6, 6, 27, 29);
		navigationPanel.add(btnClose);

		JLabel OpeninTreeSet = new JLabel("Open Program in Treeset");
		OpeninTreeSet.setForeground(Color.WHITE);
		OpeninTreeSet.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		OpeninTreeSet.setBounds(15, 559, 206, 29);
		navigationPanel.add(OpeninTreeSet);

		JLabel lblVehicle = new JLabel("Vehicle");
		lblVehicle.setForeground(Color.WHITE);
		lblVehicle.setBounds(126, 71, 88, 16);
		navigationPanel.add(lblVehicle);

		JLabel lblManagement = new JLabel("Management");
		lblManagement.setForeground(Color.WHITE);
		lblManagement.setBounds(126, 91, 88, 16);
		navigationPanel.add(lblManagement);

		JLabel lblSystem = new JLabel("System");
		lblSystem.setForeground(Color.WHITE);
		lblSystem.setBounds(126, 113, 88, 16);
		navigationPanel.add(lblSystem);

		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				homePanel.setVisible(true);
				insertPanel.setVisible(false);
				modifyPanel.setVisible(false);
				searchPanel.setVisible(false);
				deletePanel.setVisible(false);

			}
		});

		InsertVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				InsertVehicle.setBackground(new Color(123, 99, 218));
				ModifyVehicle.setBackground(new Color(66, 37, 203));
				SearchVehicle.setBackground(new Color(66, 37, 203));
				DeleteVehicle.setBackground(new Color(66, 37, 203));

				InsertVehicle.setBorder(new MatteBorder(1, 5, 1, 1, Color.WHITE));
				ModifyVehicle.setBorder(null);
				SearchVehicle.setBorder(null);
				DeleteVehicle.setBorder(null);

				homePanel.setVisible(false);
				insertPanel.setVisible(true);
				modifyPanel.setVisible(false);
				searchPanel.setVisible(false);
				deletePanel.setVisible(false);
			}
		});

		ModifyVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

//				

				ModifyVehicle.setBackground(new Color(123, 99, 218));
				InsertVehicle.setBackground(new Color(66, 37, 203));
				SearchVehicle.setBackground(new Color(66, 37, 203));
				DeleteVehicle.setBackground(new Color(66, 37, 203));

				ModifyVehicle.setBorder(new MatteBorder(1, 5, 1, 1, Color.WHITE));
				InsertVehicle.setBorder(null);
				SearchVehicle.setBorder(null);
				DeleteVehicle.setBorder(null);

				homePanel.setVisible(false);
				insertPanel.setVisible(false);
				modifyPanel.setVisible(true);
				searchPanel.setVisible(false);
				deletePanel.setVisible(false);
			}
		});

		SearchVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				SearchVehicle.setBackground(new Color(123, 99, 218));
				InsertVehicle.setBackground(new Color(66, 37, 203));
				ModifyVehicle.setBackground(new Color(66, 37, 203));
				DeleteVehicle.setBackground(new Color(66, 37, 203));

				SearchVehicle.setBorder(new MatteBorder(1, 5, 1, 1, Color.WHITE));
				ModifyVehicle.setBorder(null);
				InsertVehicle.setBorder(null);
				DeleteVehicle.setBorder(null);

				homePanel.setVisible(false);
				insertPanel.setVisible(false);
				modifyPanel.setVisible(false);
				searchPanel.setVisible(true);
				deletePanel.setVisible(false);

			}
		});

		DeleteVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				DeleteVehicle.setBackground(new Color(123, 99, 218));
				InsertVehicle.setBackground(new Color(66, 37, 203));
				SearchVehicle.setBackground(new Color(66, 37, 203));
				ModifyVehicle.setBackground(new Color(66, 37, 203));

				DeleteVehicle.setBorder(new MatteBorder(1, 5, 1, 1, Color.WHITE));
				ModifyVehicle.setBorder(null);
				SearchVehicle.setBorder(null);
				InsertVehicle.setBorder(null);

				homePanel.setVisible(false);
				insertPanel.setVisible(false);
				modifyPanel.setVisible(false);
				searchPanel.setVisible(false);
				deletePanel.setVisible(true);

			}
		});

		if (vehicleIDArray.size() != 0) {
			setSearchValues("vehicleID");
		}

	}

	public void setVehicleID() {
		try {
			int max_id = linkedlistInt.getMaxVehicleID();
			int id = Integer.parseInt(vehicleIDLbl.getText());
			newVehicleID = max_id + 1;
			vehicleIDLbl.setText("" + newVehicleID);
		} catch (Exception e) {
			vehicleIDLbl.setText("" + 1);
		}
	}

	public void getAllVehicleIDs() {
		try {
			vehicleIDCB.removeAllItems();
			deleteVehicleIDCB.removeAllItems();
			vehicleSearchIDCB.removeAllItems();
			List<LinkNode> idList = linkedlistInt.getAllIDs();
			ListIterator<LinkNode> iterator = idList.listIterator();

			while (iterator.hasNext()) {
				LinkNode temp = (LinkNode) iterator.next();
				vehicleIDCB.addItem(temp.getId());
				deleteVehicleIDCB.addItem(temp.getId());
				vehicleSearchIDCB.addItem(temp.getId());
			}
		} catch (Exception e) {
		}
	}

	public void setSearchValues(String vehicleProperty) {
		try {
			vehicleIDArray.clear();
			currentVehicleIndex = 0;
			List<LinkNode> VehicleList = null;
			if (vehicleProperty.equals("vehicleID")) {
				VehicleList = linkedlistInt.allVehicleData();
			} else if (vehicleProperty.equals("vehicleMake")) {
				VehicleList = linkedlistInt.searchByMake(makeSearchCB.getSelectedItem().toString());
			} else if (vehicleProperty.equals("vehiclePrice")) {
				VehicleList = linkedlistInt.searchByPrice(Integer.parseInt(minPriceSearchTF.getText()),
						Integer.parseInt(maxPriceSearchTF.getText()));
			}
			for (LinkNode node : VehicleList) {
				vehicleIDArray.add(node.getId());
			}
			if (vehicleIDArray.size() == 0) {
				JOptionPane.showMessageDialog(null, "No Vehicles Found!");
				return;
			}
			if (vehicleIDArray.size() == 1) {
				btnPrev.setEnabled(false);
				btnNext.setEnabled(false);
			} else {
				btnPrev.setEnabled(true);
				btnNext.setEnabled(true);
			}
			LinkNode currentVehicleInfo = null;
			try {
				currentVehicleInfo = linkedlistInt.searchByID(vehicleIDArray.get(currentVehicleIndex));
			} catch (Exception e) {
			}
			vehicle_id.setText("" + currentVehicleInfo.getId());
			vehicle_make.setText("" + currentVehicleInfo.getMake());
			vehicle_model.setText("" + currentVehicleInfo.getModel());
			vehicle_year.setText("" + currentVehicleInfo.getYear());
			vehicle_engine.setText("" + currentVehicleInfo.getEngine());
			vehicle_price.setText("" + currentVehicleInfo.getPrice());
			vehicle_doors.setText("" + currentVehicleInfo.getDoors());
			vehicle_seats.setText("" + currentVehicleInfo.getSeats());
			vehicle_weight.setText("" + currentVehicleInfo.getWeight());
			vehicle_fuelCapacity.setText("" + currentVehicleInfo.getFuelCapacity());
			vehicle_fuelAverage.setText("" + currentVehicleInfo.getFuelAverage());

		} catch (RemoteException e1) {
			JOptionPane.showMessageDialog(null, e1);
		}

	}
}
