package QuickPALM2;

import ij.IJ;
import mmcorej.CMMCore;
import org.micromanager.MMStudioMainFrame;

/** 
 * Grabs the micro-manager instance exposing the gui and core
 * 
 * @author Ricardo Henriques
 */
public class MMUtils 
{	
	public MMStudioMainFrame gui;
	public CMMCore mmc;
	
	public MMUtils()
	{
		try
		{
		    gui = (MMStudioMainFrame) Class.forName("MMStudioPlugin").getMethod("getMMStudioMainFrameInstance", null).invoke(null, (Object []) null);
		    mmc = gui.getMMCore();
		} catch (Exception ex) {
			IJ.error("Micro-Manager instance not found!");
		}
	}

}
