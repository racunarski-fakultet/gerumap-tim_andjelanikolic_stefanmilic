package dsw.gerumap.app.gui.swing.workspace.panel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;

@NoArgsConstructor
@Setter
@Getter
public class ElementPanel {

    private Color color = Color.black;
    private int stroke = 2;

    public ElementPanel(Color color, int stroke) {
        this.color = color;
        this.stroke = stroke;
    }
}
