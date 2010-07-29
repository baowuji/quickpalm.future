package QuickPALM2.plugins.ParticleDetection;

import QuickPALM2.plugin.ParticleDetectionPlugIn;

/** 
 * A dummy particle-detector do be used for test purposes.
 * 
 * @author Ricardo Henriques
 */
public class DummyDetector implements ParticleDetectionPlugIn
{
	public static String label = "Dummy Algorithm";
	
	public boolean does3D()
	{
		return true;
	}
	
	public void config()
	{
		//nothing here yet
	}
	
	public double [][] processImage(ij.ImagePlus img)
	{
		double [][] results = new double [1][3];
		results[0][0] = 0;
		results[0][1] = 0;
		results[0][2] = 0;
		return results;
	}
	
	public String [] getLabels()
	{
		String [] labels = new String [3];
		labels[0] = "x";
		labels[1] = "y";
		labels[2] = "z";
		return labels;
	}
}
