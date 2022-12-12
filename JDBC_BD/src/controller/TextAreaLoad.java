package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import model.ExecuteQueryQApp;
import view.FrameApp2;

public class TextAreaLoad implements ActionListener {

	private FrameApp2 meFrame;
	private ExecuteQueryQApp executeQuery = new ExecuteQueryQApp();
	
	public TextAreaLoad(FrameApp2 meFrame) {
		
		this.meFrame = meFrame;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comuna=(String)
				meFrame.getComuna().getSelectedItem();
		String region=(String)
				meFrame.getRegion().getSelectedItem();
		
		
		meFrame.getResult().removeAll();
		
		try {
			meFrame.getResult().setText("");
			ResultSet rs=executeQuery.filterComunaAndRegion(comuna,region);
			while(rs.next()) {
				
				meFrame.getResult().append("\n Id: "+rs.getString(1)
				+" name: "+rs.getString(2)
				+" comuna: "+rs.getString(3)
				+" region: "+rs.getString(4));
			}
			
			
		}catch(Exception error){
			error.printStackTrace();
		}
		
		
		
	}

}
