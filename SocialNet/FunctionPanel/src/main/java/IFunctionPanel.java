
public interface IFunctionPanel {
    /**
     * Вернуть Гуи Функциональной панели
     * @return
     */
    Object getGui();

    void show();
    void hide();
    boolean isHide();
}
