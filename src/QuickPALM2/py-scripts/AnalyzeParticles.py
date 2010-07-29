import QPUtils

def main():
    """
    Main function to be run in the plugin.
    """
    SM = QPUtils.settings.SettingsManager("QuickPALM2")
    DG = QPUtils.dialogs.Dialog("Analyze Particles", SM)
    generateDialog(SM, DG)
    if not DG.show(): return
        
def generateDialog(SM, DG):
    plugins_pd = QPUtils.getPlugins('ParticleDetection').keys()
    #plugins_dc = QPUtils.getPlugins('DriftCorrection')
    #plugins_dr = QPUtils.getPlugins('DataRendering')    
    DG.addChoice("PlugIn_ParticleDetection", "Particle-detection method:", plugins_pd, plugins_pd[0])
    DG.addCheckbox("CfgPlugIn_ParticleDetection", "Configure particle-detection method", True)


    