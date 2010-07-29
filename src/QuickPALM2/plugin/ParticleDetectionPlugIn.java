package QuickPALM2.plugin;

/** 
 * A dummy particle-detector plugin to be inherited by particle-detection plugins.
 * 
 * @author Ricardo Henriques
 */
public interface ParticleDetectionPlugIn 
{	
	/** 
	 * Name of the algorithm to be shown in the dialogs
	 */
	//public String label;
	
	/**
	 * @return true if the algorithm is able to process 3D data.
	 */
	public boolean does3D();
	
	/**
	 * Should create a GUI in order for the user to configure the particle-detection.
	 */
	public void config();
	
	/**
	 * Will be automatically called by the ImageHandler to detect particles in that image.
	 * 
	 * @param img - image to detect the particles on
	 * @return 2D double array where each line represents a particle detected and each column the values
	 * calculated for the particle, should at least have 3 columns representing x, y and z.
	 */
	public double [][] processImage(ij.ImagePlus img);
	
	/**
	 * @return array with the labels representing the columns returned by processImage
	 */
	public String [] getLabels();
}

