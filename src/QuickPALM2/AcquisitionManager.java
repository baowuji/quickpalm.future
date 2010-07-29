package QuickPALM2;

import mmcorej.CMMCore;
import org.micromanager.MMStudioMainFrame;

/**
 * Acquisition manager, responsible for acquiring images and sending them out to the job handler.
 * @author paxcal
 */
public class AcquisitionManager extends Thread{
	
	public MMStudioMainFrame mmgui;
	public CMMCore mmc;
	
	private int nimages;
	private String root;
	private String prefix;
	
	/**
	 * Continue flag, the acquisition will continue while this is true
	 */
	private boolean cont = true;
	
	public void setup(int numberOfImages, String rootDirectory, String saveDirectoryPrefix)
	{
		MMUtils mmu = new MMUtils();
		mmgui = mmu.gui;
		mmc = mmu.mmc;
		
		nimages = numberOfImages;
		root = rootDirectory;
		prefix = saveDirectoryPrefix;
	}
	
	public void run()
	{
		cont = true;
	    try {
			mmc.intializeCircularBuffer();
		    mmc.setCircularBufferMemoryFootprint(256); // size in MB
		    mmc.startContinuousSequenceAcquisition(mmc.getExposure());
		    
		    for (int n=0;n<nimages;n++)
		    {
		    	if (!cont) 
		    	{
		    		break; // stop acquisition
		    	}
		    }
		    mmc.stopSequenceAcquisition();
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Halts the acquisition.
	 */
	public void stopAcquisition()
	{
		cont = false;
	}
}

