package Model.Interfaces;

import controllers.MainController;

/**
 * A interface for all the panes that needs to be aware of the mainAnchor
 *
 * @author Oscar
 */
public interface iPane {
    void initPane(MainController parent);

}
