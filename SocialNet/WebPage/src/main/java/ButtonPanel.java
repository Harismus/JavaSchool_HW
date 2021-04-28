public class ButtonPanel implements IButton {

    private IFunctionPanel panel;

    ButtonPanel(IFunctionPanel panel) {
        this.panel = panel;
    }

    @Override
    public void click() {
        if (panel.isHide()) {
            panel.show();
        } else {
            panel.hide();
        }
    }
}
