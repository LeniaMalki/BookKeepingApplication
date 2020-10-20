package View.Interfaces;

import Controller.MainControllers.MainController;

/**
 * A interface for all the panes that needs to be aware of the mainAnchor
 *
 * @author Oscar
 */
public interface iPane {
    void initPane(MainController parent);

}
