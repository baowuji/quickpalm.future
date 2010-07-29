package QuickPALM2;

import ij.plugin.*;

public class RunPythonScript implements PlugIn 
{
	public void run(String name) 
	{
		QPJython.setup();
		QPJython.py.exec("runScript('"+name+"')");   
    }
}
