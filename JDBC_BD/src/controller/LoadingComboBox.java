package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import model.LoadData;
import view.FrameApp2;

public class LoadingComboBox extends WindowAdapter{
	
	private LoadData loadData= new LoadData();
	private FrameApp2 meFrame;
	

	public LoadingComboBox(FrameApp2 meFrame) {
		this.meFrame = meFrame;
	}


	public void windowOpened(WindowEvent e) {
		
		ArrayList<String>arrC= loadData.executeQueryC();
		
		for (String comuna : arrC) {
			meFrame.setComuna(comuna);
		}

		ArrayList<String>arrR= loadData.executeQueryR();
		
		for (String comuna : arrR) {
			meFrame.setRegion(comuna);
		}
	}
	

}
