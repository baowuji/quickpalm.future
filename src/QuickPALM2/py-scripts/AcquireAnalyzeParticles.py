import os
import QPUtils, AnalyzeParticles
import QuickPALM2.MMUtils

def main():
    """
    Main function to be run in the plugin
    """
    SM = QPUtils.settings.SettingsManager("QuickPALM2")
    DG = QPUtils.dialogs.Dialog("Analyze Particles", SM)
    generateDialog(SM, DG)
    if not DG.show(): return


def generateDialog(SM, DG):
    DG.addNumber('nimages', 'Number of images', 10000)
    DG.addString('root', 'Directory root', os.path.join(os.getcwd(), "Experiments"))
    DG.addString('prefix', 'Name prefix', 'QuickPALM_experiment')
    # need to add a separator
    AnalyzeParticles.generateDialog(SM, DG)
