package QuickPALM2;

import org.python.util.PythonInterpreter;

/**
 * Initializes the Jython interpreter and adds the local site-packages directory to the Jython sys.path.
 * 
 * @author Ricardo Henriques
 */
public class QPJython
{
    public static PythonInterpreter py = new PythonInterpreter();
    private static String path = QPJython.class.getResource("./").toString();
      
    /**
     * Sets up the Python interpreter environment if not set before.
     */
    public static void setup()
    {
        if (py.eval("globals().has_key('sys')").toString() == "False")
        {
            ij.IJ.showStatus("Initializing Jython Engine...");
            py.exec("import sys, ij, os, imp");
            py.set("_root", path);
            py.exec("_root = _root.replace('file:', '')");
            py.exec("sys.path.append(os.path.split(os.path.split(_root)[0])[0])"); //add the parent of QuickPALM2 path so that we can import QuickPALM2
            py.exec("sys.path.append(os.path.join(_root, 'site-packages'))");
            py.exec("sys.path.append(os.path.join(_root, 'py-scripts'))");
            py.exec("class _MyWrite:\n\tdef write(self, txt):\n\t\tij.IJ.log(str(txt))");
            py.exec("def runScript(name):\n\ts=imp.load_source(name, os.path.join(_root, 'py-scripts', name+'.py'))\n\ts.main()");
            py.exec("sys.stdout = _MyWrite()");
            ij.IJ.showStatus("Jython Engine started...");
        }
    }
}
